package gui;

import javax.swing.JFileChooser;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Labirinto;

/**
 * Cria a janela principal do jogo
 * 
 * @author Andr�
 *
 */
public class JogoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Janela janela;
	private JPanel botoesCima;
	private JPanel botoesBaixo;
	private JButton sair;
	private JButton novoJogo;
	private JButton config;
	private JButton guardar;
	private JButton carregar;
	private Opcoes opcoes;
	private Labirinto lab;
	boolean configStandard=true;

	/**
	 * Construtor onde s�o inicializados e configurados o conte�do da janela
	 */
	public JogoFrame() {
		setTitle("Labirinto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela=new Janela();
		botoesCima = new JPanel();
		botoesBaixo = new JPanel();
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
	 * Adiciona bot�es "Novo Jogo" e "Sair" � janela principal
	 */
	private void adicionaBotoes() {
		botoesCima.setLayout(new GridLayout(1,3));
		botoesCima.add(novoJogo);
		botoesCima.add(config);
		botoesCima.add(sair);

		getContentPane().add(botoesCima, BorderLayout.NORTH);

		botoesBaixo.setLayout(new GridLayout(1,2));
		botoesBaixo.add(guardar);
		botoesBaixo.add(carregar);

		getContentPane().add(botoesBaixo, BorderLayout.SOUTH);
	}

	/**
	 * Configura bot�es "Novo Jogo", "Sair" e "Configura��es" da janela principal
	 */
	private void configuraBotoes() {
		//Bot�o 'Sair'
		sair=new JButton("Sair");
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int opcao=JOptionPane.showConfirmDialog(rootPane, "Tens a certeza que pretendes desistir e sair?");
				if(opcao==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});


		//Bot�o 'Novo Jogo'
		novoJogo=new JButton("Novo Jogo");
		novoJogo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int opcao = JOptionPane.showConfirmDialog(rootPane,	"Pretendes come�ar uma nova aventura?");
				if (opcao == JOptionPane.YES_OPTION) {
					setSize(610, 660);
					Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

					if(configStandard)
						lab=new Labirinto(false, 10, false, 1);

					janela.setCima(opcoes.teclas[0]);
					janela.setBaixo(opcoes.teclas[1]);
					janela.setEsquerda(opcoes.teclas[2]);
					janela.setDireita(opcoes.teclas[3]);
					janela.setAguia(opcoes.teclas[4]);

					janela.inciaJogo(lab);
				}

			}
		});


		//Bot�o 'Guardar'
		guardar=new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					guardaJogo();
			}

		});


		//Bot�o 'Carregar'
		carregar=new JButton("Carregar");
		carregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					carregarJogo();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

				janela.inciaJogo(lab);

			}

		});

		//Bot�o "Configura��es"
		config=new JButton("Configura��es");
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

	/**
	 * Fun��o respons�vel por guardar o estado do jogo
	 */
	private void guardaJogo() {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		j.setAcceptAllFileFilterUsed(false);
		j.setFileFilter(new FileNameExtensionFilter("dat", "dat"));

		int i=j.showSaveDialog(new JFrame("Guardar"));

		if(i==JFileChooser.APPROVE_OPTION){
			try{
				File ficheiro= j.getSelectedFile();
				String nomeFicheiro= ficheiro.getName();

				if(!nomeFicheiro.endsWith(".dat"))
					ficheiro= new File(ficheiro + ".dat");

				FileOutputStream guardarFic = new FileOutputStream(ficheiro);
				ObjectOutputStream saida = new ObjectOutputStream(guardarFic);

				saida.writeObject(janela.getLab());
				saida.close();
			}catch(IOException ex){
				JOptionPane.showMessageDialog(new JFrame().getRootPane(), "Erro, ficheiro n�o guardado!");
				ex.printStackTrace();
			}
		}

		janela.requestFocus();
	}

	/**
	 * Fun��o respons�vel por carregar um jogo previamente guardado
	 * @return labirinto com as personagens no s�tio onde foram deixadas na �ltima vez jogada
	 * @throws ClassNotFoundException 
	 */
	private void carregarJogo() throws ClassNotFoundException {

		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		j.setAcceptAllFileFilterUsed(false);
		j.setFileFilter(new FileNameExtensionFilter("dat", "dat"));

		int i=j.showOpenDialog(new JFrame("Carregar"));

		if(i==JFileChooser.APPROVE_OPTION){
			try{
				File ficheiro= j.getSelectedFile();
				FileInputStream carregarFic = new FileInputStream(ficheiro);
				ObjectInputStream entrada = new ObjectInputStream(carregarFic);

				lab=(Labirinto) entrada.readObject();
				entrada.close();
			}catch(IOException ex){
				JOptionPane.showMessageDialog(new JFrame().getRootPane(), "Erro, ficheiro n�o carregado!");
				ex.printStackTrace();
			}
		}
	}

}
