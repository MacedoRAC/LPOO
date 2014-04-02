package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import logic.Labirinto;

public class JogoGUI {
	private Labirinto l;
	private JFrame frame;
	private int cima= KeyEvent.VK_UP;
	private int baixo= KeyEvent.VK_DOWN;
	private int esquerda= KeyEvent.VK_LEFT;
	private int direita= KeyEvent.VK_RIGHT;
	private int aguia= KeyEvent.VK_SPACE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoGUI window = new JogoGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JogoGUI() {
		l=new Labirinto();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		Janela panel = new Janela(l.getLabirinto().getLab());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
