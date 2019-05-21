package beans;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Usuarios {

	// Validar o campo nome - Nao pode ser repetido

	// Definindo parametros
	private String nome, login, senha, email;
	private int tipoUsuario;
	private LocalDateTime dataCadastro;
	private static boolean validaDados = true;

	// Metodos Get
	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	// Retornar Variavel validaDados
	public boolean getValidaDados() {
		return validaDados;
	}

	// Metodos Set

	public void setLogin(String login) {

		try {
			if (login.equals("")) {
				JOptionPane.showMessageDialog(null, "Login Inválido, tente novamente.");
				validaDados = false;
			} else {
				this.login = login;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Login Inválido, tente novamente.");
			validaDados = false;
		}

	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		try {
			this.dataCadastro = dataCadastro;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data inválida, contate o administrador do sistema.");
			validaDados = false;
		}

	}

	public void setTipoUsuario(int tipoUsuario) {
		try {
			if (tipoUsuario == 0 || tipoUsuario == 1) {
				this.tipoUsuario = tipoUsuario;
			} else {
				JOptionPane.showMessageDialog(null, "Tipo de Usuário inválido. Tente novamente");
				validaDados = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tipo de Usuário inválido. Tente novamente");
			validaDados = false;
		}

	}

	public void setEmail(String email) {
		try {
			if (email.equals("")) {
				JOptionPane.showMessageDialog(null, "E-mail inválido. Tente novamente");
				validaDados = false;
			} else {
				this.email = email;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "E-mail inválido. Tente novamente");
			validaDados = false;
		}

	}

	public void setSenha(String senha, String confSenha) {
		try {
			if (senha.equals(confSenha) && (!senha.equals(""))) {
				this.senha = senha;
			} else {
				JOptionPane.showMessageDialog(null, "Senhas inválidas ou diferentes. Tente novamente");
				validaDados = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Senhas inválidas ou diferentes. Tente novamente");
			validaDados = false;
		}

	}

	public void setNome(String nome) {
		try {
			if (nome.equals("")) {
				validaDados = false;
				JOptionPane.showMessageDialog(null, "Nome inválido. Tente novamente");
			} else {
				this.nome = nome;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nome inválido. Tente novamente");
			validaDados = false;
		}

	}

	public void setValidaDados(boolean valor) {
		this.validaDados = valor;
	}

}
