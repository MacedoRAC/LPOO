package logic;

import java.util.Vector;

public class Player {
	private String name;
	private String token;
	private int position;
	private int previous_position;
	private int money;
	private int arested_time;
	private Vector<Space> ownproperties = new Vector<Space> ();
	/**
	 * money + price of his properties
	 */
	private int worth;
	// false is the player has already lost
	private boolean alive;
	private boolean ddice;
	
	public Player(){
		this.name="default";
		this.token="carro";
		this.position=0;
		this.previous_position=position;
		this.money=1500;
		this.worth=1500;
		this.alive=true;
		this.arested_time=0;
	}
	
	public Player(String name, String token){
		this.name = name;
		this.token = token;
		this.position=0;
		this.previous_position=position;
		this.money=1500;
		this.worth=1500;
		this.alive=true;
		this.arested_time=0;
	}
	
	//token related methods
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	//position related methods
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	//money related methods
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * Gives money to the player
	 * @param money amount of money that is given
	 */
	public void addMoney(int money){
		this.money = this.money + money;
	}
	/**
	 * Takes money from the player
	 * @param money amount of money that is taken
	 */
	public void removeMoney(int money){
		if(this.getMoney() > money){
			this.money = this.money - money;
		}else{
			this.money=0;
			this.setAlive(false);
		}
	}
	//properties related methods
	public Vector<Space> getOwnproperties() {
		return ownproperties;
	}
	public void setOwnproperties(Vector<Space> ownproperties) {
		this.ownproperties = ownproperties;
	}
	/**
	 * Adds a Property to the player
	 * @param property property that is given
	 */
	public void addOwnproperties(Space property){
		this.ownproperties.add(property);
	}
	/**
	 * Removes a property from a player
	 * @param property property that is taken
	 * @return
	 */
	public boolean removeOwnproperties(Space property){
		if(this.ownproperties.contains(property)){
			this.ownproperties.remove(property);
			return true;
		}else
			return false;
	}
	//worth related methods
	public int getWorth() {
		return worth;
	}
	public void setWorth(int worth) {
		this.worth = worth;
	}
	
	/**
	 * Checks if the player passes through the start, if he does, receives 200$
	 */
	public void PassThroughStart(){
		if(this.getPosition() < this.getPrevious_position()){
			this.addMoney(200);
		}
	}
	
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getPrevious_position() {
		return previous_position;
	}
	public void setPrevious_position(int previous_position) {
		this.previous_position = previous_position;
	}
	
	public int getArested_time() {
		return arested_time;
	}
	public void setArested_time(int arested_time) {
		this.arested_time = arested_time;
	}

	/**
	 * allow the player to roll the dices and move to a different space
	 * 
	 * @return faces of the both dices
	 */
	public int[] RollDice(){
		int move1 = (int)(Math.random() * 6+1);
		int move2 = (int)(Math.random() * 6+1);
		if(move1==move2){
			ddice = true;
		}else{
			ddice = false;
		}
		if(this.getArested_time() == 0){
			this.setPrevious_position(this.position);
			this.setPosition(this.getPosition()+move1+move2);
		}
		
		this.PassThroughStart();
		
		 return new int[]{move1, move2};
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getDdice() {
		return ddice;
	}
	public void setDdice(boolean ddice) {
		this.ddice = ddice;
	}
	
	/**
	 * Updates the worth of the player.
	 * This increased and decreases according with his money and his properties
	 */
	public void updateWorth(){
		int amount;
		amount=getMoney();
		for(int a=0; a<getOwnproperties().size(); a++){
			amount += ((Property) getOwnproperties().get(a)).getPrice();
			amount += ((Airport) getOwnproperties().get(a)).getPrice();
			amount += ((Companies) getOwnproperties().get(a)).getPrice();
		}
		setWorth(amount);
	}

	public int getNumberBuildings() {
		int number=0;
		
		for(int i=0; i<ownproperties.size(); i++){
			number += ((Property)ownproperties.get(i)).getN_apart();
			number += ((Property)ownproperties.get(i)).getN_hotel();
		}
		
		return number;
	}
}
