
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import logic.Player;

/**
 * @author André
 *
 */
public class BoardWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boardPanel board;
	private PlayingPanel playingPanel;
	
	/**
	 * Constructor of the window
	 * @param mode 
	 * @param players 
	 */
	public BoardWindow(Vector<Player> players, String mode){
		setIconImage(Toolkit.getDefaultToolkit().getImage(BoardWindow.class.getResource("/Images/initial.jpg")));
		setResizable(false);
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1280,700);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

		board = new boardPanel();
		playingPanel = new PlayingPanel(players, mode);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(board, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(699)
					.addComponent(playingPanel, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(board, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
				.addComponent(playingPanel, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}


	/**
	 * @return the playingPanel
	 */
	public PlayingPanel getPlayingPanel() {
		return playingPanel;
	}



	/**
	 * @param playingPanel the playingPanel to set
	 */
	public void setPlayingPanel(PlayingPanel playingPanel) {
		this.playingPanel = playingPanel;
	}



	/**
	 * @return the board
	 */
	public boardPanel getBoard() {
		return board;
	}



	/**
	 * @param board the board to set
	 */
	public void setBoard(boardPanel board) {
		this.board = board;
	}

	
	
}
