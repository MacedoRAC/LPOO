package logic;

import java.util.Random;

public class ConstAleatorioLab extends ConstrutorLab{

	public ConstAleatorioLab() {
		lab=labirintoAleatorio();
	}
	

	/**
	 * verifica se ainda existem blocos 3x3 de parede
	 * @return true or false
	 */
	public boolean existeBlocos3x3(char [][] lab){
		char[][] bloco=new char[3][3];
		boolean existeBloco=false;
		int linha=1, coluna=1;
		do{
			//copia blocos de 3x3 sucessivos do labirinto para ser analisado
			for(int i=linha; i<=3; i++)
				for(int j=coluna; j<=3; j++)
					bloco[i][j]=lab[i][j];
			//analisa se bloco 3x3 é todo parede
			if(bloco[0][0] == 'X' && bloco[0][1] == 'X' && bloco[0][2] == 'X' &&
			   bloco[1][0] == 'X' && bloco[1][1] == 'X' && bloco[1][2] == 'X' &&
			   bloco[2][0] == 'X' && bloco[2][1] == 'X' && bloco[2][2] == 'X')
				existeBloco=true;
			else{
				if(linha!=tamanhoLab-4)
					linha++;
				else if(coluna!=tamanhoLab-4)
					coluna++;
			}
		}while((linha != tamanhoLab-4 && coluna!=tamanhoLab-4) || !existeBloco);
	
		return existeBloco;
	}
	
	/**
	 * Analisa-se se abrir a proxima celula se ficam blocos 2x2 abertos
	 * @param x coordenada X da proxima celula
	 * @param y coordenada Y da proxima celula
	 * @return true or false
	 */
	public boolean verificaBlocos2x2(char[][] lab, int x, int y){
		lab[y][x]=' ';
		
		if((lab[y-1][x-1]==' ' && lab[y-1][x]==' ' &&	lab[y][x-1]==' ') || //bloco superior esquerdo
		   (lab[y-1][x]==' ' && lab[y-1][x+1]==' ' &&	lab[y][x+1]==' ') || //bloco superior direito
		   (lab[y][x-1]==' ' && lab[y+1][x-1]==' ' &&	lab[y+1][x]==' ') || //bloco inferior esquerdo
		   (lab[y][x+1]==' ' && lab[y+1][x+1]==' ' &&	lab[y+1][x]==' ')){  //bloco inferior direito
			
			lab[y][x]='X';
			return true;
		}
		else
			return false;
	}
	
public char[][] labirintoAleatorio(){
		
		char[][] labirinto = new char[tamanhoLab][tamanhoLab];
		Random rand=new Random();
		int coord_X, coord_Y, r;
		Random randMov=new Random();
		
		//preencher a grelha com 'X'
		for(int i=0; i<tamanhoLab; i++)
			for(int j=0; j<tamanhoLab; j++)
				labirinto[i][j]='X';
		
		//colocar uma saida 'S'
		coord_X=rand.nextInt(tamanhoLab);
		if(coord_X==0 || coord_X==tamanhoLab-1)
			coord_Y=rand.nextInt(tamanhoLab-1)+1;
		else{
			r=rand.nextInt(2);
			if(r==0)
				coord_Y=0;
			else
				coord_Y=tamanhoLab-1;
		}
		labirinto[coord_Y][coord_X]=getSaida().getRepresentacao();
		
		//coloca a celula adjacente à saida a branco
		if(coord_X==0)
			coord_X++;
		else if(coord_X==tamanhoLab-1)
			coord_X--;
		else if(coord_Y==0)
			coord_Y++;
		else
			coord_Y--;
		
		labirinto[coord_Y][coord_X]=' ';
		
		//cria caminho sucessivamente atraves de movimentos aleatorios
		int mov;
		do{
			mov=randMov.nextInt(4);
			
			switch(mov){
			case 0: //anda para a frente
				if(coord_Y--== 0 || verificaBlocos2x2(labirinto, coord_X,coord_Y--))
					break;
				else{
					coord_Y--;
					labirinto[coord_Y][coord_X]= ' ';
				}
			case 1: //anda para a esquerda
				if(coord_X--== 0 || verificaBlocos2x2(labirinto, coord_X--,coord_Y))
					break;
				else{
					coord_X--;
					labirinto[coord_Y][coord_X]= ' ';
				}
			case 2: //anda para a direita
				if(coord_X++== tamanhoLab-1 || verificaBlocos2x2(labirinto, coord_X++,coord_Y))
					break;
				else{
					coord_X++;
					labirinto[coord_Y][coord_X]= ' ';
				}
			case 3: //anda para trás
				if(coord_Y++== tamanhoLab-1 || verificaBlocos2x2(labirinto, coord_X,coord_Y++))
					break;
				else{
					coord_Y++;
					labirinto[coord_Y][coord_X]= ' ';
				}
			}
		
		}while(!existeBlocos3x3(labirinto));
		
		return labirinto;
	}

private Random nextInt(int i) {
	// TODO Auto-generated method stub
	return null;
}
}
