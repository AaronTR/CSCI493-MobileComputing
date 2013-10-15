package com.example.photoviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

public class ViewFinderFragment extends Fragment implements SurfaceHolder.Callback {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    View view = inflater.inflate(R.layout.fragment_view_finder, container, false);
	    
	    return view;
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	
}
