package logic;

import java.io.Serializable;

public class Property extends Space implements Serializable	{

	private static final long serialVersionUID = 1L;
	private String name;
	private String color;
	private int price;
	private int apart_price;
	private boolean owned;
	private Player owner;
	private int normalRent;
	//the rent is increased by the number of apartments/hotel in the property
	private int OneRent;
	private int TwoRent;
	private int ThreeRent;
	private int FourRent;
	private int HotelRent;
	private int n_apart;
	private int n_hotel;
	private boolean mortgage=false;
	private double mortgageValue;
	
	
	public Property(String name, String color, int price, int normalRent, int OneRent, int TwoRent, int ThreeRent, int FourRent, int HotelRent, int apart_price, int position){
		this.name=name;
		this.color = color;
		this.price=price;
		this.normalRent=normalRent;
		this.OneRent=OneRent;
		this.TwoRent=TwoRent;
		this.ThreeRent=ThreeRent;
		this.FourRent=FourRent;
		this.HotelRent=HotelRent;
		this.mortgage=false;
		this.setApart_price(apart_price);
		this.mortgageValue=price/2;
		this.n_apart=0;
		this.n_hotel=0;
		this.position=position;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isOwned() {
		return owned;
	}
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	
	/**
	 * always a player stands on a property, checks if it is already bought.
	 * In this case the player must pay a rent to his owner
	 */
	@Override
	public void Action(Player p) {
		if(this.owned){
			if(this.owner != p){
				if(!getMortgage()){
					p.removeMoney(this.getRent());
					this.owner.addMoney(this.getRent());
				}
			}
		}
	}
	
	/**
	 * Allow the player to Buy the property
	 */
	public void Buy(Player p){
		if(p.getMoney() > this.getPrice()){
			p.removeMoney(this.price);
			p.addOwnproperties(this);
			this.setOwned(true);
			this.setOwner(p);
		}
	}
	
	/**
	 * Calculates the rent that players must pay
	 * @return value of the rent according to the building it was on it
	 */
	public int getRent() {
		int newrent = 0;
		if(!this.getMortgage()){
			if(this.n_apart==0 && this.n_hotel==0){
				newrent = normalRent;
			}else if(this.n_hotel == 1){
				newrent = HotelRent;
			}else if(this.n_apart==4){
				newrent = FourRent;
			}else if(this.n_apart==3){
				newrent = ThreeRent;
			}else if(this.n_apart==2){
				newrent = TwoRent;
			}else if(this.n_apart==1){
				newrent = OneRent;
			}
		}
		
		return newrent;
	}
	
	/**
	 * Adds a building to the property
	 */
	public void addBuild(){
		if(n_hotel != 1){
			if(n_apart==4){
				n_apart=0;
				n_hotel=1;
			}else if(n_apart < 4){
				n_apart++;
			}
		}	
	}
	
	/**
	 * Removes a building from the property
	 */
	public void removeBuild(){
		if(n_apart > 0 || n_hotel == 1){
			if(n_hotel==1){
				n_hotel = 0;
				n_apart=4;
			}else{
				n_apart--;
			}
		}
	}

	public int getN_apart() {
		return n_apart;
	}
	public void setN_apart(int n_apart) {
		this.n_apart = n_apart;
	}
	public int getN_hotel() {
		return n_hotel;
	}
	public void setN_hotel(int n_hotel) {
		this.n_hotel = n_hotel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public boolean getMortgage() {
		return this.mortgage;
	}

	/**
	 * Mortgages the property
	 */
	public void Mortgage(Player p){
		setMortgage(true);
		p.addMoney((int)mortgageValue);
	}

	/**
	 * Unmortgages the property
	 */
	public void Unmortgage(Player p){
		setMortgage(false);
		p.removeMoney((int) mortgageValue);
	}
	
	private void setMortgage(boolean b) {
		this.mortgage=b;
	}

	public double getMortgageValue() {
		return mortgageValue;
	}

	public void setMortgageValue(double mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	public int getApart_price() {
		return apart_price;
	}

	public void setApart_price(int apart_price) {
		this.apart_price = apart_price;
	}

	@Override
	public String getClassName() {
		return "Property";
	}
}
