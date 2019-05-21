package colaborador;

public class Colaborador extends Pessoa {

	// Atributos
	private String cargoColaborador;
	private double salarioColaborador;

	// Construtor
	public Colaborador(String nomePessoa, String emailPessoa, String enderecoPessoa, int idadePessoa,
			String cargoColaborador, double salarioColaborador) {

		// A palavra reservada SUPER executa o metodo construtor da classe que está
		// sendo extendida.
		// Nesse caso, seria a classe pessoa. Assim, funcionaria tudo certinho.
		// O super precisa ser a primeira coisa a ser executada dentro do metodo Construtor que
		// será chamada.

		super(nomePessoa, emailPessoa, enderecoPessoa, idadePessoa);

		// Atribuindo valores
		this.cargoColaborador = cargoColaborador;
		this.salarioColaborador = salarioColaborador;

		// Exibindo os Dados
		exibirDadosColaborador();

	}

	// Metodo de Exibicao dos Dados
	private void exibirDadosColaborador() {
		System.out.println("Cargo: " + cargoColaborador);
		System.out.println("Salário: " + salarioColaborador);
	}
}
