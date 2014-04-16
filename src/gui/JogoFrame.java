package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import logic.Labirinto;

/**
 * Cria a janela principal do jogo
 * 
 * @author André
 *
 */
public class JogoFrame extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private Janela janela;
	private JPanel botoes;
	private JButton sair;
	private JButton novoJogo;
	private JButton config;
	private Opcoes opcoes;
	private Labirinto lab;
	boolean configStandard=true;

	/**
	 * Construtor onde são inicializados e configurados o conteúdo da janela
	 */
	public JogoFrame() {
		setTitle("Labirinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela=new Janela();
		botoes = new JPanel();
		opcoes=new Opcoes();
		
		configuraBotoes();
		getContentPane().setLayout(new BorderLayout(0,0));
		adicionaBotoes();
		getContentPane().add(janela);
		
		setSize(655,465);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
	}

	/**
	 * Adiciona botões "Novo Jogo" e "Sair" à janela principal
	 */
	private void adicionaBotoes() {
		botoes.setLayout(new GridLayout(1,3));
		botoes.add(novoJogo);
		botoes.add(config);
		botoes.add(sair);
		getContentPane().add(botoes, BorderLayout.NORTH);
		
	}

	/**
	 * Configura botões "Novo Jogo", "Sair" e "Configurações" da janela principal
	 */
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
				int opcao = JOptionPane.showConfirmDialog(rootPane,	"Pretendes começar uma nova aventura?");
				if (opcao == JOptionPane.YES_OPTION) {
					setSize(610, 660);
					Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
					
					if(configStandard)
						lab=new Labirinto(false, 10, false, 1);
					
					janela.inciaJogo(lab);
				}
				
			}
		});
		
		
		//Botão "Configurações"
		config=new JButton("Configurações");
		config.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				opcoes.setEnabled(true);
				opcoes.setVisible(true);
				opcoes.setSize(306, 436);
				Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
				opcoes.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
				opcoes.addWindowListener(new WindowListener() {

					@Override
					public void windowClosed(WindowEvent arg0) {
						lab=opcoes.getLab();
						configStandard=false;

					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

				});

			}
		});
	}

}
