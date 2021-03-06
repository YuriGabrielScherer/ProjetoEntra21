package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTable tableProduto;
	private JScrollPane scrollPane;

	// String para msg botao
	private String botao = "Finalizar - ";

	// instanciando a classe acao
	private Acao acao = new Acao();

	public Formulario() {

		// Populando o vetor Produtos
		acao.popularVetor();

		setTitle("Sistema da Prova N\u00FAmero 4 do Yuri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProd01 = new JLabel("Camisa Amarela");
		lblProd01.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd01.setBounds(34, 53, 92, 36);
		contentPane.add(lblProd01);

		JButton btnProdAum1 = new JButton("+");

		btnProdAum1.setBounds(34, 95, 41, 23);
		contentPane.add(btnProdAum1);

		JButton btnProdDimi1 = new JButton("-");

		btnProdDimi1.setBounds(85, 95, 41, 23);
		contentPane.add(btnProdDimi1);

		JLabel lblProd02 = new JLabel("Camisa Verde");
		lblProd02.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd02.setBounds(34, 144, 92, 36);
		contentPane.add(lblProd02);

		JButton btnProdDimi2 = new JButton("-");

		btnProdDimi2.setBounds(85, 186, 41, 23);
		contentPane.add(btnProdDimi2);

		JButton btnProdAum2 = new JButton("+");

		btnProdAum2.setBounds(34, 186, 41, 23);
		contentPane.add(btnProdAum2);

		JLabel lblProd03 = new JLabel("Carro Gol");
		lblProd03.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd03.setBounds(162, 53, 92, 36);
		contentPane.add(lblProd03);

		JButton btnProdAum3 = new JButton("+");

		btnProdAum3.setBounds(162, 95, 41, 23);
		contentPane.add(btnProdAum3);

		JButton btnProdDimi3 = new JButton("-");

		btnProdDimi3.setBounds(213, 95, 41, 23);
		contentPane.add(btnProdDimi3);

		JLabel lblProd04 = new JLabel("Edif�cio Master");
		lblProd04.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd04.setBounds(162, 144, 92, 36);
		contentPane.add(lblProd04);

		JButton btnProdAum4 = new JButton("+");

		JButton btnProdDimi4 = new JButton("-");
		btnProdDimi4.setBounds(213, 186, 41, 23);
		contentPane.add(btnProdDimi4);

		btnProdAum4.setBounds(162, 186, 41, 23);
		contentPane.add(btnProdAum4);

		JLabel lblProd05 = new JLabel("Cal�a Preta");
		lblProd05.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd05.setBounds(292, 53, 92, 36);
		contentPane.add(lblProd05);

		JButton btnProdAum5 = new JButton("+");

		btnProdAum5.setBounds(292, 95, 41, 23);
		contentPane.add(btnProdAum5);

		JButton btnProdDimi5 = new JButton("-");

		btnProdDimi5.setBounds(343, 95, 41, 23);
		contentPane.add(btnProdDimi5);

		JLabel lblProd06 = new JLabel("Cal�a Amarela");
		lblProd06.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd06.setBounds(292, 144, 92, 36);
		contentPane.add(lblProd06);

		JButton btnProdDimi6 = new JButton("-");

		btnProdDimi6.setBounds(343, 186, 41, 23);
		contentPane.add(btnProdDimi6);

		JButton btnProdAum6 = new JButton("+");

		btnProdAum6.setBounds(292, 186, 41, 23);
		contentPane.add(btnProdAum6);

		JLabel lblProd07 = new JLabel("Perfume Kaiak");
		lblProd07.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd07.setBounds(433, 53, 92, 36);
		contentPane.add(lblProd07);

		JButton btnProdAum7 = new JButton("+");

		btnProdAum7.setBounds(433, 95, 41, 23);
		contentPane.add(btnProdAum7);

		JButton btnProdDimi7 = new JButton("-");

		btnProdDimi7.setBounds(484, 95, 41, 23);
		contentPane.add(btnProdDimi7);

		JLabel lblProd08 = new JLabel("Poltrona Sof�");
		lblProd08.setHorizontalAlignment(SwingConstants.CENTER);
		lblProd08.setBounds(433, 144, 92, 36);
		contentPane.add(lblProd08);

		JButton btnProdAum8 = new JButton("+");

		btnProdAum8.setBounds(433, 186, 41, 23);
		contentPane.add(btnProdAum8);

		JButton btnProdDimi8 = new JButton("-");

		btnProdDimi8.setBounds(484, 186, 41, 23);
		contentPane.add(btnProdDimi8);

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 257, 495, 2);
		contentPane.add(separator);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 294, 495, 223);
		contentPane.add(scrollPane);

		tableProduto = new JTable();
		scrollPane.setViewportView(tableProduto);

		// Atualizando table
		tableProduto.setModel(acao.readProduto());

		JButton btnFinalizar = new JButton(botao + "Prod");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Pedido finalizado.");

				// Exibindo os dados
				scrollPane.setVisible(true);

			}
		});
		btnFinalizar.setBounds(376, 11, 128, 42);
		contentPane.add(btnFinalizar);
		setResizable(false);
		setLocationRelativeTo(null);

		// -------
		// ACOES DOS BOTOES
		// -----------

		// Acao do Botao Add Prod 01
		btnProdAum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem(lblProd01.getText());
			}
		});

		// Acao do botao tirar Prod 01
		btnProdDimi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tirarItem(lblProd01.getText());
			}
		});

		// Acao do botao retirar do Prod 02
		btnProdDimi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tirarItem(lblProd02.getText());
			}
		});

		// Acao do botao Add Prod 2
		btnProdAum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem(lblProd02.getText());
			}
		});

		// Acao add prod 03
		btnProdAum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd03.getText());

			}
		});

		// Acao do botao retirar prod 03
		btnProdDimi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd03.getText());

			}
		});

		// Acao add Prod 04
		btnProdAum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd04.getText());

			}
		});

		// Acao Retirar do Prod 04
		btnProdDimi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd04.getText());

			}
		});

		// Acao do Botao Tirar Prod05
		btnProdDimi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd05.getText());

			}
		});

		// Acao do Botao Add Prod05
		btnProdAum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd05.getText());

			}
		});

		// acao do botao retirar prod 06
		btnProdDimi6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd06.getText());

			}
		});

		// Acao do Botao add prod06
		btnProdAum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd06.getText());

			}
		});

		// Acao do Botao Add Prod07
		btnProdAum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd07.getText());

			}
		});

		// Acao do Botao Retirar Produto
		btnProdDimi7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd07.getText());

			}
		});

		// Acao do Botao Add Item 08
		btnProdAum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addItem(lblProd08.getText());

			}
		});

		// Acao do botao diminuir prod 08
		btnProdDimi8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tirarItem(lblProd08.getText());

			}
		});

	}

	// metodo para adicionar item
	private void addItem(String nome) {

		// Adicionando produto
		acao.addProduto(nome);

		// Atualizando table
		tableProduto.setModel(acao.readProduto());

	}

	// Metodo para decrementar item
	private void tirarItem(String nome) {

		// retirando produto
		acao.tirarProduto(nome);

		// Atualizando table
		tableProduto.setModel(acao.readProduto());

	}
}
