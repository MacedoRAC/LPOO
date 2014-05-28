package logic;

import java.io.Serializable;

/**
 * Classe mãe de ConstAleatorioLab e ConstFixoLab
 * 
 * @author André
 *
 */
public abstract class ConstrutorLab implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int tamanhoLab=11;
	protected char[][] lab = new char[tamanhoLab][tamanhoLab];
	private elementosJogo saida=new elementosJogo('S');
	
	/**
	 * 
	 * @return O labirinto construído por uma das subclasses filhas
	 */
	public char[][] getLab() {
		return lab;
	}
	/**
	 * Altera o labirinto construído por uma das subclasses filhas
	 * 
	 * @param labirinto novo labirinto
	 */
	public void setLab(char[][] labirinto) {
		this.lab = labirinto;
	}
	
	/**
	 * 
	 * @return o tamanho do labirinto construído por uma das subclasses filhas
	 */
	public int getTamanhoLab() {
		return tamanhoLab;
	}

	/**
	 * Altera o tamanho do labirinto a ser construído
	 * 
	 * @param tamanhoLab
	 */
	public void setTamanhoLab(int tamanhoLab) {
		this.tamanhoLab = tamanhoLab;
	}
	
	/**
	 *  
	 * @return A coordenada e representação da saída do labirinto
	 */
	public elementosJogo getSaida() {
		return saida;
	}
	
	/**
	 * Altera a saida do labirinto
	 * @param saida nova saída do labirinto
	 */
	public void setSaida(elementosJogo saida) {
		this.saida = saida;
	}
}
