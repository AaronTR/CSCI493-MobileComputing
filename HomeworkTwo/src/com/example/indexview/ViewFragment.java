package com.example.indexview;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.view_fragment, container, false);
    return view;
  }
  
  //TODO save instance state
  
  //TODO scrollbar
  
  //TODO zoom
  
  public void updateImage(String absolutePath) {
	  ImageView view = (ImageView) getView().findViewById(R.id.viewImage);
	if(absolutePath != null) { 
		Drawable drawable = Drawable.createFromPath(absolutePath);
		view.setImageDrawable(drawable);
	}
	else {
		view.setImageResource(R.drawable.ic_launcher);
	}
  }
} 
