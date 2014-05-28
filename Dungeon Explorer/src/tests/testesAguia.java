package tests;

import static org.junit.Assert.*;
import logic.Labirinto;

import org.junit.Test;
/**
 * Teste unitário associado à águia
 * @author André
 *
 */
public class testesAguia {

	/**
	 * Verifica se a águia apanha a espada
	 */
	@Test
	public void testeAguia(){
		Labirinto l= new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao()[0].setX(8);
		l.getDragao()[0].setY(8);
		l.getEspada().setX(4);
		l.getEspada().setY(3);
		String[] movHeroi= new String[]{"g","g","g","g","g","g"};
		
		for(int i=0; i<movHeroi.length; i++){
			l.moveH(movHeroi[i]);
		}
		
		assertEquals(l.getAguia().getX(), l.getEspada().getX());
		assertEquals(l.getAguia().getY(), l.getEspada().getY());
	}
}
