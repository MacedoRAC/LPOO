package logic;

public abstract class ConstrutorLab {

	protected char[][] lab;
	protected int tamanhoLab=20;
	private elementosJogo saida=new elementosJogo('S');
	

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

	public elementosJogo getSaida() {
		return saida;
	}

	public void setSaida(elementosJogo saida) {
		this.saida = saida;
	}
}
