package cargo;

public class Estagiario extends Cargo {

	// Construtor
	public Estagiario() {
		cargo = "Estagiario";
	}

	// Metodo IR - Imposto de Renda
	public void ir() {

		System.out.println("Não há desconto de imposto de renda");

	}

}