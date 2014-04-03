package logic;

public class aguia extends elementosJogo {

	private boolean emVoo;
	private boolean temEspada;
	private coordenada posInicial=new coordenada();
	private coordenada posFinal=new coordenada(); 
	
	public aguia(int xHeroi, int yHeroi) {
		this.emVoo=false;
		this.temEspada=false;
		setX(xHeroi);//começa na mesma
		setY(yHeroi);//posição que o heroi
		this.setRepresentacao('G');
		
	}
	
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
		
		apanhouEspada(e);
		
	}
	
	public void apanhouEspada(espada e){
		if(this.getX()==e.getX() && this.getY()==e.getY()){
			this.temEspada=true;
			coordenada temp=posInicial;
			posInicial=posFinal;
			posFinal=temp;
			e.setAtiva(false);
		}
	}

	public boolean isEmVoo() {
		return emVoo;
	}

	public void setEmVoo(boolean emVoo) {
		this.emVoo = emVoo;
	}

	public boolean isTemEspada() {
		return temEspada;
	}

	public void setTemEspada(boolean temEspada) {
		this.temEspada = temEspada;
	}

	public coordenada getPosFinal(){
		return posFinal;
	}
	
	public void setPosFinal(int x, int y){
		this.posFinal.setX(x);
		this.posFinal.setY(y);
	}

	public coordenada getPosInicial() {
		return posInicial;
	}

	public void setPosInicial(coordenada posInicial) {
		this.posInicial = posInicial;
	}
}
