package logic;

public class aguia extends elementosJogo {

	private boolean emVoo;
	private boolean morta;
	private int Xinic, Yinic; 
	
	public aguia() {
		this.setEmVoo(false);
		this.setMorta(false);
		setX(1);
		setY(1);
		this.setXinic(getX());
		this.setYinic(getY());
		
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

	public int getXinic() {
		return Xinic;
	}

	public void setXinic(int xinic) {
		Xinic = xinic;
	}

	public int getYinic() {
		return Yinic;
	}

	public void setYinic(int yinic) {
		Yinic = yinic;
	}

}
