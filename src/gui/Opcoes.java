package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.Labirinto;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Janela onde se faz a configuração dos parâmetros do jogo
 * 
 * @author André
 *
 */
public class Opcoes extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> tipoLabirinto;
	private JComboBox<String> dragoesAdor;
	private JSpinner tamanhoLab;
	private JButton botaoOK;
	private JLabel tamanhoLabEtiqueta;
	private JLabel ModoJogoEtiqueta;
	private JLabel teclasEtiqueta;
	private JLabel dragoesEtiqueta;
	private JLabel cimaEtiqueta;
	private JLabel baixoEtiqueta;
	private JLabel esquerdaEtiqueta;
	private JLabel direitaEtiqueta;
	private JLabel aguiaEtiqueta;
	private GroupLayout groupLayout;
	private JLabel numDragoesEtiqueta;
	private JSpinner numDragoes;
	private JTextField teclaCima;
	private JTextField teclaBaixo;
	private JTextField teclaEsquerda;
	private JTextField teclaDireita;
	private JTextField teclaAguia;
	private Labirinto lab;
	String[] teclas= new String[]{" ", " ", " ", " ", " "};
	
	/**
	 * Construtor onde é inicializado o conteúdo da janela de configuração 
	 */
	public Opcoes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Configura\u00E7\u00F5es");
		setAlwaysOnTop(true);
		
				
		tipoLabirinto= new JComboBox<String>();
		tipoLabirinto.setModel(new DefaultComboBoxModel<String>(new String[] {"Fixo", "Aleat\u00F3rio"}));
		
		dragoesAdor = new JComboBox<String>();
		dragoesAdor.setModel(new DefaultComboBoxModel<String>(new String[] {"Sim", "N\u00E3o"}));
		
		tamanhoLab = new JSpinner();
		tamanhoLab.setModel(new SpinnerNumberModel(7,7,99,2));
		
		numDragoes = new JSpinner();
		numDragoes.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		
		botaoOK = new JButton("OK");
		botaoOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				configuraJogo();
				setVisible(false);
				dispose();
			}
		});
		
		configuraEtiquetas();
		
		teclaCima = new JTextField();
		teclaCima.setHorizontalAlignment(SwingConstants.CENTER);
		teclaCima.setText("W");
		teclaCima.setColumns(10);
		
		teclaBaixo = new JTextField();
		teclaBaixo.setHorizontalAlignment(SwingConstants.CENTER);
		teclaBaixo.setText("S");
		teclaBaixo.setColumns(10);
		
		teclaEsquerda = new JTextField();
		teclaEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
		teclaEsquerda.setText("A");
		teclaEsquerda.setColumns(10);
		
		teclaDireita = new JTextField();
		teclaDireita.setHorizontalAlignment(SwingConstants.CENTER);
		teclaDireita.setText("D");
		teclaDireita.setColumns(10);
		
		teclaAguia = new JTextField();
		teclaAguia.setText("G");
		teclaAguia.setHorizontalAlignment(SwingConstants.CENTER);
		teclaAguia.setColumns(10);
		
		groupLayout = new GroupLayout(getContentPane());
	
		configuraGrouplayout();
		getContentPane().setLayout(groupLayout);
		
	}

	/**
	 * Configura as Etiquetas apresentadas na janela
	 */
	private void configuraEtiquetas() {
		tamanhoLabEtiqueta = new JLabel("Tamanho Labirinto");
		tamanhoLabEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ModoJogoEtiqueta = new JLabel("Modo de Jogo");
		ModoJogoEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		teclasEtiqueta = new JLabel("Teclas de Jogo");
		teclasEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		dragoesEtiqueta = new JLabel("Drag\u00F5es Adormecem");
		dragoesEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		numDragoesEtiqueta = new JLabel("N\u00FAmero de Drag\u00F5es");
		numDragoesEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cimaEtiqueta = new JLabel("Cima");
		
		baixoEtiqueta = new JLabel("Baixo");
		
		esquerdaEtiqueta = new JLabel("Esquerda");
		
		direitaEtiqueta = new JLabel("Direita");
		
		aguiaEtiqueta = new JLabel("\u00C1guia");
		
	}

	/**
	 * Configura o Layout da janela
	 */
	private void configuraGrouplayout() {
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(teclasEtiqueta)
								.addContainerGap(207, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(1)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(botaoOK)
												.addGap(81))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(teclaEsquerda, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addGap(18))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(esquerdaEtiqueta)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(baixoEtiqueta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(teclaCima, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(cimaEtiqueta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addComponent(teclaBaixo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(direitaEtiqueta)
													.addComponent(teclaDireita, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
												.addGap(44))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(teclaAguia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
												.addComponent(aguiaEtiqueta))))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(tamanhoLabEtiqueta)
											.addComponent(ModoJogoEtiqueta, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addComponent(dragoesEtiqueta)
											.addComponent(numDragoesEtiqueta))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(numDragoes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
											.addComponent(dragoesAdor, Alignment.LEADING, 0, 111, Short.MAX_VALUE)
											.addComponent(tipoLabirinto, Alignment.LEADING, 0, 111, Short.MAX_VALUE)
											.addComponent(tamanhoLab, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
								.addGap(42))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(25)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ModoJogoEtiqueta)
							.addComponent(tipoLabirinto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tamanhoLabEtiqueta)
							.addComponent(tamanhoLab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(dragoesEtiqueta)
							.addComponent(dragoesAdor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(numDragoesEtiqueta)
							.addComponent(numDragoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(teclasEtiqueta)
								.addGap(31)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(cimaEtiqueta)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(teclaCima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(esquerdaEtiqueta)))
							.addComponent(direitaEtiqueta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(baixoEtiqueta)
							.addComponent(teclaDireita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(teclaEsquerda, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(teclaBaixo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(aguiaEtiqueta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(teclaAguia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botaoOK)
						.addContainerGap())
			);
	}

	/**
	 * Configura os parâmetros do novo jogo: modo de jogo, 
	 * comportamento dos dragões, tamanho do labirinto e número de dragões
	 *  
	 */
	public void configuraJogo(){

		boolean modoAle, dragoesAdo;
		int tamanho, numDrag;

		if (tipoLabirinto.getSelectedItem().toString() == "Aleatório") {
			tamanho = (int) tamanhoLab.getValue();
			modoAle = true;
		} else {
			modoAle = false;
			tamanho = 0;
		}
		if (dragoesAdor.getSelectedItem().toString() == "Sim") {
			dragoesAdo = true;
		} else
			dragoesAdo = false;
		numDrag = (int) numDragoes.getValue();

		lab=new Labirinto(modoAle, tamanho, dragoesAdo, numDrag);
		
		teclas[0]=teclaCima.getText();
		teclas[1]=teclaBaixo.getText();
		teclas[2]=teclaEsquerda.getText();
		teclas[3]=teclaDireita.getText();
		teclas[4]=teclaAguia.getText();
	}
	/**
	 * @return A configuração do jogo
	 */
	public Labirinto getLab() {
		return lab;
	}

	/**
	 * @param lab Altera a configuração do jogo
	 */
	public void setLab(Labirinto lab) {
		this.lab = lab;
	}
	
}
