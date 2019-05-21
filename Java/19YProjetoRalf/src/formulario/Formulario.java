package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import acao.Acao;
import beans.Curso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField JTNome;
	private JTextField JTArea;
	private JTable table;
	private static int codigoCurso;

	// Objeto da Classe Ação
	Acao acao = new Acao();

	public Formulario() {

		setTitle("Sistema de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeCurso = new JLabel("Nome Curso:");
		lblNomeCurso.setForeground(Color.BLACK);
		lblNomeCurso.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNomeCurso.setBounds(10, 38, 92, 14);
		contentPane.add(lblNomeCurso);

		JLabel lblAreaCurso = new JLabel("Área Curso:");
		lblAreaCurso.setForeground(Color.BLACK);
		lblAreaCurso.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAreaCurso.setBounds(10, 70, 92, 14);
		contentPane.add(lblAreaCurso);

		JTNome = new JTextField();
		JTNome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JTNome.setBounds(112, 32, 260, 23);
		contentPane.add(JTNome);
		JTNome.setColumns(10);

		JTArea = new JTextField();
		JTArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JTArea.setBounds(112, 67, 260, 23);
		contentPane.add(JTArea);
		JTArea.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Criar um Objeto Curso
				Curso curso = new Curso();
				curso.setNomeCurso(JTNome.getText());
				curso.setAreaCurso(JTArea.getText());

				// Efetuar Cadastro
				acao.cadastrar(curso);

				limparCampos();
			}

		});

		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnCadastrar.setBounds(10, 108, 99, 23);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Instanciar um Objeto da Classe Curso
				Curso curso = new Curso();
				curso.setNomeCurso(JTNome.getText());
				curso.setAreaCurso(JTArea.getText());

				// Realiza a alterar
				acao.alterar(codigoCurso, curso);

				// Limpando os Campos
				limparCampos();

			}
		});
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnAlterar.setBounds(115, 108, 99, 23);
		contentPane.add(btnAlterar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnCancelar.setBounds(325, 108, 99, 23);
		contentPane.add(btnCancelar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Remover o Curso
				acao.excluir(codigoCurso);

				// Limpando os Campos
				limparCampos();

			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnExcluir.setBounds(221, 108, 99, 23);
		contentPane.add(btnExcluir);

		// Acao do Botao Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Limpando os campos
				limparCampos();

				// Padronizando botoes
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);

			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 98, 438, 21);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 141, 438, 26);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 291);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) { // Mouse released quer dizer que o click do mouse acontecerá e já
														// soltar. Clica e solta.

				// Obter o indice da tabela
				int indice = table.getSelectedRow(); // Retorna a linha selecionada

				// Adicionar valor do índice no Atributo
				codigoCurso = indice;

				// Agora eu consigo manipular a coluna e ao dado.
				// Selecionando dados do Curso
				JTNome.setText(table.getValueAt(indice, 0).toString()); // getValueAt eu mostro o ponto exato do dado p/
				JTArea.setText(table.getValueAt(indice, 1).toString()); // retornar. Passando valores inteiros.

				// Focus
				JTNome.requestFocus();

				// Padronizando Botoes
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelar.setEnabled(true);

			}
		});
		table.setModel(acao.selecionar());

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
	}

	// Metodo para limpar os campos
	private void limparCampos() {
		// Limpando os Campos
		JTNome.setText("");
		JTNome.requestFocus();
		JTArea.setText("");

		// Tirando a selecao da Tabela
		table.clearSelection();

		// Atualizando a tabela
		table.setModel(acao.selecionar());

		// Focus
		JTNome.requestFocus();
	}
}
