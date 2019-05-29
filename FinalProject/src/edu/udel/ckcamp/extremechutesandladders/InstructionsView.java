package edu.udel.ckcamp.extremechutesandladders;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InstructionsView extends LinearLayout {
    private ExtremeChutesAndLaddersActivity activity;
    public InstructionsView(ExtremeChutesAndLaddersActivity activity) {
        super(activity);
        this.activity = activity;
        
        TextView instructionText = new TextView(activity);
        instructionText.setText("Turn based variant of Chutes and Ladders with deck of cards.  When it is your turn, click the 'Roll Dice' button to roll " +
        		"and then the 'Draw Card' button to pick a card.  To win, you must land on the final space exactly.  Pieces move from right to left and upward.");
        addView(instructionText);
    }
    
	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event) {
        activity.setAppView("Splash");
        return false;
    }
}
