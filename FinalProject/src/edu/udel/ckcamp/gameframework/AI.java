package edu.udel.ckcamp.gameframework;

import edu.udel.ckcamp.extremechutesandladders.Player;
import edu.udel.ckcamp.extremechutesandladders.drawCardAction;
import edu.udel.ckcamp.extremechutesandladders.takeTurnAction;

public abstract class AI<G extends Game> implements GameListener<G> {
    private char identifier;
    private Player playerAI;
    private boolean cardAI;
    public AI(char identifier, int turnNumber) {
        this.identifier = identifier;
        this.playerAI = new Player(identifier, turnNumber, true);
        this.cardAI = false;
    }
    
    public char getIdentifier() {
        return identifier;
    }
    
    public Player getPlayerAI() {
		return playerAI;
	}

	public void setPlayerAI(Player playerAI) {
		this.playerAI = playerAI;
	}
    
    public String toString() {
        return String.valueOf(getIdentifier());
    }
    
    public void onEndEvent(G game) {
    }
    
    /**
     * Subclass may override this, but AI does not need to
     * handle this event
     */
    public void onEvent(String event, G game) {
    }
    
    /**
     * 1. Check if it is "my" turn (always the case in a single player game)
     * 2. Perform the best action
     */
    protected void takeTurnIfMyTurn(G game) {
        if (isMyTurn(game)) {
            performAction(game);
        }
    }

    public void onStartEvent(G game) {
    }

    public void onPerformActionEvent(Action<G> action, G game) {
    }
    
    /**
     * Subclasses should override if they are multi-player games.
     */
    protected boolean isMyTurn(G game) {
        	return true;
    }
    
    /**
     * The AI will try to find its best action
     * to perform this tick and perform that action on the game.
     */
    public void onTickEvent(G game) {
        takeTurnIfMyTurn(game);
    }
    
    public Action<G> getAction(G game) {
    	if (cardAI == false) {
    		@SuppressWarnings("unchecked")
			Action<G> a = (Action<G>) new takeTurnAction(this.getPlayerAI());
    		this.cardAI = true;
    		return a;
    	}
    	else {
    		@SuppressWarnings("unchecked")
			Action<G> a = (Action<G>) new drawCardAction(this.getPlayerAI());
    		this.cardAI = false;
    		return a;
    	}
    }
    
    protected void performAction(G game) {
        Action<G> action = getAction(game);
        // in a turn based game the AI might have no best action (since
        //  no actions would be valid when it is not its turn)
        if (action != null) {
            game.perform(action);
        }
    }
}
