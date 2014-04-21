package logic;

import java.io.Serializable;

/**
 * Classe que representa o caracter que representa cada elemento do jogo
 * 
 * @author André
 *
 */
public class elementosJogo extends coordenada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char representacao;
	
	public elementosJogo(){};
	
	/**
	 * Cria um novo elemento no jogo 
	 * @param rep caracter que representa o novo elemento no jogo
	 */
	public elementosJogo(char rep) {
		this.representacao=rep;
	}
	/**
	 * 
	 * @return o caracter que representa o elemento no jogo
	 */
	public char getRepresentacao() {
		return representacao;
	}
	
	/**
	 * Altera o caracter que representa o elemento no jogo
	 * @param representacao novo caracter que representa o elemento no jogo
	 */
	public void setRepresentacao(char representacao) {
		this.representacao = representacao;
	}


}
