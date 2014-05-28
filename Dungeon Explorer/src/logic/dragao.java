package logic;

/**
 * Classe que representa e inicializa um dragão
 * 
 * @author André
 *
 */
public class dragao extends elementosJogo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean adormecido=false;
	private boolean morto=false;

	public dragao(){
		
	}
	
	/**
	 * Cria um dragão de acordo com os parâmetros passados
	 * 
	 * @param x abcissa da localização do dragão
	 * @param y ordenada da localização do dragão
	 * @param representacao caracter de representação do dragão no labirinto
	 */
	public dragao(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}
	
	/**
	 * 
	 * @return Verdadeiro se o dragão está adormecido e falso caso contrário
	 */
	public boolean isAdormecido() {
		return adormecido;
	}

	/**
	 * Altera o comportamento do dragão de acordo com o parâmetro passado
	 * @param adormecido novo comportamento do dragão
	 */
	public void setAdormecido(boolean adormecido) {
		this.adormecido = adormecido;
	}

	/**
	 * 
	 * @return Verdadeiro se o dragão está morto e falso caso contrário
	 */
	public boolean isMorto() {
		return morto;
	}

	/**
	 * Altera o estado do dragão
	 * @param morto novo estado do dragão
	 */
	public void setMorto(boolean morto) {
		this.morto = morto;
	}

}
