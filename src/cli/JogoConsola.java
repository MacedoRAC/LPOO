package cli;

import java.util.Scanner;

import logic.Labirinto;

/**
 * Classe base para o controlo da aplicação na linha de comandos
 * 
 * @author André
 *
 */
public class JogoConsola {

	public static void main(String[] args) {
		
		String mov="";
		Scanner s= new Scanner(System.in);
		String ale, drag;
		int numeroDrag=0, tamanho=0;
		boolean modo=false, dragoes=false;
		
		//configuração do jogo
		do {
			System.out.println("Labirinto Aleatório (s->sim / n->não): ");
			ale = s.next();
			if (ale.equals("s")){
				System.out.println("Tamanho do labirinto (tem de ser ímpar): ");
				tamanho=s.nextInt();
				modo = true;
			}
			System.out.println("Dragões Adormecem (s->sim / n->não): ");
			drag = s.next();
			if (drag.equals("s"))
				dragoes = true;
		} while (!(ale.equals("s") || ale.equals("n")) && !(drag.equals("s") || drag.equals("n")));
		
		System.out.println("Número de Dragões: ");
		numeroDrag=s.nextInt();
		
		Labirinto l=new Labirinto(modo, tamanho, dragoes, numeroDrag);
		
		
		while(!mov.equals("e") && !l.isVitoria() && !l.getHeroi().isMorto()){
			System.out.println();
			System.out.println();
			imprimePuzzle(l.getLabirinto().getLab());			
			System.out.println();
			System.out.print("Proximo movimento ('e' para sair): ");
			mov=s.next();
			l.processaEvento(mov);
			if(l.isVitoria())
				imprimePuzzle(l.getLabirinto().getLab());

		};

		if(l.isVitoria())
			System.out.println("VITORIA!");
		if(l.getHeroi().isMorto())
			System.out.println("Perdeste!");
		
		s.close();
	}
	
	/**
	 * Imprime o labirinto na consola
	 * @param lab labirinto que vai ser impresso na consola
	 */
	public static void imprimePuzzle(char[][] lab) {
		for(int i=0; i<lab.length; i++){
			System.out.println();
			for(int j=0; j<lab[i].length; j++)
				System.out.print(lab[i][j] + " ");
		}
	}
	

	
}
