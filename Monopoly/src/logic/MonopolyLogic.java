package logic;

import java.util.Random;

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
	private Player playerPlaying;
	private int indexPlayerPlaying;
	private boolean playerWon;

	public MonopolyLogic(Player[] players, String typeOfGame){
		board=new Board();
		this.players=players;
		indexPlayerPlaying=0;
		playerPlaying = players[indexPlayerPlaying];
		playerWon=false;

		if(typeOfGame=="LAN")
			lanMode();
		

	}

	public void finalize() throws Throwable {

	}

	public void buyPropertie(){

		Card card = returnCard(playerPlaying.getLocation());
		
		if(card.getOwner() == null){
			card.setOwner(playerPlaying);
			playerPlaying.addPropertie(card);
		}
	}

	private Card returnCard(int location) {

		if(location>=0 && location <=9){
			for(int i=0; i<board.getBottomSpaces().length; i++)
				if(location == board.getBottomSpaces()[i].getLocationOnBoard())
					return board.getBottomSpaces()[i];
		}else if(location>=10 && location <=19){
			for(int i=0; i<board.getLeftSpaces().length; i++)
				if(location == board.getLeftSpaces()[i].getLocationOnBoard())
					return board.getLeftSpaces()[i];
		}else if(location>=20 && location <=29){
			for(int i=0; i<board.getTopSpaces().length; i++)
				if(location == board.getTopSpaces()[i].getLocationOnBoard())
					return board.getTopSpaces()[i];
		}else{
			for(int i=0; i<board.getTopSpaces().length; i++)
				if(location == board.getTopSpaces()[i].getLocationOnBoard())
					return board.getTopSpaces()[i];
		}
		
		return null;
	}

	public void lanMode(){
		
	}

	public int rollDice(){
		int dice;
		Random r= new Random();

		dice=r.nextInt(12) + 1; //generate random number between 1 and 12

		return dice;
	}

	public void sellPropertie() {
		

	}
	
	/**
	 *Change the player who is playing 
	 */
	public void endOfTurn() {
		if(indexPlayerPlaying == players.length-1)
			indexPlayerPlaying =0;
		else
			indexPlayerPlaying++;
		
		playerPlaying = players[indexPlayerPlaying]; // time to next player play
		verifyIfSomePlayerWon();
	}

	private void verifyIfSomePlayerWon() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param playerName
	 */
	public Boolean tradePropertie(){
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

	/**
	 * @return the playerPlaying
	 */
	public Player getPlayerPlaying() {
		return playerPlaying;
	}

	/**
	 * @param playerPlaying the playerPlaying to set
	 */
	public void setPlayerPlaying(Player playerPlaying) {
		this.playerPlaying = playerPlaying;
	}
	

}