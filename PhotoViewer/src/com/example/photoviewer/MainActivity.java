package com.example.photoviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;

public class MainActivity extends Activity {

	GestureDetectorCompat gestureDetector;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_finder);
        gestureDetector = new GestureDetectorCompat(this, new GestureListener());

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	class GestureListener extends GestureDetector.SimpleOnGestureListener {
		
		//flingy stuff
		
	}

}
