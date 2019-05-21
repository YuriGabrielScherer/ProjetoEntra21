package exercicio01;

public class PerguntasRespostas {
	// Declarando Vetores com perguntas e Respostas
	String[][] perguntasRespostas = new String[15][6];
	String[] respostas = new String[15];

	// Metodo para popular a matriz
	public void populaMatriz() {

		// Populando a matriz
		perguntasRespostas[0][0] = "Qual o meu Nome?";
		perguntasRespostas[0][1] = "Gabriel";
		perguntasRespostas[0][2] = "Vaz";
		perguntasRespostas[0][3] = "Iuri";
		perguntasRespostas[0][4] = "Yuri";
		perguntasRespostas[0][5] = "Yuri";

		perguntasRespostas[1][0] = "Qual minha idade?";
		perguntasRespostas[1][1] = "19";
		perguntasRespostas[1][2] = "18";
		perguntasRespostas[1][3] = "17";
		perguntasRespostas[1][4] = "20";
		perguntasRespostas[1][5] = "17";

		perguntasRespostas[2][0] = "Quando nasci?";
		perguntasRespostas[2][1] = "2004";
		perguntasRespostas[2][2] = "1995";
		perguntasRespostas[2][3] = "1999";
		perguntasRespostas[2][4] = "2001";
		perguntasRespostas[2][5] = "2001";

		perguntasRespostas[3][0] = "Qual o nome correto da empresa?"; // karsten
		perguntasRespostas[3][1] = "Karsten";
		perguntasRespostas[3][2] = "Carstem";
		perguntasRespostas[3][3] = "Karstem";
		perguntasRespostas[3][4] = "Karten";
		perguntasRespostas[3][5] = "Karsten";

		perguntasRespostas[4][0] = "Nome dos meus pais?";
		perguntasRespostas[4][1] = "Jair e Ivone";
		perguntasRespostas[4][2] = "Jair e Eva";
		perguntasRespostas[4][3] = "Jairo e Ivone";
		perguntasRespostas[4][4] = "Jairo e Eva";
		perguntasRespostas[4][5] = "Jair e Ivone";

		perguntasRespostas[5][0] = "Cidade onde nasci?";
		perguntasRespostas[5][1] = "Blumenau";
		perguntasRespostas[5][2] = "Indaial";
		perguntasRespostas[5][3] = "Itajai";
		perguntasRespostas[5][4] = "Florianópolis";
		perguntasRespostas[5][5] = "Blumenau";

		perguntasRespostas[6][0] = "Matéria predileta da escola?"; // biologia
		perguntasRespostas[6][1] = "Biologia";
		perguntasRespostas[6][2] = "Matemática";
		perguntasRespostas[6][3] = "Engenharia";
		perguntasRespostas[6][4] = "Português";
		perguntasRespostas[6][5] = "Biologia";

		perguntasRespostas[7][0] = "Sonho de profissão?";
		perguntasRespostas[7][1] = "Programador";
		perguntasRespostas[7][2] = "Astronauta";
		perguntasRespostas[7][3] = "Engenheiro Civil";
		perguntasRespostas[7][4] = "Advogado";
		perguntasRespostas[7][5] = "Astronauta";

		perguntasRespostas[8][0] = "Qual linguagem o sistema foi desenvolvido?";
		perguntasRespostas[8][1] = "C#";
		perguntasRespostas[8][2] = "Java";
		perguntasRespostas[8][3] = "Delphi";
		perguntasRespostas[8][4] = "SQL";
		perguntasRespostas[8][5] = "Java";

		perguntasRespostas[9][0] = "HTML é uma linguagem de programação?";
		perguntasRespostas[9][1] = "Claro";
		perguntasRespostas[9][2] = "Não";
		perguntasRespostas[9][3] = "Sim";
		perguntasRespostas[9][4] = "Seu USB";
		perguntasRespostas[9][5] = "Não";

		perguntasRespostas[10][0] = "HTML é usada com frequência com a linguagem ... :";
		perguntasRespostas[10][1] = "C++";
		perguntasRespostas[10][2] = "SQL";
		perguntasRespostas[10][3] = "JavaScript";
		perguntasRespostas[10][4] = "Delphi";
		perguntasRespostas[10][5] = "C++";

		perguntasRespostas[11][0] = "Muito usada para Data Servers é a linguagem de programação ... ?";
		perguntasRespostas[11][1] = "SQL";
		perguntasRespostas[11][2] = "Delphi";
		perguntasRespostas[11][3] = "Cobol";
		perguntasRespostas[11][4] = "Java";
		perguntasRespostas[11][5] = "SQL";

		perguntasRespostas[12][0] = "Cor dos meus olhos?";
		perguntasRespostas[12][1] = "Marrons";
		perguntasRespostas[12][2] = "Verdes";
		perguntasRespostas[12][3] = "Azuis";
		perguntasRespostas[12][4] = "Vermelhos";
		perguntasRespostas[12][5] = "Verdes";

		perguntasRespostas[13][0] = "SpaceX, que tem o mesmo dono da Tesla, tem como concorrente ...?";
		perguntasRespostas[13][1] = "NASA";
		perguntasRespostas[13][2] = "Microsoft";
		perguntasRespostas[13][3] = "Apple";
		perguntasRespostas[13][4] = "Huawei";
		perguntasRespostas[13][5] = "NASA";

		perguntasRespostas[14][0] = "O que significa ISS?";
		perguntasRespostas[14][1] = "Estação Espacial Internacional";
		perguntasRespostas[14][2] = "Estação Espacial Nacional";
		perguntasRespostas[14][3] = "NASA";
		perguntasRespostas[14][4] = "Estação Americana Espacial";
		perguntasRespostas[14][5] = "Estação Espacial Internacional";

	}

	// Metodos GET
	public String[][] getPerguntasRespostas() {
		return perguntasRespostas;
	}

	// Metodos GET perguntas Respostas com Index
	public String getPerguntasRespostasIndex(int x, int y) {
		return perguntasRespostas[x][y];
	}

	// Método GET Resposta
	public String[] getRespostas() {
		return respostas;
	}
}
