package com.example.photoviewer;

import java.io.File;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private static final int THUMBNAIL_SIZE = 85;
	
	private ArrayList<Uri> uris;
	private Context context;
	
	public ImageAdapter(Context context, ArrayList<Uri> uris) {
		this.context = context;
		this.uris = uris;
	}
	
	@Override
	public int getCount() {
		return uris.size();
	}

	@Override
	public Object getItem(int pos) {
		return uris.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return 0;
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	public View getView(int pos, View convertView, ViewGroup vg) {
		ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(THUMBNAIL_SIZE, THUMBNAIL_SIZE));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        Uri chosenOne = uris.get(pos);
        Bitmap bm = createThumbnail(chosenOne);
        Drawable d = new BitmapDrawable(context.getResources(), bm);
        
        imageView.setBackgroundDrawable(d);
        return imageView;
	}
	
	private Bitmap createThumbnail(Uri uri) {
		File image = new File(uri.getPath());

	    BitmapFactory.Options bounds = new BitmapFactory.Options();
	    bounds.inJustDecodeBounds = true;
	    BitmapFactory.decodeFile(image.getPath(), bounds);
	    if ((bounds.outWidth == -1) || (bounds.outHeight == -1))
	        return null;

	    int originalSize = (bounds.outHeight > bounds.outWidth) ? bounds.outHeight
	            : bounds.outWidth;

	    BitmapFactory.Options opts = new BitmapFactory.Options();
	    opts.inSampleSize = originalSize / THUMBNAIL_SIZE;
	    return BitmapFactory.decodeFile(image.getPath(), opts); 
	}

}
