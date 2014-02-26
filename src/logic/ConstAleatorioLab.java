package logic;

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
}
