package beans;

import java.util.Date;

import javax.swing.JOptionPane;

public class Pessoa {

	// Atributos
	private String nomeP, emailP, enderecoP, cpfP;
	private int telefoneP;
	private Date dtNascP, dtCadP;
	private char sexoP;
	private static boolean verDadosP = true;

	//
	// Método Get
	//
	public String getNomeP() {
		return nomeP;
	}

	public Date getDtCadP() {
		return dtCadP;
	}

	public static boolean getVerDadosP() {
		return verDadosP;
	}

	public String getEmailP() {
		return emailP;
	}

	public String getEnderecoP() {
		return enderecoP;
	}

	public int getTelefoneP() {
		return telefoneP;
	}

	public String getCpfP() {
		return cpfP;
	}

	public Date getDtNascP() {
		return dtNascP;
	}

	public char getSexoP() {
		return sexoP;
	}

	//
	// Metodos Set

	public static void setVerDadosP(boolean verDadosP) {
		Pessoa.verDadosP = verDadosP;
	}

	public void setNomeP(String nomeP) {

		// Verificando a integridade do Nome
		if (nomeP.equals("")) {

			try {
				this.nomeP = nomeP;
			} catch (Exception e) {
				verDadosP = false;
			}

		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o nome. Tente novamente.", "Alerta do Sistema", 0);

	}

	public void setEmailP(String emailP) {

		// Verificacao do Campo Email
		if (emailP.equals("")) {
			try {
				this.emailP = emailP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o e-mail. Tente novamente.", "Alerta do Sistema", 0);

	}

	public void setEnderecoP(String enderecoP) {

		// Verificacao do Campo Email
		if (enderecoP.equals("")) {
			try {
				this.enderecoP = enderecoP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o endereço. Tente novamente.", "Alerta do Sistema",
					0);

	}

	public void setTelefoneP(int telefoneP) {

		// Verificacao do Campo telefone
		if (!(telefoneP == 0) && (telefoneP > 30000000)) {
			try {
				this.telefoneP = telefoneP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para mensagem
		JOptionPane.showMessageDialog(null, "Erro ao cadastrar o telefone. Tente novamente.", "Alerta do Sistema", 0);

	}

	public void setCpfP(String cpfP) {

		// Verificacao do Campo CPF
		if (!(cpfP.equals("")) && (cpfP.length() == 11)) {
			try {
				this.cpfP = cpfP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para Mensagem
		if (verDadosP == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o CPF. Tente novamente.", "Alerta do Sistema", 0);
	}

	public void setDtNascP(Date dtNascP) {

		// Verificacao do Campo Data Nascimento
		// Implementar

		this.dtNascP = dtNascP;
	}

	public void setDtCadP(Date dtCadP) {

		// Verificacao do Campo Data Nascimento
		// Implementar

		this.dtCadP = dtCadP;
	}

	public void setSexoP(char sexoP) {
		if ((sexoP == 'M') || (sexoP == 'F')) {
			try {
				this.sexoP = sexoP;
			} catch (Exception e) {
				verDadosP = false;
			}
		} else {
			verDadosP = false;
		}

		// Verificacao para mensagem
		if (verDadosP)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o sexo. Tente novamente.", "Alerta do Sistema", 0);
	}
}
