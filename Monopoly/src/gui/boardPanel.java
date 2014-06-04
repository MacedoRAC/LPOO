/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author André
 *
 */
public class boardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage boardImage;
	
	public boardPanel(){
		try {
			boardImage= ImageIO.read(new File("src/Images/board.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		setVisible(true);
		setFocusable(true);
	}
	
	
	/**
	 * Print images
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);
		
		g.drawImage(boardImage, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
	}
	
}
