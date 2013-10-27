package com.example.photoviewer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.photoviewer.ImageLookupContract.ImageEntry;

public class ImageDBHelper extends SQLiteOpenHelper {

	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
	    "CREATE TABLE " + ImageEntry.TABLE_NAME + " (" +
	    ImageEntry._ID + " INTEGER PRIMARY KEY," +
	    ImageEntry.COLUMN_NAME_ID + TEXT_TYPE + COMMA_SEP +
	    ImageEntry.COLUMN_NAME_URI + TEXT_TYPE + COMMA_SEP +
	    ImageEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
	    ImageEntry.COLUMN_NAME_COORDINATES + TEXT_TYPE + COMMA_SEP +
	    ImageEntry.COLUMN_NAME_TIMESTAMP + TEXT_TYPE + COMMA_SEP +
	    " )";

	private static final String SQL_DELETE_ENTRIES =
	    "DROP TABLE IF EXISTS " + ImageEntry.TABLE_NAME;
	
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "Images.db";
	
	public ImageDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
	}
	
	public long insertImage(Image image) {
		ContentValues values = new ContentValues();
		//replace with values from image object
		values.put(ImageEntry.COLUMN_NAME_URI, image.getURIAsString());
		values.put(ImageEntry.COLUMN_NAME_DESCRIPTION, image.getDescription());
		values.put(ImageEntry.COLUMN_NAME_COORDINATES, image.getLocation());
		values.put(ImageEntry.COLUMN_NAME_TIMESTAMP, image.getTimestampAsString());
		
		//returns row or -1
		return getWritableDatabase().insert(ImageEntry.TABLE_NAME, null, values);
	}
	
	public boolean deleteImage(String uri) {
		return getWritableDatabase().delete(ImageEntry.TABLE_NAME, ImageEntry.COLUMN_NAME_URI + "=?" , new String[] {uri}) > 0;
	}
	
	public Cursor retrieveURIs() {
		String query = "select " + ImageEntry.COLUMN_NAME_URI + " from " + ImageEntry.TABLE_NAME;
		return getReadableDatabase().rawQuery(query, null);
	}

}
