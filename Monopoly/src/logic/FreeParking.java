package logic;

import java.io.Serializable;

public class FreeParking extends Space implements Serializable{

	private static final long serialVersionUID = 1L;

	public FreeParking(){
		this.position=20;
	}
	
	@Override
	/**
	 * Actually does nothing
	 */
	public void Action(Player p) {
		
	}

	@Override
	public boolean getMortgage() {
		return false;
	}

	@Override
	public void Buy(Player p) {
		
	}

	@Override
	public void Mortgage(Player p) {
		
	}

	@Override
	public void Unmortgage(Player p) {
	}

	@Override
	public String getClassName() {
		return "Free Parking";
	}

}
