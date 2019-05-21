package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import acao.Acao;
import bancoDados.BancoDados;
import beans.Usuarios;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Formulario extends JFrame {

	// Campos Digita��o
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtCadNome;
	private JTextField txtCadSenha;
	private JTextField txtCadConfSenha;
	private JTextField txtCadData;
	private JTextField txtCadLogin;
	private JTextField txtCadEmail;

	// Labels
	private JLabel lbTipoUsuario;
	private JLabel lbNomeUsuario;

	// Botoes
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JButton btnCancelarCadastro;

	// Radio Buttons
	private JRadioButton radioAdministrador;
	private JRadioButton radioNormal;
	private final ButtonGroup btgTipoUsuario = new ButtonGroup();

	// Painel
	private JPanel contentPane;
	private JPanel panelCadastroUsuario;
	private JPanel panelLogin;
	private JPanel panelPrincipal;

	// Instanciar classe Acao
	private Acao acao = new Acao();

	// Instanciando classe LocalDate para utilizar no c�digo
	private LocalDateTime dataAtual = LocalDateTime.now();

	// variaveis estaticas
	private static int codigoUsuarioAlterar;
	private static int tipoUsuario;
	private static int codigoUsuario;

	// Componentes da Tabela

	private JScrollPane scrollPane;
	private JTable tableUsuariosCad;
	private JLabel lblSistemaDeLogin;
	private JButton btnExcluir;
	private JButton btnLogOut;

	public Formulario() {

		// Metodo Cadastrar para facilitar Teste
		popularVetor();

		setTitle("Sistema de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setVisible(false);

		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 266, 174);
		contentPane.add(panelLogin);
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLogin.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validando o Login
				if (acao.validaLogin(txtLogin.getText(), txtSenha.getText())) {

					// Retornando o tipo de Usuario
					if (acao.tipoUsuarioLogin(txtLogin.getText()) == 0) {

						loginUsuarioAdmin();

					} else {
						// Metodo Usuario Normal
						loginUsuarioNormal();
					}
					// Escondendo Login
					panelLogin.setVisible(false);

					// Mostrando tela Principal
					panelPrincipal.setVisible(true);

					// Populando o Campo Text data
					txtCadData.setText(dataAtual.toString());

					// Limpando campos de login
					txtLogin.setText("");
					txtSenha.setText("");

				}

			}

		});
		btnLogin.setBounds(84, 122, 89, 23);
		panelLogin.add(btnLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(84, 28, 158, 20);
		panelLogin.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(84, 73, 158, 20);
		panelLogin.add(txtSenha);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(26, 31, 48, 14);
		panelLogin.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(26, 76, 48, 14);
		panelLogin.add(lblSenha);
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrincipal.setBounds(10, 11, 688, 482);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 277, 688, 205);
		panelPrincipal.add(scrollPane);

		tableUsuariosCad = new JTable();

		// Acao do Click do Mouse na Tabela
		tableUsuariosCad.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				clickTabela();

			}

		});
		scrollPane.setViewportView(tableUsuariosCad);

		// Metodo Atualizar table
		tableUsuariosCad.setModel(acao.retornarUsuario());

		panelCadastroUsuario = new JPanel();
		panelCadastroUsuario.setBounds(0, 27, 688, 251);
		panelPrincipal.add(panelCadastroUsuario);
		panelCadastroUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCadastroUsuario.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(33, 23, 48, 14);
		panelCadastroUsuario.add(lblNewLabel_1);

		JLabel lblSenha_1 = new JLabel("Senha:");
		lblSenha_1.setBounds(33, 108, 40, 14);
		panelCadastroUsuario.add(lblSenha_1);

		JLabel lblConfSenha = new JLabel("Conf Senha:");
		lblConfSenha.setBounds(10, 140, 89, 14);
		panelCadastroUsuario.add(lblConfSenha);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(40, 165, 31, 14);
		panelCadastroUsuario.add(lblData);

		txtCadNome = new JTextField();
		txtCadNome.setBounds(81, 20, 204, 20);
		panelCadastroUsuario.add(txtCadNome);
		txtCadNome.setColumns(10);

		txtCadSenha = new JTextField();
		txtCadSenha.setColumns(10);
		txtCadSenha.setBounds(81, 105, 204, 20);
		panelCadastroUsuario.add(txtCadSenha);

		txtCadConfSenha = new JTextField();
		txtCadConfSenha.setColumns(10);
		txtCadConfSenha.setBounds(81, 137, 204, 20);
		panelCadastroUsuario.add(txtCadConfSenha);

		txtCadData = new JTextField();
		txtCadData.setEditable(false);
		txtCadData.setColumns(10);
		txtCadData.setBounds(81, 165, 205, 20);
		panelCadastroUsuario.add(txtCadData);

		btnCadastrar = new JButton("Cadastrar");

		// Acao do Botao Cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando Metodo com os Dados
				if (acao.cadastrarUsuario(objetoUsuario()) == true) {
					limparTela();
				} else {
					txtCadNome.requestFocus();
				}

			}
		});
		btnCadastrar.setBounds(554, 32, 99, 23);
		panelCadastroUsuario.add(btnCadastrar);

		btnCancelarCadastro = new JButton("Cancelar");
		btnCancelarCadastro.setEnabled(false);

		// Implementacao do Botao Cancelar
		btnCancelarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Limpando a tela
				limparTela();
			}
		});
		btnCancelarCadastro.setBounds(554, 183, 99, 23);
		panelCadastroUsuario.add(btnCancelarCadastro);

		txtCadLogin = new JTextField();
		txtCadLogin.setColumns(10);
		txtCadLogin.setBounds(81, 48, 204, 20);
		panelCadastroUsuario.add(txtCadLogin);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(33, 51, 48, 14);
		panelCadastroUsuario.add(lblLogin);

		txtCadEmail = new JTextField();
		txtCadEmail.setColumns(10);
		txtCadEmail.setBounds(81, 79, 204, 20);
		panelCadastroUsuario.add(txtCadEmail);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(33, 83, 48, 14);
		panelCadastroUsuario.add(lblEmail);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setBounds(23, 192, 72, 14);
		panelCadastroUsuario.add(lblUsurio);

		radioAdministrador = new JRadioButton("Administrador");
		btgTipoUsuario.add(radioAdministrador);
		radioAdministrador.setBounds(79, 187, 109, 23);
		panelCadastroUsuario.add(radioAdministrador);

		radioNormal = new JRadioButton("Normal");
		radioNormal.setSelected(true);
		btgTipoUsuario.add(radioNormal);
		radioNormal.setBounds(190, 187, 109, 23);
		panelCadastroUsuario.add(radioNormal);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);

		// Implementacao do Botao Alterar
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarDados();
			}

		});
		btnAlterar.setBounds(554, 78, 99, 23);
		panelCadastroUsuario.add(btnAlterar);

		lbNomeUsuario = new JLabel("New label");
		lbNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbNomeUsuario.setBounds(295, 11, 192, 14);
		panelCadastroUsuario.add(lbNomeUsuario);

		lbTipoUsuario = new JLabel("New label");
		lbTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbTipoUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbTipoUsuario.setBounds(295, 36, 192, 14);
		panelCadastroUsuario.add(lbTipoUsuario);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);

		// Implementacao do Botao Excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando o metodo de exclusao
				if (acao.excluirUsuario(codigoUsuarioAlterar)) {

					// metodo Limpar tela
					limparTela();

				}

			}
		});
		btnExcluir.setBounds(554, 127, 99, 23);
		panelCadastroUsuario.add(btnExcluir);

		lblSistemaDeLogin = new JLabel("SISTEMA DE LOGIN DO YURI");
		lblSistemaDeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSistemaDeLogin.setBounds(0, 0, 688, 25);
		panelPrincipal.add(lblSistemaDeLogin);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(566, 2, 99, 23);

		// Implementacao do LogOut
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sair do Sistema
				setBounds(100, 100, 282, 213);

				// Mostrando painel login
				panelLogin.setVisible(true);

				// Escondendo painel Principal
				panelPrincipal.setVisible(false);
			}
		});

		panelPrincipal.add(btnLogOut);
	}

	// Populando o Vetor para facilitar Testes
	public void popularVetor() {

		Usuarios new01 = new Usuarios();
		new01.setNome("Ralf");
		new01.setLogin("Ralf123");
		new01.setTipoUsuario(0);
		new01.setSenha("senhaRalf", "senhaRalf");
		new01.setEmail("ralf@gmail.com");
		new01.setDataCadastro(dataAtual);

		Usuarios new02 = new Usuarios();
		new02.setNome("Yuri");
		new02.setLogin("Yuri123");
		new02.setTipoUsuario(1);
		new02.setSenha("senhaYuri", "senhaYuri");
		new02.setEmail("yuri@gmail.com");
		new02.setDataCadastro(dataAtual);

		Usuarios new03 = new Usuarios();
		new03.setNome("Juninho");
		new03.setLogin("123");
		new03.setTipoUsuario(0);
		new03.setSenha("123", "123");
		new03.setEmail("juninho@gmail.com");
		new03.setDataCadastro(dataAtual);

		acao.cadastrarUsuario(new01);
		acao.cadastrarUsuario(new02);
		acao.cadastrarUsuario(new03);
	}

	// Metodo para Criar Novo Objeto Usuario
	private Usuarios objetoUsuario() {

		Usuarios newUsuario = new Usuarios();
		newUsuario.setNome(txtCadNome.getText());
		newUsuario.setLogin(txtCadLogin.getText());
		newUsuario.setSenha(txtCadSenha.getText(), txtCadConfSenha.getText());
		newUsuario.setEmail(txtCadEmail.getText());
		newUsuario.setTipoUsuario((radioAdministrador.isSelected() ? 0 : 1));
		newUsuario.setDataCadastro(dataAtual);

		return newUsuario;
	}

	// Metodo para Deixar a Tela OK
	private void limparTela() {

		// Campos cadastro
		txtCadNome.setText("");
		txtCadConfSenha.setText("");
		txtCadEmail.setText("");
		txtCadLogin.setText("");
		txtCadSenha.setText("");

		// requesto focus no nome
		txtCadNome.requestFocus();

		// Atualizando table
		tableUsuariosCad.clearSelection();
		tableUsuariosCad.setModel(acao.retornarUsuario());

		// Bloqueando os botoes
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnCancelarCadastro.setEnabled(false);
	}

	// Metodo para quando o Login for realizado por um usuario Normal
	private void loginUsuarioNormal() {
		// Se o usuario for do tipo normal
		tipoUsuario = 1;
		codigoUsuario = acao.codigoUsuario();

		// Populando Mensagem boas Vindas
		lbNomeUsuario.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getNome());
		lbTipoUsuario.setText("Usu�rio Normal");

		// Definindo Campos para atualiza��o
		txtCadNome.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getNome());
		txtCadLogin.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getLogin());
		txtCadEmail.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getEmail());
		txtCadSenha.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getSenha());
		txtCadConfSenha.setText(txtCadSenha.getText());
		txtCadData.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getDataCadastro().toString());

		// Desabilitando o botao Cadastrar e habilitadno o alterar
		btnCadastrar.setEnabled(false);
		btnAlterar.setEnabled(true);

		// Bloqueando radioButtons
		radioAdministrador.setEnabled(false);
		radioNormal.setEnabled(false);

		// Deixando os Bounds Corretos
		setBounds(100, 100, 722, 537);
	}

	// Metodo para quando um administrador fizer login no sistema
	private void loginUsuarioAdmin() {
		// Se o usuario for do tipo Administrador
		tipoUsuario = 0;

		// Retornando o Codigo do Usuario
		codigoUsuario = acao.codigoUsuario();

		// Incluindo Mensagem de Boas Vindas
		lbNomeUsuario.setText(BancoDados.vetorUsuarios.get(codigoUsuario).getNome());
		lbTipoUsuario.setText("Administrador");

		// Deixando os Bounds Corretos
		setBounds(100, 100, 722, 537);

		// Habilitando o botao Cadastrar e habilitadno o alterar
		btnCadastrar.setEnabled(true);
		btnAlterar.setEnabled(false);

		// Bloqueando radioButtons
		radioAdministrador.setEnabled(true);
		radioNormal.setEnabled(true);
	}

	// quando a tabela for clicada
	private void clickTabela() {

		// Verificando o tipo de Usuario
		if (tipoUsuario == 0) {

			// Retornando o valor do Index do Usuario
			codigoUsuarioAlterar = tableUsuariosCad.getSelectedRow();

			// Verificando qual usuario o administrador deseja alterar
			if ("Administrador".equals(tableUsuariosCad.getValueAt(codigoUsuarioAlterar, 4))) {

				limparTela();

			} else {

				// Populando campos de Alteracao
				txtCadNome.setText(tableUsuariosCad.getValueAt(codigoUsuarioAlterar, 0).toString());
				txtCadLogin.setText(tableUsuariosCad.getValueAt(codigoUsuarioAlterar, 1).toString());
				txtCadEmail.setText(tableUsuariosCad.getValueAt(codigoUsuarioAlterar, 2).toString());
				txtCadSenha.setText(BancoDados.vetorUsuarios.get(codigoUsuarioAlterar).getSenha());
				txtCadConfSenha.setText(txtCadSenha.getText());
				txtCadData.setText(tableUsuariosCad.getValueAt(codigoUsuarioAlterar, 3).toString());

				radioNormal.setSelected(true);

				// Ativando os Botoes para Manipulacao
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelarCadastro.setEnabled(true);

			}
		}

	}

	// Metodo Alterar Dados
	private void alterarDados() {

		// Verificando se o usuario logado � administrador
		if (tipoUsuario == 0) {

			// Verificando altera��es no JTextField
			// txtCadNome.is

			// Chamando o metodo Alterar e objetoUsuario
			if (acao.updateUsuario(codigoUsuarioAlterar, objetoUsuario()) == true) {

				// Limpando os campos
				limparTela();
			}
			// Se for um usuario normal, apenas alterou os seus dados
		} else {
			if (acao.updateUsuario(codigoUsuario, objetoUsuario())) {

				// Atualizando Tabela
				tableUsuariosCad.setModel(acao.retornarUsuario());
				loginUsuarioNormal();

			}
		}
	}
}
