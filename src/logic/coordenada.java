package logic;

/**
 * Classe que define uma coordenada constituída por uma abcissa e por uma ordenada
 * 
 * @author André
 *
 */
public class coordenada {

	private int x=0;
	private int y=0;
		
	public coordenada(){}
	
	/**
	 * Constrói uma coordenada de acordo com os valores passados
	 * 
	 * @param x abcissa da nova coordenada
	 * @param y ordenada da nova coordenada
	 */
	public coordenada(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	/**
	 * 
	 * @return a ordenada da coordenada
	 */
	public int getY() {
		return y;
	}

	/**
	 * Altera a ordenada da coordenada
	 * @param y nova ordenada da coordenada
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return a abcissa da coordenada
	 */
	public int getX() {
		return x;
	}

	/**
	 * Altera a abcissa da coordenada
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
}
