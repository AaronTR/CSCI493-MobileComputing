package com.aaronrowe.homeworkone;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;

public class BitmapBuilder {
	
	private Paint paint;
	private int width, height;
	
	public BitmapBuilder(Paint p, int width, int height) {
		this.paint = p;
		this.width = width;
		this.height = height;
	}
	
	public Bitmap buildBitmap(String text) {
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		return drawBitmap(text, bitmap);
	}
	
	public Bitmap drawBitmap(String text, Bitmap bitmap) {
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(0, Mode.CLEAR);
		canvas.drawText(text, getRealignedX(bitmap, text), height/2, this.paint);
		return bitmap;
	} 
	
	private int getRealignedX(Bitmap bm, String text) {
		int halfText = (int) (paint.measureText(text)/2);
		return bm.getWidth() / 2 - halfText;
	}

	
}