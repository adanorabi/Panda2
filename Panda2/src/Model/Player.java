package Model;

import Enum.*;

public class Player {

	private int PlayerID;
	public static int counter=0;
	private PlayerColor playerColor ;
	private String nickName;
	private int PlayerCol;
	private int PlayerRow;
	private int playeringame;
	

	public Player(PlayerColor playerColor, String nickName, int playerCol, int playerRow,int playeringame) {
		super();
		this.PlayerID = this.counter++;
		this.playerColor = playerColor;
		this.nickName = nickName;
		this.PlayerCol = playerCol;
		this.PlayerRow = playerRow;
		this.playeringame=playeringame;
	}

	public Player() {
		super();
	}


	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public PlayerColor getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(PlayerColor playerColor) {
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
	
	public void UpdateRow(int playerRow) { //function that update player's row
		PlayerRow = playerRow;
	}
	public void UpdateCol(int playerCol) { //function that update player's column
		PlayerCol = playerCol;
	}

	public int getPlayeringame() {
		return playeringame;
	}

	public void setPlayeringame(int playeringame) {
		this.playeringame = playeringame;
	}
	

}
