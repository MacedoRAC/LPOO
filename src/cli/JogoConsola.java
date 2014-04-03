package cli;

import java.util.Scanner;

import logic.Labirinto;

public class JogoConsola {

	public static void main(String[] args) {
		Labirinto l=new Labirinto();
		String mov="";
		
		Scanner s= new Scanner(System.in);
		do{
			System.out.println();
			System.out.println();
			imprimePuzzle(l.getLabirinto().getLab());			
			System.out.println();
			System.out.print("Proximo movimento ('e' para sair): ");
			mov=s.next();
			l.processaEvento(mov);
			
		}while(!mov.equals("e") || !l.isVitoria() || !l.getHeroi().isMorto());

		if(l.isVitoria())
			System.out.println("VITORIA!");
		if(l.getHeroi().isMorto())
			System.out.println("Perdeste!");
		
		s.close();
	}
	
	public static void imprimePuzzle(char[][] lab) {
		for(int i=0; i<lab.length; i++){
			System.out.println();
			for(int j=0; j<lab[i].length; j++)
				System.out.print(lab[i][j] + " ");
		}
	}
	

	
}
