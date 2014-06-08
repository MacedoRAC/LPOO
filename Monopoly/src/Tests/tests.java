package Tests;

import static org.junit.Assert.*;

import java.util.Vector;

import logic.MonopolyLogic;
import logic.Player;
import logic.Property;

import org.junit.Test;

public class tests {

	/**
	 * Checks if the user moves place when the dices are rolled
	 */
	@Test
	public void test_RollDice(){
		Player p = new Player();
		assertEquals(true, p.getPosition() == 0);
		p.RollDice();
		assertFalse(p.getPosition() == 0);
	}
	
	/**
	 * Checks if the player is at the same position than the property in the board, has enough money and if the property hasn't been already bought
	 */
	@Test
	public void test_BuyProperty(){
		Player p = new Player();
		Vector<Player> v = new Vector<Player> ();
		v.add(p);
		MonopolyLogic g = new MonopolyLogic(v, "");
		assertEquals(0,p.getOwnproperties().size());
		g.getBoard().get(39).Buy(g.getPlayers().get(0));
		assertEquals(1, g.getPlayers().get(0).getOwnproperties().size());
		assertEquals(1100, p.getMoney());
	}
	
	/**
	 * Checks if the player pays rent only when the property belongs to another player and if the property is not mortage
	 */
	@Test
	public void test_paysRent(){
		Player p = new Player();
		Player p2 = new Player();
		Vector<Player> v = new Vector<Player> ();
		v.add(p);
		v.add(p2);
		MonopolyLogic g = new MonopolyLogic(v, "");
		assertEquals(0,p.getOwnproperties().size());
		g.getBoard().get(39).Buy(g.getPlayers().get(0));
		assertEquals(1, g.getPlayers().get(0).getOwnproperties().size());
		p2.setPosition(39);
		g.getBoard().get(39).Action(p2);
		assertEquals(1450, p2.getMoney());
		((Property) g.getBoard().get(39)).addBuild();
		g.getBoard().get(39).Action(p2);
		assertEquals(1250, p2.getMoney());
		
		g.getBoard().get(39).Action(p);
		//player p money is 1500 - price + rent + rent(one apartment)
		assertEquals(1350, p.getMoney());
		
		//tests if the other players do not pay when the property is on mortgage
		g.getBoard().get(39).Mortgage(((Property) g.getBoard().get(39)).getOwner());
		g.getBoard().get(39).Action(p2);
		assertEquals(1250, p2.getMoney());
		// previous amount of money + mortgageValue(200 in this case)
		assertEquals(1550, p.getMoney());
	}
	
	/**
	 * Checks if the player receives the money when passing through the start or stand the start
	 */
	@Test
	public void test_PassStart(){
		Player p = new Player();
		p.setPosition(5);
		assertEquals(1500, p.getMoney());
		p.setPrevious_position(20);
		p.PassThroughStart();
		assertEquals(1700, p.getMoney());
	}
	
	/**
	 * Checks if the arrested player doesn't move until e pays to leave or he waits 3 turns or until he has a double rolling the dices 
	 */
	@Test
	public void test_StayInPrison(){
		Player p = new Player();
		p.setPosition(10);
		p.setArested_time(3);
		p.RollDice();
		assertEquals(10, p.getPosition());
	}
	
	/**
	 * Checks if the player's position is changed to the jail's position in the board, when he stands at the "Go To Jail"
	 */
	@Test
	public void test_GoToJail(){
		Player p = new Player();
		Vector<Player> v = new Vector<Player> ();
		v.add(p);
		MonopolyLogic g = new MonopolyLogic(v, "");
		
		p.setPosition(30);
		g.getBoard().get(30).Action(p);
		
		assertEquals(10, p.getPosition());
		assertEquals(30, p.getPrevious_position());
		//checks if the player does not receive money when goes to jail even passing through the star
		assertEquals(1500, p.getMoney());
	}
	
	/**
	 * Check if it was added/removed an apartment or hotel to a property
	 * Checks if the property's rent increases based on the number of apartments or hotels
	 */
	@Test
	public void test_IncreasingRent(){
		Property p = new Property("LISBOA BELEM", "DARK_BLUE", 350, 50, 200, 600, 1400, 1700, 2000, 200, 39);
		assertEquals(0, p.getN_apart());
		assertEquals(0, p.getN_hotel());
		assertEquals(50, p.getRent());
		p.addBuild();
		assertEquals(1, p.getN_apart());
		assertEquals(0, p.getN_hotel());
		assertEquals(200, p.getRent());
		p.addBuild();
		p.addBuild();
		p.addBuild();
		p.addBuild();
		assertEquals(0, p.getN_apart());
		assertEquals(1, p.getN_hotel());
		assertEquals(2000, p.getRent());
		
	}	
	
	/**
	* Checks if the game has ended
	*/
	@Test
	public void test_Winner(){
		Player p = new Player();
		Player p2 = new Player();
		Vector<Player> v = new Vector<Player> ();
		v.add(p);
		v.add(p2);
		MonopolyLogic g = new MonopolyLogic(v, "");
		
		g.getPlayers().get(0).removeMoney(1499);
		g.EndTurn();
		assertEquals(true, p.getAlive());
		assertEquals(null, g.Winner());
		g.getPlayers().get(0).removeMoney(200);
		g.EndTurn();
		assertEquals(p2, g.Winner());
	}

	/**
	* Checks if the player already lost the game
	*/
	@Test
	public void playerLost(){
		Player p = new Player();
		Vector<Player> v = new Vector<Player> ();
		v.add(p);
		MonopolyLogic g = new MonopolyLogic(v, "");

		g.getPlayers().get(0).removeMoney(1499);
		g.EndTurn();
		assertEquals(true, p.getAlive());
		g.getPlayers().get(0).removeMoney(200);
		g.EndTurn();
		assertEquals(false, p.getAlive());
	}
}
