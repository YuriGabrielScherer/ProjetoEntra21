package beans;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class Generos {

	public static ArrayList<Generos> vetorGenero = new ArrayList<Generos>();

	private String genero;

	// Metodos Get e Set
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void cadastrarGeneros() {

		// Instanciando e criando os generos existentess
		Generos genero1 = new Generos();
		genero1.setGenero("Aventura");
		Generos genero2 = new Generos();
		genero2.setGenero("Ação");
		Generos genero3 = new Generos();
		genero3.setGenero("RPG");
		Generos genero4 = new Generos();
		genero4.setGenero("MOBA");
		Generos genero5 = new Generos();
		genero5.setGenero("Estratégia");
		Generos genero6 = new Generos();
		genero6.setGenero("Moda");

		// Add no Banco de Dados
		vetorGenero.add(genero1);
		vetorGenero.add(genero2);
		vetorGenero.add(genero3);
		vetorGenero.add(genero4);
		vetorGenero.add(genero5);
		vetorGenero.add(genero6);

	}

	public DefaultComboBoxModel<Generos> dadosGenero() {

		DefaultComboBoxModel<Generos> dadosGenero = new DefaultComboBoxModel<Generos>();

		// For para adicionar todos os componentes existentes no Array
		for (int i = 0; i < (vetorGenero.size()); i++) {
			dadosGenero.addElement(vetorGenero.get(i));
		}

		// Retornando
		return dadosGenero;
	}
	
	public String toString() {
		return this.genero;
	}

}
