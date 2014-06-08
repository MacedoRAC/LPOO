package logic;

import java.io.Serializable;

public class GoToJail extends Space implements Serializable{

	private static final long serialVersionUID = 1L;

	public GoToJail(){
		this.position=30;
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
