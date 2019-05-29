package edu.udel.ckcamp.extremechutesandladders;

public class Cards {
	private int cardIndex;
	public Cards() {
		this.cardIndex = (int) (Math.random() * 11);
	}
	
	public int getCardIndex() {
		return this.cardIndex;
	}
	
	public String toString() {
		Cards card = new Cards();
		int cardIndex = card.getCardIndex();
		if (0 <= cardIndex && cardIndex <= 3) {
			int spacesForward = cardIndex + 1;
			return "Move forward " + spacesForward + " Space(s)";
		}
		else if (3 < cardIndex && cardIndex <= 7) {
			int spacesBackward = cardIndex - 3;
			return "Move Backwards " + spacesBackward + " Space(s)";
		}
		else if (cardIndex == 8) {
			return "Switch Places with Person in front of you";
		}
		else if (cardIndex == 9) {
			return "Switch Places with Person behind you";
		}
		else {
			return "You drew a blank card";
		}
	}
	
	public void setCard(int index) {
		this.cardIndex = index;
	}
}