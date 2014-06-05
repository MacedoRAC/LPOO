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
import javax.swing.JPanel;

import logic.Player;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * @author André
 *
 */
public class GameConfigPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mode;
	private Player[] players;
	private BufferedImage background;
	private JTextField P1Nick;
	private JTextField P2Nick;
	private JTextField P3Nick;
	private JTextField P4Nick;
	private JLabel lblP1Nick;
	private JComboBox<String> avatarP1;
	private JLabel lblP2Nick;
	private JComboBox<String> avatarP2;
	private JLabel lblP3Nick;
	private JComboBox<String> avatarP3;
	private JLabel lblP4Nick;
	private JComboBox<String> avatarP4;
	private JButton btnBack;
	private JButton btnPlay;

	public GameConfigPanel(String mode, int np) {
		setBackground(new Color(0, 0, 0));
		this.mode = mode;
		this.players = new Player[np];
		
		setSize(416,416);
		setEnabled(true);
		requestFocus(true);
		
		lblP1Nick = new JLabel("Player 1 nickname");
		lblP1Nick.setForeground(new Color(255, 255, 255));
		
		P1Nick = new JTextField();
		P1Nick.setBackground(new Color(153, 0, 0));
		P1Nick.setForeground(new Color(255, 255, 255));
		lblP1Nick.setLabelFor(P1Nick);
		P1Nick.setColumns(10);
		
		avatarP1 = new JComboBox<String>();
		avatarP1.setModel(new DefaultComboBoxModel<String>(new String[] {"Dog", "Thimble", "Car", "Hat"}));
		avatarP1.setBackground(new Color(153, 0, 0));
		avatarP1.setForeground(new Color(255, 255, 255));
		avatarP1.setMaximumRowCount(4);
		
		lblP2Nick = new JLabel("Player 2 nickname");
		lblP2Nick.setForeground(Color.WHITE);
		
		P2Nick = new JTextField();
		P2Nick.setBackground(new Color(153, 0, 0));
		lblP2Nick.setLabelFor(P2Nick);
		P2Nick.setForeground(Color.WHITE);
		P2Nick.setColumns(10);
		
		avatarP2 = new JComboBox<String>();
		avatarP2.setModel(new DefaultComboBoxModel<String>(new String[] {"Thimble", "Car", "Hat", "Dog"}));
		avatarP2.setMaximumRowCount(4);
		avatarP2.setForeground(Color.WHITE);
		avatarP2.setBackground(new Color(153, 0, 0));
		
		lblP3Nick = new JLabel("Player 3 nickname");
		lblP3Nick.setHorizontalAlignment(SwingConstants.TRAILING);
		lblP3Nick.setForeground(Color.WHITE);
		
		P3Nick = new JTextField();
		P3Nick.setForeground(Color.WHITE);
		P3Nick.setColumns(10);
		P3Nick.setBackground(new Color(153, 0, 0));
		
		avatarP3 = new JComboBox<String>();
		avatarP3.setModel(new DefaultComboBoxModel<String>(new String[] {"Car", "Hat", "Dog", "Thimble"}));
		avatarP3.setMaximumRowCount(4);
		avatarP3.setForeground(Color.WHITE);
		avatarP3.setBackground(new Color(153, 0, 0));
		
		lblP4Nick = new JLabel("Player 4 nickname");
		lblP4Nick.setForeground(Color.WHITE);
		
		P4Nick = new JTextField();
		P4Nick.setForeground(Color.WHITE);
		P4Nick.setColumns(10);
		P4Nick.setBackground(new Color(153, 0, 0));
		
		avatarP4 = new JComboBox<String>();
		avatarP4.setModel(new DefaultComboBoxModel<String>(new String[] {"Hat", "Dog", "Thimble", "Car"}));
		avatarP4.setMaximumRowCount(4);
		avatarP4.setForeground(Color.WHITE);
		avatarP4.setBackground(new Color(153, 0, 0));
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(153, 0, 0));
		
		btnPlay = new JButton("Play");
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setBackground(new Color(153, 0, 0));
		
		setNumberOfPlayers(np);
		setButtons();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblP3Nick, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblP2Nick)
									.addComponent(lblP1Nick)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(P3Nick, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(avatarP3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(P2Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(avatarP2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(P1Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(avatarP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblP4Nick, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(P4Nick, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(avatarP4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblP1Nick)
								.addComponent(P1Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblP2Nick)
								.addComponent(P2Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(avatarP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblP3Nick)
								.addComponent(P3Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(avatarP3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(avatarP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblP4Nick))
						.addComponent(P4Nick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(avatarP4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlay)
						.addComponent(btnBack))
					.addGap(25))
		);
		setLayout(groupLayout);
		
		
		try {
			background = ImageIO.read(new File("src/Images/fundo.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void setButtons() {
		
		//PLAY BUTTON
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				players[0] = new Player(P1Nick.getText());
				players[0].setAvatar(avatarP1.getActionCommand());
				
				players[1] = new Player(P2Nick.getText());
				players[1].setAvatar(avatarP2.getActionCommand());
				
				if(players.length == 3){
					players[2] = new Player(P3Nick.getText());
					players[2].setAvatar(avatarP3.getActionCommand());
				}else if(players.length == 4){
					players[2] = new Player(P3Nick.getText());
					players[2].setAvatar(avatarP3.getActionCommand());
					
					players[3] = new Player(P4Nick.getText());
					players[3].setAvatar(avatarP4.getActionCommand());
				}
				
				new BoardWindow(players, mode);
				
				
					
			}
		});
		
		//BACK BUTTON
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getRootPane().setContentPane(new NewGamePanel());
				
			}
		});
	}


	private void setNumberOfPlayers(int np) {
		if(np == 2){
			lblP3Nick.setVisible(false);
			P3Nick.setVisible(false);
			avatarP3.setVisible(false);
			
			lblP4Nick.setVisible(false);
			P4Nick.setVisible(false);
			avatarP4.setVisible(false);
		}else if(np == 3){
			lblP4Nick.setVisible(false);
			P4Nick.setVisible(false);
			avatarP4.setVisible(false);
		}
			
		
	}



	/**
	 * Print images
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
	}
}
