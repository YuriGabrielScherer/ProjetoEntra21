package principal;

import formulario.Formulario;

public class Principal {
	public static void main(String[] args) {
		Formulario frame = new Formulario();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}
}
