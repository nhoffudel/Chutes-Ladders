package edu.udel.ckcamp.extremechutesandladders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.udel.ckcamp.gameframework.Action;
import edu.udel.ckcamp.gameframework.GameListener;
import edu.udel.ckcamp.gameframework.android.AndroidTicker;
import android.R.color;
import	android.app.Activity;
import android.graphics.Color;

import	android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import	android.widget.TextView;

public class ExtremeChutesAndLaddersActivity extends Activity implements GameListener<ChutesAndLaddersGame> {
	private Map<String, View> appViews;
	
	private ChutesAndLaddersGame game;
	private ChutesAndLaddersView2D gameView;
	private TextView status;
	private TextView previousStatus;
	private Button rollButton;
	private Button cardButton;
	private VictoryScreen victoryScreen;
	private DrawScreenView drawScreenView;
	
	private Button[] buttons;

	private static final int GAMETYPE_HUMAN_AI	=	0;
	private static final int GAMETYPE_HUMAN_HUMAN	=	1;
	private static final int GAMETYPE_AI_AI	=	2;
	private static final int GAMETYPE_AI_HUMAN_HUMAN_HUMAN	=	4;
	private static final int GAMETYPE_AI_AI_HUMAN_HUMAN	=	5;
	private static final int GAMETYPE_AI_AI_AI_HUMAN	=	6;
	private static final int GAMETYPE_AI_AI_AI_AI	=	7;
	private static final int GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN = 8;

	private int gameType;

	protected void	onCreate(Bundle	savedInstanceState)	{						
		super.onCreate(savedInstanceState);
		appViews = new HashMap<String, View>();
		victoryScreen = new VictoryScreen(this);
		drawScreenView = new DrawScreenView(this);
		
		LinearLayout layout = new LinearLayout(this);
		
		status = new TextView(this);
		previousStatus = new TextView(this);
		previousStatus.setLines(2);
		previousStatus.setBackgroundColor(Color.BLUE);
		previousStatus.setTextColor(Color.YELLOW);
		gameView = new ChutesAndLaddersView2D(this);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(status);		
		
		rollButton = new Button(this);
		rollButton.setText("Roll Dice");
		cardButton = new Button(this);
		cardButton.setText("Draw Card");
		
		LinearLayout buttonLayout = new LinearLayout(this);
		buttonLayout.setBackgroundColor(color.black);
		
		buttons = new Button[]{rollButton, cardButton};
        for (Button b : buttons) {
            b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.5f));
            b.setTextColor(Color.BLACK);
            buttonLayout.addView(b);    
        }

		layout.addView(gameView);
		gameView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.205f));
		layout.addView(previousStatus);
		previousStatus.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.80f));
		layout.addView(buttonLayout);
		buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.80f));
		
		appViews.put("Game", layout);
        appViews.put("Splash", new SplashScreen(this));
        appViews.put("Victory", victoryScreen);
        appViews.put("Card", drawScreenView);
        appViews.put("Instructions", new InstructionsView(this));

        setAppView("Splash");
	}
	
	public void setAppView(String nameOfView) {
        View view = appViews.get(nameOfView);
        setContentView(view);
        view.invalidate();
    }

	public void updateViews() {
		this.victoryScreen.updateScreen();
		gameView.invalidate();
		status.setText(game.getStatus());
		previousStatus.setText(game.getPreviousAction());
	}

	public void onPerformActionEvent(Action<ChutesAndLaddersGame> action, ChutesAndLaddersGame game) {
		updateViews();
	}

	public void onTickEvent(ChutesAndLaddersGame game) {
		updateViews();
	}

	public void onStartEvent(ChutesAndLaddersGame game) {
		updateViews();
	}

	public void onEndEvent(ChutesAndLaddersGame game) {
		setAppView("Victory");
		updateViews();
	}

	public void onEvent(String event, ChutesAndLaddersGame game) {
		// TODO Auto-generated method stub

	}

	public ChutesAndLaddersGame getCurrentGame() {
		return this.game;
	}
	
	public void startGame() {
		Player player1 = new Player('1', 1, true);
		Player player2 = new Player('2', 2, true);
		Player player3 = new Player('3', 3, true);
		Player player4 = new Player('4', 4, true);
		double turnSelect = Math.random();
		if (gameType != 0 && gameType != 1 && gameType != 2) {
			Player[] turnList = {player1, player2, player3, player4};
			game = ChutesAndLaddersGame.makeStartGame(4, turnList);
			if	(0.5 > turnSelect && turnSelect	>= 0.25)	{
				game.changeTurn();
			}
			else if	(0.75 > turnSelect && turnSelect	>= 0.5)	{
				game.changeTurn();
				game.changeTurn();
			}
			else if	(1 > turnSelect && turnSelect	>= 0.75 )	{
				game.changeTurn();
				game.changeTurn();
				game.changeTurn();
			}
			game.addGameListener(this);
			Set<Player> humanPlayers = new HashSet<Player>();
			if	(gameType	==	GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN	||	gameType	==	GAMETYPE_AI_HUMAN_HUMAN_HUMAN
				|| gameType == GAMETYPE_AI_AI_HUMAN_HUMAN  || gameType	==	GAMETYPE_AI_AI_AI_HUMAN)	{
				player1.setHuman();
				humanPlayers.add(player1);
			}
			else {
				game.addGameListener(new ChutesAndLaddersAI(player1));
			}
			if (gameType ==	GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN	||	gameType	==	GAMETYPE_AI_HUMAN_HUMAN_HUMAN
					|| gameType == GAMETYPE_AI_AI_HUMAN_HUMAN) {
				player2.setHuman();
				humanPlayers.add(player2);
			}
			else {
				game.addGameListener(new ChutesAndLaddersAI(player2));
			}
			if (gameType ==	GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN	||	gameType	==	GAMETYPE_AI_HUMAN_HUMAN_HUMAN) {
				player3.setHuman();
				humanPlayers.add(player3);
			}
			else {
				game.addGameListener(new ChutesAndLaddersAI(player3));
			}
			if (gameType ==	GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN) {
				player4.setHuman();
				humanPlayers.add(player4);
			}
			else {
				game.addGameListener(new ChutesAndLaddersAI(player4));
			}
			game.start(new AndroidTicker());
			for (Button button : buttons) {
				button.setOnClickListener(new ChutesAndLaddersHuman(this, new HashSet<Player>(humanPlayers)));
			}
		}
		else {
			Player[] turnList = {player1, player2};
			game = ChutesAndLaddersGame.makeStartGame(2, turnList);
			if	(Math.random()	>	0.5)	{
				game.changeTurn();
			}
			game.addGameListener(this);
			Set<Player> humanPlayers = new HashSet<Player>();
			if	(gameType	==	GAMETYPE_HUMAN_HUMAN	||	gameType	==	GAMETYPE_HUMAN_AI)	{
				player1.setHuman();
				humanPlayers.add(player1);
			}
			else {
				game.addGameListener(new ChutesAndLaddersAI(player1));
			}
			if	(gameType	==	GAMETYPE_AI_AI	||	gameType	==	GAMETYPE_HUMAN_AI)	{
				game.addGameListener(new ChutesAndLaddersAI(player2));
			}
			else	{
				player2.setHuman();
				humanPlayers.add(player2);
			}
			game.start(new AndroidTicker());
			for (Button button : buttons) {
				button.setOnClickListener(new ChutesAndLaddersHuman(this, new HashSet<Player>(humanPlayers)));
			}
		}
		setAppView("Game");
	}

	@SuppressWarnings("static-access")
	public void	restartGame()	{
		if	(game != null && game.getLifecycle() !=	game.ENDED)	{
			game.end();
		}
		startGame();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("1 Player");
		menu.add("2 Player");
		menu.add("Restart Game");
		menu.add("Quit");
		menu.add("1 Player, 3 AI");
		menu.add("2 Player, 2 AI");
		menu.add("3 Player, 1 AI");
		menu.add("4 Player");
		menu.add("AI-AI");
		menu.add("4 AI");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		selectMenuOption(item.getTitle());
		if (item.getTitle().equals("1 Player")) {
			gameType = GAMETYPE_HUMAN_AI;
			restartGame();
		}
		else if (item.getTitle().equals("1 Player, 3 AI")) {
			gameType = GAMETYPE_AI_AI_AI_HUMAN;
			restartGame();
		}
		else if (item.getTitle().equals("2 Player")) {
			gameType = GAMETYPE_HUMAN_HUMAN;
			restartGame();
		}
		else if (item.getTitle().equals("2 Player, 2 AI")) {
			gameType = GAMETYPE_AI_AI_HUMAN_HUMAN;
			restartGame();
		}
		else if (item.getTitle().equals("3 Player, 1 AI")) {
			gameType = GAMETYPE_AI_HUMAN_HUMAN_HUMAN;
			restartGame();
		}
		else if (item.getTitle().equals("4 Player")) {
			gameType = GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN;
			restartGame();
		}
		else if (item.getTitle().equals("AI-AI")) {
			gameType = GAMETYPE_AI_AI;
			restartGame();
		}
		else if (item.getTitle().equals("4 AI")) {
			gameType = GAMETYPE_AI_AI_AI_AI;
			restartGame();
		}
		else if (item.getTitle().equals("Restart Game")) {
			restartGame();
		}
		else if (item.getTitle().equals("Quit")) {
			setAppView("Splash");
		}
		return true;
	}
	
	public void selectMenuOption(CharSequence title) {
		if (title.equals("1 Player")) {
			gameType = GAMETYPE_HUMAN_AI;
			restartGame();
		}
		else if (title.equals("Instructions")) {
			setAppView("Instructions");
		}
		else if (title.equals("1 Player, 3 AI")) {
			gameType = GAMETYPE_AI_AI_AI_HUMAN;
			restartGame();
		}
		else if (title.equals("2 Player")) {
			gameType = GAMETYPE_HUMAN_HUMAN;
			restartGame();
		}
		else if (title.equals("2 Player, 2 AI")) {
			gameType = GAMETYPE_AI_AI_HUMAN_HUMAN;
			restartGame();
		}
		else if (title.equals("3 Player, 1 AI")) {
			gameType = GAMETYPE_AI_HUMAN_HUMAN_HUMAN;
			restartGame();
		}
		else if (title.equals("4 Player")) {
			gameType = GAMETYPE_HUMAN_HUMAN_HUMAN_HUMAN;
			restartGame();
		}
		else if (title.equals("AI-AI")) {
			gameType = GAMETYPE_AI_AI;
			restartGame();
		}
		else if (title.equals("4 AI")) {
			gameType = GAMETYPE_AI_AI_AI_AI;
			restartGame();
		}
		else if (title.equals("Restart Game")) {
			restartGame();
		}
		else if (title.equals("Quit")) {
			finish();
		}
    }
}
