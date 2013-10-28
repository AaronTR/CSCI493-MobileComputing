package com.example.photoviewer;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import android.net.Uri;


public final class Image {

	private Uri uri;
	private String description, location;
	private Date timestamp;
	
	public Image(Uri uri, String description, String location, Date timestamp) {
		this.uri = uri;
		this.description = description;
		this.location = location;
		this.timestamp = timestamp;
	}
	
	public Image(String uri, String description, String location, String timestamp) throws ParseException {
		this.uri = Uri.parse(uri);
		this.description = description;
		this.location = location;

		DateFormat df = DateFormat.getDateInstance();
		this.timestamp = df.parse(timestamp);
	}
	
	public Uri getURI() {
		return this.uri;
	}
	
	public String getURIAsString() {
		return this.uri.toString();
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public Date getTimestamp() {
		return this.timestamp;
	}
	
	public String getTimestampAsString() {
		return this.timestamp.toString();
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
