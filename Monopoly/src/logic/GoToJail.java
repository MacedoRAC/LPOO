package logic;


public class GoToJail extends Space {

	public GoToJail(){
		
	}
	
	@Override
	/**
	 * Changes the Player's position to the Jail and arrests him
	 */
	public void Action(Player p) {
		p.setPosition(10);
		p.setPrevious_position(30);
		p.setArested_time(3);
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
		return "GoToJail";
	}

}
