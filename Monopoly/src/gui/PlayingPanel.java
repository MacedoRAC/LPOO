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
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import logic.MonopolyLogic;
import logic.Player;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
	
	
	public PlayingPanel(){
		setForeground(new Color(153, 0, 0));
		
		try {
			background= ImageIO.read(new File("src/Images/fundo.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player[] players= {new Player("John"), new Player("Louis")};
		monopoly=new MonopolyLogic(players , "local");
		
		setSize(500,661);
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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnRollDice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSpecialCard))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSell, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(btnDone, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTrade, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
					.addGap(32))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(lblDiceNumber, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(406, Short.MAX_VALUE)
					.addComponent(lblDiceNumber, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
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
					.addGap(28))
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Setup all buttons
	 */
	public void setupButtons(){
		
		//ROLL DICE BUTTON
		btnRollDice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int dice = monopoly.rollDice();
				lblDiceNumber.setText(""+dice);
				lblDiceNumber.setVisible(true);
				btnRollDice.setEnabled(false);
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
			}
		});
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
