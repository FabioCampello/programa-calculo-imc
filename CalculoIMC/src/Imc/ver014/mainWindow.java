//****************************************************************************************************************************************
/**
 * Autor: Fábio Campêllo
 * Matricula: 201620240 
 * Disciplina: Linguagens de Programação
 * Professor: Francisco Edvan
 * Data: 16/03/2017 Atualização: 24/03/2017
 * 
 * Objetivo da aplicação: Calcular o índice de massa corporal(IMC). Uma aplicação desktop onde o usuário insere seu peso e altura
 * 			 e recebe o valor do seu IMC e a mensagem informando a classificação de seu peso. 
 * 
 * Objetivo da classe: Classe que fornece a janela principal do programa onde são inseridos os dados do usuário.
 * 
 * *******************************************************************************************
 * 											ATUALIZAÇÕES: 
 * 								Fiz atualizações no tratamento de erros.
 * *******************************************************************************************
 * 
 * observações: Decidi não comentar a outra JFrame, que trata de informações do desenvolvedor, pois é um pouco trabalhoso.
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
	// DECLARAÇÃO DOS COMPONENTES DA JANELA
	// -------------------------------------
	private JPanel contentPane;
	private JFormattedTextField jtfPeso;
	private JTextField jtfAltura;
	private JTextArea jtaResultado;
	private JLabel lblMensagem;
	private MaskFormatter ftmPeso;
	private MaskFormatter ftmAltura;

	// -------------------------------------------------------------------------
	// DECLARAÇÃO DAS VARIÁVEIS QUE RECEBERAM OS VALORES INSERIDOS PELO USUÁRIO
	// -------------------------------------------------------------------------
	private double kg;
	private double cm;

	// -------------------------------------------------------------------------
	// DECLARANDO E INSTÂNCIANDO A CLASSE USUÁRIO PASSANDO OS VALORES INSERIDOS
	// PELO USUÁRIO NO CONSTRUTOR
	// -------------------------------------------------------------------------
	Usuario imc = new Usuario(kg, cm);

	// *******************************************************************************************************************************
	// MÉTODO PRINCIPAL QUE INSTÂNCIA A JENELA PRINCIPAL
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
	// MÉTODO QUE CRIA A JENELA PRINCIPAL
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
		// PAINEL PRINCIPAL DA APLICAÇÃO
		// ------------------------------
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 11, 264, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		// ******************************************************************************************************************************
		// LABEL'S DA APLIACAÇÃO
		// ******************************************************************************************************************************

		// -----------------------------
		// LABEL DO TÍTULO DA APLICAÇÃO
		// -----------------------------
		JLabel lblCalculoDoImc = new JLabel("Calculo do IMC");
		lblCalculoDoImc.setBounds(90, 11, 104, 17);
		lblCalculoDoImc.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblCalculoDoImc);

		// --------------------------------
		// LABEL INFORMAÇÃO PARA O USUÁRIO
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
		// LABEL RESULTADO QUE INFORMA AO USUÁRIO O RESULTADO DO IMC
		// ----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(56, 174, 80, 14);
		contentPane.add(lblNewLabel);

		// -----------------------------------------------------------
		// LABEL QUE EXIBE A MENSAGEM SOBRE SUA CLASSIFICAÇÃO DE PESO
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
		// LABEL QUE INFORMA A VERÇÃO DO APLICATIVO
		// -----------------------------------------
		JLabel lblVer = new JLabel("ver 0.1.4");
		lblVer.setBounds(234, 246, 60, 14);
		contentPane.add(lblVer);

		// ******************************************************************************************************************************
		// CAMPOS DE ENTRADA DA APLIACAÇÃO
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
		// CAMPOS QUE DE EXIBIÇÃO DE MENSAGENS DA APLIACAÇÃO
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
		// BOTÕES DA APLICAÇÃO
		// ******************************************************************************************************************************

		// ---------------------------------------------------------
		// BOTÃO SOBRE - QUE TRAZ INFORMAÇÕES SOBRE O DESENVOLVEDOR
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
		// BOTÃO CALCULAR
		// ---------------------------------------------------------
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(new Color(95, 158, 160));
		btnCalcular.setBounds(107, 231, 89, 23);
		contentPane.add(btnCalcular);

		// ---------------------------------------------------------
		// EVENTO DO BOTÃO CALCULAR AO PRESSIONAR A TECLA ENTER
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
		// EVENTO DO BOTÃO CALCULAR AO CLICAR COM O MOUSE
		// -----------------------------------------------
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eventoBotao();

			}
		});

		// ------------------------------------------------------------------
		// CONFIGURANDO POR PADRÃO PRESSIONAR O ENTER PARA EFETUAR O CÁLCULO
		// ------------------------------------------------------------------
		getRootPane().setDefaultButton(btnCalcular);

	}

	// ******************************************************************************************************************************
	// MÉTODO QUE LIMPA OS CAMPOS DE ENTRADA E SAÍSA DE INFORMAÇÕES
	// ******************************************************************************************************************************
	public void limparCampo() throws ParseException {
		jtfPeso.setText("");
		jtfAltura.setText("");
		ftmPeso.stringToValue("");
		ftmAltura.stringToValue("");

	}

	// ******************************************************************************************************************************
	// MÉTODO DO EVENTO DO BOTÃO CALCULAR
	// ******************************************************************************************************************************
	public void eventoBotao() {

		// --------------------------------------------------------------
		// TRECHO DE CONDICIONAL QUE TRATA DE ERROS DE INSERÇÃO DE DADOS
		// --------------------------------------------------------------
		// -----------------------------------
		// FORMATANDO A SAÍDA DO VALOR DO IMC
		// -----------------------------------
		DecimalFormat decimal = new DecimalFormat("#,###.00");

		// -----------------------------------------------------------
		// BLOCO DE TRATAMENTO DE ERRO
		// NO BLOCO TRY SÃO CAPTURADOS OS VALORES DOS CAMPOS DE TEXTO
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
			// PASSANDO OS VALORES CAPTURADOS AO MÉTODO QUE CALCULA O IMC
			// -----------------------------------------------------------
			imc.calculoImc(imc.getPeso(), imc.getAltura());

			// -----------------------------------
			// EXIBINDO O VALOR NA CAIXA DE TEXTO
			// -----------------------------------
			jtaResultado.setText(String.valueOf(decimal.format(imc.getResultado())));

			// ------------------------------------
			// MÉTODO QUE EXIBE O RESULTADO DO IMC
			// ------------------------------------
			exibirResultado();

		}
		// -----------------------------------------------------------------------
		// BLOCO CATCH ONDE É CAPTURADO O ERRO, SE HOUVER E INFORMADO AO
		// USUÁRIO.
		// -----------------------------------------------------------------------
		catch (Exception e) {
			
			// ---------------------------------------------------------------------------
			// DECLARAÇÃO DE UMA VARIÁVEL STRING QUE RECEBE A CAPTURA DA
			// MENSAGEM DE ERRO
			// ---------------------------------------------------------------------------
			String erro = e.getMessage();

			// -------------------------------------------------------------------------------
			// CONDICIONAL QUE COMPARA O ERRO CAPTURADO COM O VALOR
			// ATRIBUÍDO A VARIÁVEL ERRO
			// -------------------------------------------------------------------------------
			if (e.getMessage().equals(erro)) {
				// ----------------------------------------------------------
				// JANELA DE MENSAGEM INFORMANDO AO USUÁRIO O ERRO OCORRIDO.
				// ----------------------------------------------------------
				JOptionPane.showMessageDialog(null, "Algum campo está vázio, preencha-o!");
				decimal = new DecimalFormat("#,##0.00");
			}

		}

	}

	// ******************************************************************************************************************************
	// MÉTODO QUE COMPARA O RESULTADO PARA EXIBIR A MENSAGEM AO USUÁRIO
	// ******************************************************************************************************************************
	public void exibirResultado() {

		if (imc.getResultado() > 0 && imc.getResultado() <= 17) {
			lblMensagem.setText("Você está muito abaixo do peso!");
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
			lblMensagem.setText("Obesidade III (mórbida)!");
		}
	}
}
