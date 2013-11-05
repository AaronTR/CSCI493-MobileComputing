package com.example.photoviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImageFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    View view = inflater.inflate(R.layout.fragment_image, container, false);
	    
	    return view;
	}
	
	public void updateImage(Image image) {
		//get stuff
	}

}
