package logic;
import java.util.Random;


public class Labirinto {
	
	private ConstrutorLab labirinto;
	private boolean vitoria = false;
	private boolean modoAleatorio=false;
	private boolean dragoesAdormecem=false;
	private heroi H;
	private dragao[] D;
	private espada E;
	private aguia Ag;
	private elementosJogo posAnteriorAguia= new elementosJogo();
	private coordenada inicialAguia =new coordenada();
	private boolean aguiaNaParede=false;
	
	public Labirinto(boolean modoAle, int tamanho, boolean dragoesAdo, int numeroDrag) {
		this.modoAleatorio = modoAle;
		this.dragoesAdormecem = dragoesAdo;
		
		if(modoAleatorio)
			labirinto=new ConstAleatorioLab(tamanho);
		else
			labirinto=new ConstFixoLab();
		H=new heroi();
		
		D=new dragao[numeroDrag];
		
		for(int i=0; i<numeroDrag; i++)
			D[i]=new dragao();
		
		E=new espada();
		geraPosInicialEspada();		
		geraPosInicialDragao();
		geraPosInicialHeroi();
		Ag=new aguia(H.getX(), H.getY());
		verificaLab(labirinto.getLab());
	}
	
	public boolean isVitoria() {
		return vitoria;
	}
	
	public void setVitoria(boolean vitoria) {
		this.vitoria = vitoria;
	}
	
	public heroi getHeroi() {
		return H;
	}
	
	public espada getEspada(){
		return E;
	}
	
	public dragao[] getDragao(){
		return D;
	}
	
	public boolean isModoAleatorio(){
		return modoAleatorio;
	}
	
	public void setModoAleatorio(boolean modo){
		this.modoAleatorio=modo;
	}
	
	public void processaEvento(String mov) {
		
		if(!mov.equals("e"))
			moveH(mov);
		for (int i = 0; i < D.length; i++) {
			if (!D[i].isMorto()) {
				movimentoDragao();
				if (morteDragao(D[i]))
					D[i].setMorto(true);
			}
		}
		
		if (morteHeroi())
			H.setMorto(true);
		morteAguia();
		
		verificaLab(labirinto.getLab());
	}

	public void verificaLab(char[][] lab){

		for (int i = 0; i < D.length; i++) {
			if (!D[i].isMorto()) {//dragao nao esta morto
				if (E.isAtiva()) {//espada esta ativa
					if (E.getY() == D[i].getY() && E.getX() == D[i].getX())//posicao dragao==posicao espada
						labirinto.getLab()[E.getY()][E.getX()] = 'F';
					else {
						if (D[i].isAdormecido())
							labirinto.getLab()[D[i].getY()][D[i].getX()] = 'Z';
						else
							labirinto.getLab()[D[i].getY()][D[i].getX()] = 'D';

						labirinto.getLab()[E.getY()][E.getX()] = 'E';

					}
				} else {//espada nao esta ativa
					if (D[i].isAdormecido())
						labirinto.getLab()[D[i].getY()][D[i].getX()] = 'Z';
					else
						labirinto.getLab()[D[i].getY()][D[i].getX()] = 'D';
				}
			} else if (D[i].isMorto())
				labirinto.getLab()[D[i].getY()][D[i].getX()] = ' ';
		}
		
		if(!H.isMorto()){
			if(H.isArmado())
				labirinto.getLab()[H.getY()][H.getX()]='A';
			else
				labirinto.getLab()[H.getY()][H.getX()]='H';
		}
		
		if(Ag.isEmVoo() && !Ag.isMorta()){
			labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]=posAnteriorAguia.getRepresentacao();
			labirinto.getLab()[Ag.getY()][Ag.getX()]='G';
		}
		if(Ag.getX()==inicialAguia.getX() && Ag.getY()==inicialAguia.getY())
			Ag.setEmVoo(false);
		
	}
	
	
	public void moveH(String mov){
		
		char adjacente;
		int i;
		
		switch(mov){
		case "w":
			i=H.getY()-1;
			adjacente= labirinto.getLab()[i][H.getX()];
			if(adjacente==' ')
				trocaH("cima");
			else if(adjacente=='S' && dragoesEstaoMortos()){
				vitoria=true;
				trocaH("cima");
			}else if(adjacente=='S' && !dragoesEstaoMortos()){
				System.out.println("N�o podes sair, os drag�es ainda n�o foram mortos!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("cima");
			}else
				System.out.print("Movimento n�o permitido!");
			moveAguia();
			break;
		
		case "s":
			i=H.getY()+1;
			adjacente=labirinto.getLab()[i][H.getX()];
			
			if(adjacente==' ')
				trocaH("baixo");
			else if(adjacente=='S' && dragoesEstaoMortos()){
				vitoria=true;
				trocaH("baixo");
			}else if(adjacente=='S' && !dragoesEstaoMortos()){
				System.out.println("N�o podes sair, os drag�es ainda n�o foram mortos!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("baixo");
			}else
				System.out.print("Movimento n�o permitido!");
			moveAguia();
			break;
			
		case "a":
			i=H.getX()-1;
			adjacente=labirinto.getLab()[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("esquerda");
			else if(adjacente=='S' && dragoesEstaoMortos()){
				vitoria=true;
				trocaH("esquerda");
			}else if(adjacente=='S' && !dragoesEstaoMortos()){
				System.out.println("N�o podes sair, os drag�es ainda n�o foram mortos!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("esquerda");
			}else
				System.out.print("Movimento n�o permitido!");
			moveAguia();
			break;
			
		case "d":
			i=H.getX()+1;
			adjacente=labirinto.getLab()[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("direita");
			else if(adjacente=='S' && dragoesEstaoMortos()){
				vitoria=true;
				trocaH("direita");
			}else if(adjacente=='S' && !dragoesEstaoMortos()){
				System.out.println("N�o podes sair, os drag�es ainda n�o foram mortos!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("direita");
			}else
				System.out.print("Movimento n�o permitido!");
			moveAguia();
			break;
		case "g":
			if(!Ag.isEmVoo() && E.isAtiva()){
				Ag.comecaMovimento(H, E);
				posAnteriorAguia.setX(Ag.getX());
				posAnteriorAguia.setY(Ag.getY());
				posAnteriorAguia.setRepresentacao(labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]);
			}else
				moveAguia();
			break;
		}
	}

	private boolean dragoesEstaoMortos() {
		for(int i=0; i<D.length; i++)
			if(!D[i].isMorto())
				return false;
		
		
		return true;
	}

	public void moveAguia() {
		if(Ag.isEmVoo() && !Ag.isMorta()){
			labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]=posAnteriorAguia.getRepresentacao();
			Ag.calculaNovaPos(E);
			posAnteriorAguia.setX(Ag.getX());
			posAnteriorAguia.setY(Ag.getY());
			posAnteriorAguia.setRepresentacao(labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]);
			if(posAnteriorAguia.getRepresentacao()=='X')
				setAguiaNaParede(true);
			else
				setAguiaNaParede(false);
			
			morteAguia();
		}else if(Ag.isMorta())
			labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]=posAnteriorAguia.getRepresentacao();
	}

	public void trocaH(String movimento) {
		labirinto.getLab()[H.getY()][H.getX()]=' ';
		
		switch(movimento){
		case "cima":
			H.setY(H.getY()-1);
			if(morteHeroi())
				H.setMorto(true);
			for(int i=0;i<D.length;i++)
				if(morteDragao(D[i]))
					D[i].setMorto(true);
			break;
		case "baixo":
			H.setY(H.getY()+1);
			if(morteHeroi())
				H.setMorto(true);
			for (int i = 0; i < D.length; i++) {
				if (morteDragao(D[i]))
					D[i].setMorto(true);
			}
			break;
		case "esquerda":
			H.setX(H.getX()-1);
			if(morteHeroi())
				H.setMorto(true);
			for (int i = 0; i < D.length; i++) {
				if (morteDragao(D[i]))
					D[i].setMorto(true);
			}
			break;
		case "direita":
			H.setX(H.getX()+1);
			if(morteHeroi())
				H.setMorto(true);
			for (int i = 0; i < D.length; i++) {
				if (morteDragao(D[i]))
					D[i].setMorto(true);
			}
			break;
		}
	}

	public void geraPosInicialHeroi(){

		boolean livre=false;
		Random rand=new Random();
		int coord_X, coord_Y;

		for (int i = 0; i < D.length; i++) {
			while (livre == false) {
				coord_X = rand.nextInt(labirinto.getTamanhoLab() - 2) + 1; //se o labirinto for 10x10 gera um numero entre 1 e 9
				coord_Y = rand.nextInt(labirinto.getTamanhoLab() - 2) + 1; //se o labirinto for 10x10 gera um numero entre 1 e 9
				if (labirinto.getLab()[coord_Y][coord_X] == ' ' && (((coord_Y + 1) != D[i].getY()) && //o dragao esta na celula acima � do heroi
																	((coord_Y - 1) != D[i].getY()) && //o dragao esta na celula abaixo � do heroi
																	((coord_X + 1) != D[i].getX()) && //o dragao esta na celula � direita � do heroi
																	((coord_X - 1) != D[i].getX()))) {
					livre = true;
					H.setX(coord_X);
					H.setY(coord_Y);
				}
			}
		}
	}

	public void geraPosInicialDragao(){
		boolean livre=false;
		Random rand=new Random();
		int coord_X, coord_Y;

		for (int i = 0; i < D.length; i++) {
			livre = false;
			while (livre == false) {
				coord_X = rand.nextInt(labirinto.getTamanhoLab() - 2) + 1; //se o labirinto for 10x10 gera um numero entre 1 e 9
				coord_Y = rand.nextInt(labirinto.getTamanhoLab() - 2) + 1; //se o labirinto for 10x10 gera um numero entre 1 e 9
				if (labirinto.getLab()[coord_Y][coord_X] == ' ' || labirinto.getLab()[coord_Y][coord_X] == 'E') { //ANALISAR SITUA��ES EM QUE O HEROI � COLOCADO AO LADO DO DRAGAO OU DA SAIDA
					livre = true;
					D[i].setX(coord_X);
					D[i].setY(coord_Y);
				}
			}
		}
	}

	public void geraPosInicialEspada(){
		boolean livre=false;
		Random rand=new Random();
		int coord_X, coord_Y;

		while(livre==false){
			coord_X=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(labirinto.getLab()[coord_Y][coord_X] == ' '){
				livre=true;
				E.setX(coord_X);
				E.setY(coord_Y);
			}
		}
	}

	public boolean morteHeroi(){
		boolean morreu=false;
				
		for (int i = 0; i < D.length; i++) {
			if (!H.isArmado() && !D[i].isAdormecido() && (((H.getY() + 1) == D[i].getY() && H.getX() == D[i].getX()) || //o dragao esta na celula abaixo � do heroi
														  ((H.getY() - 1) == D[i].getY() && H.getX() == D[i].getX()) || //o dragao esta na celula acima � do heroi
														   (H.getY() == D[i].getY() && (H.getX() + 1) == D[i].getX()) || //o dragao esta na celula � direita � do heroi
														   (H.getY() == D[i].getY() && (H.getX() - 1) == D[i].getX()))) { //o dragao esta na celula � esquerda � do heroi
				morreu = true;
			}	
		}
		
		return morreu;
	}

	public boolean morteDragao(dragao Dg){
		if(H.isArmado() && (((H.getY()+1)==Dg.getY() && H.getX()==Dg.getX()) || //o dragao esta na celula abaixo � do heroi
							((H.getY()-1)==Dg.getY() && H.getX()==Dg.getX()) || //o dragao esta na celula acima � do heroi
							(H.getY()==Dg.getY() && (H.getX()+1)==Dg.getX()) || //o dragao esta na celula � direita � do heroi
							(H.getY()==Dg.getY() && (H.getX()-1)==Dg.getX()))){ //o dragao esta na celula � esquerda � do heroi
			return true;
		}else
			return false;
	}
	
	public void morteAguia(){
		for (int i = 0; i < D.length; i++) {
			if (!Ag.isTemEspada() && !D[i].isAdormecido() && (((Ag.getY() + 1) == D[i].getY() && Ag.getX() == D[i].getX()) || //o dragao esta na celula abaixo � do heroi
															  ((Ag.getY() - 1) == D[i].getY() && Ag.getX() == D[i].getX()) || //o dragao esta na celula acima � do heroi
															   (Ag.getY() == D[i].getY() && (Ag.getX() + 1) == D[i].getX()) || //o dragao esta na celula � direita � do heroi
															   (Ag.getY() == D[i].getY() && (Ag.getX() - 1) == D[i].getX()))) { //o dragao esta na celula � esquerda � do heroi
				Ag.setMorta(true);
				
			}
		}
	}
	
	public void movimentoDragao(){
		boolean podeMover=false;
		Random rand= new Random();
		int i;

		for (int j = 0; j < D.length; j++) {
			D[j].setAdormecido(false);
			if (dragoesAdormecem)
				i = rand.nextInt(2);
			else
				i = 1;//dragoes nao adormecem 
			if (i == 0)
				D[j].setAdormecido(true);
			else
				do {
					i = rand.nextInt(4);
					switch (i) {
					case 0:
						if (labirinto.getLab()[D[j].getY() - 1][D[j].getX()] == ' ' || labirinto.getLab()[D[j].getY() - 1][D[j].getX()] == 'E') {
							labirinto.getLab()[D[j].getY()][D[j].getX()] = ' ';
							D[j].setY(D[j].getY() - 1);
							podeMover = true;
						}
						break;
					case 1:
						if (labirinto.getLab()[D[j].getY() + 1][D[j].getX()] == ' ' || labirinto.getLab()[D[j].getY() + 1][D[j].getX()] == 'E') {
							labirinto.getLab()[D[j].getY()][D[j].getX()] = ' ';
							D[j].setY(D[j].getY() + 1);
							podeMover = true;
						}
						break;
					case 2:
						if (labirinto.getLab()[D[j].getY()][D[j].getX() - 1] == ' ' || labirinto.getLab()[D[j].getY()][D[j].getX() - 1] == 'E') {
							labirinto.getLab()[D[j].getY()][D[j].getX()] = ' ';
							D[j].setX(D[j].getX() - 1);
							podeMover = true;
						}
						break;
					case 3:
						if (labirinto.getLab()[D[j].getY()][D[j].getX() + 1] == ' ' || labirinto.getLab()[D[j].getY()][D[j].getX() + 1] == 'E') {
							labirinto.getLab()[D[j].getY()][D[j].getX()] = ' ';
							D[j].setX(D[j].getX() + 1);
							podeMover = true;
						}
						break;
					}
				} while (!podeMover);
		}
		
	}	

	public ConstrutorLab getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(ConstrutorLab labirinto) {
		this.labirinto = labirinto;
	}

	public boolean isAguiaNaParede() {
		return aguiaNaParede;
	}

	public void setAguiaNaParede(boolean aguiaNaParede) {
		this.aguiaNaParede = aguiaNaParede;
	}

	
}
