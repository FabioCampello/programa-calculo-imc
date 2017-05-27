//****************************************************************************************************************************************
/**
 * Autor: F�bio Camp�llo
 * Matricula: 201620240 
 * Disciplina: Linguagens de Programa��o
 * Professor: Francisco Edvan
 * Data: 16/03/2017 Atualiza��o: 24/03/2017
 * 
 * Objetivo da aplica��o: Calcular o �ndice de massa corporal(IMC). Uma aplica��o desktop onde o usu�rio insere seu peso e altura
 * 			 e recebe o valor do seu IMC e a mensagem informando a classifica��o de seu peso. 
 * 
 * Objetivo da classe: Classe que fornece a janela principal do programa onde s�o inseridos os dados do usu�rio.
 * 
 * *******************************************************************************************
 * 											ATUALIZA��ES: 
 * 								Fiz atualiza��es no tratamento de erros.
 * *******************************************************************************************
 * 
 * observa��es: Decidi n�o comentar a outra JFrame, que trata de informa��es do desenvolvedor, pois � um pouco trabalhoso.
 * 				Contudo caso queria posso comentar sem problemas. 
 * 
 */
//****************************************************************************************************************************************
package Imc.ver014;

//-------------------------------------------
// IMPORTANDO AS CLASSES UTILIZADAS NA CLASSE
//-------------------------------------------
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

//*******************************************************************************************************************************
//CLASSE REFERENTE A JANELA PRINCIPAL DO PROGRAMA QUE EXTEND DE JFRAME
// ******************************************************************************************************************************
public class mainWindow extends JFrame {

	// -------------------------------------
	// DECLARA��O DOS COMPONENTES DA JANELA
	// -------------------------------------
	private JPanel contentPane;
	private JFormattedTextField jtfPeso;
	private JTextField jtfAltura;
	private JTextArea jtaResultado;
	private JLabel lblMensagem;
	private MaskFormatter ftmPeso;
	private MaskFormatter ftmAltura;

	// -------------------------------------------------------------------------
	// DECLARA��O DAS VARI�VEIS QUE RECEBERAM OS VALORES INSERIDOS PELO USU�RIO
	// -------------------------------------------------------------------------
	private double kg;
	private double cm;

	// -------------------------------------------------------------------------
	// DECLARANDO E INST�NCIANDO A CLASSE USU�RIO PASSANDO OS VALORES INSERIDOS
	// PELO USU�RIO NO CONSTRUTOR
	// -------------------------------------------------------------------------
	Usuario imc = new Usuario(kg, cm);

	// *******************************************************************************************************************************
	// M�TODO PRINCIPAL QUE INST�NCIA A JENELA PRINCIPAL
	// *******************************************************************************************************************************
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */

	// *******************************************************************************************************************************
	// M�TODO QUE CRIA A JENELA PRINCIPAL
	// *******************************************************************************************************************************
	public mainWindow() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ------------------------------
		// PAINEL PRINCIPAL DA APLICA��O
		// ------------------------------
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 264, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		// ******************************************************************************************************************************
		// LABEL'S DA APLIACA��O
		// ******************************************************************************************************************************

		// -----------------------------
		// LABEL DO T�TULO DA APLICA��O
		// -----------------------------
		JLabel lblCalculoDoImc = new JLabel("Calculo do IMC");
		lblCalculoDoImc.setBounds(90, 11, 104, 17);
		lblCalculoDoImc.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCalculoDoImc);

		// --------------------------------
		// LABEL INFORMA��O PARA O USU�RIO
		// --------------------------------
		JLabel lblDados = new JLabel("Informe os dados abaixo:");
		lblDados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDados.setBounds(56, 75, 190, 14);
		contentPane.add(lblDados);

		// -----------
		// LABEL PESO
		// -----------
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(56, 124, 46, 14);
		contentPane.add(lblPeso);

		// -------------
		// LABEL ALTURA
		// -------------
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(56, 149, 60, 14);
		contentPane.add(lblAltura);

		// ----------------------------------------------------------
		// LABEL RESULTADO QUE INFORMA AO USU�RIO O RESULTADO DO IMC
		// ----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(56, 174, 80, 14);
		contentPane.add(lblNewLabel);

		// -----------------------------------------------------------
		// LABEL QUE EXIBE A MENSAGEM SOBRE SUA CLASSIFICA��O DE PESO
		// -----------------------------------------------------------
		lblMensagem = new JLabel();
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(55, 200, 190, 20);
		contentPane.add(lblMensagem);

		// ---------------------------------
		// LABEL QUE EXIBE A MEDIDA DE PESO
		// ---------------------------------
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(228, 121, 20, 14);
		contentPane.add(lblKg);

		// -----------------------------------
		// LABEL QUE EXIBE A MEDIDA DA ALTURA
		// -----------------------------------
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(228, 146, 20, 14);
		contentPane.add(lblCm);

		// -----------------------------------------
		// LABEL QUE INFORMA A VER��O DO APLICATIVO
		// -----------------------------------------
		JLabel lblVer = new JLabel("ver 0.1.4");
		lblVer.setBounds(234, 246, 60, 14);
		contentPane.add(lblVer);

		// ******************************************************************************************************************************
		// CAMPOS DE ENTRADA DA APLIACA��O
		// ******************************************************************************************************************************

		// -------------------------
		// CAMPO DE ENTRADA DO PESO
		// -------------------------
		ftmPeso = new MaskFormatter("##.#");
		jtfPeso = new JFormattedTextField(ftmPeso);
		ftmPeso.setValidCharacters("0123456789");
		jtfPeso.setHorizontalAlignment(SwingConstants.LEFT);
		jtfPeso.setToolTipText("0.00");
		jtfPeso.setBounds(138, 118, 86, 20);
		contentPane.add(jtfPeso);
		jtfPeso.setColumns(10);

		// ---------------------------
		// CAMPO DE ENTRADA DA ALTURA
		// ---------------------------
		ftmAltura = new MaskFormatter("#.##");
		jtfAltura = new JFormattedTextField(ftmAltura);
		ftmAltura.setValidCharacters("0123456789");
		jtfAltura.setToolTipText("0.00");
		jtfAltura.setBounds(138, 143, 86, 20);
		contentPane.add(jtfAltura);
		jtfAltura.setColumns(10);

		// ******************************************************************************************************************************
		// CAMPOS QUE DE EXIBI��O DE MENSAGENS DA APLIACA��O
		// ******************************************************************************************************************************

		// ----------------------------
		// CAMPO QUE EXIBE O RESULTADO
		// ----------------------------
		jtaResultado = new JTextArea();
		jtaResultado.setText("0.00");
		jtaResultado.setToolTipText("0.00");
		jtaResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtaResultado.setColumns(10);
		jtaResultado.setBounds(138, 171, 86, 20);
		contentPane.add(jtaResultado);

		// ******************************************************************************************************************************
		// BOT�ES DA APLICA��O
		// ******************************************************************************************************************************

		// ---------------------------------------------------------
		// BOT�O SOBRE - QUE TRAZ INFORMA��ES SOBRE O DESENVOLVEDOR
		// ---------------------------------------------------------
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new WindowDeveloper().setVisible(true);// que quer abrir
				dispose();
			}
		});
		btnSobre.setBounds(194, 52, 80, 20);
		contentPane.add(btnSobre);

		// ---------------------------------------------------------
		// BOT�O CALCULAR
		// ---------------------------------------------------------
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(new Color(95, 158, 160));
		btnCalcular.setBounds(107, 231, 89, 23);
		contentPane.add(btnCalcular);

		// ---------------------------------------------------------
		// EVENTO DO BOT�O CALCULAR AO PRESSIONAR A TECLA ENTER
		// ---------------------------------------------------------
		btnCalcular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnCalcular.doClick();
				}
			}
		});

		// -----------------------------------------------
		// EVENTO DO BOT�O CALCULAR AO CLICAR COM O MOUSE
		// -----------------------------------------------
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eventoBotao();

			}
		});

		// ------------------------------------------------------------------
		// CONFIGURANDO POR PADR�O PRESSIONAR O ENTER PARA EFETUAR O C�LCULO
		// ------------------------------------------------------------------
		getRootPane().setDefaultButton(btnCalcular);

	}

	// ******************************************************************************************************************************
	// M�TODO QUE LIMPA OS CAMPOS DE ENTRADA E SA�SA DE INFORMA��ES
	// ******************************************************************************************************************************
	public void limparCampo() throws ParseException {
		jtfPeso.setText("");
		jtfAltura.setText("");
		ftmPeso.stringToValue("");
		ftmAltura.stringToValue("");

	}

	// ******************************************************************************************************************************
	// M�TODO DO EVENTO DO BOT�O CALCULAR
	// ******************************************************************************************************************************
	public void eventoBotao() {

		// --------------------------------------------------------------
		// TRECHO DE CONDICIONAL QUE TRATA DE ERROS DE INSER��O DE DADOS
		// --------------------------------------------------------------
		// -----------------------------------
		// FORMATANDO A SA�DA DO VALOR DO IMC
		// -----------------------------------
		DecimalFormat decimal = new DecimalFormat("#,###.00");

		// -----------------------------------------------------------
		// BLOCO DE TRATAMENTO DE ERRO
		// NO BLOCO TRY S�O CAPTURADOS OS VALORES DOS CAMPOS DE TEXTO
		// -----------------------------------------------------------
		try {
			// ------------------
			// CAPTURANDO O PESO
			// ------------------
			imc.setPeso(Double.parseDouble(jtfPeso.getText()));

			// --------------------
			// CAPTURANDO A ALTURA
			// --------------------
			imc.setAltura(Double.parseDouble(jtfAltura.getText()));

			// -----------------------------------------------------------
			// PASSANDO OS VALORES CAPTURADOS AO M�TODO QUE CALCULA O IMC
			// -----------------------------------------------------------
			imc.calculoImc(imc.getPeso(), imc.getAltura());

			// -----------------------------------
			// EXIBINDO O VALOR NA CAIXA DE TEXTO
			// -----------------------------------
			jtaResultado.setText(String.valueOf(decimal.format(imc.getResultado())));

			// ------------------------------------
			// M�TODO QUE EXIBE O RESULTADO DO IMC
			// ------------------------------------
			exibirResultado();

		}
		// -----------------------------------------------------------------------
		// BLOCO CATCH ONDE � CAPTURADO O ERRO, SE HOUVER E INFORMADO AO
		// USU�RIO.
		// -----------------------------------------------------------------------
		catch (Exception e) {
			
			// ---------------------------------------------------------------------------
			// DECLARA��O DE UMA VARI�VEL STRING QUE RECEBE A CAPTURA DA
			// MENSAGEM DE ERRO
			// ---------------------------------------------------------------------------
			String erro = e.getMessage();

			// -------------------------------------------------------------------------------
			// CONDICIONAL QUE COMPARA O ERRO CAPTURADO COM O VALOR
			// ATRIBU�DO A VARI�VEL ERRO
			// -------------------------------------------------------------------------------
			if (e.getMessage().equals(erro)) {
				// ----------------------------------------------------------
				// JANELA DE MENSAGEM INFORMANDO AO USU�RIO O ERRO OCORRIDO.
				// ----------------------------------------------------------
				JOptionPane.showMessageDialog(null, "Algum campo est� v�zio, preencha-o!");
				decimal = new DecimalFormat("#,##0.00");
			}

		}

	}

	// ******************************************************************************************************************************
	// M�TODO QUE COMPARA O RESULTADO PARA EXIBIR A MENSAGEM AO USU�RIO
	// ******************************************************************************************************************************
	public void exibirResultado() {

		if (imc.getResultado() > 0 && imc.getResultado() <= 17) {
			lblMensagem.setText("Voc� est� muito abaixo do peso!");
		} else if (imc.getResultado() > 17 && imc.getResultado() <= 18.49) {
			lblMensagem.setText("Abaixo do peso!");
		} else if (imc.getResultado() > 18.49 && imc.getResultado() <= 24.99) {
			lblMensagem.setText("Peso normal!");
		} else if (imc.getResultado() > 24.99 && imc.getResultado() <= 29.99) {
			lblMensagem.setText("Acima do peso!");
		} else if (imc.getResultado() > 29.99 && imc.getResultado() <= 34.99) {
			lblMensagem.setText("Obesidade I!");
		} else if (imc.getResultado() > 34.99 && imc.getResultado() <= 39.99) {
			lblMensagem.setText("Obesidade II (severa)!");
		} else if (imc.getResultado() > 40) {
			lblMensagem.setText("Obesidade III (m�rbida)!");
		}
	}
}
