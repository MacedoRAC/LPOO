package logic;

import java.io.Serializable;

/**
 * Classe m�e de ConstAleatorioLab e ConstFixoLab
 * 
 * @author Andr�
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
	 * @return O labirinto constru�do por uma das subclasses filhas
	 */
	public char[][] getLab() {
		return lab;
	}
	/**
	 * Altera o labirinto constru�do por uma das subclasses filhas
	 * 
	 * @param labirinto novo labirinto
	 */
	public void setLab(char[][] labirinto) {
		this.lab = labirinto;
	}
	
	/**
	 * 
	 * @return o tamanho do labirinto constru�do por uma das subclasses filhas
	 */
	public int getTamanhoLab() {
		return tamanhoLab;
	}

	/**
	 * Altera o tamanho do labirinto a ser constru�do
	 * 
	 * @param tamanhoLab
	 */
	public void setTamanhoLab(int tamanhoLab) {
		this.tamanhoLab = tamanhoLab;
	}
	
	/**
	 *  
	 * @return A coordenada e representa��o da sa�da do labirinto
	 */
	public elementosJogo getSaida() {
		return saida;
	}
	
	/**
	 * Altera a saida do labirinto
	 * @param saida nova sa�da do labirinto
	 */
	public void setSaida(elementosJogo saida) {
		this.saida = saida;
	}
}
