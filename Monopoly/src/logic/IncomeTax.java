package logic;

import java.io.Serializable;

public class IncomeTax extends Space implements Serializable{

	private static final long serialVersionUID = 1L;

	public IncomeTax(int position){
		this.position=position;
	}
	
	@Override
	/**
	 * When the player stand in a taxes space he must pay 200$ or 10% of his worth
	 */
	public void Action(Player p) {
		//player can either pay 200$ or 10% of his worth
		int rent = (int) 0.1*p.getWorth();
		if(rent > 200){
			p.removeMoney(200);
		}else{
			p.removeMoney(rent);
		}
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
		return "IncomeTax";
	}

}
