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
public class ActionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dice_1;
	private int dice_2;
	private BufferedImage dice1;
	private BufferedImage dice2;
	private BufferedImage dice3;
	private BufferedImage dice4;
	private BufferedImage dice5;
	private BufferedImage dice6;
	private String mode;
	private BufferedImage cardToShow;

	public ActionPanel(){
		setVisible(true);
		setFocusable(true);
		setSize(575, 371);
		setBackground(new Color(153, 0, 0));

		try {
			dice1= ImageIO.read(new File("src/Images/dice/dice1.png")) ;
			dice2= ImageIO.read(new File("src/Images/dice/dice2.png")) ;
			dice3= ImageIO.read(new File("src/Images/dice/dice3.png")) ;
			dice4= ImageIO.read(new File("src/Images/dice/dice4.png")) ;
			dice5= ImageIO.read(new File("src/Images/dice/dice5.png")) ;
			dice6= ImageIO.read(new File("src/Images/dice/dice6.png")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mode = "";
	}

	public void setDice(int[] dice) {
		dice_1 = dice[0];
		dice_2 = dice[1];
	}

	/**
	 * Set mode of draw
	 * @param i 
	 */
	public void setMode(String mode){
		this.mode = mode;
	}
	
	/**
	 * 
	 * @param cardToShow location of the card on the board
	 * @param typeOfCard type of cart to show (property, airport, companies, chance or community)
	 */
	public void setCardToShow(int cardToShow, String typeOfCard) {


		try {
			switch(typeOfCard){
			case "Chance":
				this.cardToShow= ImageIO.read(new File("src/Images/ChanceCards/" + cardToShow + ".jpg")) ;
				break;
			case "Community":
				this.cardToShow= ImageIO.read(new File("src/Images/CommunityCards/" + cardToShow + ".jpg")) ;
				break;
			case "Airport":
				this.cardToShow= ImageIO.read(new File("src/Images/PropertyCards/" + cardToShow + ".jpg")) ;
				break;
			case "Companies":
				this.cardToShow= ImageIO.read(new File("src/Images/PropertyCards/" + cardToShow + ".jpg")) ;
				break;
			case "Property":
				this.cardToShow= ImageIO.read(new File("src/Images/PropertyCards/" + cardToShow + ".jpg")) ;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Print dices 
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);

		switch(mode){
		case "dice":
			dicePaint(g);
			break;
		case "showCard":
			g.drawImage(cardToShow, 135, 35, 200, 300, Color.WHITE, null);
			break;
		}
	}

	private void dicePaint(Graphics g) {
		int height=100;
		int width=100;

		//draw first dice
		switch(dice_1){
		case 1:
			g.drawImage(dice1, 125, 135, width, height, Color.WHITE, null);
			break;
		case 2:
			g.drawImage(dice2, 125, 135, width, height, Color.WHITE, null);
			break;
		case 3:
			g.drawImage(dice3, 125, 135, width, height, Color.WHITE, null);
			break;
		case 4:
			g.drawImage(dice4, 125, 135, width, height, Color.WHITE, null);
			break;
		case 5:
			g.drawImage(dice5, 125, 135, width, height, Color.WHITE, null);
			break;
		case 6:
			g.drawImage(dice6, 125, 135, width, height, Color.WHITE, null);
			break;
		}

		//draw second dice
		switch(dice_2){
		case 1:
			g.drawImage(dice1, 250, 135, width, height, Color.WHITE, null);
			break;
		case 2:
			g.drawImage(dice2, 250, 135, width, height, Color.WHITE, null);
			break;
		case 3:
			g.drawImage(dice3, 250, 135, width, height, Color.WHITE, null);
			break;
		case 4:
			g.drawImage(dice4, 250, 135, width, height, Color.WHITE, null);
			break;
		case 5:
			g.drawImage(dice5, 250, 135, width, height, Color.WHITE, null);
			break;
		case 6:
			g.drawImage(dice6, 250, 135, width, height, Color.WHITE, null);
			break;
		}

	}


}
