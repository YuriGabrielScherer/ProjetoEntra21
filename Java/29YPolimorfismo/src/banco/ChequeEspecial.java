package banco;

public class ChequeEspecial extends Cheque {

	// metodo de juros
	public void juros(double valor) {
		System.out.println("Valor simb�lico especial: " + valor * (0.05 * 4));

	}
	
	public void mensagem1() {
		System.out.println("Mensagem reescrita");
	}
}