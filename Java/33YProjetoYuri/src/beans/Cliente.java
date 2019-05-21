package beans;

import javax.swing.JOptionPane;

public class Cliente extends Pessoa {

	// Atributos
	private int codigoCli, satisfacaoCli;
	private boolean cooperadoCli;

	// Verificadora de Dados
	private static boolean verDadosCli = true;

	//
	// Metodos Get

	public int getCodigoCli() {
		return codigoCli;
	}

	public boolean getVerDadosCli() {
		return verDadosCli;
	}

	public int getSatisfacaoCli() {
		return satisfacaoCli;
	}

	public boolean getCooperadoCli() {
		return cooperadoCli;
	}

	//
	// Metodos Set

	public void setCodigoCli(int codigoCli) {

		// Verificacao do Codigo Cliente
		if (codigoCli > 0) {

			try {
				this.codigoCli = codigoCli;
			} catch (Exception e) {
				verDadosCli = false;
			}
		} else {
			verDadosCli = false;
		}

		// Verificacao para mensagem
		if (verDadosCli == false)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o código. Tente novamente.", "Alerta do Sistema", 0);

	}

	public void setSatisfacaoCli(int satisfacaoCli) {

		// Verificacao de Satisfacao
		if ((satisfacaoCli >= 0) && (satisfacaoCli <= 5)) {
			try {
				this.satisfacaoCli = satisfacaoCli;
			} catch (Exception e) {
				verDadosCli = false;
			}
		} else {
			verDadosCli = false;
		}

		// Verificacao para Mensagem
		if (verDadosCli == false) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar a satisfação do cliente. Tente novamente.",
					"Alerta do Sistema", 0);
		}

	}

	public void setCooperado(boolean cooperado) {
		this.cooperadoCli = cooperado;
	}

	public static void setVerDadosCli(boolean verDadosCli) {
		Cliente.verDadosCli = verDadosCli;
	}

}
