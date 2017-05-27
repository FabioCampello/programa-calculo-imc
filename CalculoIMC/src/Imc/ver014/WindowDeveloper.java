package Imc.ver014;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class WindowDeveloper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDeveloper frame = new WindowDeveloper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowDeveloper() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setLocationRelativeTo(null);  
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 264, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCalculoDoImc = new JLabel("Calculo do IMC");
		lblCalculoDoImc.setBounds(90, 11, 104, 17);
		lblCalculoDoImc.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCalculoDoImc);
		
		JButton btnVoltar = new JButton("Voltar");
		
		//CONFIGURANDO PO PADRÃO PRESSIONAR O ENTER
		getRootPane().setDefaultButton(btnVoltar);
		
		//EVENTO DO BOTÃO CALCULAR AO PRESSIONAR A TECLA ENTER
		btnVoltar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnVoltar.doClick();
				}
			}
		});
		
		//EVENTO DO BOTÃO CALCULAR AO CLICAR COM O MOUSE
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			    try {
					new mainWindow().setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//que quer abrir
			     dispose();
			   }
		});
		btnVoltar.setBackground(new Color(95, 158, 160));
		btnVoltar.setBounds(99, 207, 89, 23);
		contentPane.add(btnVoltar);
		
		JTextArea txtInfo = new JTextArea("Atividade proposta em sala de aula. 					Disciplina de Linguangens de Programa\u00E7\u00E3o. 			Desenvolvido por : F\u00E1bio Camp\u00EAllo");
		txtInfo.setAlignmentY(CENTER_ALIGNMENT);
		txtInfo.setTabSize(10);
		txtInfo.setEditable(false);
		txtInfo.setWrapStyleWord(true);
		txtInfo.setLineWrap(true);
		
		txtInfo.setBounds(10, 77, 264, 119);
		contentPane.add(txtInfo);
	}
}
