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


public class Opcoes extends JFrame{
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
	
	
	public Opcoes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Configura\u00E7\u00F5es");
		setResizable(false);
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
				setVisible(false);
				dispose();
			}
		});
		
		configuraEtiquetas();
		
		groupLayout = new GroupLayout(getContentPane());
		configuraGrouplayout();
		getContentPane().setLayout(groupLayout);
		
	}

	
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
		
		cimaEtiqueta = new JLabel("Cima: \"seta cima\" ou \"w\"");
		
		baixoEtiqueta = new JLabel("Baixo: \"seta baixo\" ou \"s\"");
		
		esquerdaEtiqueta = new JLabel("Esquerda: \"seta esquerda\" ou \"a\"");
		
		direitaEtiqueta = new JLabel("Direita: \"seta direita\" ou \"d\"");
		
		aguiaEtiqueta = new JLabel("\u00C1guia: \"espa\u00E7o\" ou \"g\"");
		
	}

	private void configuraGrouplayout() {
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(cimaEtiqueta)
								.addContainerGap(173, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(baixoEtiqueta)
								.addContainerGap(168, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(direitaEtiqueta)
								.addContainerGap(158, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(aguiaEtiqueta)
								.addContainerGap(182, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(botaoOK)
									.addComponent(esquerdaEtiqueta))
								.addContainerGap(129, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(teclasEtiqueta)
								.addContainerGap(207, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
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
									.addComponent(tamanhoLab, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
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
						.addComponent(teclasEtiqueta)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(cimaEtiqueta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(baixoEtiqueta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(esquerdaEtiqueta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(direitaEtiqueta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(aguiaEtiqueta)
						.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
						.addComponent(botaoOK)
						.addContainerGap())
			);
	}

	public Labirinto configuraJogo(){

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


		return(new Labirinto(modoAle, tamanho, dragoesAdo, numDrag));
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
