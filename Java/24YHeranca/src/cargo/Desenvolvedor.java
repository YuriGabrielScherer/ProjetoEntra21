package cargo;

public class Desenvolvedor extends Cargo {

	// Construtor
	public Desenvolvedor(double salario, int nivel) {
		this.cargo = "Desenvolvedor";
		this.salario = salario;
		this.nivel = nivel;
	}

	// Metodo IR - Imposto de Renda
	public void ir() {

		if (nivel == 1) {
			System.out.println("Imposto de Renda: " + salario * 0.04);
		} else if (nivel == 2) {
			System.out.println("Imposto de Renda: " + salario * 0.05);
		} else {
			System.out.println("Imposto de Renda: " + salario * 0.10);
		}

	}

}