package edu.udel.ckcamp.extremechutesandladders;

public class Ladder extends Space {
	Ladder() {
		super('L');
	}
	
	private int endHeight;
	private int endWidth;
	
	Ladder(int startHeight, int startWidth, int endHeight, int endWidth) {
		super('L', startHeight, startWidth, true);
		this.endHeight = endHeight;
		this.endWidth = endWidth;
	}
	
	public int getEndHeight() {
		return this.endHeight;
	}
	
	public int getEndWidth() {
		return this.endWidth;
	}
	
}
