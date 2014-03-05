package tests;

import static org.junit.Assert.*;
import logic.Labirinto;

import org.junit.Test;

public class tests {
	@Test
	public void heroiMoveUmaPosicao() {
		Labirinto l=new Labirinto();
		int posCorreta[]={1,2};
		l.moveH("s");
		int posAtual[]={l.getHeroi().getX(), l.getHeroi().getY()};
		
		assertEquals("Nova posição deve ser coluna 1, linha 2",posCorreta,posAtual);
	}
	
	@Test
	public void heroiMoveContraParede(){
		Labirinto l=new Labirinto();
		int posCorreta[]={1,1};
		l.moveH("a");
		int posAtual[]={l.getHeroi().getX(), l.getHeroi().getY()};
		
		assertEquals("Nova posição deve ser coluna 1, linha 1",posCorreta,posAtual);
	}
	
	@Test
	public void apanharEspada(){
		Labirinto l=new Labirinto();
		l.getEspada().setX(2);
		l.getEspada().setY(1);
		l.moveH("d");
		
		assertEquals("Heroi deve estar armado", true, l.getHeroi().isArmado());
	}
	
	@Test
	public void heroiMorre(){
		Labirinto l=new Labirinto();
		l.getDragao().setX(3);
		l.getDragao().setY(1);
		l.moveH("d");
		
		assertEquals("Heroi deve estar morto", true, l.getHeroi().isMorto());
		}
	
	@Test
	public void heroiMataDragao(){
		Labirinto l=new Labirinto();
		l.getDragao().setX(3);
		l.getDragao().setY(1);
		l.getHeroi().setArmado(true);
		l.moveH("d");
		
		assertEquals("Dragao deve estar morto", true, l.getDragao().isMorto());
	}
	
	@Test
	public void heroiPodeSair(){
		Labirinto l=new Labirinto();
		l.getHeroi().setArmado(true);
		l.getDragao().setMorto(true);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi pode sair do labirinto", true, l.isVitoria());
	}
	
	@Test
	public void heroiNaoPodeSair(){
		Labirinto l=new Labirinto();
		l.getHeroi().setArmado(false);
		l.getDragao().setMorto(false);
		l.getHeroi().setX(8);
		l.getHeroi().setY(5);
		l.moveH("d");
		
		assertEquals("Heroi nao pode sair do labirinto", false, l.isVitoria());
	}

}
