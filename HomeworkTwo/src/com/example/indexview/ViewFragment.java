package com.example.indexview;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class ViewFragment extends Fragment {

	private static final String DEFAULT_PATH =  "/android_res/drawable/ic_launcher.png";
	
	WebView webView;
	
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.view_fragment, container, false);
	  
    webView = (WebView) view.findViewById(R.id.viewImage);
    webView.getSettings().setBuiltInZoomControls(true);
    webView.loadDataWithBaseURL("", setWebViewResource(DEFAULT_PATH, true), "text/html", "utf-8", null);
    
    return view;
  }
  
  //TODO save instance state
  
  public void updateImage(String absolutePath) {
	if(absolutePath != null) { 
		boolean imageFlag = absolutePath.endsWith(".jpg") ? true : false;
		webView.loadDataWithBaseURL("", setWebViewResource(absolutePath, imageFlag), "text/html", "utf-8", null);
	}
	else {
		webView.loadDataWithBaseURL("", setWebViewResource(DEFAULT_PATH, true), "text/html", "utf-8", null);
	}
  }
  
  public String setWebViewResource(String path, boolean imageFlag) {
	  StringBuilder builder = new StringBuilder();
	  builder.append("<html>");
	  builder.append("<body>");
	  builder.append("<center>");
	  if(imageFlag) {
		  builder.append("<img src='");
		  builder.append("file://");
		  builder.append(path);
		  builder.append("'/>");
	  }
	  else {
		  try {
			  builder.append(readTextFile(path));
		  }
		  catch (FileNotFoundException fne) {
			  builder.append("File not found");
		  } 
		  catch (IOException e) {
			  builder.append("Could not read file");
		  }
	  }
	  builder.append("</center>");
	  builder.append("</body>");
	  builder.append("</html>");
	  return builder.toString();
  }
  
  private String readTextFile(String path) throws IOException {
	  FileInputStream fis = new FileInputStream(new File(path));
	  InputStreamReader inputStreamReader = new InputStreamReader(fis);
	  BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	  StringBuilder sb = new StringBuilder();
	  String line;
	  while ((line = bufferedReader.readLine()) != null) {
	        sb.append(line);
	  }
	  bufferedReader.close();
	  inputStreamReader.close();
	  fis.close();
	  return sb.toString();
  }
} 
