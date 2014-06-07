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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import logic.MonopolyLogic;
import logic.Player;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
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
	private JButton btnSell;
	private JButton btnBuy;
	private JButton btnTrade;
	private JButton btnSpecialCard;
	private JButton btnExit;
	private JButton btnSave;
	private JButton btnDone;
	private JLabel lblDiceNumber;
	private MonopolyLogic monopoly;


	public PlayingPanel(Player[] players, String mode){
		setForeground(new Color(153, 0, 0));

		try {
			background= ImageIO.read(new File("src/Images/fundo.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		monopoly=new MonopolyLogic(players , mode);

		setSize(575,671);
		setVisible(true);
		setFocusable(true);

		btnRollDice = new JButton("Roll Dice");
		btnRollDice.setForeground(new Color(255, 255, 255));
		btnRollDice.setBackground(new Color(153, 0, 0));

		btnTrade = new JButton("Trade");
		btnTrade.setForeground(new Color(255, 255, 255));
		btnTrade.setBackground(new Color(153, 0, 0));

		btnSell = new JButton("Sell");
		btnSell.setForeground(new Color(255, 255, 255));
		btnSell.setBackground(new Color(153, 0, 0));

		btnBuy = new JButton("Buy");
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.setBackground(new Color(153, 0, 0));

		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(153, 0, 0));

		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(153, 0, 0));

		btnSpecialCard = new JButton("Special Card");
		btnSpecialCard.setForeground(new Color(255, 255, 255));
		btnSpecialCard.setBackground(new Color(153, 0, 0));

		lblDiceNumber = new JLabel("");
		lblDiceNumber.setBackground(new Color(153, 0, 0));
		lblDiceNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceNumber.setForeground(new Color(255, 255, 255));
		lblDiceNumber.setFont(new Font("Tahoma", Font.PLAIN, 96));
		lblDiceNumber.setVisible(false);

		btnDone = new JButton("Done");
		btnDone.setBackground(new Color(153, 0, 0));
		btnDone.setForeground(new Color(255, 255, 255));

		setupButtons();		

		playersPanel = new PlayersPanel(monopoly.getPlayers());

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(lblDiceNumber, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnRollDice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSpecialCard))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSell, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(btnDone, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTrade, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addGap(39))
				.addComponent(playersPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(playersPanel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
					.addComponent(lblDiceNumber, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRollDice)
							.addGap(18)
							.addComponent(btnSpecialCard))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnTrade)
							.addGap(18)
							.addComponent(btnExit))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSell)
							.addGap(18)
							.addComponent(btnDone))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuy)
							.addGap(18)
							.addComponent(btnSave)))
					.addGap(27))
		);
		setLayout(groupLayout);
	}

	/**
	 * Setup all buttons
	 */
	public void setupButtons(){
		
		//SPECIAL CARD BUTTON
		btnSpecialCard.addActionListener(new ActionListener() {
			
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
		
		//SELL BUTTON
		btnSell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monopoly.sellPropertie("name of the player");
				
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
				int dice = monopoly.rollDice();
				lblDiceNumber.setText(""+dice);
				lblDiceNumber.setVisible(true);
				btnRollDice.setEnabled(false);
				
				getParent().repaint();
			}
		});

		//DONE BUTTON
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monopoly.endOfTurn();
				btnRollDice.setEnabled(true);
				lblDiceNumber.setVisible(false);
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
