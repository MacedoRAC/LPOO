package logic;
import java.util.Random;


public class Labirinto {
	
	private ConstrutorLab labirinto;
	private boolean vitoria = false;
	private heroi H;
	private dragao D;
	private espada E;
	private aguia Ag;
	private elementosJogo posAnteriorAguia= new elementosJogo();
	private coordenada inicialAguia =new coordenada();
	
	public Labirinto() {
		labirinto=new ConstFixoLab();
		H=new heroi();
		D=new dragao();
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
	
	public dragao getDragao(){
		return D;
	}
	
	public void processaEvento(String mov) {
		
		if(!mov.equals("e"))
			moveH(mov);
		if(!D.isMorto()){
			movimentoDragao();
			if(morteDragao())
				D.setMorto(true);
			if(morteHeroi())
				H.setMorto(true);
		}
		verificaLab(labirinto.getLab());
	}

	public void verificaLab(char[][] lab){

		if(!D.isMorto()){//dragao nao esta morto
			if(E.isAtiva()){//espada esta ativa
				if(E.getY()==D.getY() && E.getX()==D.getX())//posicao dragao==posicao espada
					labirinto.getLab()[E.getY()][E.getX()]='F';
				else{
					if(D.isAdormecido())
						labirinto.getLab()[D.getY()][D.getX()]='Z';
					else
						labirinto.getLab()[D.getY()][D.getX()]='D';
					
					labirinto.getLab()[E.getY()][E.getX()]='E';
					
				}
			}else{//espada nao esta ativa
				if(D.isAdormecido())
					labirinto.getLab()[D.getY()][D.getX()]='Z';
				else
					labirinto.getLab()[D.getY()][D.getX()]='D';
			}
		}else if(D.isMorto()) 
			labirinto.getLab()[D.getY()][D.getX()]=' ';

		if(!H.isMorto()){
			if(H.isArmado())
				labirinto.getLab()[H.getY()][H.getX()]='A';
			else
				labirinto.getLab()[H.getY()][H.getX()]='H';
		}
		
		if(Ag.isEmVoo()){
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
			else if(adjacente=='S' && D.isMorto()){
				vitoria=true;
				trocaH("cima");
			}else if(adjacente=='S' && !D.isMorto()){
				System.out.println("Não podes sair, o dragão ainda não foi morto!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("cima");
			}else
				System.out.print("Movimento não permitido!");
			moveAguia();
			break;
		
		
		case "s":
			i=H.getY()+1;
			adjacente=labirinto.getLab()[i][H.getX()];
			
			if(adjacente==' ')
				trocaH("baixo");
			else if(adjacente=='S' && D.isMorto()){
				vitoria=true;
				trocaH("baixo");
			}else if(adjacente=='S' && !D.isMorto()){
				System.out.println("Não podes sair, o dragão ainda não foi morto");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("baixo");
			}else
				System.out.print("Movimento não permitido!");
			moveAguia();
			break;
			
		case "a":
			i=H.getX()-1;
			adjacente=labirinto.getLab()[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("esquerda");
			else if(adjacente=='S' && D.isMorto()){
				vitoria=true;
				trocaH("esquerda");
			}else if(adjacente=='S' && !D.isMorto()){
				System.out.println("Não podes sair, o dragão ainda não foi morto!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("esquerda");
			}else
				System.out.print("Movimento não permitido!");
			moveAguia();
			break;
			
		case "d":
			i=H.getX()+1;
			adjacente=labirinto.getLab()[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("direita");
			else if(adjacente=='S' && D.isMorto()){
				vitoria=true;
				trocaH("direita");
			}else if(adjacente=='S' && !D.isMorto()){
				System.out.println("Não podes sair, o dragão ainda não foi morto!");
			}else if(adjacente=='E' || adjacente=='G'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("direita");
			}else
				System.out.print("Movimento não permitido!");
			moveAguia();
			break;
		case "g":
			if(!Ag.isEmVoo() && E.isAtiva()){
				Ag.comecaMovimento(H, E);
				posAnteriorAguia.setX(Ag.getX());
				posAnteriorAguia.setX(Ag.getX());
				posAnteriorAguia.setRepresentacao(labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]);
			}else
				moveAguia();
			break;
		}
	}

	public void moveAguia() {
		if(Ag.isEmVoo()){
			Ag.calculaNovaPos(E);
			posAnteriorAguia.setX(Ag.getX());
			posAnteriorAguia.setX(Ag.getX());
			posAnteriorAguia.setRepresentacao(labirinto.getLab()[posAnteriorAguia.getY()][posAnteriorAguia.getX()]);
		}
	}

	public void trocaH(String movimento) {
		labirinto.getLab()[H.getY()][H.getX()]=' ';
		
		switch(movimento){
		case "cima":
			H.setY(H.getY()-1);
			if(morteHeroi())
				H.setMorto(true);
			if(morteDragao())
				D.setMorto(true);
			break;
		case "baixo":
			H.setY(H.getY()+1);
			if(morteHeroi())
				H.setMorto(true);
			if(morteDragao())
				D.setMorto(true);
			break;
		case "esquerda":
			H.setX(H.getX()-1);
			if(morteHeroi())
				H.setMorto(true);
			if(morteDragao())
				D.setMorto(true);
			break;
		case "direita":
			H.setX(H.getX()+1);
			if(morteHeroi())
				H.setMorto(true);
			if(morteDragao())
				D.setMorto(true);
			break;
		}
	}

	public void geraPosInicialHeroi(){

		boolean livre=false;
		Random rand=new Random();
		int coord_X, coord_Y;

		while(livre==false){
			coord_X=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(labirinto.getLab()[coord_Y][coord_X] == ' '  && (((coord_Y+1)!=D.getY()) && //o dragao esta na celula acima à do heroi
												 				((coord_Y-1)!=D.getY()) && //o dragao esta na celula abaixo à do heroi
  															    ((coord_X+1)!=D.getX()) && //o dragao esta na celula à direita à do heroi
															    ((coord_X-1)!=D.getX()))){ 
				livre=true;
				H.setX(coord_X);
				H.setY(coord_Y);
			}
		}
	}

	public void geraPosInicialDragao(){
		boolean livre=false;
		Random rand=new Random();
		int coord_X, coord_Y;

		while(livre==false){
			coord_X=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(labirinto.getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(labirinto.getLab()[coord_Y][coord_X] == ' ' || labirinto.getLab()[coord_Y][coord_X] == 'E'){ //ANALISAR SITUAÇÕES EM QUE O HEROI É COLOCADO AO LADO DO DRAGAO OU DA SAIDA
				livre=true;
				D.setX(coord_X);
				D.setY(coord_Y);
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
				
		if(!H.isArmado() && !D.isAdormecido() && (((H.getY()+1)==D.getY() && H.getX()==D.getX()) || //o dragao esta na celula abaixo à do heroi
												 ((H.getY()-1)==D.getY() && H.getX()==D.getX()) || //o dragao esta na celula acima à do heroi
												 (H.getY()==D.getY() && (H.getX()+1)==D.getX()) || //o dragao esta na celula à direita à do heroi
												 (H.getY()==D.getY() && (H.getX()-1)==D.getX()))){ //o dragao esta na celula à esquerda à do heroi
			return true;
		}else
			return false;
	}

	public boolean morteDragao(){
		if(H.isArmado() && (((H.getY()+1)==D.getY() && H.getX()==D.getX()) || //o dragao esta na celula abaixo à do heroi
							((H.getY()-1)==D.getY() && H.getX()==D.getX()) || //o dragao esta na celula acima à do heroi
							(H.getY()==D.getY() && (H.getX()+1)==D.getX()) || //o dragao esta na celula à direita à do heroi
							(H.getY()==D.getY() && (H.getX()-1)==D.getX()))){ //o dragao esta na celula à esquerda à do heroi
			return true;
		}else
			return false;
	}
	
	public void movimentoDragao(){
		boolean podeMover=false;
		Random rand= new Random();
		int i;

		D.setAdormecido(false);
		i=rand.nextInt(2);
		
		if(i==0)
			D.setAdormecido(true);
		else		
			do{
				i=rand.nextInt(4);
				switch(i){
				case 0:
					if(labirinto.getLab()[D.getY()-1][D.getX()] == ' ' || labirinto.getLab()[D.getY()-1][D.getX()] == 'E'){
						labirinto.getLab()[D.getY()][D.getX()] = ' ';
						D.setY(D.getY()-1);
						podeMover=true;
					}break;
				case 1:
					if(labirinto.getLab()[D.getY()+1][D.getX()] == ' ' || labirinto.getLab()[D.getY()+1][D.getX()] == 'E'){
						labirinto.getLab()[D.getY()][D.getX()] = ' ';
						D.setY(D.getY()+1);
						podeMover=true;
					}break;
				case 2:
					if(labirinto.getLab()[D.getY()][D.getX()-1] == ' ' || labirinto.getLab()[D.getY()][D.getX()-1] == 'E'){
						labirinto.getLab()[D.getY()][D.getX()] = ' ';
						D.setX(D.getX()-1);
						podeMover=true;
					}break;
				case 3:
					if(labirinto.getLab()[D.getY()][D.getX()+1] == ' ' || labirinto.getLab()[D.getY()][D.getX()+1] == 'E'){
						labirinto.getLab()[D.getY()][D.getX()] = ' ';
						D.setX(D.getX()+1);
						podeMover=true;
					}break;
				}
			}while(!podeMover);
		
	}	

	public ConstrutorLab getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(ConstrutorLab labirinto) {
		this.labirinto = labirinto;
	}

	
}
