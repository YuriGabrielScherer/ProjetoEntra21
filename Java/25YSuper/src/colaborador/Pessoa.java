package colaborador;

public class Pessoa {

	// Atributos
	private String nomePessoa, emailPessoa, enderecoPessoa;
	private int idadePessoa;

	// Metodo para chamar os metodos Privados
	// Nesse caso vai ser o Construtor
	public Pessoa(String nomePessoa, String emailPessoa, String enderecoPessoa, int idadePessoa) {

		// Atribuindo Valores
		this.nomePessoa = nomePessoa;
		this.emailPessoa = emailPessoa;
		this.enderecoPessoa= enderecoPessoa;
		this.idadePessoa = idadePessoa;

		// Chamando o metodo exibirDadosPessoa, que � privado
		exibirDadosPessoa();
	}

	// Metodo para exibir os dados da Pessoa
	private void exibirDadosPessoa() {

		System.out.println("Nome: " + nomePessoa + "\nE-mail: " + emailPessoa + "\nEndere�o: " + enderecoPessoa
				+ "\nIdade: " + idadePessoa);

	}

}
