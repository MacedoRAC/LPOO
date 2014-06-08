/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Player;

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
	public JButton previous;
	public JButton select;
	public JButton next;
	/**
	 * index to go through all properties of the player
	 */
	private int index;
	private Player playing;

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
		
		previous = new JButton("Previous");
		previous.setBackground(new Color(153,0,0));
		previous.setForeground(new Color(255, 255, 255));
		
		select = new JButton("Select");
		select.setBackground(new Color(153,0,0));
		select.setForeground(new Color(255, 255, 255));
		
		next = new JButton("Next");
		next.setBackground(new Color(153,0,0));
		next.setForeground(new Color(255, 255, 255));
		
		previous.setVisible(false);
		select.setVisible(false);
		next.setVisible(false);
		
		add(previous);
		add(select);
		add(next);
		
		mode = "";
		index = 0;
	}
	
	public void setPlayerPlaying(Player p){
		this.playing = p;
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
			g.drawImage(cardToShow, 125, 60, 333, 234, Color.WHITE, null);
			break;
		case "mortgage":
			mortgage(g);
			break;
		}
	}

	private void mortgage(Graphics g) {		
		previous.setVisible(true);
		select.setVisible(true);
		next.setVisible(true);
		JLabel mortgaged;
		
		setCardToShow(playing.getOwnproperties().get(index).getPosition(), (playing.getOwnproperties()).get(index).getClassName());
		
		g.drawImage(cardToShow, 135, 35, 200, 300, Color.WHITE, null);
		
		if(playing.getOwnproperties().get(index).getMortgage()){
			mortgaged = new JLabel("MORTGAGED");
			mortgaged.setBackground(new Color(153,0,0));
			mortgaged.setForeground(new Color(255,255,255));
			add(mortgaged);
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
	
	/**
	 * setup all Buttons
	 */
	public void setButtons(){
		
		//PREVIOUS BUTTON
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index == 0)
					index = playing.getOwnproperties().size() - 1;
				else 
					index--;
				
				repaint();
			}
		});
		
		//NEXT BUTTON
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index == (playing.getOwnproperties().size() - 1))
					index = 0;
				else
					index++;
				
				repaint();
			}
		});
		
		//SELECT BUTTON
		select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!playing.getOwnproperties().get(index).getMortgage())
					playing.getOwnproperties().get(index).Mortgage(playing);
			}
		});
	}


}
