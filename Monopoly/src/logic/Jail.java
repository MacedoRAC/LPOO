package logic;

import java.io.Serializable;

public class Jail extends Space implements Serializable {

	private static final long serialVersionUID = 1L;

	public Jail(){
		this.position=10;
	}
	
	/**
	 * When the player stands in here, he is arrested
	 */
	@Override
	public void Action(Player p) {
		if(p.getPosition() != p.getPrevious_position()){
			p.setArested_time(3);
		}
		p.setPrevious_position(p.getPosition());		
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
		return "Jail";
	}

}
