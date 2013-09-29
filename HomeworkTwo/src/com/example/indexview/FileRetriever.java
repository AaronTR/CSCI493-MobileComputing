package com.example.indexview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import android.util.Log;

public class FileRetriever {
	
	public HashMap<String, String> retrieve(File rootDirectory, String[] extensions) {
		Log.d("rootdirectory", rootDirectory.getAbsolutePath());
		HashMap<String, String> fileMap = new HashMap<String, String>();
		File[] files = rootDirectory.listFiles();
		for(File f : files) {
			for(String ext : extensions)
			if(f.getName().endsWith(ext)) {
				fileMap.put(f.getName(), f.getAbsolutePath());
			}
		}
		return fileMap;
	}
}
