package edu.udel.ckcamp.extremechutesandladders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class VictoryScreen extends LinearLayout implements View.OnClickListener {

	private ExtremeChutesAndLaddersActivity activity;

	private ImageView imageView;
	private Bitmap victoryImage1;
	private Bitmap victoryImage2;
	private Bitmap victoryImage3;
	private Bitmap victoryImage4;
	private Bitmap victoryImage5;
	private Bitmap victoryImage6;

	private Button button;

	public VictoryScreen(ExtremeChutesAndLaddersActivity activity) {
		super(activity);

		this.activity = activity;
		this.imageView = new ImageView(activity);
		this.button = new Button(activity);

		init();
	}

	private void init() {
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundColor(Color.rgb(255, 192, 0));
		imageView.setAdjustViewBounds(true);

		button.setText("Touch here to return to title screen");
		button.setTypeface(Typeface.SANS_SERIF);
		button.setGravity(Gravity.CENTER);
		button.setBackgroundColor(Color.BLACK);
		button.setTextColor(Color.WHITE);
		button.setOnClickListener(this);

		button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.80f));
		imageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.20f));
		addView(imageView);
		addView(button);
	}

	@Override
	public void onClick(View v) {
		if (v == button) {
			activity.setAppView("Splash");
		}

	}

	public void updateScreen() {
		if (activity.getCurrentGame().getWinner() != '0'); {
			if (activity.getCurrentGame().getTurnList().length == 4) {
				if (activity.getCurrentGame().getWinner() == '1') {
					victoryImage1 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen1", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage1);
				}
				else if (activity.getCurrentGame().getWinner() == '2') {
					victoryImage2 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen2", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage2);
				}
				else if (activity.getCurrentGame().getWinner() == '3') {
					victoryImage3 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen3", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage3);
				}
				else if (activity.getCurrentGame().getWinner() == '4') {
					victoryImage4 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen4", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage4);
				}
			}
			else {
				if (activity.getCurrentGame().getWinner() == '1') {
					victoryImage5 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen5", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage5);
				}
				else if (activity.getCurrentGame().getWinner() == '2') {
					victoryImage6 = BitmapFactory.decodeResource(activity.getResources(), 
							activity.getResources().getIdentifier("victory_screen6", "drawable", getClass().getPackage().getName()));
					imageView.setImageBitmap(victoryImage6);
				}
			}
		}
	}


}
