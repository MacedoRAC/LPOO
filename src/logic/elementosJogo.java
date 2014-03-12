package logic;

public class elementosJogo extends coordenada{

	private char representacao;
	
	public elementosJogo(){};
	
	public elementosJogo(char rep) {
		this.representacao=rep;
	}
	public char getRepresentacao() {
		return representacao;
	}
	public void setRepresentacao(char representacao) {
		this.representacao = representacao;
	}


}
