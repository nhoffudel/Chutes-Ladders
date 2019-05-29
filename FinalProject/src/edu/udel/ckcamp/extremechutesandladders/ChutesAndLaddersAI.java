package edu.udel.ckcamp.extremechutesandladders;
import edu.udel.ckcamp.gameframework.AI;

public class ChutesAndLaddersAI extends AI<ChutesAndLaddersGame> {
	public ChutesAndLaddersAI(char symbol, int turnNumber) {
        super(symbol, turnNumber);
        this.setPlayerAI(new Player(symbol, turnNumber, true));
    }
	
	public ChutesAndLaddersAI(Player player) {
		super(player.getName(), player.getTurnNumber());
		player.setComputer();
		this.setPlayerAI(player);
	}
    
    // convenience method
    private char getOurSymbol() {
        return getIdentifier();
    }
    
    protected boolean isMyTurn(ChutesAndLaddersGame game) {
        return game.getLastActionTickId() != game.getTickId() &&
    	 game.getTurn() == getOurSymbol();
    }

}
