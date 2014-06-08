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

		setSize(416,416);
		setEnabled(true);
		requestFocus(true);
		
		this.mode = mode;
		this.players = new Player[np];
	
		lblP1Nick = new JLabel("Player 1 nick");
		lblP1Nick.setBounds(65, 60, 98, 14);
		lblP1Nick.setForeground(new Color(255, 255, 255));
		
		P1Nick = new JTextField();
		P1Nick.setBounds(187, 57, 86, 20);
		P1Nick.setBackground(new Color(153, 0, 0));
		P1Nick.setForeground(new Color(255, 255, 255));
		lblP1Nick.setLabelFor(P1Nick);
		P1Nick.setColumns(10);
		
		avatarP1 = new JComboBox<String>();
		avatarP1.setBounds(279, 57, 61, 20);
		avatarP1.setModel(new DefaultComboBoxModel<String>(new String[] {"dog", "thimble", "car", "hat"}));
		avatarP1.setBackground(new Color(153, 0, 0));
		avatarP1.setForeground(new Color(255, 255, 255));
		avatarP1.setMaximumRowCount(4);
		
		lblP2Nick = new JLabel("Player 2 nick");
		lblP2Nick.setBounds(65, 110, 98, 14);
		lblP2Nick.setForeground(Color.WHITE);
		
		P2Nick = new JTextField();
		P2Nick.setBounds(187, 107, 86, 20);
		P2Nick.setBackground(new Color(153, 0, 0));
		lblP2Nick.setLabelFor(P2Nick);
		P2Nick.setForeground(Color.WHITE);
		P2Nick.setColumns(10);
		
		avatarP2 = new JComboBox<String>();
		avatarP2.setBounds(279, 107, 61, 20);
		avatarP2.setModel(new DefaultComboBoxModel<String>(new String[] {"thimble", "car", "hat", "dog"}));
		avatarP2.setMaximumRowCount(4);
		avatarP2.setForeground(Color.WHITE);
		avatarP2.setBackground(new Color(153, 0, 0));
		
		lblP3Nick = new JLabel("Player 3 nick");
		lblP3Nick.setBounds(65, 164, 98, 14);
		lblP3Nick.setHorizontalAlignment(SwingConstants.LEFT);
		lblP3Nick.setForeground(Color.WHITE);
		
		P3Nick = new JTextField();
		lblP3Nick.setLabelFor(P3Nick);
		P3Nick.setBounds(187, 161, 86, 20);
		P3Nick.setForeground(Color.WHITE);
		P3Nick.setColumns(10);
		P3Nick.setBackground(new Color(153, 0, 0));
		
		avatarP3 = new JComboBox<String>();
		avatarP3.setBounds(279, 161, 61, 20);
		avatarP3.setModel(new DefaultComboBoxModel<String>(new String[] {"car", "hat", "dog", "thimble"}));
		avatarP3.setMaximumRowCount(4);
		avatarP3.setForeground(Color.WHITE);
		avatarP3.setBackground(new Color(153, 0, 0));
		
		lblP4Nick = new JLabel("Player 4 nick");
		lblP4Nick.setBounds(65, 222, 98, 14);
		lblP4Nick.setForeground(Color.WHITE);
		
		P4Nick = new JTextField();
		lblP4Nick.setLabelFor(P4Nick);
		P4Nick.setBounds(187, 219, 86, 20);
		P4Nick.setForeground(Color.WHITE);
		P4Nick.setColumns(10);
		P4Nick.setBackground(new Color(153, 0, 0));
		
		avatarP4 = new JComboBox<String>();
		avatarP4.setBounds(279, 219, 61, 20);
		avatarP4.setModel(new DefaultComboBoxModel<String>(new String[] {"hat", "dog", "thimble", "car"}));
		avatarP4.setMaximumRowCount(4);
		avatarP4.setForeground(Color.WHITE);
		avatarP4.setBackground(new Color(153, 0, 0));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(65, 368, 119, 23);
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(153, 0, 0));
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(221, 368, 119, 23);
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setBackground(new Color(153, 0, 0));
		
		
		setButtons();
		setLayout(null);
		add(lblP1Nick);
		add(P1Nick);
		add(avatarP1);
		add(lblP2Nick);
		add(P2Nick);
		add(avatarP2);
		
		if(np > 2){
			add(lblP3Nick);
			add(P3Nick);
			add(avatarP3);

			if(np>3){
				add(lblP4Nick);
				add(P4Nick);
				add(avatarP4);
			}
		}
		
		add(btnBack);
		add(btnPlay);
		
		
		try {
			background = ImageIO.read(new File("src/Images/fundo.png")) ;
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
				players[0].setAvatar((String) avatarP1.getSelectedItem());
				
				players[1] = new Player(P2Nick.getText());
				players[1].setAvatar((String) avatarP2.getSelectedItem());
				
				if(players.length > 2){
					players[2] = new Player(P3Nick.getText());
					players[2].setAvatar((String) avatarP3.getSelectedItem());

					if(players.length > 3){
						players[3] = new Player(P4Nick.getText());
						players[3].setAvatar((String) avatarP4.getSelectedItem());
					}
				}
				getRootPane().setContentPane(new InitialPanel());
				
				BoardWindow window = new BoardWindow(players, mode);
				window.setVisible(true);	
								
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


	/**
	 * Print images
	 */
	protected void paintComponent(Graphics g){
		requestFocus(true);
		setFocusable(true);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), Color.WHITE, null);
	}
}
