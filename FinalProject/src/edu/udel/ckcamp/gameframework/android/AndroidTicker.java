package edu.udel.ckcamp.gameframework.android;

import android.os.Handler;
import edu.udel.ckcamp.gameframework.GameTicker;

public class AndroidTicker extends GameTicker implements Runnable {
    private Handler timer;

    public AndroidTicker() {
        timer = new Handler();
    }
    
    protected void nextTask() {
        timer.postDelayed(this, game.getRealTimeTickLength());
    }
    
    public void run() {
        tick();
    }
}
