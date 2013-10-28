package com.example.photoviewer;

import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.photoviewer.ImageLookupContract.ImageEntry;

public class ImageManager {

	private ImageDBHelper helper;
	
	public ImageManager(Context context) {
		helper = new ImageDBHelper(context);
	}
	
	public Image retrieveImageFromDB(String uri) throws ParseException {
		Cursor cursor = helper.retrieveImage(uri);
		cursor.moveToFirst();
		String description = cursor.getString(cursor.getColumnIndex(ImageEntry.COLUMN_NAME_DESCRIPTION));
		String location = cursor.getString(cursor.getColumnIndex(ImageEntry.COLUMN_NAME_COORDINATES));
		String timestamp = cursor.getString(cursor.getColumnIndex(ImageEntry.COLUMN_NAME_TIMESTAMP));
		return new Image(uri, description, location, timestamp);
	}
	
	public boolean addImageToDB(Image image) {
		return helper.insertImage(image);
	}
	
	public boolean deleteImageFromDB(Image image) {
		return deleteImageFromDB(image.getURIAsString());
	}
	
	public boolean deleteImageFromDB(String uri) {
		return helper.deleteImage(uri);
	}
	
	//use to fill grid view
	public ArrayList<Uri> retrieveURIs() {
		ArrayList<Uri> uris = new ArrayList<Uri>();
		Cursor cursor = helper.retrieveURIs();
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			String s = cursor.getString(cursor.getColumnIndex(ImageEntry.COLUMN_NAME_URI));
			uris.add(Uri.parse(s));
		}
		return uris;
	}
	
	public boolean updateImageDescription(String description, Image image) {
		image.setDescription(description);
		return helper.updateImageDescription(image.getURIAsString(), description);
	}
	
	
}
