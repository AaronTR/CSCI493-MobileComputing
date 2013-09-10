package com.aaronrowe.homeworkone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button button;
	private EditText editText;
	private ImageView imageView;
	
	private BitmapBuilder builder;
	private Bitmap bitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.press_me);
		editText = (EditText) findViewById(R.id.user_input);
		imageView = (ImageView) findViewById(R.id.image);
		
		Point size = calculateBitmapDimensions();
		builder = new BitmapBuilder(createSimpleTextOptions(), size.x, size.y);
		bitmap = builder.buildBitmap(getString(R.string.app_name));
		imageView.setImageBitmap(bitmap);
		
		button.setOnClickListener(clickListener);
	}
	
	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if(editText.getText().toString() != "") {
				updateBitmapFromEditText(editText);
				editText.setText("");
			}
			else {
				Toast.makeText(getBaseContext(), getString(R.string.toast_text), Toast.LENGTH_LONG).show();
			}
		}
		
	};
	
	private Paint createSimpleTextOptions() {
		Paint paint = new Paint();
		paint.setTextSize(25);
		paint.setColor(Color.WHITE);
		paint.setAlpha(200);
		paint.setTextAlign(Paint.Align.LEFT);
		return paint;
	}
	
	
	private void updateBitmapFromEditText(EditText et) {
		String text = et.getText().toString();
		Bitmap redrawn = builder.drawBitmap(text, bitmap);
		imageView.setImageBitmap(redrawn);
	}
	
	@SuppressLint("NewApi")
	private Point calculateBitmapDimensions() {
		Display display = this.getWindowManager().getDefaultDisplay();
		if(android.os.Build.VERSION.SDK_INT >= 13) { 
			Point size = new Point();
			display.getSize(size);
			return size;
		}
		int width = (int)(display.getWidth()/2);
		int height = (int)(display.getHeight()/2);
		return new Point(width, height);
	}

}
