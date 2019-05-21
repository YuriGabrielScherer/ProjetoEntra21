package pacote;

public class Texto {

	// Atributo
	private String palavra;

	// Construtor
	public Texto(String palavra) {
		this.palavra = palavra;
	}

	// Metodo Contar Caracteres
	public void contarLetrar() {
		System.out.println("A palavra " + palavra.toLowerCase() + " possui " + palavra.length() + " letras.");
	}
}
