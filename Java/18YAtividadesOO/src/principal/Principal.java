package principal;

import formulario.Formulario;

public class Principal {
	public static void main(String[] args) {

		Formulario frame = new Formulario();

		// Parametros do Frame
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
