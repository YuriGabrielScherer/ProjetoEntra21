package pacote;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {

		// Instanciando a nova classe
		Texto t = new Texto(JOptionPane.showInputDialog("Digite uma palavra para contar as letras."));

		// Metodo Contar Letras
		t.contarLetrar();
	}
}
