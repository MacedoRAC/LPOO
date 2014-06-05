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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.MonopolyLogic;

/**
 * @author André
 *
 */
public class InitialPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnExit;
	private MonopolyLogic monopoly;
	private NewGamePanel newGamePanel;
	
	InitialPanel(){
		setSize(416,416);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(new Color(153, 0, 0));
		btnNewGame.setForeground(Color.WHITE);
		
		btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBackground(new Color(153, 0, 0));
		btnLoadGame.setForeground(new Color(255, 255, 255));
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(153, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		
		try {
			setupButtons();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnLoadGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(301, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(btnNewGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLoadGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit)
					.addContainerGap(311, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		try {
			background = ImageIO.read(new File("src/Images/initial.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * setup the 3 buttons
	 */
	public void setupButtons() throws ClassNotFoundException {
		
		//EXIT BUTTON
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		
		//NEW GAME
		btnNewGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setEnabled(false);
				
				newGamePanel = new NewGamePanel();
				
				getRootPane().setContentPane(newGamePanel);
				
			}

		});
		
		
		//LOAD GAME
		btnLoadGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadGame(); 
				//janela.inciaJogo(lab);
			}
		});
	}
	
public void loadGame() {
	JFileChooser j = new JFileChooser();
	j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	j.setAcceptAllFileFilterUsed(false);
	j.setFileFilter(new FileNameExtensionFilter("dat", "dat"));

	int i=j.showOpenDialog(new JFrame("Load"));

	if(i==JFileChooser.APPROVE_OPTION){
		try{
			File file= j.getSelectedFile();
			FileInputStream loadFile = new FileInputStream(file);
			ObjectInputStream entrie = new ObjectInputStream(loadFile);

			monopoly=(MonopolyLogic) entrie.readObject();
			entrie.close();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(new JFrame().getRootPane(), "Erro, ficheiro não carregado!");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
