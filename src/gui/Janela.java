package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Labirinto;

public class Janela extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage dragao;
	private BufferedImage dragaoDormir;
	private BufferedImage heroi;
	private BufferedImage heroiArmado;
	private BufferedImage espada;
	private BufferedImage aguiaCaminho;
	private BufferedImage aguiaParede;
	private BufferedImage parede;
	private BufferedImage caminho;
	private BufferedImage fundo;
	private Labirinto lab;
	private int cima= KeyEvent.VK_UP;
	private int baixo= KeyEvent.VK_DOWN;
	private int esquerda= KeyEvent.VK_LEFT;
	private int direita= KeyEvent.VK_RIGHT;
	private int aguia= KeyEvent.VK_SPACE;
	private boolean aJogar;
	
	
	public Janela() {		
		aJogar=false;
		// importar imagens
		try {
			dragao=ImageIO.read(new File("src/Imagens/dragon.png"));
			dragaoDormir=ImageIO.read(new File("src/Imagens/sleepingDragon.png"));
			heroi=ImageIO.read(new File("src/Imagens/heroUnarmored.png"));
			heroiArmado=ImageIO.read(new File("src/Imagens/hero.png"));
			espada=ImageIO.read(new File("src/Imagens/sword.png"));
			aguiaCaminho=ImageIO.read(new File("src/Imagens/eaglePath.png"));
			aguiaParede=ImageIO.read(new File("src/Imagens/eagleWall.png"));
			parede=ImageIO.read(new File("src/Imagens/wall.png"));
			caminho=ImageIO.read(new File("src/Imagens/path.png"));
			fundo=ImageIO.read(new File("src/Imagens/fundo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new teclado());
		setFocusable(true);
	}
	
	void inciaJogo(){
		aJogar=true;
		lab=new Labirinto();
	}
	
	
	protected void paintComponent(Graphics g){
		char elemento;
		if(aJogar){
			for(int i=0; i<lab.getLabirinto().getLab().length; i++){
				for(int j=0; j<lab.getLabirinto().getLab().length; j++){
					elemento =lab.getLabirinto().getLab()[i][j];
					switch(elemento){
					case 'D':
						g.drawImage(dragao, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'E':
						g.drawImage(espada, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'H':
						g.drawImage(heroi, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'A':
						g.drawImage(heroiArmado, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'X':
						g.drawImage(parede, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'F':
						g.drawImage(dragao, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case ' ':
						g.drawImage(caminho, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'S':
						g.drawImage(caminho, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					case 'Z':
						g.drawImage(dragaoDormir, j*60, i*60, 60, 60, Color.WHITE, null);
						break;
					}

				}
			}
		}
		else{
			g.drawImage(fundo, 0, 0, 640, 400, Color.WHITE, null);
		}
	}
	

	private class teclado extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			int direcao=e.getKeyCode();
			
			if(direcao==cima)
				lab.processaEvento("w");
			else if(direcao==baixo)
				lab.processaEvento("s");
			else if(direcao==esquerda)
				lab.processaEvento("a");
			else if(direcao==direita)
				lab.processaEvento("d");
			else if(direcao==aguia)
				lab.processaEvento("g");
			
			repaint();
		}

	}


}
