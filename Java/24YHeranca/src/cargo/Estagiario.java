package cargo;

public class Estagiario extends Cargo {

	// Construtor
	public Estagiario() {
		cargo = "Estagiario";
	}

	// Metodo IR - Imposto de Renda
	public void ir() {

		System.out.println("N�o h� desconto de imposto de renda");

	}

}