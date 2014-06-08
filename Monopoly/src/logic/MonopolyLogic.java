package logic;

import java.io.Serializable;
import java.util.Vector;

import logic.Space;

public class MonopolyLogic implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * Vector of players playing in this board
	 */
	private Vector<Player> players;
	/**
	 * Vector of Spaces on the board
	 */
	private Vector<Space> board = new Vector<Space>();
	/**
	 * Game mode
	 */
	private String tipo;
	/**
	 * indicator of the player playing at this time
	 */
	public int i=0;

	public void setBoard(Vector<Space> board) {
		this.board = board;
	}

	public Vector<Space> getBoard() {
		return board;
	}

	public Vector<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Vector<Player> players) {
		this.players = players;
	}

	public MonopolyLogic(Vector<Player> players, String mode){
		//constroi tabuleiro
		//inicializa os jogadores
		this.board = Board();
		this.tipo=mode;
		this.players = players;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public MonopolyLogic() {
		this.board = Board();
		players = Players();
	}

	private Vector<Player> Players() {
		return null;
	}

	/**
	 * Initializes the board with all the spaces by order
	 * the spaces already have all the information that they need
	 * 
	 * @return ready board
	 */
	private Vector<Space> Board() {
		Space space0 = new Go();
		board.add(space0);
		Property space1 = new Property("CASTELO BRANCO","BROWN", 60, 2, 10, 30, 90, 160, 250, 50, 1);
		board.add(space1);
		Community space2 = new Community(2);
		board.add(space2);
		Property space3 = new Property("VILA REAL","BROWN", 60, 2, 10, 30, 90, 160, 250, 50, 3);
		board.add(space3);
		IncomeTax space4 = new IncomeTax(4);
		board.add(space4);
		Airport space5 = new Airport(200, 5);
		board.add(space5);
		Property space6 = new Property("BRAGANCA","LIGHT_BLUE", 100, 6, 30, 90, 270, 400, 550, 50, 6);
		board.add(space6);
		Chance space7 = new Chance(7);
		board.add(space7);
		Property space8 = new Property("LEIRIA","LIGHT_BLUE", 100, 6, 30, 90, 270, 400, 550, 50, 8);
		board.add(space8);
		Property space9 = new Property("PORTALEGRE","LIGHT_BLUE", 120, 8, 40, 100, 300, 450, 600, 50, 9);
		board.add(space9);
		Jail space10 = new Jail();
		board.add(space10);

		Property space11 = new Property("SANTAREM","PINK", 140, 10, 50, 150, 450, 625, 750, 100, 11);
		board.add(space11);
		Companies space12 = new Companies(150, 12);
		board.add(space12);
		Property space13 = new Property("AVEIRO","PINK", 140, 10, 50, 150, 450, 625, 750, 100, 13);
		board.add(space13);
		Property space14 = new Property("BRAGA","PINK", 160, 12, 60, 180, 500, 700, 900, 100, 14);
		board.add(space14);
		Airport space15 = new Airport(200, 15);
		board.add(space15);
		Property space16 = new Property("VISEU","ORANGE", 180, 14, 70, 200, 550, 750, 950, 100, 16);
		board.add(space16);
		Community space17 = new Community(17);
		board.add(space17);
		Property space18 = new Property("SETUBAL","ORANGE", 180, 14, 70, 200, 550, 750, 950, 100, 18);
		board.add(space18);
		Property space19 = new Property("GUARDA","ORANGE", 200, 16, 80, 220, 600, 800, 1000, 100, 19);
		board.add(space19);
		FreeParking space20 = new FreeParking();
		board.add(space20);

		Property space21 = new Property("EVORA","RED", 220, 18, 90, 250, 700, 875, 1050, 150, 21);
		board.add(space21);
		Chance space22 = new Chance(22);
		board.add(space22);
		Property space23 = new Property("BEJA","RED", 220, 18, 90, 250, 700, 875, 1050, 150, 23);
		board.add(space23);
		Property space24 = new Property("VIANA DO CASTELO","RED", 240, 20, 100, 300, 750, 925, 1100, 150, 24);
		board.add(space24);
		Airport space25 = new Airport(200, 25);
		board.add(space25);
		Property space26 = new Property("COIMBRA","YELLOW", 260, 22, 110, 330, 800, 975, 1150, 150, 26);
		board.add(space26);
		Property space27 = new Property("FARO","YELLOW", 260, 22, 110, 330, 800, 975, 1150, 150, 27);
		board.add(space27);
		Companies space28 = new Companies(150, 28);
		board.add(space28);
		Property space29 = new Property("PORTO BOAVISTA","YELLOW", 280, 24, 120, 360, 850, 1025, 1200, 150, 29);
		board.add(space29);
		GoToJail space30 = new GoToJail();
		board.add(space30);

		Property space31 = new Property("LISBOA EXPO","GREEN", 300, 26, 130, 390, 900, 1100, 1275, 200, 31);
		board.add(space31);
		Property space32 = new Property("MADEIRA","GREEN", 300, 26, 130, 390, 900, 1100, 1275, 200, 32);
		board.add(space32);
		Community space33 = new Community(33);
		board.add(space33);
		Property space34 = new Property("ACORES","GREEN", 320, 28, 150, 450, 1000, 1200, 1400, 200, 34);
		board.add(space34);
		Airport space35 = new Airport(200, 35);
		board.add(space35);
		Chance space36 = new Chance(36);
		board.add(space36);
		Property space37 = new Property("PORTO RIBEIRA","DARK_BLUE", 350, 35, 175, 500, 1100, 1300, 1500, 200, 37);
		board.add(space37);
		IncomeTax space38 = new IncomeTax(38);
		board.add(space38);
		Property space39 = new Property("LISBOA BELEM","DARK_BLUE", 400, 50, 200, 600, 1400, 1700, 2000, 200, 39);
		board.add(space39);

		return this.board;
	}

	/**
	 * Passes the turn to the next player on the vector
	 */
	public void EndTurn(){
		getPlayers().get(i).updateWorth();
		Winner();
		if(i<getPlayers().size() -1)
			i++;
		else
			i=0;
	}

	/**
	 * buys the property where the player is standing
	 */
	public void Buy(){
		getBoard().get(getPlayers().get(i).getPosition()).Buy(getPlayers().get(i));
	}

	
	/**
	 * /**
	 * Add a building (apartment) to a certain Property
	 * 
	 * @param s property where it will be built
	 * @param n_builds number of building that will be added to that property
	 * @return true if the property can be built in, and false if it can not
	 */
	public boolean AddBuild(Property s, int n_builds){
		Player owner = s.getOwner();
		boolean canBuild=false;
		for(int b=0; b<Board().size(); b++){
			if(((Property) getBoard().get(b)).getColor()==s.getColor()){
				if(((Property) getBoard().get(b)).getOwner()==owner){
					canBuild=true;
				}else{
					canBuild=false;
				}
			}
		}
		if(canBuild){
			for(int a=0; a<n_builds; a++){
				s.addBuild();
			}
		}
		return canBuild;
	}
	

	/**
	 * Removes a building (apartment) of a certain Property
	 * 
	 * @param s property where the buildings will be demolished
	 * @param n_builds number of building that will be demolished from a property
	 */
	public void RemoveBuild(Property s, int n_builds){
		for(int a=0; a<n_builds; a++){
			s.removeBuild();
		}
	}

	/**
	 * Allows to mortgage a Airport, company or property
	 * 
	 * @param s space that you want to mortgage
	 */
	public void Mortgage(Space s){
		s.Mortgage(Players().get(i));
	}

	/**
	 * Allows to unmortgage a Airport, company or property
	 * 
	 * @param s space that you want to unmortgage
	 */
	public void Unmortgage(Space s){
		s.Unmortgage(Players().get(i));
	}

	/**
	 * Rolls the dice and moves the player to the right position
	 */
	public int[] RollDice(){
		int[] res;
		res = players.get(i).RollDice();
		int position = players.get(i).getPosition();
		board.get(position).Action(players.get(i));
		return res;
	}

	/**
	 * When in jail, the player can pays to leave
	 */
	public void JailPays(){
		players.get(i).removeMoney(50);
		players.get(i).setArested_time(0);
	}

	/**
	 * When in jail, if the player chooses not to pay, e can try to have a double to be set free
	 */
	public void JailTriesDouble(){
		int move1 = (int)(Math.random() * 6+1);
		int move2 = (int)(Math.random() * 6+1);
		if(move1==move2){
			players.get(i).setArested_time(0);
		}
		else{
			players.get(i).setArested_time(players.get(i).getArested_time()-1);
		}
	}

	/**
	 * verifies is the game has ended
	 * @return the player who won the game
	 */
	public Player Winner(){
		int number_Active_Players=0;
		Player pw=null;
		for(int a=0; a<getPlayers().size(); a++){
			if(getPlayers().get(a).getAlive()==true){
				number_Active_Players++;
				pw=getPlayers().get(a);
			}
		}
		if(number_Active_Players==1){
			return pw;
		}else{
			return null;
		}
	}
}
