package tests;


import static org.junit.Assert.*;

import org.junit.Test;

import logic.Labirinto;
/**
 * Testes unitários complexos, associados aos movimentos dos dragões
 * @author André
 *
 */
public class testesComplexos {
		
	/**
	 * Verifica se os dragões nunca adormecem
	 */
	@Test
	public void dragaoNuncaDorme(){
		Labirinto l= new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao()[0].setX(8);
		l.getDragao()[0].setY(8);
		String[] movHeroi= new String[]{"s","s","s","s","s","s"};
		
		for(int i=0; i<movHeroi.length; i++){
			l.moveH(movHeroi[i]);
			assertEquals(l.getDragao()[0].isAdormecido(), false);
		}
	}
	
	/**
	 * Verifica se os dragões adormecem
	 */
	@Test
	public void DragaoDorme(){
		Labirinto l= new Labirinto(false, 0, true, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao()[0].setX(8);
		l.getDragao()[0].setY(8);
		String[] movHeroi= new String[]{"s","s","s","s","s","s"};
		
		for(int i=0; i<movHeroi.length; i++){
			l.moveH(movHeroi[i]);
			assertEquals(l.getDragao()[0].isAdormecido(), true);
		}
	}
	
	/**
	 * Verifica o número de dragões em jogo
	 */
	@Test
	public void numeroDragoes(){
		Labirinto l= new Labirinto(false, 0, false, 5);
		int numeroDrag=0;
		
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(l.getLabirinto().getLab()[i][j]=='D')
					numeroDrag++;
			}
		
		assertEquals(5, numeroDrag);
	}
}
