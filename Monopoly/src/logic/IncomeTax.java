package logic;


public class IncomeTax extends Space {

	public IncomeTax(){
		
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
