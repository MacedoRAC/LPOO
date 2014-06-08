package logic;

import java.io.Serializable;


public class Board implements Serializable{

	private static final long serialVersionUID = 1L;
	private Card[] bottomSpaces;
	//private MiddleCards chance;
	//private MiddleCards communityChest;
	private Card[] leftSpaces;
	private Card[] rightSpaces;
	private Card[] topSpaces;

	public Board(){
		initializeBottomSpaces();
		initializeTopSpaces();
		initializeRightSpaces();
		initializeLeftSpaces();
	}

	private void initializeLeftSpaces() {
		// TODO Auto-generated method stub
		
	}

	private void initializeTopSpaces() {
		// TODO Auto-generated method stub
		
	}

	private void initializeRightSpaces() {
		// TODO Auto-generated method stub
		
	}

	private void initializeBottomSpaces() {
		// TODO Auto-generated method stub
		
	}

	public void finalize() throws Throwable {

	}

	public Card[] getBottomSpaces(){
		return bottomSpaces;
	}

	/*public MiddleCards getChance(){
		return null;
	}

	public MiddleCards getCommunityChest(){
		return null;
	}*/

	public Card[] getLeftSpaces(){
		return leftSpaces;
	}

	public Card[] getRightSpaces(){
		return rightSpaces;
	}

	public Card[] getTopSpaces(){
		return topSpaces;
	}

	/**
	 * 
	 * @param bottomSpaces
	 */
	public void setBottomSpaces(Card[] bottomSpaces){
		this.bottomSpaces=bottomSpaces;
	}

	/**
	 * 
	 * @param chance
	 */
	/*public void setChance(MiddleCards chance){

	}*/

	/**
	 * 
	 * @param communityChest
	 */
	/*public void setCommunityChest(MiddlleCards communityChest){

	}*/

	/**
	 * 
	 * @param leftSpaces
	 */
	public void setLeftSpaces(Card[] leftSpaces){
		this.leftSpaces=leftSpaces;
	}

	/**
	 * 
	 * @param rightSpaces
	 */
	public void setRightSpaces(Card[] rightSpaces){
		this.rightSpaces=rightSpaces;
	}

	/**
	 * 
	 * @param topSpaces
	 */
	public void setTopSpaces(Card[] topSpaces){
		this.topSpaces=topSpaces;
	}

}