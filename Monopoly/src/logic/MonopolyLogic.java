package logic;

/**
 * The place where all the game's logic is processed
 * @author André
 * @version 1.0
 * @created 23-mai-2014 01:04:25
 */
public class MonopolyLogic {

	private Board board;
	private Player[] players;
	/**
	 * LAN or local mode
	 */
	private String typeOfGame;

	public MonopolyLogic(Player[] players, String typeOfGame){
		board=new Board();
		this.players=players;
		
		if(typeOfGame=="LAN")
			lanMode();
		else
			localMode();

	}

	public void finalize() throws Throwable {

	}

	public void buyPropertie(){
		
	}

	public void lanMode(){

	}

	public void localMode(){

	}

	public void playerTurn(){

	}

	/**
	 * 
	 * @param playerName
	 */
	public Boolean tradePropertie(String playerName){
		return false;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}

	/**
	 * @return the typeOfGame
	 */
	public String getTypeOfGame() {
		return typeOfGame;
	}

	/**
	 * @param typeOfGame the typeOfGame to set
	 */
	public void setTypeOfGame(String typeOfGame) {
		this.typeOfGame = typeOfGame;
	}

}