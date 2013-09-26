package com.example.indexview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.view_fragment, container, false);
    return view;
  }
  
  public void updateText(String message) {
	TextView view = (TextView) getView().findViewById(R.id.viewText);
	view.setText(message);
  }
} 
