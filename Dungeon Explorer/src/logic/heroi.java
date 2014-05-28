package logic;

/**
 * Classe que representa e inicializa o herói
 * 
 * @author André
 *
 */
public class heroi extends elementosJogo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean armado=false;
	private boolean morto=false;
	private boolean aguiaEmUso=false;

	public heroi() {
		setX(1);
		setX(1);
	}
	
	/**
	 * Cria um herói com as características passadas como parâmetros
	 *  
	 * @param x abcissa do herói
	 * @param y ordenada do herói
	 * @param representacao caracter de representação do herói no jogo
	 */
	public heroi(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	/**
	 * 
	 * @return Verdadeiro se o herói está armado e falso caso contrário
	 */
	public boolean isArmado() {
		return armado;
	}
	
	/**
	 * Modifica o estado do equipamento do herói, armado ou não armado
	 * @param armado novo estado do equipamento do herói
	 */
	public void setArmado(boolean armado) {
		this.armado = armado;
	}

	/**
	 * 
	 * @return Verdadeiro se o herói está morto e falso caso contrário
	 */
	public boolean isMorto() {
		return morto;
	}

	/**
	 * Altera o estado do herói
	 * @param morto novo estado do herói
	 */
	public void setMorto(boolean morto) {
		this.morto = morto;
	}
	
	/**
	 * 
	 * @return Verdadeiro se o herói está a usar a águia para apanhar a espada
	 * e falso caso contrário
	 */
	public boolean isAguiaEmUso() {
		return aguiaEmUso;
	}

	/**
	 * Altera o estado de uso da águia por parte do herói
	 * @param aguiaEmUso novo estado de utilização da águia
	 */
	public void setAguiaEmUso(boolean aguiaEmUso) {
		this.aguiaEmUso = aguiaEmUso;
	}

}
