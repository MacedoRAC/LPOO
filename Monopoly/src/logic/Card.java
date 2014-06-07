package logic;

import java.io.Serializable;

/**
 * @author André
 * @version 1.0
 * @created 23-mai-2014 01:04:22
 */
public class Card implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;
	private int cost;
	private int numberOfHotels;
	private int numberOfHouses;
	private int hotelCost;
	private int housesCost;
	private int locationOnBoard;
	private int mortgageValue;
	private String name;
	private Player owner;
	private int[] rentWithHotel;
	/**
	 * index 0 match with 1 house's rent and index 3 match with 3 houses' rent
	 */
	private int[] rentWithHouses;
	private int simpleRent;

	public Card(String color, int cost, int hotelCost, int housesCost, int locationOnBoard, 
				int mortgageValue, String name, int[] rentWithHotel, int[] rentWithHouses, int simpleRent){
		
		this.color=color;
		this.cost=cost;
		this.hotelCost=hotelCost;
		this.housesCost=housesCost;
		this.setLocationOnBoard(locationOnBoard);
		this.mortgageValue=mortgageValue;
		this.name=name;
		this.rentWithHotel=rentWithHotel;
		this.rentWithHouses=rentWithHouses;
		this.simpleRent=simpleRent;
		
		this.setNumberOfHotels(0);
		this.numberOfHouses=0;
		this.owner=null;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * if 'hasHotel' is false increment number of houses
	 */
	public void addHouse(){
		numberOfHouses++;
		
		if(numberOfHouses==4){
			setNumberOfHotels(1);
			numberOfHouses=0;
		}
		
	}

	public String getColor(){
		return color;
	}

	public int getCost(){
		return cost;
	}

	public int getHotelCost(){
		return hotelCost;
	}

	public int getHousesCost(){
		return housesCost;
	}

	public int getMortgageValue(){
		return mortgageValue;
	}

	public String getName(){
		return name;
	}

	public Player getOwner(){
		return owner;
	}

	public int[] getRentWithHotel(){
		return rentWithHotel;
	}

	public int[] getRentWithHouses(){
		return rentWithHouses;
	}

	public int getSimpleRent(){
		return simpleRent;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(String color){
		this.color=color;
	}

	/**
	 * 
	 * @param cost
	 */
	public void setCost(int cost){
		this.cost=cost;
	}

	/**
	 * 
	 * @param hotelCost
	 */
	public void setHotelCost(int hotelCost){
		this.hotelCost=hotelCost;
	}

	/**
	 * 
	 * @param housesCost
	 */
	public void setHousesCost(int housesCost){
		this.housesCost=housesCost;
	}

	/**
	 * 
	 * @param mortgageValue
	 */
	public void setMortgageValue(int mortgageValue){
		this.mortgageValue=mortgageValue;
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
	 * @param owner
	 */
	public void setOwner(Player owner){
		this.owner=owner;
	}

	/**
	 * 
	 * @param rentWithHotel
	 */
	public void setRentWithHotel(int[] rentWithHotel){
		this.rentWithHotel=rentWithHotel;
	}

	/**
	 * 
	 * @param simpleRent
	 */
	public void setSimpleRent(int simpleRent){
		this.simpleRent=simpleRent;
	}

	/**
	 * @return the numberOfHotels
	 */
	public int getNumberOfHotels() {
		return numberOfHotels;
	}
	
	/**
	 * @return the numberOfHouses
	 */
	public int getNumberOfHouses() {
		return numberOfHouses;
	}

	/**
	 * @param numberOfHotels the numberOfHotels to set
	 */
	public void setNumberOfHotels(int numberOfHotels) {
		this.numberOfHotels = numberOfHotels;
	}

	/**
	 * @return the locationOnBoard
	 */
	public int getLocationOnBoard() {
		return locationOnBoard;
	}

	/**
	 * @param locationOnBoard the locationOnBoard to set
	 */
	public void setLocationOnBoard(int locationOnBoard) {
		this.locationOnBoard = locationOnBoard;
	}

}