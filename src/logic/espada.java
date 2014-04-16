package logic;

/**
 * Classe que representa e inicializa a espada 
 * 
 * @author André
 *
 */
public class espada extends elementosJogo{
	
	private boolean ativa=true;
	
	public espada() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Cria uma espada com as características passadas como parâmetros
	 * 
	 * @param x abcissa da espada
	 * @param y ordenada da espada
	 * @param representacao caracter de representação da espada no jogo
	 */
	public espada(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	/**
	 * 
	 * @return Verdadeira se a espada ainda estiver activa e falso caso contrário
	 */
	public boolean isAtiva() {
		return ativa;
	}

	/**
	 * Altera o estado de activação da espada no jogo
	 * @param ativa novo estado de activação
	 */
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

}
