package logic;

import java.io.Serializable;

public class Chance extends Space implements Serializable{

	private static final long serialVersionUID = 1L;
	int lastCard = 0;
	
	public Chance(int position){
		this.position=position;
	}
	
	/**
	 * generates a random chance card to be attributed to the player p
	 */
	@Override
	public void Action(Player p) {
		int randomNum = (int)(Math.random()*7); 
		if(randomNum==0){
			p.addMoney(50);
		}else if(randomNum==1){
			p.removeMoney(150);
		}else if(randomNum==2){
			p.setPosition(39);
			p.PassThroughStart();
		}else if(randomNum==3){
			p.setPosition(0);
			p.PassThroughStart();
		}else if(randomNum==4){
			p.setPosition(10);
		}else if(randomNum==5){
			p.setPosition(p.getPosition()-3);
			p.PassThroughStart();
		}else{
			int amount=0;
			for(int i=0; i<p.getOwnproperties().size(); i++){
				if(((Property) p.getOwnproperties().get(i)).getN_apart() == 0 && ((Property) p.getOwnproperties().get(i)).getN_hotel()==0){
					//does not change the amount of money
				}else{
					if(((Property) p.getOwnproperties().get(i)).getN_hotel() == 1){
						amount += 115;
					}else{
						amount = amount + 40*(((Property) p.getOwnproperties().get(i)).getN_apart());
					}
				}
			}
			p.removeMoney(amount);
		}
		lastCard=randomNum;
	}

	@Override
	public boolean getMortgage() {
		return false;
	}

	@Override
	public void Buy(Player p) {

	}
	
	public int getLastCard(){
		return this.lastCard;
	}

	@Override
	public void Mortgage(Player p) {
		
	}

	@Override
	public void Unmortgage(Player p) {
		
	}

	@Override
	public String getClassName() {
		return "Chance";
	}
}
