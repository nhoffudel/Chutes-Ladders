package edu.udel.ckcamp.extremechutesandladders;

import edu.udel.ckcamp.gameframework.Action;

public class drawCardAction implements Action<ChutesAndLaddersGame> {
	Cards card;
	private Player player1;
	private Player player2;


	public drawCardAction(Player player1, Player player2) {
		this.card = new Cards();
		this.player1 = player1;
		this.player2 = player2;
	}
	public drawCardAction(Player player1) {
		this.card = new Cards();
		this.setPlayer1(player1);
	}

	@Override
	public boolean isValid(ChutesAndLaddersGame s) {
		return true;
	}

	@Override
	public void update(ChutesAndLaddersGame s) {
		if (s.getDrawTime()) {
			s.move(this.cardEffect(s.getPlayerTurn(), s.getNextPlayer(), s), s.getPlayerTurn());
			s.setPreviousAction(this.toString());
			s.isEnd();
			s.drawReady();
			s.changeTurn();
		}		
	}

	public int cardEffect(Player player1, Player player2, ChutesAndLaddersGame game) {
		int cardIndex = this.card.getCardIndex();
		if (0 <= cardIndex && cardIndex <= 3) {
			return cardIndex + 1;
		}
		else if (3 < cardIndex && cardIndex <= 7) {
			return  (-1 * (cardIndex - 3));
		}
		else if (cardIndex == 8) {
			if (player2 != null) {
				Space newSpace = player2.getSpace();
				Space oldSpace = player1.getSpace();
				player2.setPosition(oldSpace);
				player1.setPosition(newSpace);
			}
			return 0;
		}
		else {
			return 0;
		}
	}

	public String toString() {
		if (0 <= card.getCardIndex() && card.getCardIndex() <= 3) {
			return "Player " + this.getPlayer1().getName() + " has drawn the card 'Move Forward " + (card.getCardIndex() + 1) + " Spaces'";
		}
		else if (4 <= card.getCardIndex() && card.getCardIndex() <= 7) {
			return "Player " + this.getPlayer1().getName() + " has drawn the card 'Move Backward " + (card.getCardIndex() - 3) + " Spaces'";
		}
		else if (card.getCardIndex() == 8) {
			if (this.getPlayer2() != null) {
				return "Player " + this.getPlayer1().getName() + " has drawn the card 'Switch Places with Player " + this.getPlayer2().getName() + "'";
			}
			else {
				return "Player " + this.getPlayer1().getName() + " has switched places with the next player";
			}
		}
		else {
			return "Player " + this.getPlayer1().getName() + " drew a blank card";
		} 
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
}
