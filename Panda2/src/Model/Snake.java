package Model;

import java.util.Random;

import Enum.SnakeColor;

public class Snake {

	private SnakeColor Color;

	private int XHeadNum;
	private int YHeadNum;
	private int XTailNum;
	private int YTailNum;
	Random rand = new Random();

	public Snake(SnakeColor color) {
		super();
		Color = color;
	}

	public SnakeColor getColor() {
		return Color;
	}

	public void setColor(SnakeColor color) {
		Color = color;
	}

	public int getXHeadNum() {
		return XHeadNum;
	}

	public void setXHeadNum(int xHeadNum) {
		XHeadNum = xHeadNum;
	}

	public int getYHeadNum() {
		return YHeadNum;
	}

	public void setYHeadNum(int yHeadNum) {
		YHeadNum = yHeadNum;
	}

	public int getXTailNum() {
		return XTailNum;
	}

	public void setXTailNum(int xTailNum) {
		XTailNum = xTailNum;
	}

	public int getYTailNum() {
		return YTailNum;
	}

	public void setYTailNum(int yTailNum) {
		YTailNum = yTailNum;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	

}
