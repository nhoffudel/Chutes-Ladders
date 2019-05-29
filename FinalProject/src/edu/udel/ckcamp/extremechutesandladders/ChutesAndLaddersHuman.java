package edu.udel.ckcamp.extremechutesandladders;

import java.util.Set;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChutesAndLaddersHuman implements View.OnClickListener {

	private ExtremeChutesAndLaddersActivity activity;

	private Set<Player> humanPlayers;

	public ChutesAndLaddersHuman (ExtremeChutesAndLaddersActivity activity, 
			Set<Player> humanPlayers) {
		this.humanPlayers = humanPlayers;
		this.activity = activity;
	}

	public void onClick(View v) {
		ChutesAndLaddersGame game = activity.getCurrentGame();
		Player[] turnList = game.getTurnList();
		if (game != null) {
			if (humanPlayers.contains(turnList[game.getTurnNumber()])) {
				if (v instanceof Button) {
					Button b = (Button) v;
					String text = b.getText().toString();
					if (text.equals("Draw Card") && game.getDrawTime()) {
						activity.setAppView("Card");
					}
					else if (text.equals("Roll Dice") && !game.getDrawTime()) {
						int diceRoll = takeTurnAction.rollDice();
						Toast.makeText(activity.getApplicationContext(), diceRoll + "", Toast.LENGTH_SHORT).show();
						game.setCurrentRoll(diceRoll);
						game.perform(new takeTurnAction(game.getPlayerTurn(), diceRoll));
					}
					else if (text.equals("Roll Dice") && game.getDrawTime()){
						Toast.makeText(activity.getApplicationContext(), "Draw a card.", Toast.LENGTH_LONG).show();
					}
					else if (text.equals("Draw Card") && !game.getDrawTime()){
						Toast.makeText(activity.getApplicationContext(), "Roll the dice.", Toast.LENGTH_LONG).show();
					}
				}
			}
		}
	}
}
