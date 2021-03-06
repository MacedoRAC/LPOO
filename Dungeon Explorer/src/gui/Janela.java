package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Labirinto;
/**
 * Janela � o s�tio principal da aplica��o, onde o labirinto e os elementos s�o desenhados
 * 
 * @author Andr�
 *
 */
public class Janela extends JPanel implements Serializable{

	/**
	 * 
	 */
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
	private int setaCima= KeyEvent.VK_UP;
	private int setaBaixo= KeyEvent.VK_DOWN;
	private int setaEsquerda= KeyEvent.VK_LEFT;
	private int setaDireita= KeyEvent.VK_RIGHT;
	private int espaco= KeyEvent.VK_SPACE;
	private boolean aJogar;
	private String cima="w";
	private String baixo="s";
	private String esquerda="a";
	private String direita="d";
	private String aguia="g";

	
	/**
	 * Construtor de Janela onde s�o carregadas as imagens para depois serem impressas
	 */
	public Janela() {		
		this.aJogar=false;
		
		// importar imagens
		try {
			dragao=ImageIO.read(new File("src/gui/Imagens/dragon.png"));
			dragaoDormir=ImageIO.read(new File("src/gui/Imagens/sleepingDragon.png"));
			heroi=ImageIO.read(new File("src/gui/Imagens/heroUnarmored.png"));
			heroiArmado=ImageIO.read(new File("src/gui/Imagens/hero.png"));
			espada=ImageIO.read(new File("src/gui/Imagens/sword.png"));
			aguiaCaminho=ImageIO.read(new File("src/gui/Imagens/eaglePath.png"));
			aguiaParede=ImageIO.read(new File("src/gui/Imagens/eagleWall.png"));
			parede=ImageIO.read(new File("src/gui/Imagens/wall.png"));
			caminho=ImageIO.read(new File("src/gui/Imagens/path.png"));
			fundo=ImageIO.read(new File("src/gui/Imagens/fundo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new teclado());
		setFocusable(true);
	}
	
	/**
	 * Apenas "liga" a flag que d� in�cio ao jogo no modo gr�fico
	 * @param l L�gica do jogo sobre a qual se vai jogar
	 */
	void inciaJogo(Labirinto l){
		aJogar=true;
		this.lab=l;
		this.tamanholab=lab.getLabirinto().getTamanhoLab();
		setFocusable(true);
	}
	
	/**
	 * Imprime no ecr� as imagens previamente carregadas de acordo com a posi��o dos elementos no labirinto
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
	 * @author Andr�
	 *
	 */
	private class teclado extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			int direcao=e.getKeyCode();
			
			if(direcao==setaCima || direcao==(int) cima.charAt(0)){
				lab.processaEvento("w");
			}else if(direcao==setaBaixo || direcao==(int) baixo.charAt(0)){
				lab.processaEvento("s");
			}else if(direcao==setaEsquerda || direcao==(int) esquerda.charAt(0)){
				lab.processaEvento("a");
			}else if(direcao==setaDireita || direcao==(int) direita.charAt(0)){
				lab.processaEvento("d");
			}else if(direcao==espaco || direcao==(int) aguia.charAt(0)){
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
			JOptionPane.showMessageDialog(null, "Parab�ns! Aventura terminada com sucesso");
			setFocusable(false);
			aJogar=false;
			repaint();
		}else if(lab.getHeroi().isMorto()){
			JOptionPane.showMessageDialog(null, "Um drag�o matou-te!");
			setFocusable(false);
			aJogar=false;
			repaint();
		}
		
		
	}
	
	/**
	 * @return estado do jogo
	 */
	Labirinto getLab(){
		return lab;
	}
	
	/**
	 * 
	 *@param cima nova tecla para cima
	 */
	void setCima(String cima){
		this.cima=cima;
	}
	
	/**
	 * 
	 *@param baixo nova tecla para baixo
	 */
	void setBaixo(String baixo){
		this.baixo=baixo;
	}
	
	/**
	 * 
	 *@param esquerda nova tecla para esquerda
	 */
	void setEsquerda(String esquerda){
		this.esquerda=esquerda;
	}
	
	/**
	 * 
	 *@param direita nova tecla para direita
	 */
	void setDireita(String direita){
		this.direita=direita;
	}
	
	/**
	 * 
	 *@param aguia nova tecla para movimentar aguia
	 */
	void setAguia(String aguia){
		this.aguia=aguia;
	}

}
