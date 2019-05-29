package edu.udel.ckcamp.extremechutesandladders;

import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.view.View;

public class DrawScreenView extends LinearLayout implements View.OnClickListener {

	private ExtremeChutesAndLaddersActivity activity;
	
	private TextView textView;
	
	private Button[] buttonRow1;
	private Button[] buttonRow2;
	private Button[] buttonRow3;
	private Button[] buttonRow4;
	private Button card1;
	private Button card2;
	private Button card3;
	private Button card4;
	private Button card5;
	private Button card6;
	private Button card7;
	private Button card8;
	private Button card9;
	private Button card10;
	private Button card11;
	private Button card12;
	
	public DrawScreenView(ExtremeChutesAndLaddersActivity activity) {
		super(activity);
		
		this.activity = activity;
		this.textView = new TextView(activity);
		
		card1 = new Button(activity);
		card2 = new Button(activity);
		card3 = new Button(activity);
		card4 = new Button(activity);
		card5 = new Button(activity);
		card6 = new Button(activity);
		card7 = new Button(activity);
		card8 = new Button(activity);
		card9 = new Button(activity);
		card10 = new Button(activity);
		card11 = new Button(activity);
		card12 = new Button(activity);
		
		init();
	}

	private void init() {
		
		//LinearLayout layout = new LinearLayout(this.activity);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundColor(Color.BLACK);
		
		LinearLayout buttonLayout1 = new LinearLayout(this.activity);
		LinearLayout buttonLayout2 = new LinearLayout(this.activity);
		LinearLayout buttonLayout3 = new LinearLayout(this.activity);
		LinearLayout buttonLayout4 = new LinearLayout(this.activity);
		
		card1.setOnClickListener(this);
		card2.setOnClickListener(this);
		card3.setOnClickListener(this);
		card4.setOnClickListener(this);
		card5.setOnClickListener(this);
		card6.setOnClickListener(this);
		card7.setOnClickListener(this);
		card8.setOnClickListener(this);
		card9.setOnClickListener(this);
		card10.setOnClickListener(this);
		card11.setOnClickListener(this);
		card12.setOnClickListener(this);
		
		buttonRow1 = new Button[]{card1, card2, card3};
		buttonRow2 = new Button[]{card4, card5, card6};
		buttonRow3 = new Button[]{card7, card8, card9};
		buttonRow4 = new Button[]{card10, card11, card12};
		for (Button b : buttonRow1) {
			b.setText("PICK ME");
            b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.66f));
            b.setTextColor(Color.BLACK);
            buttonLayout1.addView(b);    
        }
		for (Button b : buttonRow2) {
			b.setText("PICK ME");
            b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.66f));
            b.setTextColor(Color.BLACK);
            buttonLayout2.addView(b);    
        }
		for (Button b : buttonRow3) {
			b.setText("PICK ME");
            b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.66f));
            b.setTextColor(Color.BLACK);
            buttonLayout3.addView(b);    
        }
		for (Button b : buttonRow4) {
			b.setText("PICK ME");
            b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.66f));
            b.setTextColor(Color.BLACK);
            buttonLayout4.addView(b);    
        }
		
		addView(textView);
		textView.setText("CHOOSE A CARD");
		textView.setTextColor(Color.DKGRAY);
		textView.setGravity(Gravity.CENTER);
		addView(buttonLayout1);
		buttonLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.75f));
		
		addView(buttonLayout2);
		buttonLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.75f));
		
		addView(buttonLayout3);
		buttonLayout3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.75f));
		
		addView(buttonLayout4);
		buttonLayout4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.75f));
	}

	@Override
	public void onClick(View v) {
		if (v instanceof Button) {
			activity.setAppView("Game");
			drawCardAction draw = new drawCardAction(activity.getCurrentGame().getPlayerTurn(), activity.getCurrentGame().getNextPlayer());
			activity.getCurrentGame().perform(draw);
			Toast.makeText(activity.getApplicationContext(), draw.toString(), Toast.LENGTH_SHORT).show();

			
		}
	}

}
