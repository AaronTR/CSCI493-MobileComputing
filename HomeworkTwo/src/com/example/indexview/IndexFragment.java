package com.example.indexview;

import java.io.File;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IndexFragment extends ListFragment{
  
	ViewChangedListener listener;
	HashMap<String, String> fileMap;
	
  public interface ViewChangedListener {
	public void viewChanged(String message);
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	 
	  
	File cameraDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + File.separator + "Camera");
	FileRetriever fr = new FileRetriever();
	String[] extensions = {"txt", "jpg"};
	fileMap = fr.retrieve(cameraDir, extensions);
	
	String[] nameList = new String[1];
	if(!fileMap.isEmpty()) {
		nameList = fileMap.keySet().toArray(new String[0]);
	}
	else {
		nameList[0] = "No files found";
	}
	
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, nameList);
	setListAdapter(adapter);
	
    View view = inflater.inflate(R.layout.index_fragment, container, false);
    
    return view;
  }
  
  @Override
  public void onListItemClick(ListView lv, View v, int position, long id) {
	  String listItem = getListAdapter().getItem(position).toString();
	  updateView(fileMap.get(listItem));
	  
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
  
  public void updateView(String message) {
	listener.viewChanged(message);
  }

} 
