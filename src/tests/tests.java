package tests;

import static org.junit.Assert.*;
import logic.Labirinto;

import org.junit.Test;

public class tests {
	@Test
	public void heroiMoveUmaPosicao() {
		Labirinto l=new Labirinto();
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.moveH("s");
		
		assertEquals(1,l.getHeroi().getX());
		assertEquals(2,l.getHeroi().getY());
	}
	
	@Test
	public void heroiMoveContraParede(){
		Labirinto l=new Labirinto();
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.moveH("a");
		
		assertEquals(1,l.getHeroi().getX());
		assertEquals(1,l.getHeroi().getY());
	}
	
	@Test
	public void apanharEspada(){
		Labirinto l=new Labirinto();
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao().setX(7);
		l.getDragao().setY(1);
		l.getEspada().setX(3);
		l.getEspada().setY(1);
		l.moveH("d");
		l.moveH("d");
		
		assertEquals(true, l.getHeroi().isArmado());
	}
	
	@Test
	public void heroiMorre(){
		Labirinto l=new Labirinto();
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao().setX(3);
		l.getDragao().setY(1);
		l.getDragao().setAdormecido(false);
		l.getEspada().setX(7);
		l.getEspada().setY(1);
		
		l.moveH("d");
		
		assertEquals(true, l.getHeroi().isMorto());
		}
	
	@Test
	public void heroiMataDragao(){
		Labirinto l=new Labirinto();
		l.getDragao().setX(3);
		l.getDragao().setY(1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getHeroi().setArmado(true);
		l.moveH("d");
		
		assertEquals(true, l.getDragao().isMorto());
	}
	
	@Test
	public void heroiPodeSair(){
		Labirinto l=new Labirinto();
		l.getHeroi().setArmado(true);
		l.getDragao().setMorto(true);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi pode sair do Labirinto", true, l.isVitoria());
	}
	
	@Test
	public void heroiNaoPodeSair(){
		Labirinto l=new Labirinto();
		l.getHeroi().setArmado(false);
		l.getDragao().setMorto(false);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi nao pode sair do Labirinto", false, l.isVitoria());
	}

}
