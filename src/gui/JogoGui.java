package gui;

import java.awt.EventQueue;
/**
 * Classe base no controlo da aplica��o no modo gr�fico
 * 
 * @author Andr�
 *
 */
public class JogoGUI {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
						JogoFrame window = new JogoFrame();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
	}
}
