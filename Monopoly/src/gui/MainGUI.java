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
						BoardWindow window = new BoardWindow();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});

	}

}
