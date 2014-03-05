package logic;

public abstract class ConstrutorLab {

	protected char[][] lab;
	private int tamanhoLab=10;
	
	
	
	public void criaLab(){}

	public void crialab(int tamanho){}

	public char[][] getLab() {
		return lab;
	}

	public void setLab(char[][] labirinto) {
		this.lab = labirinto;
	}

	public int getTamanhoLab() {
		return tamanhoLab;
	}

	public void setTamanhoLab(int tamanhoLab) {
		this.tamanhoLab = tamanhoLab;
	}
}
