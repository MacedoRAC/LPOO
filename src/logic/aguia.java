package logic;

public class aguia extends elementosJogo {

	private boolean emVoo;
	private boolean morta;
	private coordenada pos_inicial; 
	
	public aguia(int xHeroi, int yHeroi) {
		this.setEmVoo(false);
		this.setMorta(false);
		setX(xHeroi);//começa na mesma
		setY(yHeroi);//posição que o heroi
		this.pos_inicial.setX(getX());
		this.pos_inicial.setY(getY());
		
	}

	public boolean isEmVoo() {
		return emVoo;
	}

	public void setEmVoo(boolean emVoo) {
		this.emVoo = emVoo;
	}

	public boolean isMorta() {
		return morta;
	}

	public void setMorta(boolean morta) {
		this.morta = morta;
	}

}
