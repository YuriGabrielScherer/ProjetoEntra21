package principal;

import javax.swing.JOptionPane;

import colaborador.Colaborador;

public class Principal {
	public static void main(String[] args) {

		// Instanciar objeto da Classe Colaborador
		Colaborador colaborador = new Colaborador(JOptionPane.showInputDialog("Digite seu nome"), "yuriGoogle",
				"Velha Grande", 18, "Diretor", 10000);

	}
}
