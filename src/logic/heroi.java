package logic;

/**
 * Classe que representa e inicializa o her�i
 * 
 * @author Andr�
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
	 * Cria um her�i com as caracter�sticas passadas como par�metros
	 *  
	 * @param x abcissa do her�i
	 * @param y ordenada do her�i
	 * @param representacao caracter de representa��o do her�i no jogo
	 */
	public heroi(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	/**
	 * 
	 * @return Verdadeiro se o her�i est� armado e falso caso contr�rio
	 */
	public boolean isArmado() {
		return armado;
	}
	
	/**
	 * Modifica o estado do equipamento do her�i, armado ou n�o armado
	 * @param armado novo estado do equipamento do her�i
	 */
	public void setArmado(boolean armado) {
		this.armado = armado;
	}

	/**
	 * 
	 * @return Verdadeiro se o her�i est� morto e falso caso contr�rio
	 */
	public boolean isMorto() {
		return morto;
	}

	/**
	 * Altera o estado do her�i
	 * @param morto novo estado do her�i
	 */
	public void setMorto(boolean morto) {
		this.morto = morto;
	}
	
	/**
	 * 
	 * @return Verdadeiro se o her�i est� a usar a �guia para apanhar a espada
	 * e falso caso contr�rio
	 */
	public boolean isAguiaEmUso() {
		return aguiaEmUso;
	}

	/**
	 * Altera o estado de uso da �guia por parte do her�i
	 * @param aguiaEmUso novo estado de utiliza��o da �guia
	 */
	public void setAguiaEmUso(boolean aguiaEmUso) {
		this.aguiaEmUso = aguiaEmUso;
	}

}
