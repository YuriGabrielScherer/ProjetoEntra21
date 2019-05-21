
public class Principal {

	// M�todo Est�tico de Exibi��o
	// Padrao do Generics: E - Elements
	// Passamos como parametro o vetor E porque nao sabemos de qual tipo vai ser o
	// vetor, por isso generics

	public static <E> void exibirDados(E[] vetor) {
		for (E elemento : vetor) {
			// E - tipo generico
			// elemento = index
			// vetor � o parametro passado

			System.out.println(elemento);
		}
	}

	// M�todo Main
	public static void main(String[] args) {

		// Dados - Vetores
		Integer[] dadosInt = { 1, 5, 7, 8 };
		Double[] dadosDouble = { 7.5, 8.2, 3.6 };
		String[] dadosString = { "PC", "Imp", "Teste" };

		// Exbir dados
		exibirDados(dadosInt);
		exibirDados(dadosDouble);
		exibirDados(dadosString);

	}
}

/*
  (VALORES GEN�RICOS)
  
  E -> Tipos de Classes (String, Double, ou Pessoa (que eu criei) 
  K -> Chave (Utilizado com HashMap) 
  V -> Valor (Utilizado com HashMap) 
  T -> Tipo primitivos (int, double, char)
 
 */
