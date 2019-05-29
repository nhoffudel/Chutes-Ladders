package edu.udel.ckcamp.extremechutesandladders;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ClickableViewAccessibility")
public class SplashScreen extends LinearLayout implements View.OnTouchListener, View.OnClickListener, OnItemClickListener{

	private ExtremeChutesAndLaddersActivity activity;

	private ImageView imageView;
	private Bitmap splashImage;
	private Button button;

	private PopupMenu selectOptions;

	public SplashScreen(ExtremeChutesAndLaddersActivity activity) {
		super(activity);
		this.activity = activity;
		this.imageView = new ImageView(activity);
		this.button = new Button(activity);

		init();

		splashImage = BitmapFactory.decodeResource(activity.getResources(), 
				activity.getResources().getIdentifier("menu_image", "drawable", getClass().getPackage().getName()));

		setBackgroundDrawable(new BitmapDrawable(splashImage));


	}

	private void init() {
		setOrientation(LinearLayout.VERTICAL);

		imageView.setImageBitmap(splashImage);
		imageView.setAdjustViewBounds(true);
		setOnTouchListener(this);

		selectOptions = new PopupMenu(activity, "Extreme Chutes and Ladders",
				new String[]{"1 Player","1 Player, 3 AI", "2 Player", "2 Player, 2 AI", "3 Player, 1 AI", "4 Player",
				"AI-AI", "4 AI", "Instructions", "Quit"}, this, 20);

		button.setText("Touch to begin");
		button.setTypeface(Typeface.SANS_SERIF);
		button.setGravity(Gravity.CENTER);
		button.setBackgroundColor(Color.BLACK);
		button.setTextColor(Color.WHITE);
		button.setOnClickListener(this);

		button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		addView(imageView);
		addView(button);
	}

	@Override
	public void onClick(View v) {
		if (v == button) {
			selectOptions.show();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			selectOptions.show();
		}
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		activity.selectMenuOption(((TextView)view).getText());
	}
}

