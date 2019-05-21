package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;
import beans.Funcionario;
import beans.Setor;
import dados.Dados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtColaborador;
	private JTextField txtSalarioBruto;
	private JTextField txtValeTransporte;
	private JTextField txtImpostoRenda;
	private JTextField txtSalarioLiquido;
	private JTextField txtQntFaltas;

	private JSpinner spinFaltas;
	private String faltas;

	private JTable tableFuncionarios;

	// CheckBoxes
	private JCheckBox ckPlano;
	private JCheckBox ckClube;

	// Combo Box
	private JComboBox<Setor> cbbFuncao;

	// Instanciando Classes
	private Acao acao = new Acao();
	private Dados dados = new Dados();

	public Formulario() {

		// Populando os campos no Setor
		Setor setor = new Setor();
		setor.popularSetores();

		setTitle("Sistema de Cadastro de Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 585);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(34, 36, 71, 14);
		contentPane.add(lblColaborador);

		JLabel lblSalrioBruto = new JLabel("Sal\u00E1rio Bruto:");
		lblSalrioBruto.setBounds(34, 61, 71, 14);
		contentPane.add(lblSalrioBruto);

		JLabel lblValeTransporte = new JLabel("Vale transporte:");
		lblValeTransporte.setBounds(10, 86, 89, 14);
		contentPane.add(lblValeTransporte);

		JLabel lblFaltasNoMs = new JLabel("Faltas no m\u00EAs:");
		lblFaltasNoMs.setBounds(20, 111, 103, 14);
		contentPane.add(lblFaltasNoMs);

		txtColaborador = new JTextField();
		txtColaborador.setBounds(115, 33, 164, 20);
		contentPane.add(txtColaborador);
		txtColaborador.setColumns(10);

		txtSalarioBruto = new JTextField();
		txtSalarioBruto.setEditable(false);
		txtSalarioBruto.setColumns(10);
		txtSalarioBruto.setBounds(115, 58, 164, 20);
		contentPane.add(txtSalarioBruto);

		txtValeTransporte = new JTextField();
		txtValeTransporte.setEditable(false);
		txtValeTransporte.setColumns(10);
		txtValeTransporte.setBounds(136, 83, 143, 20);
		contentPane.add(txtValeTransporte);

		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(429, 36, 48, 14);
		contentPane.add(lblFuno);

		JLabel lblImpostoDeRenda = new JLabel("Imposto de Renda:");
		lblImpostoDeRenda.setBounds(414, 111, 127, 14);
		contentPane.add(lblImpostoDeRenda);

		cbbFuncao = new JComboBox<Setor>();
		cbbFuncao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Retornando o Index Selecionado
				int index;
				index = cbbFuncao.getSelectedIndex();

				// Populando o Texto Salario Bruto
				txtSalarioBruto.setText(String.valueOf(dados.vetorSetores.get(index).getSalario()));

				// Populando imposto de Renda
				txtImpostoRenda.setText(
						String.valueOf(acao.calculaImposto(Double.parseDouble(txtSalarioBruto.getText()), index)));

				// Populando Text Vale Transporte
				txtValeTransporte
						.setText(String.valueOf(acao.calculaTransporte(dados.vetorSetores.get(index).getSalario())));

				// Populando salario Liquido
				txtSalarioLiquido.setText(String.valueOf(acao.calcularLiquido(criarObjeto())));

			}
		});

		cbbFuncao.setBounds(487, 32, 207, 22);
		contentPane.add(cbbFuncao);

		// Definindo os dados dentro do ComboBox
		cbbFuncao.setModel(setor.dadosSetores());

		ckClube = new JCheckBox("Clube Fidelidade");
		ckClube.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				// Mensagem de teste
				if (ckClube.isSelected()) {
					JOptionPane.showMessageDialog(null, "Teste selecionado");
				} else {
					JOptionPane.showMessageDialog(null, "Teste n�o selecionado");
				}

			}
		});
		ckClube.setBounds(429, 77, 143, 23);
		contentPane.add(ckClube);

		ckPlano = new JCheckBox("Plano de Sa\u00FAde");
		ckPlano.setBounds(584, 77, 115, 23);
		contentPane.add(ckPlano);

		txtImpostoRenda = new JTextField();
		txtImpostoRenda.setEditable(false);
		txtImpostoRenda.setColumns(10);
		txtImpostoRenda.setBounds(530, 108, 164, 20);
		contentPane.add(txtImpostoRenda);

		txtSalarioLiquido = new JTextField();
		txtSalarioLiquido.setEditable(false);
		txtSalarioLiquido.setColumns(10);
		txtSalarioLiquido.setBounds(530, 136, 164, 20);
		contentPane.add(txtSalarioLiquido);

		JLabel lblSalrioLquido = new JLabel("Sal�rio L�quido:");
		lblSalrioLquido.setBounds(429, 139, 103, 14);
		contentPane.add(lblSalrioLquido);

		JSeparator separator = new JSeparator();
		separator.setBounds(34, 233, 769, -46);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 248, 769, 287);
		contentPane.add(scrollPane);

		tableFuncionarios = new JTable();

		// Populando Modelo de Tabela
		tableFuncionarios.setModel(acao.readFuncionario());

		scrollPane.setViewportView(tableFuncionarios);

		JButton btnCadastrar = new JButton("Cadastrar");

		// Acao do Botao Cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Add no metodo Cadastrar
				acao.cadastrarFuncionario(criarObjeto());

				// Atualizar a Tabela
				tableFuncionarios.setModel(acao.readFuncionario());

			}
		});

		btnCadastrar.setBounds(44, 182, 115, 23);
		contentPane.add(btnCadastrar);

		JButton btnEstatsticas = new JButton("Estat�sticas");

		// Acao do bota ocadastrar
		btnEstatsticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faltas = String.valueOf(spinFaltas.getValue());
				JOptionPane.showMessageDialog(null, faltas);
			}
		});

		btnEstatsticas.setBounds(220, 182, 115, 23);
		contentPane.add(btnEstatsticas);

		JCheckBox ckTransporte = new JCheckBox("");
		ckTransporte.setBounds(115, 77, 21, 23);
		contentPane.add(ckTransporte);

		txtQntFaltas = new JTextField();
		txtQntFaltas.setText("00");
		txtQntFaltas.setColumns(10);
		txtQntFaltas.setBounds(115, 108, 38, 20);
		contentPane.add(txtQntFaltas);

		spinFaltas = new JSpinner();
		spinFaltas.setBounds(173, 108, 30, 20);

		// faltas
		faltas = String.valueOf(spinFaltas.getValue());

		contentPane.add(spinFaltas);
	}

	// Metodo Criar objeto Funcionario
	private Funcionario criarObjeto() {
		// Instanciando Objeto
		Funcionario func = new Funcionario();

		func.setNome(txtColaborador.getText());
		func.setSalarioBruto(Double.parseDouble(txtSalarioBruto.getText()));
		func.setSetor(cbbFuncao.getSelectedIndex());
		func.setPlanoSaude(ckPlano.isSelected() ? true : false);
		func.setClubeFidelidade(ckClube.isSelected() ? true : false);
		func.setQntFaltas(Integer.parseInt(txtQntFaltas.getText()));

		return func;

	}

}