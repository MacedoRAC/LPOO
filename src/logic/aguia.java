package logic;

/**
 * Classe de representação da águia
 * 
 * @author André
 *
 */
public class aguia extends elementosJogo {

	private boolean emVoo;
	private boolean temEspada;
	private boolean morta;
	private coordenada posInicial=new coordenada();
	private coordenada posFinal=new coordenada(); 
	
	/**
	 * Inicialização dos parêmetros que representam a águia
	 * 
	 * @param xHeroi abcissa inicial do herói 
	 * @param yHeroi ordenada inicial do herói
	 */
	public aguia(int xHeroi, int yHeroi) {
		this.emVoo=false;
		this.temEspada=false;
		this.setMorta(false);
		setX(xHeroi);//começa na mesma
		setY(yHeroi);//posição que o heroi
		this.setRepresentacao('G');
		
	}
	
	/**
	 * Começa o movimento da águia na busca da espada
	 * 
	 * @param h herói 
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
	 * Calcula a nova posição da águia 
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
	 * Verifica se a águia apanhou a espada e caso seja verdade
	 * troca a posição final com a posição inicial
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
	 * @return Verdadeiro ou falso se a águia está em voo ou não, respectivamente
	 */
	public boolean isEmVoo() {
		return emVoo;
	}
	
	public void setEmVoo(boolean emVoo) {
		this.emVoo = emVoo;
	}
	
	/**
	 *  
	 * @return Verdadeiro ou falso se a águia tem a espada ou não, respectivamente
	 */
	public boolean isTemEspada() {
		return temEspada;
	}

	public void setTemEspada(boolean temEspada) {
		this.temEspada = temEspada;
	}
	
	/**
	 * 
	 * @return A posição final do voo da águia
	 */
	public coordenada getPosFinal(){
		return posFinal;
	}
	
	/**
	 * Altera a posição final do voo da águia
	 * 
	 * @param x Nova abcissa da posição final
	 * @param y	Nova ordenada da posição final
	 */
	public void setPosFinal(int x, int y){
		this.posFinal.setX(x);
		this.posFinal.setY(y);
	}

	/**
	 * 
	 * @return A posição inicial do voo da águia
	 */
	public coordenada getPosInicial() {
		return posInicial;
	}
	
	/**
	 * Altera a posição inicial do voo da águia
	 * 
	 * @param x Nova abcissa da posição inicial
	 * @param y	Nova ordenada da posição inicial
	 */
	public void setPosInicial(coordenada posInicial) {
		this.posInicial = posInicial;
	}
	
	/**
	 * 
	 * @return Verdadeiro se a águia está morta e falso caso contrário
	 */
	public boolean isMorta() {
		return morta;
	}

	public void setMorta(boolean morta) {
		this.morta = morta;
	}
}
