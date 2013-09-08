package com.aaronrowe.homeworkone;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;

public class BitmapBuilder {

	public static final int TEXT_SIZE = 10;
	public static final int CANVAS_X = 5;
	public static final int CANVAS_Y = 5;
	
	private Paint paint;
	
	public BitmapBuilder(Paint p) {
		this.paint = p;
	}
	
	public Bitmap buildBitmap(String text, int width, int height) {
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		return drawBitmap(text, bitmap);
	}
	
	public Bitmap drawBitmap(String text, Bitmap bitmap) {
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(0, Mode.CLEAR);
		canvas.drawText(text, getRealignedX(bitmap, text), MainActivity.BITMAP_HEIGHT/2, this.paint);
		return bitmap;
	} 
	
	private int getRealignedX(Bitmap bm, String text) {
		int halfText = (int) (paint.measureText(text)/2);
		return bm.getWidth() / 2 - halfText;
	}
	
	private void formatTextToFit() {
		//TODO wrap larger text to fill bitmap
	}
}