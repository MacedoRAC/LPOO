/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Player;

/**
 * @author André
 *
 */
public class boardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Player> players;
	private BufferedImage boardImage;
	private BufferedImage car;
	private BufferedImage dog;
	private BufferedImage hat;
	private BufferedImage thimble;
	
	public boardPanel(Vector<Player> players){
		setVisible(true);
		setFocusable(true);
		
		try {
			boardImage= ImageIO.read(new File("src/Images/board.jpg")) ;
			car= ImageIO.read(new File("src/Images/avatars/carBoard.png")) ;
			hat= ImageIO.read(new File("src/Images/avatars/hatBoard.png")) ;
			thimble= ImageIO.read(new File("src/Images/avatars/thimbleBoard.png")) ;
			dog= ImageIO.read(new File("src/Images/avatars/dogBoard.png")) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.players = players;
	}
	
	/**
	 * 
	 */
	public void updatePlayers(Vector<Player> players){
		this.players=players;
	}
	/**
	 * 
	 * @return x and y coordinates to draw tokens on board
	 */
	public int[] calcCoord(Player p){
		int x=0, y=0;
		
		if(p.getPosition() >=0 && p.getPosition()<=10){
			y = 635;
			x = 30 + 63* (10 - p.getPosition());
		}else if(p.getPosition() >=20 && p.getPosition()<=30){
			y = 30;
			x = 30 + 63* (p.getPosition()-20);
		}else if(p.getPosition() >10 && p.getPosition()<=19){
			x = 35;
			y = 28 + 61* (20 - p.getPosition());
		}else{
			x = 665;
			y = 28 + 61* (p.getPosition()-30);
		}
			
		return new int[]{x,y};
	}
	
	/**
	 * 
	 * @param p player
	 * @return image corresponding to player token
 	 */
	public BufferedImage getToken(Player p){
		
		if(p.getToken() == "car")
			return this.car;
		else if(p.getToken() == "dog")
			return this.dog;
		else if(p.getToken() == "thimble")
			return this.thimble;
		else
			return this.hat;
	}
	
	
	/**
	 * Print images
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);
		
		g.drawImage(boardImage, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
		
		g.drawImage(getToken(players.get(0)), calcCoord(players.get(0))[0], calcCoord(players.get(0))[1], 30, 29, Color.WHITE, null);
		g.drawImage(getToken(players.get(1)), calcCoord(players.get(1))[0], calcCoord(players.get(0))[1], 30, 29, Color.WHITE, null);
		
		if(players.size() > 2){
			g.drawImage(getToken(players.get(2)), calcCoord(players.get(2))[0], calcCoord(players.get(0))[1], 30, 29, Color.WHITE, null);
			
			if(players.size() > 3)
				g.drawImage(getToken(players.get(3)), calcCoord(players.get(3))[0], calcCoord(players.get(0))[1], 30, 29, Color.WHITE, null);
		}
		
	}
	
}
