package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JogoFrame extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private Janela janela;
	private JPanel botoes;
	private JButton sair;
	private JButton novoJogo;
	private JButton config;
	private JDialog opcoes;

	/**
	 * Create the application.
	 */
	public JogoFrame() {
		setTitle("Labirinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela=new Janela();
		botoes = new JPanel();
		opcoes=new JDialog();
		
		configuraBotoes();
		getContentPane().setLayout(new BorderLayout(0,0));
		adicionaBotoes();
		getContentPane().add(janela);
		
		setSize(655,465);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
	}

	private void adicionaBotoes() {
		botoes.setLayout(new GridLayout(1,3));
		botoes.add(novoJogo);
		botoes.add(config);
		botoes.add(sair);
		
		getContentPane().add(botoes, BorderLayout.NORTH);
		
	}

	private void configuraBotoes() {
		//Botão 'Sair'
		sair=new JButton("Sair");
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int opcao=JOptionPane.showConfirmDialog(rootPane, "Tens a certeza que pretendes desistir e sair?");
				if(opcao==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		
		//Botão 'Novo Jogo'
		novoJogo=new JButton("Novo Jogo");
		novoJogo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int opcao=JOptionPane.showConfirmDialog(rootPane, "Pretendes começar uma nova aventura?");
				if(opcao==JOptionPane.YES_OPTION){
					setSize(655,465);
					Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
					
					janela.inciaJogo();
				}
			}
		});
		
		//Botão  'Config'
		config=new JButton("Configurações");
		config.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				opcoes.setVisible(true);
			}
		});
		
	}

}
