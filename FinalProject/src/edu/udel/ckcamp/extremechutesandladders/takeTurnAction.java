package edu.udel.ckcamp.extremechutesandladders;
import edu.udel.ckcamp.gameframework.Action;

public class takeTurnAction implements Action<ChutesAndLaddersGame> {
	private Player player;
    private int diceRoll;
	
	public takeTurnAction(Player player) {
		this.player = player;
		this.diceRoll = rollDice();
	}
	
	public takeTurnAction(Player player, int roll) {
		this.player = player;
		this.diceRoll = roll;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getDiceRoll() {
		return this.diceRoll;
	}
	
	/**
     * Moving to a space is only valid if:
     * 1. It is within the bounds of the board
     * 2. and it is the player's turn
     */
	
	public boolean isValid(ChutesAndLaddersGame s) {
		int width = this.getPlayer().getSpace().getWidth();
		int height = this.getPlayer().getSpace().getHeight();
		int roll = this.getDiceRoll();		
        return  width >= 0 &&  height >= 0 && ((height <= 9 && width + roll <=9) || (height < 9)) &&
                s.getTurn() == player.getName();        
    }
	
	public static int rollDice() {
		return (int) (Math.random()*6 + 1);
	}
	
	
	public void update(ChutesAndLaddersGame s) {
        s.move(this.getDiceRoll(), s.getPlayerTurn());
        s.setPreviousAction(this.toString());
        s.isEnd();
        s.drawReady();
    }
	
	public String toString() {
        return "Player " + this.getPlayer().getName() + " has rolled a " + this.getDiceRoll();
    }
		
}
