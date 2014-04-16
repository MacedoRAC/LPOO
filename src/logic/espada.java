package logic;

/**
 * Classe que representa e inicializa a espada 
 * 
 * @author Andr�
 *
 */
public class espada extends elementosJogo{
	
	private boolean ativa=true;
	
	public espada() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Cria uma espada com as caracter�sticas passadas como par�metros
	 * 
	 * @param x abcissa da espada
	 * @param y ordenada da espada
	 * @param representacao caracter de representa��o da espada no jogo
	 */
	public espada(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	/**
	 * 
	 * @return Verdadeira se a espada ainda estiver activa e falso caso contr�rio
	 */
	public boolean isAtiva() {
		return ativa;
	}

	/**
	 * Altera o estado de activa��o da espada no jogo
	 * @param ativa novo estado de activa��o
	 */
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

}
