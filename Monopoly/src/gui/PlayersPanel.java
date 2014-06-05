/**
 * 
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.swing.Icon;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Canvas;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

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
	private BufferedImage dog;
	private JLabel lblPlayer1name;
	private JLabel lblCash;
	private JLabel lblAmountProperties;
	private JLabel lblAmountBuilings;
	private JLabel lblSpecialCards;
	private JLabel lblCashP1;
	private JLabel lblPropP1;
	private JLabel lblBuildP1;
	private JLabel lblCardsP1;
	
	
	public PlayersPanel(){
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		
		setSize(575, 272);
		
		try {
			background= ImageIO.read(new File("src/Images/fundo.jpg")) ;
			dog= ImageIO.read(new File("src/Images/dogBackground.png")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Graphics g = new Graphics();
		AvatarP1.paint()*/
		
		lblPlayer1name = new JLabel("Player1Name");
		lblPlayer1name.setForeground(Color.WHITE);
		
		lblCash = new JLabel("Cash:");
		lblCash.setForeground(Color.WHITE);
		
		lblAmountProperties = new JLabel("Amount Properties:");
		lblAmountProperties.setForeground(Color.WHITE);
		
		lblAmountBuilings = new JLabel("Amount Builings: ");
		lblAmountBuilings.setForeground(Color.WHITE);
		
		lblSpecialCards = new JLabel("Special Cards: ");
		lblSpecialCards.setForeground(Color.WHITE);
		
		lblCashP1 = new JLabel("CashP1");
		lblCashP1.setForeground(Color.WHITE);
		
		lblPropP1 = new JLabel("PropP1");
		lblPropP1.setForeground(Color.WHITE);
		
		lblBuildP1 = new JLabel("BuildP1");
		lblBuildP1.setForeground(Color.WHITE);
		
		lblCardsP1 = new JLabel("CardsP1");
		lblCardsP1.setForeground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayer1name)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCash, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAmountProperties, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAmountBuilings, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPropP1)
								.addComponent(lblCashP1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSpecialCards, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblCardsP1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblBuildP1, Alignment.LEADING))))
					.addContainerGap(345, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCashP1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPropP1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBuildP1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCardsP1)
								.addComponent(lblSpecialCards, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlayer1name)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCash)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmountProperties, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAmountBuilings, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(187, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
		
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
