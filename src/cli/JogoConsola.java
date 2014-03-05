package cli;

import java.util.Scanner;

import logic.Labirinto;

public class JogoConsola {

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

		if(l.isVitoria())
			System.out.println("VITORIA!");
		
		s.close();
	}
}
