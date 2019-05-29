package edu.udel.ckcamp.extremechutesandladders;

public class Space {
	private char symbol;
	private int height;
	private int width;
	private int spaceNumber;
	private boolean empty;
	
	public Space(char symbol) {
		this.symbol = symbol;
		this.empty = true;
	}
	
	public Space(char symbol, int height, int width, boolean empty) {
		this.symbol = symbol;
		this.height = height;
		this.width = width;
		this.spaceNumber = (10 * (9 - height) + width + 1);
		this.empty = empty;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public boolean equals(Object obj) {
        return obj instanceof Space && ((Space)obj).symbol == symbol;
    }
	
	public String toString() {
        return Character.toString(symbol);
    }
	
	public int getSquareNumber() {
		return this.spaceNumber;
	}
	
	public boolean emptySpace() {
		return this.empty; 		
	}
	
	public void changeToEmpty() {
		this.empty = true;
		this.symbol = 'E';
	}
	
	public void changeToOccupied() {
		this.empty = false;
	}

	public void setHeight(int height) {
		this.height = height;	
	}
	
	public void setWidth(int width) {
		this.width = width;	
	}
	
	public void setSymbol(char s) {
		this.symbol = s;
	}
}
