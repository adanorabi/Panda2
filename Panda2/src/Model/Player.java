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

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPlayerCol() {
		return PlayerCol;
	}



	public int getPlayerRow() {
		return PlayerRow;
	}


}
