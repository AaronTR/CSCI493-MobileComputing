package com.example.photoviewer;

import android.provider.BaseColumns;

public final class ImageLookupContract {

	public ImageLookupContract() {}
	
	public static abstract class ImageEntry implements BaseColumns {
		public static final String TABLE_NAME = "images";
        public static final String COLUMN_NAME_ID = "imageId";
        public static final String COLUMN_NAME_URI = "imageURI";
        public static final String COLUMN_NAME_DESCRIPTION = "imageDescription";
        public static final String COLUMN_NAME_COORDINATES = "imageCooordinates";
        public static final String COLUMN_NAME_TIMESTAMP = "imageTimeStamp";
	}
}
