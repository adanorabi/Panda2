package Model;


import Enum.Color;

public class Player {

	private int PlayerID;
	private Color playerColor ;
	private String nickName;
	private int PlayerCol;
	private int PlayerRow;

	public Player(int playerID, Color playerColor, String nickName, int playerCol, int playerRow) {
		super();
		PlayerID = playerID;
		this.playerColor = playerColor;
		this.nickName = nickName;
		PlayerCol = playerCol;
		PlayerRow = playerRow;
	}

	
}
