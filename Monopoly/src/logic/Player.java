package logic;

import java.util.ArrayList;

/**
 * @author Mário Macedo
 * @version 1.0
 * @created 23-mai-2014 01:04:28
 */
public class Player {

	private boolean inJail;
	/**
	 * Necessary to verify if player has passed by start position
	 */
	private int lastLocation;
	/**
	 * 0(go) to 40 
	 */
	private int location;
	private int money;
	private String name;
	private ArrayList<Card> OwnedProperties;
	private Boolean won;

	public Player(){
		inJail=false;
		setLastLocation(0);
		location=0;
		money=1500;
		name="";
		OwnedProperties=new ArrayList<Card>();
		won=false;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param name
	 */
	public Player(String name){
		inJail=false;
		setLastLocation(0);
		location=0;
		money=1500;
		this.name=name;
		OwnedProperties=new ArrayList<Card>();
		won=false;

	}

	/**
	 * 
	 * @param propertie
	 */
	public void addPropertie(Card propertie){
		OwnedProperties.add(propertie);

	}

	public int getLocation(){
		return location;
	}

	public int getMoney(){
		return money;
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Card> getOwnedProperties(){
		return OwnedProperties;
	}

	public boolean isInJail(){
		return inJail;
	}

	/**
	 * 
	 * @param inJail
	 */
	public void setInJail(boolean inJail){
		this.inJail=inJail;

	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(int location){
		this.location=location;

	}

	/**
	 * <font color="#7f9fbf"><b>return</b></font><font color="#3f5fbf"> the
	 * money</font>
	 * 
	 * @param money
	 */
	public void setMoney(int money){
		this.money=money;

	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name=name;

	}

	/**
	 * 
	 * @param ownedProperties
	 */
	public void setOwnedProperties(ArrayList<Card> ownedProperties){
		this.OwnedProperties=ownedProperties;

	}

	/**
	 * if a player is the only one with money wins the game
	 */
	public Boolean somePlayerWon(){
		return won;
	}

	/**
	 * @return the lastLocation
	 */
	public int getLastLocation() {
		return lastLocation;
	}

	/**
	 * @param lastLocation the lastLocation to set
	 */
	public void setLastLocation(int lastLocation) {
		this.lastLocation = lastLocation;
	}

}