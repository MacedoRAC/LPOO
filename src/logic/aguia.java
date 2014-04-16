package logic;

/**
 * Classe de representa��o da �guia
 * 
 * @author Andr�
 *
 */
public class aguia extends elementosJogo {

	private boolean emVoo;
	private boolean temEspada;
	private boolean morta;
	private coordenada posInicial=new coordenada();
	private coordenada posFinal=new coordenada(); 
	
	/**
	 * Inicializa��o dos par�metros que representam a �guia
	 * 
	 * @param xHeroi abcissa inicial do her�i 
	 * @param yHeroi ordenada inicial do her�i
	 */
	public aguia(int xHeroi, int yHeroi) {
		this.emVoo=false;
		this.temEspada=false;
		this.setMorta(false);
		setX(xHeroi);//come�a na mesma
		setY(yHeroi);//posi��o que o heroi
		this.setRepresentacao('G');
		
	}
	
	/**
	 * Come�a o movimento da �guia na busca da espada
	 * 
	 * @param h her�i 
	 * @param e espada
	 */
	public void comecaMovimento(heroi h, espada e){
		if(!h.isAguiaEmUso() && e.isAtiva()){
			posInicial.setX(h.getX());
			posInicial.setY(h.getY());
			posFinal.setX(e.getX());
			posFinal.setY(e.getY());
			
			emVoo=true;
			h.setAguiaEmUso(true);
			setX(h.getX());
			setY(h.getY());
		}
	}
	
	/**
	 * Calcula a nova posi��o da �guia 
	 * 
	 * @param e espada
	 */
	public void calculaNovaPos(espada e){
		
		int deltaX= posFinal.getX()- getX();
		int deltaY= posFinal.getY()- getY();
		
		if(deltaX>deltaY){
			if(getX()<posFinal.getX())
				setX(getX()+1);
			else
				setX(getX()-1);
		}else{
			if(getY()<posFinal.getY())
				setY(getY()+1);
			else
				setY(getY()-1);
		}
		
		if(this.temEspada==false)
			apanhouEspada(e);
		
	}
	
	/**
	 * Verifica se a �guia apanhou a espada e caso seja verdade
	 * troca a posi��o final com a posi��o inicial
	 * 
	 * @param e espada
	 */
	public void apanhouEspada(espada e){
		if(this.getX()==e.getX() && this.getY()==e.getY()){
			this.temEspada=true;
			coordenada temp=posInicial;
			posInicial=posFinal;
			posFinal=temp;
			e.setAtiva(false);
		}
	}

	/**
	 *  
	 * @return Verdadeiro ou falso se a �guia est� em voo ou n�o, respectivamente
	 */
	public boolean isEmVoo() {
		return emVoo;
	}
	
	public void setEmVoo(boolean emVoo) {
		this.emVoo = emVoo;
	}
	
	/**
	 *  
	 * @return Verdadeiro ou falso se a �guia tem a espada ou n�o, respectivamente
	 */
	public boolean isTemEspada() {
		return temEspada;
	}

	public void setTemEspada(boolean temEspada) {
		this.temEspada = temEspada;
	}
	
	/**
	 * 
	 * @return A posi��o final do voo da �guia
	 */
	public coordenada getPosFinal(){
		return posFinal;
	}
	
	/**
	 * Altera a posi��o final do voo da �guia
	 * 
	 * @param x Nova abcissa da posi��o final
	 * @param y	Nova ordenada da posi��o final
	 */
	public void setPosFinal(int x, int y){
		this.posFinal.setX(x);
		this.posFinal.setY(y);
	}

	/**
	 * 
	 * @return A posi��o inicial do voo da �guia
	 */
	public coordenada getPosInicial() {
		return posInicial;
	}
	
	/**
	 * Altera a posi��o inicial do voo da �guia
	 * 
	 * @param x Nova abcissa da posi��o inicial
	 * @param y	Nova ordenada da posi��o inicial
	 */
	public void setPosInicial(coordenada posInicial) {
		this.posInicial = posInicial;
	}
	
	/**
	 * 
	 * @return Verdadeiro se a �guia est� morta e falso caso contr�rio
	 */
	public boolean isMorta() {
		return morta;
	}

	public void setMorta(boolean morta) {
		this.morta = morta;
	}
}
