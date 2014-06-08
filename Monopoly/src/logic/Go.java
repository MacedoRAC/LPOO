package logic;


public class Go extends Space {
	public Go(){
	}
	
	@Override
	/**
	 * if the player stands here he receives 200$
	 */
	public void Action(Player p) {
		p.addMoney(200);
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
		return "Go";
	}

}
