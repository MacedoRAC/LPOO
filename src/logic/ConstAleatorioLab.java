package logic;

import java.util.Random;
import java.util.Stack;

public class ConstAleatorioLab extends ConstrutorLab{

	public ConstAleatorioLab() {
		lab=labirintoAleatorio();
	}
	

	private char[][] labirintoAleatorio() {
		char[][]labirinto= new char[tamanhoLab][tamanhoLab];
		int coord_X=0, coord_Y=0, r;
		Random rand = new Random();
		elementosJogo guia= new elementosJogo('+');
		
		//por labirinto todo a 'X'
		for(int i=0; i<tamanhoLab; i++)
			for(int j=0; j<tamanhoLab; j++)
				labirinto[i][j]='X';
		
		//abrir espaços impares do labirinto
		for(int i=1; i<tamanhoLab; i+=2)
			for(int j=1; j<tamanhoLab; j+=2)
				labirinto[i][j]=' ';
		
		//colocar uma celula guia '+'
		while(labirinto[coord_Y][coord_X]!= ' '){
			r = rand.nextInt(4);
			if(r==0){//celula guia no topo do labirinto
				coord_Y=1;
				coord_X = rand.nextInt(tamanhoLab-2)+1;
			}else if(r==1){//celula guia no lado direito
				coord_X=tamanhoLab-2;
				coord_Y= rand.nextInt(tamanhoLab-2)+1;
			}else if(r==2){//celula guia em baixo
				coord_Y=tamanhoLab-2;
				coord_X= rand.nextInt(tamanhoLab-2)+1;
			}else{//celula guia no lado esquerdo
				coord_X=1;
				coord_Y= rand.nextInt(tamanhoLab-2)+1;
			}
		}
		
		labirinto[coord_Y][coord_X]=guia.getRepresentacao();
		guia.setX(coord_X);
		guia.setY(coord_Y);	

		//coloca a celula saida adjacente à celula guia
		if(coord_X==1)
			coord_X--;
		else if(coord_X==tamanhoLab-2)
			coord_X++;
		else if(coord_Y==1)
			coord_Y--;
		else
			coord_Y++;

		labirinto[coord_Y][coord_X]=getSaida().getRepresentacao();
		
		//criar caminho
		char[][] celVisitadas= new char[(tamanhoLab-1)/2][(tamanhoLab-1)/2];
		Stack<elementosJogo> historico=new Stack<elementosJogo>();
		boolean completo=true;
		
		for(int i=0; i<celVisitadas.length; i++)
			for(int j=0; j<celVisitadas.length; j++)
				celVisitadas[i][j]='X';
		
		guia.setX((guia.getX()-1)/2);
		guia.setY((guia.getY()-1)/2);
		celVisitadas[guia.getY()][guia.getX()]=guia.getRepresentacao();
		historico.push(guia);
		
		do{
			completo=true;
			if(!adjacentesNaoVisitadas(celVisitadas, guia.getX(), guia.getY()))
				guia=analisaHistorico(historico, celVisitadas);
			
			r=rand.nextInt(4);//generate random move
			switch(r){
			case 0://esquerda
				if((guia.getX()-1)>=0 && celVisitadas[guia.getY()][guia.getX()-1]!='+'){
					guia.setX(guia.getX()-1);
					celVisitadas[guia.getY()][guia.getX()]=guia.getRepresentacao();
					labirinto[guia.getY()*2+1][guia.getX()*2+1]=' ';
					historico.push(guia);
				}
				break;
			case 1://direita
				if((guia.getX()+1)<celVisitadas.length && celVisitadas[guia.getY()][guia.getX()+1]!='+'){
					guia.setX(guia.getX()+1);
					celVisitadas[guia.getY()][guia.getX()]=guia.getRepresentacao();
					labirinto[guia.getY()*2+1][guia.getX()*2+1]=' ';
					historico.push(guia);
				}
				break;
			case 2://cima
				if((guia.getY()-1)>=0 && celVisitadas[guia.getY()-1][guia.getX()]!='+'){
					guia.setX(guia.getY()-1);
					celVisitadas[guia.getY()][guia.getX()]=guia.getRepresentacao();
					labirinto[guia.getY()*2+1][guia.getX()*2+1]=' ';
					historico.push(guia);
				}
				break;
			case 3://baixo
				if((guia.getY()+1)<celVisitadas.length && celVisitadas[guia.getY()+1][guia.getX()]!='+'){
					guia.setX(guia.getY()+1);
					celVisitadas[guia.getY()][guia.getX()]=guia.getRepresentacao();
					labirinto[guia.getY()*2+1][guia.getX()*2+1]=' ';
					historico.push(guia);
				}
				break;
			}
			
			for(int i=0; i<celVisitadas.length; i++)
				for(int j=0; j<celVisitadas[i].length; j++)
					if(celVisitadas[i][j]!='+')
						completo=false;
			
		}while(!completo);
		
		return labirinto;
	}


	private elementosJogo analisaHistorico(Stack<elementosJogo> historico, char[][] celVisitadas) {
		elementosJogo e=new elementosJogo('+');
		
		do{
		e=historico.pop();
		}while(!adjacentesNaoVisitadas(celVisitadas,e.getX(),e.getY()) && !historico.empty());
		
		return e;
	}


	private boolean adjacentesNaoVisitadas(char[][] celVisitadas, int x, int y) {

		if(y==(celVisitadas.length-1)) {
			if(celVisitadas[y-1][x]== 'X')
				return true;
		}else if(y==0){
			if(celVisitadas[y+1][x]== 'X')
				return true;
		}else if(x==(celVisitadas.length-1)) {
			if(celVisitadas[y][x-1]== 'X')
				return true;
		}else if(x==0) {
			if(celVisitadas[y][x+1]== 'X')
				return true;
		}else if(celVisitadas[y-1][x]== 'X' || celVisitadas[y+1][x]== 'X' ||
				 celVisitadas[y][x-1]== 'X' || celVisitadas[y][x+1]== 'X')
			return true;

		return false;
	}


}
