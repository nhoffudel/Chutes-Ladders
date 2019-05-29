package edu.udel.ckcamp.extremechutesandladders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class ChutesAndLaddersView2D extends View {

	protected ExtremeChutesAndLaddersActivity activity;

	private Bitmap boardImage;



	public ChutesAndLaddersView2D(ExtremeChutesAndLaddersActivity context) {
		super(context);
		activity = context;

		setFocusable(true);
		setFocusableInTouchMode(true);
		boardImage = loadImage("board_background");
		setBackgroundDrawable(new BitmapDrawable(boardImage));

	}

	private Bitmap loadImage(String name) {
		return BitmapFactory.decodeResource(activity.getResources(), 
				activity.getResources().getIdentifier(name, "drawable", getClass().getPackage().getName()));
	}

	/**
	 * Provides specific implementation for a ChutesAndLaddersView.  This view has 3 main components:
	 *   - a grid
	 *   - a set of pieces
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// set the canvas so that it scales the screen to our world coordinates
		canvas.save();
		canvas.scale(getWidth() / 10f, getHeight() / 10f);
		
		//draws the players on the board
		drawPlayers(canvas);

		// set the canvas scaling back (this is necessary)
		canvas.restore();

	}

	private void drawPlayers(Canvas canvas) {
		Player[] turnList = activity.getCurrentGame().getTurnList();
		for (Player a : turnList) {
			int i = a.getSpace().getHeight();
			int j = a.getSpace().getWidth();
			if (a.getName() == '1') {
				Paint APaint = new Paint();
				APaint.setColor(Color.argb(178, 0, 0, 0));
				APaint.setStyle(Style.FILL_AND_STROKE);
				canvas.drawCircle((float) (j + 0.5), (float) (i + 0.5), (float) (0.4), APaint);
				APaint.setColor(Color.WHITE);
				APaint.setTextSize(.75f);
				canvas.drawText("1", (float) (j + 0.30), (float) (i + 0.75), APaint);
				invalidate();
			}
			else if (a.getName() == '2') {
				Paint BPaint = new Paint();
				BPaint.setColor(Color.argb(178, 80, 1, 90));
				BPaint.setStyle(Style.FILL_AND_STROKE);
				canvas.drawCircle((float) (j + 0.5), (float) (i + 0.5), (float) (0.4), BPaint);
				BPaint.setColor(Color.WHITE);
				BPaint.setTextSize(.75f);
				canvas.drawText("2", (float) (j + 0.30), (float) (i + 0.75), BPaint);
				invalidate();
			}
			else if (a.getName() == '3') {
				Paint CPaint = new Paint();
				CPaint.setColor(Color.argb(178, 64, 0, 0));
				CPaint.setStyle(Style.FILL_AND_STROKE);
				canvas.drawCircle((float) (j + 0.5), (float) (i + 0.5), (float) (0.40), CPaint);
				CPaint.setColor(Color.WHITE);
				CPaint.setTextSize(.75f);
				canvas.drawText("3", (float) (j + 0.30), (float) (i + 0.75), CPaint);
				invalidate();
			}
			else if (a.getName() == '4') {
				Paint DPaint = new Paint();
				DPaint.setColor(Color.argb(178, 0, 13, 174));
				DPaint.setStyle(Style.FILL_AND_STROKE);
				canvas.drawCircle((float) (j + 0.5), (float) (i + 0.5), (float) (0.40), DPaint);
				DPaint.setColor(Color.WHITE);
				DPaint.setTextSize(.75f);
				canvas.drawText("4", (float) (j + 0.30), (float) (i + 0.75), DPaint);
				invalidate();
			}
		}
	}
}




