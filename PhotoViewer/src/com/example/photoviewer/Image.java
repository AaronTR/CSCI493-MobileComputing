package com.example.photoviewer;

import java.net.URI;
import java.util.Date;

public final class Image {

	private URI uri;
	private String description, location;
	private Date timestamp;
	
	public Image(URI uri, String description, String location, Date timestamp) {
		this.uri = uri;
		this.description = description;
		this.location = location;
		this.timestamp = timestamp;
	}
	
	public URI getURI() {
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
