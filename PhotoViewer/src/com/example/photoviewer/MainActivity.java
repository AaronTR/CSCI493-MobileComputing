package com.example.photoviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity implements AlbumFragment.ViewChangedListener {

	GestureDetectorCompat gestureDetector;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetectorCompat(this, new GestureListener());
        //view.startActivity(getIntent());
    }
	
	class GestureListener extends GestureDetector.SimpleOnGestureListener {
		
		AlbumFragment albumFragment = (AlbumFragment) getSupportFragmentManager().findFragmentById(R.id.albumFragment);
//		ImageFragment imageFragment = (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.imageFragment);
//		ViewFinderFragment vfFragment = (ViewFinderFragment) getSupportFragmentManager().findFragmentById(R.id.viewFinderFragment);
		
		//gesture stuff
	}

	@Override
	public void viewChanged(String message) {
		// TODO Auto-generated method stub
	}
	
}
