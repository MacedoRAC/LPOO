/**
 * 
 */
package gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import java.awt.SystemColor;
import java.util.Vector;

import logic.Player;

import javax.swing.ImageIcon;

/**
 * @author André
 *
 */
public class PlayersPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private JLabel lblPlayer1name;
	private JLabel lblCash;
	private JLabel lblAmountProperties;
	private JLabel lblAmountBuilings;
	private JLabel lblCashP1;
	private JLabel lblPropP1;
	private JLabel lblBuildP1;
	private JLabel AvatarP1;
	private JLabel lblPlayer2name;
	private JLabel lblBuildP2;
	private JLabel AvatarP2;
	private JLabel lblCash2;
	private JLabel lblAmoutProperties2;
	private JLabel lblCashP2;
	private JLabel lblAmountBuildings2;
	private JLabel lblPropP2;
	private JLabel AvatarP3;
	private JLabel lblPlayerName3;
	private JLabel lblCash3;
	private JLabel lblAmountProperties3;
	private JLabel lblAmountBuildings3;
	private JLabel lblBuildP3;
	private JLabel lblPropP3;
	private JLabel lblCashP3;
	private JLabel lblPlayerName4;
	private JLabel AvatarP4;
	private JLabel lblCash4;
	private JLabel lblAmoutProperties4;
	private JLabel lblAmountBuildings4;
	private JLabel lblBuildP4;
	private JLabel lblPropP4;
	private JLabel lblCashP4;
	private JLabel lblPosition1;
	private JLabel lblPosP1;
	private JLabel lblPosition2;
	private JLabel lblPosP2;
	private JLabel lblPosition3;
	private JLabel lblPosP3;
	private JLabel lblPosition4;
	private JLabel lblPosP4;
	
	private Vector<Player> players;
	
	
	public PlayersPanel(Vector<Player> vector){
	
		this.players = vector;
		
		setBackground(SystemColor.desktop);
		setForeground(Color.WHITE);
		
		setSize(575, 212);
		
		
		lblPlayer1name = new JLabel("Player1Name");
		lblPlayer1name.setBounds(10, 71, 63, 14);
		lblPlayer1name.setForeground(Color.WHITE);
		
		lblCash = new JLabel("Cash:");
		lblCash.setBounds(91, 11, 97, 14);
		lblCash.setForeground(Color.WHITE);
		
		lblAmountProperties = new JLabel("Amount Properties:");
		lblAmountProperties.setBounds(91, 31, 97, 14);
		lblAmountProperties.setForeground(Color.WHITE);
		
		lblAmountBuilings = new JLabel("Amount Buildings: ");
		lblAmountBuilings.setBounds(91, 51, 97, 19);
		lblAmountBuilings.setForeground(Color.WHITE);
				
		lblCashP1 = new JLabel("CashP1");
		lblCashP1.setBounds(194, 11, 36, 14);
		lblCashP1.setForeground(Color.WHITE);
		
		lblPropP1 = new JLabel("PropP1");
		lblPropP1.setBounds(194, 31, 34, 14);
		lblPropP1.setForeground(Color.WHITE);
		
		lblBuildP1 = new JLabel("BuildP1");
		lblBuildP1.setBounds(194, 51, 34, 14);
		lblBuildP1.setForeground(Color.WHITE);
		
		AvatarP1 = new JLabel("");
		AvatarP1.setBounds(10, 11, 48, 47);
		
		lblPlayer2name = new JLabel("Player2Name");
		lblPlayer2name.setBounds(10, 173, 63, 14);
		lblPlayer2name.setForeground(Color.WHITE);
		
		lblBuildP2 = new JLabel("BuildP2");
		lblBuildP2.setBounds(194, 153, 34, 14);
		lblBuildP2.setForeground(Color.WHITE);
		
		AvatarP2 = new JLabel("");
		AvatarP2.setBounds(10, 113, 48, 47);
		
		lblCash2 = new JLabel("Cash:");
		lblCash2.setBounds(91, 113, 97, 14);
		lblCash2.setForeground(Color.WHITE);
		
		lblAmoutProperties2 = new JLabel("Amount Properties:");
		lblAmoutProperties2.setBounds(91, 133, 97, 14);
		lblAmoutProperties2.setForeground(Color.WHITE);
		
		lblCashP2 = new JLabel("CashP2");
		lblCashP2.setBounds(194, 113, 36, 14);
		lblCashP2.setForeground(Color.WHITE);
		
		lblAmountBuildings2 = new JLabel("Amount Buildings: ");
		lblAmountBuildings2.setBounds(91, 153, 97, 19);
		lblAmountBuildings2.setForeground(Color.WHITE);
		
		lblPropP2 = new JLabel("PropP2");
		lblPropP2.setBounds(194, 133, 34, 14);
		lblPropP2.setForeground(Color.WHITE);
		
		AvatarP3 = new JLabel("");
		AvatarP3.setBounds(308, 11, 48, 47);
		
		lblPlayerName3 = new JLabel("Player3Name");
		lblPlayerName3.setBounds(308, 71, 63, 14);
		lblPlayerName3.setForeground(Color.WHITE);
		
		lblCash3 = new JLabel("Cash:");
		lblCash3.setBounds(389, 11, 97, 14);
		lblCash3.setForeground(Color.WHITE);
		
		lblAmountProperties3 = new JLabel("Amount Properties:");
		lblAmountProperties3.setBounds(389, 31, 97, 14);
		lblAmountProperties3.setForeground(Color.WHITE);
		
		lblAmountBuildings3 = new JLabel("Amount Buildings: ");
		lblAmountBuildings3.setBounds(389, 51, 97, 19);
		lblAmountBuildings3.setForeground(Color.WHITE);
		
		lblBuildP3 = new JLabel("BuildP3");
		lblBuildP3.setBounds(492, 51, 34, 14);
		lblBuildP3.setForeground(Color.WHITE);
		
		lblPropP3 = new JLabel("PropP3");
		lblPropP3.setBounds(492, 31, 34, 14);
		lblPropP3.setForeground(Color.WHITE);
		
		lblCashP3 = new JLabel("CashP3");
		lblCashP3.setBounds(492, 11, 36, 14);
		lblCashP3.setForeground(Color.WHITE);
		
		lblPlayerName4 = new JLabel("Player4Name");
		lblPlayerName4.setBounds(308, 173, 63, 14);
		lblPlayerName4.setForeground(Color.WHITE);
		
		AvatarP4 = new JLabel("");
		AvatarP4.setBounds(308, 113, 48, 47);
		
		lblCash4 = new JLabel("Cash:");
		lblCash4.setBounds(389, 113, 97, 14);
		lblCash4.setForeground(Color.WHITE);
		
		lblAmoutProperties4 = new JLabel("Amount Properties:");
		lblAmoutProperties4.setBounds(389, 133, 97, 14);
		lblAmoutProperties4.setForeground(Color.WHITE);
		
		lblAmountBuildings4 = new JLabel("Amount Buildings: ");
		lblAmountBuildings4.setBounds(389, 153, 97, 19);
		lblAmountBuildings4.setForeground(Color.WHITE);
		
		lblBuildP4 = new JLabel("BuildP4");
		lblBuildP4.setBounds(492, 153, 34, 14);
		lblBuildP4.setForeground(Color.WHITE);
		
		lblPropP4 = new JLabel("PropP4");
		lblPropP4.setBounds(492, 133, 34, 14);
		lblPropP4.setForeground(Color.WHITE);
		
		lblCashP4 = new JLabel("CashP4");
		lblCashP4.setBounds(492, 113, 36, 14);
		lblCashP4.setForeground(Color.WHITE);
		
		lblPosition1 = new JLabel("Position:");
		lblPosition1.setForeground(new Color(255, 255, 255));
		lblPosition1.setBackground(new Color(153, 0, 0));
		lblPosition1.setBounds(91, 71, 46, 14);
		
		lblPosP1 = new JLabel("PosP1");
		lblPosP1.setForeground(new Color(255, 255, 255));
		lblPosP1.setBackground(new Color(153, 0, 0));
		lblPosP1.setBounds(194, 71, 46, 14);

		lblPosP2 = new JLabel("PosP2");
		lblPosP2.setForeground(Color.WHITE);
		lblPosP2.setBackground(new Color(153, 0, 0));
		lblPosP2.setBounds(194, 173, 46, 14);

		lblPosition2 = new JLabel("Position:");
		lblPosition2.setForeground(Color.WHITE);
		lblPosition2.setBackground(new Color(153, 0, 0));
		lblPosition2.setBounds(91, 173, 46, 14);
		
		lblPosP4 = new JLabel("PosP4");
		lblPosP4.setForeground(Color.WHITE);
		lblPosP4.setBackground(new Color(153, 0, 0));
		lblPosP4.setBounds(492, 173, 46, 14);
		
		lblPosition4 = new JLabel("Position:");
		lblPosition4.setForeground(Color.WHITE);
		lblPosition4.setBackground(new Color(153, 0, 0));
		lblPosition4.setBounds(389, 173, 46, 14);
		
		lblPosP3 = new JLabel("PosP3");
		lblPosP3.setForeground(Color.WHITE);
		lblPosP3.setBackground(new Color(153, 0, 0));
		lblPosP3.setBounds(492, 71, 46, 14);
		
		lblPosition3 = new JLabel("Position:");
		lblPosition3.setForeground(Color.WHITE);
		lblPosition3.setBackground(new Color(153, 0, 0));
		lblPosition3.setBounds(389, 71, 46, 14);
		
		setLayout(null);
		add(lblPlayer1name);
		add(AvatarP1);
		add(lblCash);
		add(lblAmountProperties);
		add(lblAmountBuilings);
		add(lblPropP1);
		add(lblCashP1);
		add(lblBuildP1);
		add(lblPosition1);
		add(lblPosP1);
		add(AvatarP2);
		add(lblCash2);
		add(lblAmoutProperties2);
		add(lblAmountBuildings2);
		add(lblCashP2);
		add(lblPropP2);
		add(lblBuildP2);
		add(lblPlayer2name);
		add(lblPosP2);
		add(lblPosition2);
				
		if(players.size() > 2){
			add(AvatarP3);
			add(lblCash3);
			add(lblAmountProperties3);
			add(lblCashP3);
			add(lblPropP3);
			add(lblBuildP3);
			add(lblAmountBuildings3);
			add(lblPlayerName3);
			add(lblPosP3);
			add(lblPosition3);
			if(players.size() > 3){
				add(AvatarP4);
				add(lblCash4);
				add(lblAmoutProperties4);
				add(lblAmountBuildings4);
				add(lblCashP4);
				add(lblPropP4);
				add(lblBuildP4);
				add(lblPlayerName4);
				add(lblPosP4);
				add(lblPosition4);
			}
		}
		
		
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
		
		setAvatars();
		
		setInfoPlayers();
	}

	/**
	 * Set information of Players (cash, properties, buildings and special cards)
	 */
	private void setInfoPlayers() {

		//PLAYER 1
		lblPlayer1name.setText(players.get(0).getName());
		lblCashP1.setText("" + players.get(0).getMoney());
		lblBuildP1.setText("" + players.get(0).getNumberBuildings());
		lblPropP1.setText("" + players.get(0).getOwnproperties().size());
		lblPosP1.setText(""+ players.get(0).getPosition());

		//PLAYER 2
		lblPlayer2name.setText(players.get(1).getName());
		lblCashP2.setText("" + players.get(1).getMoney());
		lblBuildP2.setText("" + players.get(1).getNumberBuildings());
		lblPropP2.setText("" + players.get(1).getOwnproperties().size());
		lblPosP2.setText(""+ players.get(1).getPosition());
		
		if(players.size() > 2){
			//PLAYER 3
			lblPlayerName3.setText(players.get(2).getName());
			lblCashP3.setText("" + players.get(2).getMoney());
			lblBuildP3.setText("" + players.get(2).getNumberBuildings());
			lblPropP3.setText("" + players.get(2).getOwnproperties().size());
			lblPosP3.setText(""+ players.get(2).getPosition());

			if(players.size() > 3){
				//PLAYER 4
				lblPlayerName4.setText(players.get(3).getName());
				lblCashP4.setText("" + players.get(3).getMoney());
				lblBuildP4.setText("" + players.get(3).getNumberBuildings());
				lblPropP4.setText("" + players.get(3).getOwnproperties().size());
				lblPosP4.setText(""+ players.get(3).getPosition());
			}
		}
		
	}


	/**
	 * set players tokens
	 */
	private void setAvatars() {
		//player 1
		switch(players.get(0).getToken()){
		case "dog":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/dogSmaller.png")));
			break;
		case "hat":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/hatSmaller.png")));
			break;
		case "thimble":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/thimbleSmaller.png")));
			break;
		case "car":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/carSmaller.png")));
			break;
		}

		//player 2
		switch(players.get(1).getToken()){
		case "dog":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/dogSmaller.png")));
			break;
		case "hat":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/hatSmaller.png")));
			break;
		case "thimble":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/thimbleSmaller.png")));
			break;
		case "car":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/carSmaller.png")));
			break;
		}

		if(players.size() > 2){
			//player 3
			switch(players.get(2).getToken()){
			case "dog":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/dogSmaller.png")));
				break;
			case "hat":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/hatSmaller.png")));
				break;
			case "thimble":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/thimbleSmaller.png")));
				break;
			case "car":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/carSmaller.png")));
				break;
			}

			if(players.size() > 3){
				//player 4
				switch(players.get(3).getToken()){
				case "dog":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/dogSmaller.png")));
					break;
				case "hat":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/hatSmaller.png")));
					break;
				case "thimble":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/thimbleSmaller.png")));
					break;
				case "car":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/avatars/carSmaller.png")));
					break;
				}
			}
		}
	}
}
