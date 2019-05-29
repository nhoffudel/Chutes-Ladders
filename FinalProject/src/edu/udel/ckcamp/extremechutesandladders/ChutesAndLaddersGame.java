//Casey Campbell, Nick Hoffman
//Extreme Trouble with Chutes And Ladders
//CISC 181-010 Spring 2015

package edu.udel.ckcamp.extremechutesandladders;
import edu.udel.ckcamp.gameframework.Game;

public class ChutesAndLaddersGame extends Game {

	private Space[][] board;
	private int playerNumber;
	private int turnNumber;
	private Player[] turnList;
	private boolean readyToDraw;
	private Chute[] Chutes = {new Chute(8, 4, 9, 5), new Chute(5, 6, 7, 5), new Chute(5, 8, 8, 9), 
			new Chute(3, 3, 4, 1), new Chute(1, 6, 7, 3), new Chute(0, 7, 2, 7), 
			new Chute(0, 2, 2, 2), new Chute(4, 1, 8, 1)};
	private Ladder[] Ladders = {new Ladder(9, 3, 8, 6), new Ladder(9, 9, 7, 9), new Ladder(7, 0, 5, 1), 
			new Ladder(7, 7, 1, 3), new Ladder(6, 4, 5, 3), new Ladder(4, 9, 3, 6), 
			new Ladder(2, 0, 0, 1)};
	private String previousAction;
	private char Winner;
	private int currentRoll;

	public ChutesAndLaddersGame(Space[][] board, int playerNumber, Player[] turnList) {
		this.board = board;
		this.playerNumber = playerNumber;
		this.turnNumber = 0;
		this.turnList = turnList;
		this.readyToDraw = false;
		this.previousAction = "";
		this.Winner = '0';
		this.currentRoll = 0;
	}

	public Space[][] getBoard() {
		return board;
	}

	public int getTurnNumber() {
		return this.turnNumber;
	}

	public char getTurn() {
		int turn = this.getTurnNumber();
		return turnList[turn].getName();
	}

	public Player getPlayerTurn() {
		int turn = this.getTurnNumber();
		return turnList[turn];
	}

	public Player[] getTurnList() {
		return this.turnList;
	}
	
	public boolean getDrawTime() {
		return this.readyToDraw;
	}
	
	public char getWinner() {
		return Winner;
	}
	
	public Player getNextPlayer() {
		if (this.getTurnNumber() + 1 <= this.playerNumber - 1) {
			return turnList[this.getTurnNumber() + 1];
		}
		else {
			return turnList[0];
		}
	}

	public int getCurrentRoll() {
		return currentRoll;
	}

	public void setCurrentRoll(int currentRoll) {
		this.currentRoll = currentRoll;
	}
	
	public void drawReady() {
		readyToDraw = !readyToDraw;
	}
	
	public void setPreviousAction(String string) {
		this.previousAction = string;
	}
	
	public String getPreviousAction() {
		return this.previousAction;
	}

	public void changeTurn() {
		if (this.turnNumber == playerNumber - 1) {
			this.turnNumber = 0;
		}
		else {
			this.turnNumber++;
		}
	}

	public boolean checkSpaceOccupied(int height, int width) {
		return board[height][width].emptySpace();
	}

	public void move(int spacesMoved, Player player) {
		Space oldSpace = player.getSpace();
		int addedSum = oldSpace.getWidth() + spacesMoved;
		int newHeight;
		int newWidth;
		if (addedSum > 9) {
			newWidth = addedSum - 10;
			newHeight = oldSpace.getHeight() - 1;
		}
		else if (addedSum < 0) {
			newWidth = addedSum + 10;
			newHeight = oldSpace.getHeight() + 1;
		}
		else {
			newWidth = addedSum;
			newHeight = oldSpace.getHeight();
		}
		if (isWithinBounds(newWidth, newHeight)) {
			if (board[newHeight][newWidth].getSymbol() == 'C') {

				for (int j = 0; j < Chutes.length; j++) {
					if (newWidth == Chutes[j].getWidth() && newHeight == Chutes[j].getHeight() && !checkSpaceOccupied(Chutes[j].getEndHeight(), Chutes[j].getEndWidth())/*board[Chutes[j].getEndHeight()][Chutes[j].getEndWidth()].getSymbol() != 'E'*/) {
						player.setPosition(new Space(player.getName(), Chutes[j].getEndHeight(), Chutes[j].getEndWidth() - 1, false));
						board[Chutes[j].getEndHeight()][Chutes[j].getEndWidth()] = new Space(player.getName(), Chutes[j].getEndHeight(), Chutes[j].getEndWidth(), false);
					}
					else if (newWidth == Chutes[j].getWidth() && newHeight == Chutes[j].getHeight() && checkSpaceOccupied(Chutes[j].getEndHeight(), Chutes[j].getEndWidth())) {
						player.setPosition(new Space(player.getName(), Chutes[j].getEndHeight(), Chutes[j].getEndWidth(), false));
						board[Chutes[j].getEndHeight()][Chutes[j].getEndWidth()] = new Space(player.getName(), Chutes[j].getEndHeight(), Chutes[j].getEndWidth(), false);
					}
				}
				board[oldSpace.getHeight()][oldSpace.getWidth()] = new Space('E', oldSpace.getHeight(), oldSpace.getWidth(), true);
			}
			else if (board[newHeight][newWidth].getSymbol() == 'L') {
				for (int j = 0; j < Ladders.length; j++) {
					if (newWidth == Ladders[j].getWidth() && newHeight == Ladders[j].getHeight() && !checkSpaceOccupied(Ladders[j].getEndHeight(), Ladders[j].getEndWidth())/*board[Ladders[j].getEndHeight()][Ladders[j].getEndWidth()].getSymbol() != 'E'*/) {
						player.setPosition(new Space(player.getName(), Ladders[j].getEndHeight(), Ladders[j].getEndWidth() - 1, false));
						board[Ladders[j].getEndHeight()][Ladders[j].getEndWidth() - 1] = new Space(player.getName(), Ladders[j].getEndHeight(), Ladders[j].getEndWidth() - 1, false);

					}
					else if (newWidth == Ladders[j].getWidth() && newHeight == Ladders[j].getHeight() && checkSpaceOccupied(Ladders[j].getEndHeight(), Ladders[j].getEndWidth())) {
						player.setPosition(new Space(player.getName(), Ladders[j].getEndHeight(), Ladders[j].getEndWidth(), false));
						board[Ladders[j].getEndHeight()][Ladders[j].getEndWidth()] = new Space(player.getName(), Ladders[j].getEndHeight(), Ladders[j].getEndWidth(), false);
					}
				}
				board[oldSpace.getHeight()][oldSpace.getWidth()] = new Space('E', oldSpace.getHeight(), oldSpace.getWidth(), true);
			}
			else {
				for (int i = 0; i < turnList.length; i++) {
					if (turnList[i].getSpace().getSquareNumber() == (10 * (9 - newHeight) + newWidth + 1)) {
						Player switcher = turnList[i];
						switcher.setPosition(new Space(turnList[i].getName(), oldSpace.getHeight(), oldSpace.getWidth(), false));
						board[oldSpace.getHeight()][oldSpace.getWidth()] = new Space(turnList[i].getName(), oldSpace.getHeight(), oldSpace.getWidth(), false); 
					}
					else {
						board[oldSpace.getHeight()][oldSpace.getWidth()] = new Space('E', oldSpace.getHeight(), oldSpace.getWidth(), true);
					}
				}
				player.setPosition(new Space(player.getName(), newHeight, newWidth, false));
				board[newHeight][newWidth] = new Space(player.getName(), newHeight, newWidth, false);
			}
		}
	}

	public String getStatus() {
		if (isEnd()) {
			return "Player " + board[0][9].getSymbol() + " Wins!";
		}
		else {
			return "Player " + turnList[turnNumber].getName() + "'s turn";
		}
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getStatus()+"\n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				buffer.append(board[i][j]);
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}


	public boolean isWithinBounds(int row, int column) {
		return row >= 0 && column >= 0 && 
				row < getBoard().length && 
				column < getBoard()[row].length;
	}

	public boolean isEnd() {
		return !(isEndUnoccupied());
	}

	public boolean isEndUnoccupied() {
		if (board[0][9].getSymbol() == 'F') {
			return true;
		}
		else {
			Winner = board[0][9].getSymbol();
			return false;
		}
	}

	public static ChutesAndLaddersGame makeStartGame(int playerNumber, Player[] turnList) {
		// creates a starting board
		Space E = new Space('E');
		Space C = new Chute();
		Space L = new Ladder();
		Space F = new Finish();
		Space S = new Start();
		

		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, E, E, E, E},
				{S, E, E, L, E, E, E, E, E, L}};

		return new ChutesAndLaddersGame(board, playerNumber, turnList);
	}

	
}
