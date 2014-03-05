package logic;

import java.util.Random;

public class ConstAleatorioLab extends ConstrutorLab{

	public ConstAleatorioLab() {
		criaLab();
	}
	
	public void criaLab(){
		
	}

	public void crialab(int tamanho){
		
	}

	/**
	 * verifica se ainda existem blocos 3x3 de parede
	 * @return true or false
	 */
	public boolean verificaBlocos3x3(){
		char[][] bloco=new char[3][3];
		boolean existeBloco=false;
		int linha=1, coluna=1;
		do{
			//copia blocos de 3x3 sucessivos do labirinto para ser analisado
			for(int i=linha; i<4; i++)
				for(int j=coluna; j<4; j++)
					bloco[i][j]=lab[i][j];
			//analisa se bloco 3x3 é todo parede
			if(bloco[0][0] == 'X' && bloco[0][1] == 'X' && bloco[0][2] == 'X' &&
			   bloco[1][0] == 'X' && bloco[1][1] == 'X' && bloco[1][2] == 'X' &&
			   bloco[2][0] == 'X' && bloco[2][1] == 'X' && bloco[2][2] == 'X')
				existeBloco=true;
			else{
				if(linha!=getTamanhoLab()-4)
					linha++;
				else if(coluna!=getTamanhoLab()-4)
					coluna++;
			}
		}while((linha != getTamanhoLab()-4 && coluna!=getTamanhoLab()-4) || !existeBloco);
	
		return existeBloco;
	}
	
	/**
	 * Analisa-se se abrir a proxima celula se ficam blocos 2x2 abertos
	 * @param x coordenada X da proxima celula
	 * @param y coordenada Y da proxima celula
	 * @return true or false
	 */
	public boolean verificaBlocos2x2(int x, int y){
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
}
