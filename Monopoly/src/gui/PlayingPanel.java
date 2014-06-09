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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Airport;
import logic.Chance;
import logic.Community;
import logic.Companies;
import logic.MonopolyLogic;
import logic.Player;
import logic.Property;
import logic.Space;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author André
 *
 */
public class PlayingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage background;
	private PlayersPanel playersPanel;
	private JButton btnRollDice;
	private JButton btnMortgage;
	private JButton btnBuy;
	private JButton btnView;
	private JButton btnBuildings;
	private JButton btnExit;
	private JButton btnSave;
	private JButton btnDone;
	private MonopolyLogic monopoly;
	private ActionPanel actionPanel;


	public PlayingPanel(Vector<Player> players, String mode){
		setForeground(new Color(153, 0, 0));

		try {
			background= ImageIO.read(new File("src/Images/fundo.png")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		monopoly=new MonopolyLogic(players , mode);

		setSize(575,671);
		setVisible(true);
		setFocusable(true);

		btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(29, 596, 93, 23);
		btnRollDice.setForeground(new Color(255, 255, 255));
		btnRollDice.setBackground(new Color(153, 0, 0));

		btnView = new JButton("View");
		btnView.setBounds(428, 596, 114, 23);
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBackground(new Color(153, 0, 0));

		btnMortgage = new JButton("Mortgage");
		btnMortgage.setBounds(149, 596, 114, 23);
		btnMortgage.setForeground(new Color(255, 255, 255));
		btnMortgage.setBackground(new Color(153, 0, 0));

		btnBuy = new JButton("Buy");
		btnBuy.setBounds(299, 596, 93, 23);
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.setBackground(new Color(153, 0, 0));
		btnBuy.setEnabled(false);

		btnSave = new JButton("Save");
		btnSave.setBounds(299, 637, 93, 23);
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(153, 0, 0));

		btnExit = new JButton("Exit");
		btnExit.setBounds(428, 637, 114, 23);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(153, 0, 0));

		btnBuildings = new JButton("Buildings");
		btnBuildings.setBounds(29, 637, 93, 23);
		btnBuildings.setForeground(new Color(255, 255, 255));
		btnBuildings.setBackground(new Color(153, 0, 0));

		btnDone = new JButton("Done");
		btnDone.setBounds(149, 637, 114, 23);
		btnDone.setBackground(new Color(153, 0, 0));
		btnDone.setForeground(new Color(255, 255, 255));

		setupButtons();		

		playersPanel = new PlayersPanel(monopoly.getPlayers());
		playersPanel.setBounds(0, 0, 575, 208);
		
		actionPanel = new ActionPanel();
		actionPanel.setBounds(0, 214, 575, 371);
		actionPanel.setBackground(new Color(153, 0, 0));
		
		setLayout(null);
		add(playersPanel);
		add(btnRollDice);
		add(btnBuildings);
		add(btnMortgage);
		add(btnDone);
		add(btnSave);
		add(btnBuy);
		add(btnView);
		add(btnExit);
		add(actionPanel);
		
	
	}

	/**
	 * Setup all buttons
	 */
	public void setupButtons(){
		
		//BUILDINGS BUTTON
		btnBuildings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPanel.setPlayerPlaying(monopoly.getPlayers().get(monopoly.i));
				actionPanel.setMode("buildings");
				actionPanel.setIndex();
				
				actionPanel.repaint();
				playersPanel.repaint();
				getParent().repaint();
				
				actionPanel.previous.setVisible(false);
				actionPanel.next.setVisible(false);
				actionPanel.select.setVisible(false);
			}
		});
		
		//VIEW BUTTON
		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//after move the token according to the dice result,
				//show on actionPanel the card relative to new player's position on the board
				actionPanel.setMode("showCard");
				int location =  (monopoly.getPlayers().get(monopoly.i)).getPosition();
				String typeOfCart = monopoly.getBoard().get(location).getClassName();
				
				if(typeOfCart == "Chance")
					location= ((Chance) monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition())).getLastCard();
				else if(typeOfCart == "Community")
					location= ((Community) monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition())).getLastCard();
				
				actionPanel.setCardToShow(location , typeOfCart);
				actionPanel.repaint();
				playersPanel.repaint();
				getParent().repaint();
				
				actionPanel.previous.setVisible(false);
				actionPanel.next.setVisible(false);
				actionPanel.select.setVisible(false);
				
				actionPanel.addBuilding.setVisible(false);
				actionPanel.removeBuilding.setVisible(false);
			}
		});
		
		//MORTGAGE BUTTON
		btnMortgage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//monopoly.Mortgage();
				actionPanel.setMode("mortgage");
				actionPanel.setPlayerPlaying(monopoly.getPlayers().get(monopoly.i));
				actionPanel.setIndex();
				
				actionPanel.repaint();
				playersPanel.repaint();
				getParent().repaint();
				
			}
		});
		
		//BUY BUTTON
		btnBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				monopoly.Buy();
				
				btnBuy.setEnabled(false);
				
				actionPanel.repaint();
				playersPanel.repaint();
				getParent().repaint();
				
				actionPanel.previous.setVisible(false);
				actionPanel.next.setVisible(false);
				actionPanel.select.setVisible(false);
				
				actionPanel.addBuilding.setVisible(false);
				actionPanel.removeBuilding.setVisible(false);
			}
		});

		//ROLL DICE BUTTON
		btnRollDice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean canPlay=true;
				
				if(monopoly.getPlayers().get(monopoly.i).getArested_time() != 0){
					canPlay=false;
					actionPanel.setPlayerPlaying(monopoly.getPlayers().get(monopoly.i));
					actionPanel.setMode("arrested");
					canPlay=actionPanel.hasPaid();
				}
				
				actionPanel.tryDouble.setVisible(false);
				actionPanel.pay.setVisible(false);
				actionPanel.arrestMessage.setVisible(false);
				
				if(canPlay){
				int[] dice = monopoly.RollDice();
				
				
				//show dice result on actionPanel
				actionPanel.setDice(dice);
				actionPanel.setMode("dice");
				actionPanel.repaint();
				
				
				getParent().repaint();
				
				//if the dice result is a double the player can roll dice again
				if(dice[0] != dice[1])
					btnRollDice.setEnabled(false);
				
				//disable buy button if a space is not available to buy
				String s = monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition()).getClassName();
				
				if(s == "Property"  && !((Property) monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition())).isOwned())
					btnBuy.setEnabled(true);
				else if(s == "Companies"  && !((Companies) monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition())).getOwned())
					btnBuy.setEnabled(true);
				else if(s == "Airport"  && !( (Airport) monopoly.getBoard().get(monopoly.getPlayers().get(monopoly.i).getPosition())).getOwned())
					btnBuy.setEnabled(true);
				
				}else
					btnRollDice.setEnabled(false);
			}
		});

		//DONE BUTTON
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monopoly.EndTurn();
				btnRollDice.setEnabled(true);
				btnBuy.setEnabled(true);
				actionPanel.setMode("");
				
				actionPanel.repaint();
				getParent().repaint();
				
				actionPanel.previous.setVisible(false);
				actionPanel.next.setVisible(false);
				actionPanel.select.setVisible(false);
				
				actionPanel.addBuilding.setVisible(false);
				actionPanel.removeBuilding.setVisible(false);
				
				actionPanel.tryDouble.setVisible(false);
				actionPanel.pay.setVisible(false);
				actionPanel.arrestMessage.setVisible(false);

			}
		});

		//EXIT BUTTON
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int option=JOptionPane.showConfirmDialog(getRootPane(), "Do you have sure you want to leave?");
				if(option==JOptionPane.YES_OPTION){					
					System.exit(0);
				}
			}
		});
		
		//SAVE BUTTON
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveGame();
				
				actionPanel.previous.setVisible(false);
				actionPanel.next.setVisible(false);
				actionPanel.select.setVisible(false);
				
				actionPanel.addBuilding.setVisible(false);
				actionPanel.removeBuilding.setVisible(false);
			}
		});
		
	}
	
	/**
	 * Function responsible to save the game
	 */
	private void saveGame() {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		j.setAcceptAllFileFilterUsed(false);
		j.setFileFilter(new FileNameExtensionFilter("dat", "dat"));

		int i=j.showSaveDialog(new JFrame("Guardar"));

		if(i==JFileChooser.APPROVE_OPTION){
			try{
				File file= j.getSelectedFile();
				String nameOfFile= file.getName();

				if(!nameOfFile.endsWith(".dat"))
					file= new File(file + ".dat");

				FileOutputStream saveFile = new FileOutputStream(file);
				ObjectOutputStream output = new ObjectOutputStream(saveFile);

				output.writeObject(monopoly);
				output.close();
			}catch(IOException ex){
				JOptionPane.showMessageDialog(new JFrame().getRootPane(), "An error has occured. Game not saved!");
				ex.printStackTrace();
			}
		}

		requestFocus();
	}

	/**
	 * Print images
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);
		int height=this.getHeight();
		int width=this.getWidth();

		g.drawImage(background, 0, 0, width, height, Color.WHITE, null);
		
	}
}
