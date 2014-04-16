package logic;

/**
 * Constr�i um labirinto fixo de tamanho 10x10
 * 
 * @author Andr�
 *
 */
public class ConstFixoLab extends ConstrutorLab{
	
	/**
	 * Construtor do labirinto fixo
	 */
	public ConstFixoLab() {
		tamanhoLab=10;
		lab= new char[][] {{'X','X','X','X','X','X','X','X','X','X'},
					 	   {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					 	   {'X',' ','X','X',' ','X',' ','X',' ','X'},
					 	   {'X',' ','X','X',' ','X',' ','X',' ','X'},
					 	   {'X',' ','X','X',' ','X',' ','X',' ','X'},
					 	   {'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
					 	   {'X',' ','X','X',' ','X',' ','X',' ','X'},
					 	   {'X',' ','X','X',' ','X',' ','X',' ','X'},
					 	   {'X',' ','X','X',' ',' ',' ',' ',' ','X'},
					 	   {'X','X','X','X','X','X','X','X','X','X'}};
	}


}
