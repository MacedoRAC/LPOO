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
/**
 * Janela é o sítio principal da aplicação, onde o labirinto e os elementos são desenhados
 * 
 * @author André
 *
 */
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
	private int tamanholab;
	private int cima= KeyEvent.VK_UP;
	private int baixo= KeyEvent.VK_DOWN;
	private int esquerda= KeyEvent.VK_LEFT;
	private int direita= KeyEvent.VK_RIGHT;
	private int aguia= KeyEvent.VK_SPACE;
	private boolean aJogar;
	
	/**
	 * Construtor de Janela onde são carregadas as imagens para depois serem impressas
	 */
	public Janela() {		
		this.aJogar=false;
		
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
	
	/**
	 * Apenas "liga" a flag que dá início ao jogo no modo gráfico
	 * @param l Lógica do jogo sobre a qual se vai jogar
	 */
	void inciaJogo(Labirinto l){
		aJogar=true;
		this.lab=l;
		this.tamanholab=lab.getLabirinto().getTamanhoLab();
		setFocusable(true);
	}
	
	/**
	 * Imprime no ecrã as imagens previamente carregadas de acordo com a posição dos elementos no labirinto
	 */
	protected void paintComponent(Graphics g){
		char elemento;
		requestFocus(true);
		setFocusable(true);
		
		if(aJogar){
			int altura=this.getHeight()/tamanholab;
			int largura=this.getWidth()/tamanholab;
			for(int i=0; i<tamanholab; i++){
				for(int j=0; j<tamanholab; j++){
					elemento =lab.getLabirinto().getLab()[i][j];
					switch(elemento){
					case 'D':
						g.drawImage(dragao, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'E':
						g.drawImage(espada, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'H':
						g.drawImage(heroi, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'A':
						g.drawImage(heroiArmado, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'X':
						g.drawImage(parede, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'F':
						g.drawImage(dragao, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case ' ':
						g.drawImage(caminho, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'S':
						g.drawImage(caminho, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'Z':
						g.drawImage(dragaoDormir, j*largura, i*altura, largura, altura, Color.WHITE, null);
						break;
					case 'G':
						if(lab.isAguiaNaParede())
							g.drawImage(aguiaParede, j*largura, i*altura, largura, altura, Color.WHITE, null);
						else
							g.drawImage(aguiaCaminho, j*largura, i*altura, largura, altura, Color.WHITE, null);
					}

				}
			}
		}
		else{
			g.drawImage(fundo, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
		}
	}
	
	/**
	 * Reescrita do KeyAdapter
	 * 
	 * @author André
	 *
	 */
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
	
	/**
	 * Verifica se o jogador venceu ou perdeu o jogo
	 */
	void verificaVitoriaDerrota(){
		if(lab.isVitoria()){
			JOptionPane.showMessageDialog(null, "Parabéns! Aventura terminada com sucesso");
			setFocusable(false);
			aJogar=false;
			repaint();
		}else if(lab.getHeroi().isMorto()){
			JOptionPane.showMessageDialog(null, "Um dragão matou-te!");
			setFocusable(false);
			aJogar=false;
			repaint();
		}
		
		
	}


}
