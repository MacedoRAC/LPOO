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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logic.MonopolyLogic;
import logic.Player;

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
	private JButton btnTrade;
	private JButton btnBuildings;
	private JButton btnExit;
	private JButton btnSave;
	private JButton btnDone;
	private MonopolyLogic monopoly;
	private ActionPanel actionPanel;


	public PlayingPanel(Player[] players, String mode){
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

		btnTrade = new JButton("Trade");
		btnTrade.setBounds(428, 596, 114, 23);
		btnTrade.setForeground(new Color(255, 255, 255));
		btnTrade.setBackground(new Color(153, 0, 0));

		btnMortgage = new JButton("Mortgage");
		btnMortgage.setBounds(149, 596, 114, 23);
		btnMortgage.setForeground(new Color(255, 255, 255));
		btnMortgage.setBackground(new Color(153, 0, 0));

		btnBuy = new JButton("Buy");
		btnBuy.setBounds(299, 596, 93, 23);
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.setBackground(new Color(153, 0, 0));

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
		add(btnTrade);
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
				
				getParent().repaint();
				playersPanel.repaint();
				requestFocus();
			}
		});
		
		//TRADE BUTTON
		btnTrade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cardLocation=0;
				int myCardLocation=0;
				
				monopoly.tradePropertie("namePlayer", cardLocation, myCardLocation);
				
				getParent().repaint();
				playersPanel.repaint();
				requestFocus();
			}
		});
		
		//MORTGAGE BUTTON
		btnMortgage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monopoly.mortgagePropertie("name of the player");
				
				getParent().repaint();
				playersPanel.repaint();
				requestFocus();
			}
		});
		
		//BUY BUTTON
		btnBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				monopoly.buyPropertie();
				
				getParent().repaint();
				playersPanel.repaint();
				requestFocus();
			}
		});

		//ROLL DICE BUTTON
		btnRollDice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] dice = monopoly.rollDice();
				actionPanel.setDice(dice);
				actionPanel.setMode("dice");
				actionPanel.repaint();
				getParent().repaint();
				btnRollDice.setEnabled(false);
				
			}
		});

		//DONE BUTTON
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monopoly.endOfTurn();
				btnRollDice.setEnabled(true);
				btnBuy.setEnabled(true);
				
				getParent().repaint();

			}
		});

		//EXIT BUTTON
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int option=JOptionPane.showConfirmDialog(getRootPane(), "Do you have sure you want to leave?");
				if(option==JOptionPane.YES_OPTION){					
					getRootPane().setVisible(false);
				}
			}
		});
		
		//SAVE BUTTON
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveGame();
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
