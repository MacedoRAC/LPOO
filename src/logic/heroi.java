package logic;

public class heroi extends elementosJogo{
	
	private boolean armado=false;
	private boolean morto=false;
	private boolean aguiaEmUso=false;

	public heroi() {
		setX(1);
		setX(1);
	}
	
	public heroi(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	public boolean isArmado() {
		return armado;
	}

	public void setArmado(boolean armado) {
		this.armado = armado;
	}

	public boolean isMorto() {
		return morto;
	}

	public void setMorto(boolean morto) {
		this.morto = morto;
	}

	public boolean isAguiaEmUso() {
		return aguiaEmUso;
	}

	public void setAguiaEmUso(boolean aguiaEmUso) {
		this.aguiaEmUso = aguiaEmUso;
	}

}
