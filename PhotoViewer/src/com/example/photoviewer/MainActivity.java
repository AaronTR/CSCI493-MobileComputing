package com.example.photoviewer;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends SingleFragmentActivity implements AlbumFragment.ViewChangedListener{

	GestureDetector gestureDetector;
	FragmentManager manager = getSupportFragmentManager();


	@Override
	public void onCreate(Bundle savedInstanceState) {
      //  hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  hide the status bar and other OS-level chrome
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		gestureDetector = new GestureDetector(this, new GestureListener());
		super.onCreate(savedInstanceState);
		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        
    }
	  @Override
	    protected Fragment createFragment() {
	            
	        return new ViewFinderFragment();
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	
	}
	
    public boolean onTouchEvent(MotionEvent e) {
        return gestureDetector.onTouchEvent(e);
    }
	
	class GestureListener extends GestureDetector.SimpleOnGestureListener {
		   @Override
	        public boolean onDown(MotionEvent e) {
	            return true;
	        }
	        
	        @Override
	        public void onLongPress(MotionEvent e) {
	        	ViewFinderFragment view = (ViewFinderFragment) manager.findFragmentById(R.id.view_finder_fragment);
	        	view.takePicture();
	            float x = e.getX();
	            float y = e.getY();
	            Log.d("Long Tap", "Tapped at: (" + x + "," + y + ")");
	                
	        }
	        // event when double tap occurs
	        @Override
	        public boolean onDoubleTap(MotionEvent e) {
	               
	            manager.beginTransaction().replace(R.id.fragmentContainer, new AlbumFragment()).commit();
	            float x = e.getX();
	            float y = e.getY();
	            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

	            return true;
	        }
	
	}

	@Override
	public void viewChanged(Image image) {
		// TODO Auto-generated method stub
		
	}


	
}
