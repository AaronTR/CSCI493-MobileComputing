package com.aaronrowe.homeworkone;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final int BITMAP_WIDTH = 300;
	public static final int BITMAP_HEIGHT = 300;
	
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
		
		builder = new BitmapBuilder(createSimpleTextOptions());
		bitmap = builder.buildBitmap(getString(R.string.app_name), BITMAP_WIDTH, BITMAP_HEIGHT);
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
		paint.setTextSize(20);
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
	
	private void calculateBitmapSize() {
		//TODO adjust bitmap size to device params
	}

}
