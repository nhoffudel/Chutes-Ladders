package edu.udel.ckcamp.extremechutesandladders;

public class Chute extends Space {
	Chute() {
		super('C');
	}
	
	private int endHeight;
	private int endWidth;
	
	Chute(int startHeight, int startWidth, int endHeight, int endWidth) {
		super('C', startHeight, startWidth, true);
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
