package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;
import beans.Generos;
import beans.Jogos;
import beans.Plataforma;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	// Declara��o dos Bot�es
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnEstatisticas;

	private JPanel contentPane;
	private JTextField txtNomeJogo;
	private JTextField txtClassificacao;
	private JTextField txtValor;
	private JComboBox<Generos> cbbGenero;
	private JComboBox<Plataforma> cbbPlataforma;
	private final JSeparator separator = new JSeparator();
	private JTable table;

	// Indice Est�tico para o indice do Campo
	private static int codigoJogo;

	// Instanciando a acao para utilizar os seus componentes
	Acao acao = new Acao();

	Plataforma plataforma = new Plataforma();
	Generos genero = new Generos();

	public Formulario() {

		// Populando generos e plataformas
		plataforma.cadastrarPlataformas();
		genero.cadastrarGeneros();

		// Chamando m�todo para facilitar os testes
		teste();

		setTitle("Sistema de Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Jogos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(153, 11, 131, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome do Jogo:");
		lblNewLabel_1.setBounds(26, 50, 107, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setBounds(63, 79, 79, 14);
		contentPane.add(lblGnero);

		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setBounds(44, 112, 85, 14);
		contentPane.add(lblPlataforma);

		JLabel lblClassificaoIndicativa = new JLabel("Classifica\u00E7\u00E3o Ind.:");
		lblClassificaoIndicativa.setBounds(8, 147, 123, 14);
		contentPane.add(lblClassificaoIndicativa);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(74, 176, 59, 14);
		contentPane.add(lblValor);

		txtNomeJogo = new JTextField();
		txtNomeJogo.setBounds(115, 49, 216, 20);
		contentPane.add(txtNomeJogo);
		txtNomeJogo.setColumns(10);

		cbbGenero = new JComboBox<Generos>();
		cbbGenero.setModel(genero.dadosGenero());
		cbbGenero.setBounds(115, 78, 143, 22);
		contentPane.add(cbbGenero);

		cbbPlataforma = new JComboBox<Plataforma>();
		// Retornando os dados da Plataforma para o Combo Box
		cbbPlataforma.setModel(plataforma.dadosPlataforma());
		cbbPlataforma.setSelectedIndex(0);
		cbbPlataforma.setBounds(115, 109, 143, 22);
		contentPane.add(cbbPlataforma);

		txtClassificacao = new JTextField();
		txtClassificacao.setColumns(10);
		txtClassificacao.setBounds(115, 145, 72, 20);
		contentPane.add(txtClassificacao);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(115, 173, 72, 20);
		contentPane.add(txtValor);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Efetuando o Cadastro
				if (acao.cadastrar(novoJogo()) == true) {

					// Chamando o Metodo para deixar a tela OK
					limparCampos();
				} else {
					// Requerendo foco no nome do Jogo
					txtNomeJogo.requestFocus();
				}

			}
		});
		btnCadastrar.setBounds(394, 48, 95, 23);
		contentPane.add(btnCadastrar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			// Implementa��o do Botao Alterar
			public void actionPerformed(ActionEvent e) {

				// Realizando a alteracao
				acao.updateJogos(codigoJogo, novoJogo());

				// M�todo Limpar Campos
				limparCampos();

			}
		});
		btnAlterar.setBounds(394, 79, 95, 23);
		contentPane.add(btnAlterar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			// Implementar o Bot�o Excluir
			public void actionPerformed(ActionEvent e) {

				// Excluindo
				acao.excluirJogo(codigoJogo);

				// Deixando a tela normal
				limparCampos();

			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(394, 112, 95, 23);
		contentPane.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(394, 147, 95, 23);
		contentPane.add(btnCancelar);

		// Acao do Botao Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamando m�todo para limpar os Campos
				limparCampos();

				// Desabilitando os Botoes
				telaCadastro();

			}
		});

		btnEstatisticas = new JButton("Estatisticas");
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Mostrando as estatisticas
				acao.retornaPlataforma();
				acao.retornaGeneros();

			}
		});
		btnEstatisticas.setBounds(394, 172, 105, 23);
		contentPane.add(btnEstatisticas);
		separator.setBounds(0, 204, 524, 31);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(358, 36, 9, 154);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(26, 226, 463, 224);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				// Obter o indice da linha selecionada
				int linha = table.getSelectedRow();

				// Atribuindo c�digo do Jogo � sua vari�vel
				codigoJogo = linha;

				// Populando os componentes da Tabela
				txtNomeJogo.setText(table.getValueAt(linha, 0).toString());
				txtClassificacao.setText(table.getValueAt(linha, 3).toString());
				txtValor.setText(table.getValueAt(linha, 4).toString());

				// Precisa fazer um get na Classe Plataforma
				cbbGenero.setSelectedIndex(0);
				// Precisa fazer um get na Classe Generos
				cbbPlataforma.setSelectedIndex(0);

				// Focus no Nome do Jogo
				txtNomeJogo.requestFocus();

				telaAlteracao();

			}

		});

		table.setModel(acao.readJogo());

		scrollPane.setViewportView(table);
	}

	// M�todo para limpar os campos
	private void limparCampos() {

		// Limpando campos
		txtNomeJogo.setText("");
		txtValor.setText("");
		txtClassificacao.setText("");

		cbbGenero.setSelectedIndex(-1);
		cbbPlataforma.setSelectedIndex(-1);

		// Deixando a tabela atualizada
		table.setModel(acao.readJogo());

		// Tirando sele��o da Tabela
		table.clearSelection();

		// Foco no Nome Jogo
		txtNomeJogo.requestFocus();

		// M�todo para deixar a tela em forma de Cadastro
		telaCadastro();
	}

	// M�todo para deixar a tela em Modo Altera��o
	private void telaAlteracao() {
		// Habilitando botoes para o usuario
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnCadastrar.setEnabled(false);
	}

	// M�todo para deixar a tela em Modo Altera��o
	private void telaCadastro() {
		// Habilitando botoes para o usuario
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnCadastrar.setEnabled(true);

	}

	// Met�do para criar o Objeto Jogo
	private Jogos novoJogo() {

		// Criacao de um Novo Objeto Jogo
		// Utilizo a Classe Beans para ter todos os atributos
		Jogos newJogo = new Jogos();

		// Passando os Parametros
		newJogo.setNomeJogo(txtNomeJogo.getText());
		newJogo.setGeneroJogo(cbbGenero.getSelectedItem().toString());
		newJogo.setPlataformaJogo(cbbPlataforma.getSelectedItem().toString());
		newJogo.setClassificacaoJogo(txtClassificacao.getText());
		newJogo.setValorJogo(Double.parseDouble(txtValor.getText()));

		return newJogo;
	}

	// Metodo Para Testes
	private void teste() {

		Jogos newJogo = new Jogos();
		newJogo.setNomeJogo("TEESTES 01");
		newJogo.setGeneroJogo("MOBA");
		newJogo.setPlataformaJogo("Playstation 3");
		newJogo.setClassificacaoJogo("100");
		newJogo.setValorJogo(25.66);

		Jogos newJogo1 = new Jogos();
		newJogo1.setNomeJogo("TEESTES 01");
		newJogo1.setGeneroJogo("MOBA");
		newJogo1.setPlataformaJogo("Playstation 4");
		newJogo1.setClassificacaoJogo("80");
		newJogo1.setValorJogo(700);

		Jogos newJogo2 = new Jogos();
		newJogo2.setNomeJogo("CE �SSE");
		newJogo2.setGeneroJogo("Estrat�gia");
		newJogo2.setPlataformaJogo("PC");
		newJogo2.setClassificacaoJogo("10");
		newJogo2.setValorJogo(500);

		acao.cadastrar(newJogo);
		acao.cadastrar(newJogo1);
		acao.cadastrar(newJogo2);
	}
}
