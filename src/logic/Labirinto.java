package logic;
import java.util.Random;
import java.util.Scanner;


public class Labirinto extends ConstrutorLab {
	
	private ConstrutorLab labirinto;
	private boolean vitoria = false;
	private heroi H;
	private dragao D;
	private espada E;

	public Labirinto() {
		H=new heroi();
		D=new dragao();
		E=new espada();
		geraPosInicialHeroi();
		geraPosInicialEspada();		
		geraPosInicialDragao();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Labirinto l=new Labirinto();
		String mov="";
		
		Scanner s= new Scanner(System.in);
		do{
			l.imprimeLab();
			System.out.println();
			System.out.print("Proximo movimento ('e' para sair): ");
			mov=s.next();
			if(!mov.equals("e"))
				l.moveH(mov);
			l.movimentoDragao();
			
		}while(!mov.equals("e") );

		if(l.vitoria)
			System.out.println("VITORIA!");
		
		s.close();
	}
	
	public boolean isVitoria() {
		return vitoria;
	}
	
	public void setVitoria(boolean vitoria) {
		this.vitoria = vitoria;
	}
	
	public int getTamanhoLabirinto() {
		return getTamanhoLab();
	}

	public void setTamanhoLabirinto(int tamanhoLabirinto) {
		this.setTamanhoLab(tamanhoLabirinto);
	}
	
	
	public void imprimeLab(){

		System.out.println();
		System.out.println();

		if(E.isAtiva() && !D.isMorto()){
			if(E.getY()==D.getY() && E.getX()==D.getX())//posicao dragao==posicao espada
				lab[E.getY()][E.getX()]='F';
			else{
				lab[E.getY()][E.getX()]='E';
				lab[D.getY()][D.getX()]='D';
			}
		}else if(D.isMorto())
			lab[D.getY()][D.getX()]=' ';

		if(!H.isMorto()){
			if(H.isArmado())
				lab[H.getY()][H.getX()]='A';
			else
				lab[H.getY()][H.getX()]='H';
		}

		for(int i=0; i<lab.length; i++){
			System.out.println();
			for(int j=0; j<lab[i].length; j++)
				System.out.print(lab[i][j] + " ");
		}
	}
	
	public void moveH(String mov){
		
		char adjacente;
		int i;
		
		switch(mov){
		case "w":
			i=H.getY()-1;
			adjacente= lab[i][H.getX()];
			if(adjacente==' ')
				trocaH("cima");
			else if(adjacente=='S' && H.isArmado()){
				vitoria=true;
				trocaH("cima");
			}else if(adjacente=='S' && !H.isArmado()){
				System.out.println("Não podes sair, ainda não estás armado!");
			}else if(adjacente=='E'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("cima");
			}else
				System.out.print("Movimento não permitido!");
			break;
		
		
		case "s":
			i=H.getY()+1;
			adjacente=lab[i][H.getX()];
			
			if(adjacente==' ')
				trocaH("baixo");
			else if(adjacente=='S' && H.isArmado()){
				vitoria=true;
				trocaH("baixo");
			}else if(adjacente=='S' && !H.isArmado()){
				System.out.println("Não podes sair, ainda não estás armado!");
			}else if(adjacente=='E'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("baixo");
			}else
				System.out.print("Movimento não permitido!");
			break;
			
		case "a":
			i=H.getX()-1;
			adjacente=lab[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("esquerda");
			else if(adjacente=='S' && H.isArmado()){
				vitoria=true;
				trocaH("esquerda");
			}else if(adjacente=='S' && !H.isArmado()){
				System.out.println("Não podes sair, ainda não estás armado!");
			}else if(adjacente=='E'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("esquerda");
			}else
				System.out.print("Movimento não permitido!");
			break;
			
		case "d":
			i=H.getX()+1;
			adjacente=lab[H.getY()][i];
			
			if(adjacente==' ')
				trocaH("direita");
			else if(adjacente=='S' && H.isArmado()){
				vitoria=true;
				trocaH("direita");
			}else if(adjacente=='S' && !H.isArmado()){
				System.out.println("Não podes sair, ainda não estás armado!");
			}else if(adjacente=='E'){
				H.setArmado(true);
				E.setAtiva(false);
				trocaH("direita");
			}else
				System.out.print("Movimento não permitido!");
			break;
			
			default:
				break;
		}
	}

	public void trocaH(String movimento) {
		lab[H.getY()][H.getX()]=' ';
		
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
			coord_X=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(lab[coord_Y][coord_X] == ' '  && (lab[coord_Y+1][coord_X]!='D' && //o dragao esta na celula acima à do heroi
												 lab[coord_Y-1][coord_X]!='D' && //o dragao esta na celula abaixo à do heroi
												 lab[coord_Y][coord_X+1]!='D' && //o dragao esta na celula à direita à do heroi
												 lab[coord_Y][coord_X-1]!='D')){ 
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
			coord_X=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(lab[coord_Y][coord_X] == ' ' || lab[coord_Y][coord_X] == 'E'){ //ANALISAR SITUAÇÕES EM QUE O HEROI É COLOCADO AO LADO DO DRAGAO OU DA SAIDA
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
			coord_X=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			coord_Y=rand.nextInt(getTamanhoLab()-2) +1; //se o labirinto for 10x10 gera um numero entre 1 e 9
			if(lab[coord_Y][coord_X] == ' '){
				livre=true;
				E.setX(coord_X);
				E.setY(coord_Y);
			}
		}
	}

	public boolean morteHeroi(){
				
		if(!H.isArmado() && (lab[H.getY()+1][H.getX()]=='D' || //o dragao esta na celula acima à do heroi
							 lab[H.getY()-1][H.getX()]=='D' || //o dragao esta na celula abaixo à do heroi
							 lab[H.getY()][H.getX()+1]=='D' || //o dragao esta na celula à direita à do heroi
							 lab[H.getY()][H.getX()-1]=='D')){ //o dragao esta na celula à esquerda à do heroi
			return true;
		}else
			return false;
	}

	public boolean morteDragao(){
		
		if(H.isArmado() && (lab[H.getY()+1][H.getX()]=='D' || //o dragao esta na celula acima à do heroi
							lab[H.getY()-1][H.getX()]=='D' || //o dragao esta na celula abaixo à do heroi
							lab[H.getY()][H.getX()+1]=='D' || //o dragao esta na celula à direita à do heroi
							lab[H.getY()][H.getX()-1]=='D')){ //o dragao esta na celula à esquerda à do heroi
			return true;
		}else
			return false;
	}
	
	public void movimentoDragao(){
		boolean podeMover=false;
		Random rand= new Random();
		int i;
		
		do{
			i=rand.nextInt(4);
			switch(i){
			case 0:
				if(lab[D.getY()-1][D.getX()] == ' ' || lab[D.getY()-1][D.getX()] == 'E'){
					lab[D.getY()][D.getX()] = ' ';
					D.setY(D.getY()-1);
					podeMover=true;
				}break;
			case 1:
				if(lab[D.getY()+1][D.getX()] == ' ' || lab[D.getY()+1][D.getX()] == 'E'){
					lab[D.getY()][D.getX()] = ' ';
					D.setY(D.getY()+1);
					podeMover=true;
				}break;
			case 2:
				if(lab[D.getY()][D.getX()-1] == ' ' || lab[D.getY()][D.getX()-1] == 'E'){
					lab[D.getY()][D.getX()] = ' ';
					D.setX(D.getX()-1);
					podeMover=true;
				}break;
			case 3:
				if(lab[D.getY()][D.getX()+1] == ' ' || lab[D.getY()][D.getX()+1] == 'E'){
					lab[D.getY()][D.getX()] = ' ';
					D.setX(D.getX()+1);
					podeMover=true;
				}break;
			}
		}while(!podeMover);
		
	}

	public char[][] labirintoAleatorio(){
		
		char[][] labirinto = {{}};
		Random rand=new Random();
		int coord_X_saida, coord_Y_saida, r;
		
		//preencher a grelha com 'X'
		for(int i=0; i<getTamanhoLab(); i++)
			for(int j=0; j<getTamanhoLab(); j++)
				labirinto[i][j]='X';
		
		//colocar em branco (' ') as coordenadas impares
				for(int i=1; i<getTamanhoLab()-1; i++,i++)
					for(int j=0; j<getTamanhoLab()-1; j++,j++)
						labirinto[i][j]=' ';
		
		//colocar uma saida 'S'
		coord_X_saida=rand.nextInt(getTamanhoLab());
		if(coord_X_saida==0 || coord_X_saida==getTamanhoLab()-1)
			coord_Y_saida=rand.nextInt(getTamanhoLab()-1)+1;
		else{
			r=rand.nextInt(2);
			if(r==0)
				coord_Y_saida=0;
			else
				coord_Y_saida=getTamanhoLab()-1;
		}
		labirinto[coord_Y_saida][coord_X_saida]='S';
		
		
		
		return labirinto;
	}
	
	

	public ConstrutorLab getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(ConstrutorLab labirinto) {
		this.labirinto = labirinto;
	}
}
