package logic;

public class espada extends elementosJogo{
	
	private boolean ativa=true;
	
	public espada() {
		// TODO Auto-generated constructor stub
	}
	
	public espada(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

}
