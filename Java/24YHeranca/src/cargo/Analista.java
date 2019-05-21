package cargo;

public class Analista extends Cargo {

	// Construtor
	public Analista(double salario, int nivel) {
		this.cargo = "Analista";
		this.salario = salario;
		this.nivel = nivel;

	}

	// Metodo IR - Imposto de Renda
	public void ir() {

		if (nivel == 1) {
			System.out.println("Imposto de Renda: " + salario * 0.15);
		} else {
			System.out.println("Imposto de Renda: " + salario * 0.20);
		}

	}
}