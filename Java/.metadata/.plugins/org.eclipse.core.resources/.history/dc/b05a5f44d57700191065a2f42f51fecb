package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import acao.AcaoJogo;
import acao.AcaoPlataforma;
import beans.Jogo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPlataforma;
	private JTextField txtValor;
	private JTable tabelaJogos;
	private JTable tabelaPlataformas;
	private static int linha = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {

		AcaoJogo a = new AcaoJogo();
		AcaoPlataforma ap = new AcaoPlataforma();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 11, 448, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeDoJogo = new JLabel("Nome do Jogo");
		lblNomeDoJogo.setBounds(10, 26, 81, 14);
		panel.add(lblNomeDoJogo);
		
		txtNome = new JTextField();
		txtNome.setBounds(88, 23, 350, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(11, 58, 81, 14);
		panel.add(lblPlataforma);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setColumns(10);
		txtPlataforma.setBounds(88, 55, 350, 20);
		panel.add(txtPlataforma);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(11, 89, 81, 14);
		panel.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(88, 86, 350, 20);
		panel.add(txtValor);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instânciar obj
				Jogo j = new Jogo();
				j.setNome(txtNome.getText());
				j.setPlataforma(txtPlataforma.getText());
				j.setValor(Double.parseDouble(txtValor.getText()));
				
				//Realizar cadastro
				a.cadastrarJogo(j);
				
				//Atualizar
				tabelaJogos.setModel(a.selecionarJogos());
				tabelaPlataformas.setModel(ap.selecionarPlataforma());
				
				//Limpar campos
				txtNome.setText("");
				txtPlataforma.setText("");
				txtValor.setText("");
			}
		});
		btnNewButton.setBounds(55, 131, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obter o nome da plataforma atualmente
				String nomePlataforma = tabelaJogos.getValueAt(linha, 1).toString();
				
				//Instânciar obj
				Jogo j = new Jogo();
				j.setNome(txtNome.getText());
				j.setPlataforma(txtPlataforma.getText());
				j.setValor(Double.parseDouble(txtValor.getText()));
				
				//Realizar alteração
				a.alterarJogo(linha, j, nomePlataforma);
				
				//Atualizar
				tabelaJogos.setModel(a.selecionarJogos());
				tabelaPlataformas.setModel(ap.selecionarPlataforma());
				
				//Limpar campos
				txtNome.setText("");
				txtPlataforma.setText("");
				txtValor.setText("");
			}
		});
		btnAlterar.setBounds(167, 131, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(271, 131, 89, 23);
		panel.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 448, 167);
		contentPane.add(scrollPane);
		
		tabelaJogos = new JTable();
		tabelaJogos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//Obter a linha selecionada
				linha = tabelaJogos.getSelectedRow();
				
				//Exibir dados nos campos
				txtNome.setText(tabelaJogos.getValueAt(linha, 0).toString());
				txtPlataforma.setText(tabelaJogos.getValueAt(linha, 1).toString());
				txtValor.setText(tabelaJogos.getValueAt(linha, 2).toString());
				
			}
		});
		tabelaJogos.setModel(a.selecionarJogos());
		scrollPane.setViewportView(tabelaJogos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 398, 448, 167);
		contentPane.add(scrollPane_1);
		
		tabelaPlataformas = new JTable();
		tabelaPlataformas.setModel(ap.selecionarPlataforma());
		scrollPane_1.setViewportView(tabelaPlataformas);
		
	}
}
