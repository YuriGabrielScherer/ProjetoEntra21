package estado;

import java.util.HashMap;

public class Principal {
	public static void main(String[] args) {

		// Criar o HashMap
		// � um vetor, basically

		// K - key, V - value
		HashMap<String, String> estados = new HashMap<String, String>();

		// Add Dados
		// PUT = ADD
		estados.put("Santa Catarina", "Floripan�polis");
		estados.put("S�o Paulo", "Urupema");
		estados.put("Palmas", "Parab�ns");
		estados.put("Minas Ingerais", "N�o conhe�o nunca mais");

		// Exibir informa��o espec�fica
		// Tipo Banco de Dados...
		System.out.println(estados.get("S�o Paulo"));

		// Remover
		estados.remove("Paulo");

		// Remover tudo
		//estados.clear();
		
		estados.replace("S�o Paulo", "Teste");

		// Listar todos os valores
		// Retorna um Vetor
		System.out.println(estados);
	}
}
