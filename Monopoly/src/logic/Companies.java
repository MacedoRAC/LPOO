package logic;


public class Companies extends Space {
	private int price;
	private boolean owned;
	private Player owner;
	//the rent paid is equal to dice number*4 (if the player owns a company) or dice number*10 (if the player owns both companies)
	private int rent = 0;
	private boolean mortgage=false;
	/**
	 * mortgage value of a certain airport
	 */
	private double mortgageValue;

	public Companies(int price){
		this.price=price;
		this.owned=false;
		this.owner=null;
		this.rent=0;
		this.mortgage=false;
		this.mortgageValue=price/2;
	}

	@Override
	/**
	 * if the player p stands on a bought company, he must pays the rent
	 */
	public void Action(Player p) {
		int n_companies=0;
		if(this.getOwned()){
			if(!this.getMortgage()){
				if(this.getOwner()==p){
				}else{
					rent = p.getPosition() - p.getPrevious_position();
					for(int i=0; i<p.getOwnproperties().size(); i++){
						if(p.getOwnproperties().get(i).getClass() == this.getClass()){
							if(!this.getMortgage()){
								n_companies++;
							}
						}
					}
					if(n_companies==1){
						p.removeMoney(4*rent);
						this.getOwner().addMoney(4*rent);
					}else if(n_companies==2){
						p.removeMoney(10*rent);
						this.getOwner().addMoney(10*rent);
					}
				}
			}
		}
	}

	/**
	 * Allow the player p to Buy a company where he stands
	 */
	public void Buy(Player p){
		if(p.getMoney() > this.getPrice()){
			p.removeMoney(this.price);
			p.addOwnproperties(this);
			this.setOwned(true);
			this.setOwner(p);
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean getOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public boolean getMortgage() {
		return this.mortgage;
	}

	public void Mortgage(Player p){
		setMortgage(true);
		p.addMoney((int)mortgageValue);
	}

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

	@Override
	public String getClassName() {
		return "Companies";
	}

}
