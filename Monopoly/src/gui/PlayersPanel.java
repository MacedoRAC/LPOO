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
	private JLabel lblSpecialCards;
	private JLabel lblCashP1;
	private JLabel lblPropP1;
	private JLabel lblBuildP1;
	private JLabel lblCardsP1;
	private JLabel AvatarP1;
	private JLabel lblPlayer2name;
	private JLabel lblBuildP2;
	private JLabel AvatarP2;
	private JLabel lblCash2;
	private JLabel lblAmoutProperties2;
	private JLabel lblCashP2;
	private JLabel lblSpecialCards2;
	private JLabel lblCardsP2;
	private JLabel lblAmountBuildings2;
	private JLabel lblPropP2;
	private JLabel AvatarP3;
	private JLabel lblPlayerName3;
	private JLabel lblCash3;
	private JLabel lblAmountProperties3;
	private JLabel lblAmountBuildings3;
	private JLabel lblSpecialCards3;
	private JLabel lblCardsP3;
	private JLabel lblBuildP3;
	private JLabel lblPropP3;
	private JLabel lblCashP3;
	private JLabel lblPlayerName4;
	private JLabel AvatarP4;
	private JLabel lblCash4;
	private JLabel lblAmoutProperties4;
	private JLabel lblAmountBuildings4;
	private JLabel lblSpecialCards4;
	private JLabel lblCardsP4;
	private JLabel lblBuildP4;
	private JLabel lblPropP4;
	private JLabel lblCashP4;
	
	private Player[] players;
	
	
	public PlayersPanel(Player[] players){
		
		this.players=players;
		
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
		
		lblSpecialCards = new JLabel("Special Cards: ");
		lblSpecialCards.setBounds(91, 71, 85, 14);
		lblSpecialCards.setForeground(Color.WHITE);
		
		lblCashP1 = new JLabel("CashP1");
		lblCashP1.setBounds(194, 11, 36, 14);
		lblCashP1.setForeground(Color.WHITE);
		
		lblPropP1 = new JLabel("PropP1");
		lblPropP1.setBounds(194, 31, 34, 14);
		lblPropP1.setForeground(Color.WHITE);
		
		lblBuildP1 = new JLabel("BuildP1");
		lblBuildP1.setBounds(194, 51, 34, 14);
		lblBuildP1.setForeground(Color.WHITE);
		
		lblCardsP1 = new JLabel("CardsP1");
		lblCardsP1.setBounds(194, 71, 34, 14);
		lblCardsP1.setForeground(Color.WHITE);
		
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
		
		lblSpecialCards2 = new JLabel("Special Cards: ");
		lblSpecialCards2.setBounds(91, 173, 85, 14);
		lblSpecialCards2.setForeground(Color.WHITE);
		
		lblCardsP2 = new JLabel("CardsP2");
		lblCardsP2.setBounds(194, 173, 34, 14);
		lblCardsP2.setForeground(Color.WHITE);
		
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
		
		lblSpecialCards3 = new JLabel("Special Cards: ");
		lblSpecialCards3.setBounds(389, 71, 85, 14);
		lblSpecialCards3.setForeground(Color.WHITE);
		
		lblCardsP3 = new JLabel("CardsP3");
		lblCardsP3.setBounds(492, 71, 34, 14);
		lblCardsP3.setForeground(Color.WHITE);
		
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
		
		lblSpecialCards4 = new JLabel("Special Cards: ");
		lblSpecialCards4.setBounds(389, 173, 85, 14);
		lblSpecialCards4.setForeground(Color.WHITE);
		
		lblCardsP4 = new JLabel("CardsP4");
		lblCardsP4.setBounds(492, 173, 34, 14);
		lblCardsP4.setForeground(Color.WHITE);
		
		lblBuildP4 = new JLabel("BuildP4");
		lblBuildP4.setBounds(492, 153, 34, 14);
		lblBuildP4.setForeground(Color.WHITE);
		
		lblPropP4 = new JLabel("PropP4");
		lblPropP4.setBounds(492, 133, 34, 14);
		lblPropP4.setForeground(Color.WHITE);
		
		lblCashP4 = new JLabel("CashP4");
		lblCashP4.setBounds(492, 113, 36, 14);
		lblCashP4.setForeground(Color.WHITE);
		
		setLayout(null);
		add(lblPlayer1name);
		add(AvatarP1);
		add(lblCash);
		add(lblAmountProperties);
		add(lblAmountBuilings);
		add(lblPropP1);
		add(lblCashP1);
		add(lblSpecialCards);
		add(lblCardsP1);
		add(lblBuildP1);
		add(AvatarP2);
		add(lblCash2);
		add(lblAmoutProperties2);
		add(lblAmountBuildings2);
		add(lblCashP2);
		add(lblPropP2);
		add(lblBuildP2);
		add(lblPlayer2name);
		add(lblSpecialCards2);
		add(lblCardsP2);
		
		if(players.length > 2){
			add(AvatarP3);
			add(lblCash3);
			add(lblAmountProperties3);
			add(lblCashP3);
			add(lblPropP3);
			add(lblBuildP3);
			add(lblAmountBuildings3);
			add(lblPlayerName3);
			add(lblSpecialCards3);
			add(lblCardsP3);

			if(players.length > 3){
				add(AvatarP4);
				add(lblCash4);
				add(lblAmoutProperties4);
				add(lblAmountBuildings4);
				add(lblCashP4);
				add(lblPropP4);
				add(lblBuildP4);
				add(lblPlayerName4);
				add(lblSpecialCards4);
				add(lblCardsP4);
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
		lblPlayer1name.setText(players[0].getName());
		lblCashP1.setText("" + players[0].getMoney());
		lblBuildP1.setText("" + players[0].getNumberBuildings());
		lblPropP1.setText("" + players[0].getOwnedProperties().size());
		lblCardsP1.setText("" + players[0].getSpecialCards().size());

		//PLAYER 2
		lblPlayer2name.setText(players[1].getName());
		lblCashP2.setText("" + players[1].getMoney());
		lblBuildP2.setText("" + players[1].getNumberBuildings());
		lblPropP2.setText("" + players[1].getOwnedProperties().size());
		lblCardsP2.setText("" + players[1].getSpecialCards().size());

		if(players.length > 2){
			//PLAYER 3
			lblPlayerName3.setText(players[2].getName());
			lblCashP3.setText("" + players[2].getMoney());
			lblBuildP3.setText("" + players[2].getNumberBuildings());
			lblPropP3.setText("" + players[2].getOwnedProperties().size());
			lblCardsP3.setText("" + players[2].getSpecialCards().size());

			if(players.length > 3){
				//PLAYER 4
				lblPlayerName4.setText(players[3].getName());
				lblCashP4.setText("" + players[3].getMoney());
				lblBuildP4.setText("" + players[3].getNumberBuildings());
				lblPropP4.setText("" + players[3].getOwnedProperties().size());
				lblCardsP4.setText("" + players[3].getSpecialCards().size());
			}
		}
		
	}


	/**
	 * set players avatars
	 */
	private void setAvatars() {
		
		//player 1
		switch(players[0].getAvatar()){
		case "dog":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/dogSmaller.png")));
			break;
		case "hat":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/hatSmaller.png")));
			break;
		case "thimble":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/thimbleSmaller.png")));
			break;
		case "car":
			AvatarP1.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/carSmaller.png")));
			break;
		}

		//player 2
		switch(players[1].getAvatar()){
		case "dog":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/dogSmaller.png")));
			break;
		case "hat":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/hatSmaller.png")));
			break;
		case "thimble":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/thimbleSmaller.png")));
			break;
		case "car":
			AvatarP2.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/carSmaller.png")));
			break;
		}

		if(players.length > 2){
			//player 3
			switch(players[2].getAvatar()){
			case "dog":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/dogSmaller.png")));
				break;
			case "hat":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/hatSmaller.png")));
				break;
			case "thimble":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/thimbleSmaller.png")));
				break;
			case "car":
				AvatarP3.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/carSmaller.png")));
				break;
			}

			if(players.length > 3){
				//player 4
				switch(players[3].getAvatar()){
				case "dog":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/dogSmaller.png")));
					break;
				case "hat":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/hatSmaller.png")));
					break;
				case "thimble":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/thimbleSmaller.png")));
					break;
				case "car":
					AvatarP4.setIcon(new ImageIcon(PlayersPanel.class.getResource("/Images/carSmaller.png")));
					break;
				}
			}
		}
	}
}
