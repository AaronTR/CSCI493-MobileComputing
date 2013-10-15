package com.example.photoviewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlbumFragment extends Fragment{

	ViewChangedListener listener;
	
	public interface ViewChangedListener {
		public void viewChanged(String message);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    View view = inflater.inflate(R.layout.fragment_album, container, false);
	    
	    return view;
	}
	
	//onGridItemCLick
	
	@Override
	public void onAttach(Activity activity) {
	    super.onAttach(activity);
	    if (activity instanceof ViewChangedListener) {
	      listener = (ViewChangedListener) activity;
	    } else {
	      throw new ClassCastException(activity.toString()
	          + " must implemenet IndexFragment.ViewChangedListener");
	    }
	}
	  
	public void updateView(String message) {
		listener.viewChanged(message);
	}
}
