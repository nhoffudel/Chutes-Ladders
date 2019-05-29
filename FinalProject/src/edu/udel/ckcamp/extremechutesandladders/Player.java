package edu.udel.ckcamp.extremechutesandladders;


public class Player {
	private char name;
	private int turnNumber;
	private boolean isComputer;
	private Space position;
	
	public Player(char name, int turnNumber, boolean isComputer) {
		this.name = name;
		this.turnNumber = turnNumber;
		this.isComputer = isComputer;
		this.position = new Space('P', 9, 0, false);
	}
	
	public char getName() {
		return this.name;
	}
	
	public int getTurnNumber() {
		return this.turnNumber;
	}
	
	public boolean getIsComputer() {
		return this.isComputer;
	}
	
	public Space getSpace() {
		return this.position;
	}
	
	public int getSpaceNumber() {
		return this.getSpace().getSquareNumber();
	}
	
	public void autoSetPosition(int height, int width) {
		this.setPosition(new Space(this.getName(), height, width, false));
	}
	
	public void setPosition(Space newSpace) {
		this.position = newSpace;
		newSpace.setSymbol(this.getName());
	}
	
	public void setHuman() {
		this.isComputer = false;
	}
	
	public void setComputer() {
		this.isComputer = true;
	}
}
