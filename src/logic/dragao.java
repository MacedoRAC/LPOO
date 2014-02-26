package logic;

public class dragao extends elementosJogo {
	
	private boolean adormecido=false;
	private boolean morto=false;

	public dragao(){
		
	}
	
	public dragao(int x, int y, char representacao){
		setX(x);
		setY(y);
		setRepresentacao(representacao);
	}
	
	public boolean isAdormecido() {
		return adormecido;
	}

	public void setAdormecido(boolean adormecido) {
		this.adormecido = adormecido;
	}

	public boolean isMorto() {
		return morto;
	}

	public void setMorto(boolean morto) {
		this.morto = morto;
	}

}
