package Model;

import java.util.Random;

public class Ladder {


	private int Length;
	private int XStart;
	private int YStart;
	private int XEnd;
	private int YEnd;
	Random rand = new Random();

	public Ladder(int length) {
		super();
		Length = length;
	}

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public int getXStart() {
		return XStart;
	}

	public void setXStart(int xStart) {
		XStart = xStart;
	}

	public int getYStart() {
		return YStart;
	}

	public void setYStart(int yStart) {
		YStart = yStart;
	}

	public int getXEnd() {
		return XEnd;
	}

	public void setXEnd(int xEnd) {
		XEnd = xEnd;
	}

	public int getYEnd() {
		return YEnd;
	}

	public void setYEnd(int yEnd) {
		YEnd = yEnd;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	
}
