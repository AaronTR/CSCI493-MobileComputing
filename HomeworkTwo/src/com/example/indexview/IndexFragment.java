package com.example.indexview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class IndexFragment extends Fragment{
  ViewChangedListener listener;
	
  public interface ViewChangedListener {
	public void viewChanged(String message);
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.index_fragment, container, false);

    Button button1 = (Button) view.findViewById(R.id.button_hello);
    button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            updateView("Hello!");
        }
    });
    
    Button button2 = (Button) view.findViewById(R.id.button_bye);
    button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            updateView("Goodbye!");
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
  
  public void updateView(String message) {
	listener.viewChanged(message);
  }

} 
