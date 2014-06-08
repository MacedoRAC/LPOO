package logic;

public abstract class Space {

	public Space(){

	}
	
	/**
	 * 
	 * @return the class name
	 */
	public abstract String getClassName(); 

	public abstract void Action(Player p);
	/**
	 * 
	 * @return true if the space is mortgaged or false if it is not
	 */
	public abstract boolean getMortgage();

	/**
	 * Allow the player to Buy a Space (airport, company or property)
	 * @param p Player who is buying
	 */
	public abstract void Buy(Player p);

	/**
	 * Allows to mortgage a Airport, company or property
	 * 
	 * @param p Player that is mortgaging
	 */
	public abstract void Mortgage(Player p);
	
	/**
	 * Allows to unmortgage a Airport, company or property
	 * 
	 * @param p Player that is unmortgaging
	 */
	public abstract void Unmortgage(Player p);
}
