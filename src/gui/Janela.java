package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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
	
	void inciaJogo(Labirinto l){
		aJogar=true;
		this.lab=l;
	}
	
	
	protected void paintComponent(Graphics g){
		char elemento;
		requestFocus(true); 
		
		if(aJogar){
			int tamanholab=lab.getLabirinto().getTamanhoLab();
			for(int i=0; i<tamanholab; i++){
				for(int j=0; j<tamanholab; j++){
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
					case 'G':
						if(lab.isAguiaNaParede())
							g.drawImage(aguiaParede, j*60, i*60, 60, 60, Color.WHITE, null);
						else
							g.drawImage(aguiaCaminho, j*60, i*60, 60, 60, Color.WHITE, null);
					}

				}
			}
		}
		else{
			g.drawImage(fundo, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
		}
	}
	

	private class teclado extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			int direcao=e.getKeyCode();
			
			if(direcao==cima || direcao==KeyEvent.VK_W){
				lab.processaEvento("w");
			}else if(direcao==baixo || direcao==KeyEvent.VK_S){
				lab.processaEvento("s");
			}else if(direcao==esquerda || direcao==KeyEvent.VK_A){
				lab.processaEvento("a");
			}else if(direcao==direita || direcao==KeyEvent.VK_D){
				lab.processaEvento("d");
			}else if(direcao==aguia || direcao==KeyEvent.VK_G){
				lab.processaEvento("g");
			}
			repaint();
			verificaVitoriaDerrota();
		}

	}
	
	void verificaVitoriaDerrota(){
		if(lab.isVitoria()){
			JOptionPane.showMessageDialog(null, "Parabéns! Aventura terminada com sucesso");
			setFocusable(false);
		}else if(lab.getHeroi().isMorto()){
			JOptionPane.showMessageDialog(null, "Um dragão matou-te!");
			setFocusable(false);
		}
		
		
	}


}
