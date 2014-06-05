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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import logic.Player;

/**
 * @author André
 *
 */
public class NewGamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private JComboBox<String> gameMode;
	private JSpinner numbPlayersSpinner;
	private JLabel lblNumberOfPlayers;
	private JButton btnPlay;
	private JButton btnBack;
	
	
	public NewGamePanel(){
		setSize(416,416);
		setEnabled(true);
		requestFocus(true);
		
		gameMode = new JComboBox<String>();
		gameMode.setModel(new DefaultComboBoxModel<String>(new String[] {"Local Mode", "LAN Mode"}));
		gameMode.setMaximumRowCount(2);
		gameMode.setForeground(new Color(255, 255, 255));
		gameMode.setBackground(new Color(153, 0, 0));
		
		numbPlayersSpinner = new JSpinner();
		numbPlayersSpinner.setModel(new SpinnerNumberModel(2, 2, 4, 1));
		numbPlayersSpinner.setForeground(new Color(255, 255, 255));
		numbPlayersSpinner.setBackground(new Color(153, 0, 0));
		
		lblNumberOfPlayers = new JLabel("Number of Players");
		lblNumberOfPlayers.setForeground(new Color(255, 255, 255));
		
		btnPlay = new JButton("Play");
		btnPlay.setBackground(new Color(153, 0, 0));
		btnPlay.setForeground(new Color(255, 255, 255));
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(153, 0, 0));
		
		setupButtons();
		
		layoutConfig();
		
		
		try {
			background = ImageIO.read(new File("src/Images/initial.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void layoutConfig() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPlay)
							.addGap(18)
							.addComponent(btnBack))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(gameMode, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNumberOfPlayers)
								.addGap(4)
								.addComponent(numbPlayersSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(280, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(gameMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfPlayers)
						.addComponent(numbPlayersSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlay)
						.addComponent(btnBack))
					.addContainerGap(325, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}


	private void setupButtons() {

		//PLAY BUTTON
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mode = gameMode.getActionCommand();
				int np = numbPlayersSpinner.getComponentCount();
								
				GameConfigPanel panel = new GameConfigPanel(mode, np);
				
				getRootPane().setContentPane(panel);
				
			}
		});
		
		
		//BACK BUTTON
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getRootPane().setContentPane(new InitialPanel());
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
