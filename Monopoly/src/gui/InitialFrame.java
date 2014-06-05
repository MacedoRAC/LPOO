package gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Dimension;
import java.awt.Toolkit;

public class InitialFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InitialPanel initial;
	
	
	public InitialFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InitialFrame.class.getResource("/Images/initial.jpg")));
		setResizable(false);
		setTitle("Monopoly");
		setSize(420, 430);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
		
		initial = new InitialPanel();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
				.addComponent(initial)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 391, Short.MAX_VALUE)
				.addComponent(initial)
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		
	}

}
