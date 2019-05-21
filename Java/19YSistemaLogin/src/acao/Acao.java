package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bancoDados.BancoDados;
import beans.Usuarios;

public class Acao {

	// Instanciando classe Usuarios para utilizar seus metodos
	private Usuarios beanUsuario = new Usuarios();

	// Codigo usuario que fez o login
	private static int codigoUsuarioLogado = 0;

	// Metodos CRUD

	// Create
	public boolean cadastrarUsuario(Usuarios usuario) {

		// Variavel para retornar valor
		boolean cadastroRealizado = false;

		// Realizando o cadastro
		if (beanUsuario.getValidaDados()) {
			try {
				if (nomesDuplicados(usuario.getNome(), usuario.getLogin()) == false) {
					BancoDados.vetorUsuarios.add(usuario);
					cadastroRealizado = true;
				} else {
					JOptionPane.showMessageDialog(null, "Nomes duplicados!\nTente novamente.");
					cadastroRealizado = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro.");
				cadastroRealizado = false;
			}

		} else {
			// Definindo o valor padrao novamente para true
			beanUsuario.setValidaDados(true);

		}

		return cadastroRealizado;

	}

	// Read
	public DefaultTableModel retornarUsuario() {

		// Criando o novo Modelo de Tabela
		DefaultTableModel model = new DefaultTableModel();

		// Add Colunas
		model.addColumn("Nome");
		model.addColumn("Login");
		model.addColumn("E-mail");
		model.addColumn("Data Cadastro");
		model.addColumn("Tipo Usuario");

		// Realizando a pesquisa
		for (int i = 0; i < (BancoDados.vetorUsuarios.size()); i++) {
			model.addRow(new Object[] { // Add Rows ao Model
					BancoDados.vetorUsuarios.get(i).getNome(), // Campo Nome
					BancoDados.vetorUsuarios.get(i).getLogin(), // Campo Login
					BancoDados.vetorUsuarios.get(i).getEmail(), // Campo Email
					BancoDados.vetorUsuarios.get(i).getDataCadastro(), // Campo Data
					(BancoDados.vetorUsuarios.get(i).getTipoUsuario() == 0 ? "Administrador" : "Normal") });
		}

		// Retornando Modelo
		return model;
	}

	// Excluir
	public boolean excluirUsuario(int index) {

		// Variavel verificadora
		boolean excluir = false;

		// Tentando Excluir
		try {
			BancoDados.vetorUsuarios.remove(index);
			JOptionPane.showMessageDialog(null, "Registro exclu�do com sucesso!");
			excluir = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir o registro.");
			excluir = false;
		}

		return excluir;
	}

	// Update
	public boolean updateUsuario(int index, Usuarios usuario) {

		// variavel verificadora
		boolean update = false;
		boolean nomeExiste = false;

		// Verificacao individual de Nome e login
		for (int i = 0; i < BancoDados.vetorUsuarios.size(); i++) {

			if ((usuario.getNome().equals(BancoDados.vetorUsuarios.get(i).getNome())) && (i != index)) {
				nomeExiste = true;
				break;
			}

		}

		for (int i = 0; i < BancoDados.vetorUsuarios.size(); i++) {

			if ((usuario.getLogin().equals(BancoDados.vetorUsuarios.get(i).getLogin())) && (i != index)) {
				nomeExiste = true;
				break;
			}

		}

		try {
			// Verificando duplicidade de dados
			if (nomeExiste == false) {

				// Realizando a altera��o dos Dados
				BancoDados.vetorUsuarios.set(index, usuario);
				update = true;
				JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");

			} else {

				// Mostrando a mensagem de Erro
				JOptionPane.showMessageDialog(null, "Nomes ou logins duplicados. Tente novamente");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar o Update. Tente novamente");
			update = false;
		}

		return update;
	}

	// Verificando o login
	public boolean validaLogin(String login, String senha) {

		// variavel verificadora
		boolean loginRealizado = false;

		// Realizando a busca no banco de dados
		for (int i = 0; i < (BancoDados.vetorUsuarios.size()); i++) {

			// Verificando dados
			if (login.equals(BancoDados.vetorUsuarios.get(i).getLogin())
					&& (senha.equals(BancoDados.vetorUsuarios.get(i).getSenha()))) {
				// mensagem para o usuario
				loginRealizado = true;
				codigoUsuarioLogado = i;
				break;
			}
		}

		if (!loginRealizado) {
			JOptionPane.showMessageDialog(null, "Login ou senha incorretos, tente novamente.");
		}
		return loginRealizado;
	}

	// Retornar o c�digo do usuario que fez login
	public int codigoUsuario() {

		return codigoUsuarioLogado;

	}

	// Retornar o tipo de Usuario que fez o login
	public int tipoUsuarioLogin(String login) {

		int tipoUsuario = 0;

		// Fazendo a pesquisa no Banco
		for (int i = 0; i < (BancoDados.vetorUsuarios.size()); i++) {
			if (login.equals(BancoDados.vetorUsuarios.get(i).getLogin())) {
				tipoUsuario = BancoDados.vetorUsuarios.get(i).getTipoUsuario();
			}
		}

		// Retornando
		return tipoUsuario;
	}

	// Verificando duplicidade de dados no NOME
	private boolean nomesDuplicados(String nome, String login) {

		// variavel verificadora
		boolean nomeDuplicado = false;

		// realizando pesquisa no banco
		for (int i = 0; i < (BancoDados.vetorUsuarios.size()); i++) {

			// Verificando
			if (nome.equalsIgnoreCase(BancoDados.vetorUsuarios.get(i).getNome())
					|| login.equals(BancoDados.vetorUsuarios.get(i).getLogin())) {
				nomeDuplicado = true;
				break;
			}
		}

		return nomeDuplicado;
	}
}
