package logic;

/**
 * Classe que representa e inicializa um drag�o
 * 
 * @author Andr�
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
	 * Cria um drag�o de acordo com os par�metros passados
	 * 
	 * @param x abcissa da localiza��o do drag�o
	 * @param y ordenada da localiza��o do drag�o
	 * @param representacao caracter de representa��o do drag�o no labirinto
	 */
	public dragao(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}
	
	/**
	 * 
	 * @return Verdadeiro se o drag�o est� adormecido e falso caso contr�rio
	 */
	public boolean isAdormecido() {
		return adormecido;
	}

	/**
	 * Altera o comportamento do drag�o de acordo com o par�metro passado
	 * @param adormecido novo comportamento do drag�o
	 */
	public void setAdormecido(boolean adormecido) {
		this.adormecido = adormecido;
	}

	/**
	 * 
	 * @return Verdadeiro se o drag�o est� morto e falso caso contr�rio
	 */
	public boolean isMorto() {
		return morto;
	}

	/**
	 * Altera o estado do drag�o
	 * @param morto novo estado do drag�o
	 */
	public void setMorto(boolean morto) {
		this.morto = morto;
	}

}
