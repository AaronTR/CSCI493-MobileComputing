package com.example.photoviewer;

import java.util.Date;

import android.net.Uri;

public final class ImageBuilder {

	public static Image buildInitialImage(Uri uri, float[] location) {
		String locationString = convertLocationToString(location);
		Date date = new Date();
		return new Image(uri, "", locationString, date);
	}
	
	private static String convertLocationToString(float[] location) {
		StringBuilder sb = new StringBuilder();
		for(Float f : location) {
			sb.append(f.toString());
			sb.append(":");
		}
		return sb.toString();
	}
	
}
