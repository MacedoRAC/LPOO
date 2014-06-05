/**
 * 
 */
package gui;

import java.awt.EventQueue;

/**
 * @author André
 *
 */
public class MainGUI {

	/**
	 * launch the game
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
						InitialFrame game = new InitialFrame();
						game.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});

	}

}
