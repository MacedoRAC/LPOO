package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.ConstrutorLab;
import logic.Labirinto;

public class Janela extends JPanel {

	private BufferedImage dragao;
	private BufferedImage dragaoDormir;
	private BufferedImage heroi;
	private BufferedImage heroiArmado;
	private BufferedImage espada;
	private BufferedImage aguiaCaminho;
	private BufferedImage aguiaParede;
	private BufferedImage parede;
	private BufferedImage caminho;
	private char[][] lab;
	
	
	public Janela(char[][] lab) {
		// importar imagens
		try {
			dragao=ImageIO.read(new File("src/Imagens/dragon.png"));
			dragaoDormir=ImageIO.read(new File("src/Imagens/sleepingDragon.png"));
			heroi=ImageIO.read(new File("src/Imagens/hero.png"));
			heroiArmado=ImageIO.read(new File("src/Imagens/hero.png"));
			espada=ImageIO.read(new File("src/Imagens/sword.png"));
			aguiaCaminho=ImageIO.read(new File("src/Imagens/eaglePath.png"));
			aguiaParede=ImageIO.read(new File("src/Imagens/eagleWall.png"));
			parede=ImageIO.read(new File("src/Imagens/wall.png"));
			caminho=ImageIO.read(new File("src/Imagens/path.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.lab=lab;
		
	}
	
	
	protected void paintComponent(Graphics g){
		char elemento;
		
		for(int i=0; i<lab.length; i++){
			for(int j=0; j<lab.length; j++){
				elemento =lab[i][j];
				switch(elemento){
				case 'D':
					g.drawImage(dragao, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'E':
					g.drawImage(espada, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'H':
					g.drawImage(heroi, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'A':
					g.drawImage(heroiArmado, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'X':
					g.drawImage(parede, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'F':
					g.drawImage(dragao, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case ' ':
					g.drawImage(caminho, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				case 'S':
					g.drawImage(caminho, j*80, i*80, 80, 80, Color.WHITE, null);
					break;
				}
				
					
			}
		}
	}

}
