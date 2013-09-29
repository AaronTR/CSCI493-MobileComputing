package com.example.indexview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;

public class IndexViewActivity extends FragmentActivity 
	implements IndexFragment.ViewChangedListener {

	private GestureDetectorCompat gestureDetector; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indexview_activity);
        gestureDetector = new GestureDetectorCompat(this, new GestureListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index_view, menu);
        return true;
    }

    public void viewChanged(String message) {
        ViewFragment fragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.viewFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.updateImage(message);
        }     	
    }    
    
    @Override 
    public boolean onTouchEvent(MotionEvent event){ 
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    
    class GestureListener extends GestureDetector.SimpleOnGestureListener {
  
      @Override
      public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
  
        IndexFragment indexFragment = (IndexFragment) getSupportFragmentManager().findFragmentById(R.id.indexFragment);        
        ViewFragment viewFragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.viewFragment);        
        
        boolean flingLeft = false, flingRight=false;
        boolean landscape = false;
        boolean indexVisible = indexFragment.isVisible();
        boolean viewVisible = viewFragment.isVisible();
        
        if (velocityX < -50 && velocityY < -.5*velocityX && velocityY > .5*velocityY)
        	flingLeft = true;
        if (velocityX > 50 && velocityY < .5*velocityX && velocityY > -.5*velocityX)
        	flingRight = true;
        if (getWindowManager().getDefaultDisplay().getHeight() < getWindowManager().getDefaultDisplay().getWidth())
        	landscape = true;
        
       	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (landscape && flingLeft && indexVisible) {
       		transaction.hide(indexFragment);
        }
        if (landscape && flingRight && !indexVisible) {
       		transaction.show(indexFragment);
        }
        
        if (!landscape && flingLeft && indexVisible) {
       		transaction.hide(indexFragment);
       		transaction.show(viewFragment);
        }
        if (!landscape && flingRight && viewVisible) {
       		transaction.show(indexFragment);
       		transaction.hide(viewFragment);
        }
        
       	transaction.commit();
        
  	    return true;
      }
    }

}
