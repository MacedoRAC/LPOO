package tests;

import static org.junit.Assert.*;
import logic.Labirinto;

import org.junit.Test;

public class testesSimples {
	@Test
	public void heroiMoveUmaPosicao() {
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.moveH("s");
		
		assertEquals(1,l.getHeroi().getX());
		assertEquals(2,l.getHeroi().getY());
	}
	
	@Test
	public void heroiMoveContraParede(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.moveH("a");
		
		assertEquals(1,l.getHeroi().getX());
		assertEquals(1,l.getHeroi().getY());
	}
	
	@Test
	public void apanharEspada(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao()[0].setX(7);
		l.getDragao()[0].setY(1);
		l.getEspada().setX(3);
		l.getEspada().setY(1);
		l.moveH("d");
		l.moveH("d");
		
		assertEquals(true, l.getHeroi().isArmado());
	}
	
	@Test
	public void heroiMorre(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getDragao()[0].setX(3);
		l.getDragao()[0].setY(1);
		l.getDragao()[0].setAdormecido(false);
		l.getEspada().setX(7);
		l.getEspada().setY(1);
		
		l.moveH("d");
		
		assertEquals(true, l.getHeroi().isMorto());
		}
	
	@Test
	public void heroiMataDragao(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getDragao()[0].setX(3);
		l.getDragao()[0].setY(1);
		l.getHeroi().setX(1);
		l.getHeroi().setY(1);
		l.getHeroi().setArmado(true);
		l.moveH("d");
		
		assertEquals(true, l.getDragao()[0].isMorto());
	}
	
	@Test
	public void heroiPodeSair(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setArmado(true);
		l.getDragao()[0].setMorto(true);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi pode sair do Labirinto", true, l.isVitoria());
	}
	
	@Test
	public void heroiNaoPodeSair(){
		Labirinto l=new Labirinto(false, 0, false, 1);
		l.getHeroi().setArmado(false);
		l.getDragao()[0].setMorto(false);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi nao pode sair do Labirinto", false, l.isVitoria());
	}

}
