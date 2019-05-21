package principal;

import formularios.Formulario;

public class Principal {
	public static void main(String[] args) {

		// Instanciando o form
		Formulario frame = new Formulario();

		// Chamando
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
