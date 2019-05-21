package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import acao.Acao;
import acao.AcaoEstatisticas;
import beans.Usuario;
import dados.Dados;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;

	// Campos de Text
	private JTextField txtNome;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtIdade;

	private JLabel lblNewLabel;

	// Botoes
	private JButton btnAlterar;
	private JButton btnCadastrar;
	private JButton btnExcluir;

	private JTable tableUsuario;

	private JSeparator separator_1;
	private JScrollPane scrollPane_1;
	private JTable tableEstatisticas;

	// Variavel codigo Usuario
	private static int codigoUsuario;

	// Instanciando classe Acao
	private Acao acao = new Acao();
	private AcaoEstatisticas acaoEst = new AcaoEstatisticas();
	private JButton btnCancelar;

	public Formulario() {

		// Populando o banco de Dados
		acaoEst.popularEstatisticas();

		setTitle("Sistema de IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(34, 28, 48, 14);
		contentPane.add(lblNome);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(34, 79, 48, 14);
		contentPane.add(lblAltura);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(34, 53, 48, 14);
		contentPane.add(lblIdade);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(34, 104, 48, 14);
		contentPane.add(lblPeso);

		txtNome = new JTextField();
		txtNome.setBounds(92, 25, 162, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(92, 76, 96, 20);
		contentPane.add(txtAltura);

		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(92, 104, 96, 20);
		contentPane.add(txtPeso);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(92, 50, 96, 20);
		contentPane.add(txtIdade);

		btnCadastrar = new JButton("Cadastrar");

		// Acao do Metodo Cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando metodo cadastrar
				if (acao.cadastrarUsuario(novoObjeto())) {
					// Limpando Campos
					limparCampos();
				} else {
					txtNome.requestFocus();
				}

			}
		});
		btnCadastrar.setBounds(10, 167, 99, 23);
		contentPane.add(btnCadastrar);

		JPanel panel = new JPanel();
		panel.setBounds(343, 28, 213, 131);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 193, 131);
		panel.add(lblNewLabel);

		// Atribuindo Imagem
		ImageIcon icon = new ImageIcon("\\C:\\Users\\i3i\\Desktop\\IMC.jpeg");
		lblNewLabel.setIcon(icon);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 214, 546, 8);
		contentPane.add(separator);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);

		// Acao do Botao Alterar
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Imc Antigo
				double imc = 0;
				imc = Double.parseDouble(tableUsuario.getValueAt(codigoUsuario, 4).toString());

				// Chamando metodo alterar
				acao.alterarUsuario(novoObjeto(), codigoUsuario, imc);

				// Limpar Campos
				limparCampos();

				// Desabilitando ele mesmo
				btnAlterar.setEnabled(false);

			}
		});
		btnAlterar.setBounds(119, 167, 89, 23);
		contentPane.add(btnAlterar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);

		// Acao do Botao Excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando o metodo
				acao.excluirUsuario(codigoUsuario);

				// limparCampos
				limparCampos();

				// Desabilitando ele mesmo
				btnExcluir.setEnabled(false);
				btnAlterar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnCadastrar.setEnabled(true);
			}
		});
		btnExcluir.setBounds(218, 167, 89, 23);
		contentPane.add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 233, 518, 198);
		contentPane.add(scrollPane);

		tableUsuario = new JTable();

		// Acao do click do mouse na tabela
		tableUsuario.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				// Chamando metodo do Click do Mouse
				clickMouse();

			}
		});
		scrollPane.setViewportView(tableUsuario);

		separator_1 = new JSeparator();
		separator_1.setBounds(10, 442, 546, 8);
		contentPane.add(separator_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 461, 518, 166);
		contentPane.add(scrollPane_1);

		tableEstatisticas = new JTable();
		scrollPane_1.setViewportView(tableEstatisticas);

		btnCancelar = new JButton("Cancelar");

		// Acao do Botao Cancelar

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// limparCampos
				limparCampos();

				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnCadastrar.setEnabled(true);

			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(324, 167, 89, 23);
		contentPane.add(btnCancelar);

		// Atualizando Tabela
		atualizarTabela();

		setResizable(false);
		setLocationRelativeTo(null);
	}

	// Metodo popular Tabela
	private void atualizarTabela() {

		// Atualizando tabela
		tableUsuario.setModel(acao.readUsuario());

		tableEstatisticas.setModel(acaoEst.readEst());
	}

	// Metodo Criar Objeto Usuario
	private Usuario novoObjeto() {

		// Instanciando
		Usuario usuario = new Usuario();

		// Tratativa de Erros geralzona
		try {
			usuario.setNome(txtNome.getText());
			usuario.setIdade(Byte.parseByte(txtIdade.getText()));
			usuario.setPeso(Double.parseDouble(txtPeso.getText()));
			usuario.setAltura(Double.parseDouble(txtAltura.getText()));

			usuario.setImc(acao.calculaImc(usuario.getPeso(), usuario.getAltura()));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valores inseridos inválidos. \nErro: " + e.getMessage());

		}

		return usuario;

	}

	// Metodo Click do Mouse na Tabela
	private void clickMouse() {

		// Pegando o codigo do Usuario
		codigoUsuario = tableUsuario.getSelectedRow();

		// Atribuindo valores
		txtNome.setText(Dados.vetorUsuario.get(codigoUsuario).getNome());
		txtIdade.setText(String.valueOf(Dados.vetorUsuario.get(codigoUsuario).getIdade()));
		txtPeso.setText(String.valueOf(Dados.vetorUsuario.get(codigoUsuario).getPeso()));
		txtAltura.setText(String.valueOf(Dados.vetorUsuario.get(codigoUsuario).getAltura()));

		// Ativando botoes
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnCadastrar.setEnabled(false);

	}

	// Metodo Limpar Campos
	private void limparCampos() {

		// Limpando campos
		txtNome.setText("");
		txtIdade.setText("");
		txtPeso.setText("");
		txtAltura.setText("");

		// Foco
		txtNome.requestFocus();

		// Atualizar Tabela
		atualizarTabela();

	}

}
