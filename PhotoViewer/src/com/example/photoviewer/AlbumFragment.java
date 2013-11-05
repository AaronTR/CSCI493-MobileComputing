package com.example.photoviewer;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class AlbumFragment extends Fragment{

	ViewChangedListener listener;
	ImageManager manager;
	
	public interface ViewChangedListener {
		public void viewChanged(Image image);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    View view = inflater.inflate(R.layout.fragment_album, container, false);
	    manager = new ImageManager(getActivity().getApplicationContext());
	    
	    //ArrayList<Uri> uris = getTestShit();
	    addDatabaseShit();
	    final ArrayList<Uri> uris = manager.retrieveURIs();
	    
	    GridView gridview = (GridView) view.findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(getActivity().getApplicationContext(), uris));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	Image image = null;
	        	try {
	        		image = manager.retrieveImageFromDB(uris.get(position).toString());
	        	}
	        	catch (ParseException pe) {
	        		pe.printStackTrace();
	        	}
	            updateView(image);
	            
	            ImageFragment imageFragment = new ImageFragment();
		      	if(!imageFragment.isVisible()) {
		      		FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
		      		transaction.hide((AlbumFragment)v.getParent());
		      		transaction.show(imageFragment);
		      		transaction.commit();
		      	}
	        }
	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener() {
	    	public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
	    		Toast.makeText(getActivity(), "delete picture " + position + "?", Toast.LENGTH_SHORT).show();
				return false;
	    	}
	    });
	    return view;
	}
	
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
	  
	public void updateView(Image image) {
		listener.viewChanged(image);
	}
	
	//testing only
	private void addDatabaseShit() {
		File cameraDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + File.separator + "Camera");
		File[] files = cameraDir.listFiles();
		for(File f : files) {
			if(f.getName().endsWith(".jpg")) {
				Image i = ImageBuilder.buildInitialImage(Uri.fromFile(f), new float[]{0,0});
				manager.addImageToDB(i);
			}
		}
	}
}
