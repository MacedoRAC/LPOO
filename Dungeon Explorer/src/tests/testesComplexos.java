package tests;


import static org.junit.Assert.*;

import org.junit.Test;

import logic.Labirinto;
/**
 * Testes unit�rios complexos, associados aos movimentos dos drag�es
 * @author Andr�
 *
 */
public class testesComplexos {
		
	/**
	 * Verifica se os drag�es nunca adormecem
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
	 * Verifica se os drag�es adormecem
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
	 * Verifica o n�mero de drag�es em jogo
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
