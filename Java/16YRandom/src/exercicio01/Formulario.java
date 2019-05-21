package exercicio01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Formulario {

	// Instanciando a classe Perguntas e Respostas
	private PerguntasRespostas perg = new PerguntasRespostas();

	// Declarao dos Componentes para usar em diversas partes do Código
	private JButton btnComecar;

	// Nova Matriz para Armazenar os valores randomicos
	private String[][] novaMatriz = new String[15][6];

	// Criacao do Objeto para respostas
	private Object[] opcoesRespostas = { "1", "2", "3", "4" };

	// Vetor com numeros de perguntas que já foram
	private int[] vetorPerguntas = new int[15];
	private int[] vetorRespostas = new int[4];

	// Variaveis para perguntas, questoes e respotas
	private int pergunta = 0;
	private int resposta = 0;

	private boolean acertou = false;
	// Variavel resposta
	private int opcaoResposta;

	// Variavel verificadora
	boolean verRandom = false;

	// Gerar Pergunta Random
	private void gerarRandom() {

		// Definindo valores randômicos para as perguntas e respostas
		Random gerar = new Random();

		boolean adicionarVetor = false;
		for (int j = 0; j < (vetorPerguntas.length); j++) {

			// Verificando se é o último digito a ser acrescentado
			if (j == 14) {
				vetorPerguntas[j] = 0;
				break;
			} else {
				// Colocando os valores aleatorios dentro do Vetor
				verRandom = false;
				while (!verRandom) {
					// Gerando novo Random
					pergunta = gerar.nextInt(15);

					// Novo vetor para percorrer o Vetor pergunta
					for (int i = 0; i < (vetorPerguntas.length); i++) {
						// Verificando se já existe
						if (pergunta == vetorPerguntas[i]) {
							verRandom = false;
							adicionarVetor = false;
							break;
						} else {
							adicionarVetor = true;
							verRandom = true;
						}
					}
					// Adicionando no vetor
					if (adicionarVetor) {
						vetorPerguntas[j] = pergunta;
						verRandom = true;
					}
				}
			}
		}

		// Gerando Respostas Randômicas
		adicionarVetor = false;
		for (int j = 0; j < (vetorRespostas.length); j++) {

			// Verificando se é o último dígito
			if (j == 3) {
				vetorRespostas[j] = 4;
				break;
			} else {
				// Colocando os valores aleatorios dentro do Vetor
				verRandom = false;

				while (!verRandom) {
					// Gerando novo Random
					resposta = gerar.nextInt(4);

					// Novo vetor para percorrer o Vetor pergunta
					for (int i = 0; i < (vetorRespostas.length); i++) {

						// Verificando se já existe
						if (resposta == vetorRespostas[i]) {
							verRandom = false;
							adicionarVetor = false;
							break;
						} else {
							adicionarVetor = true;
							verRandom = true;
						}
					}
					// Adicionando no vetor
					if (adicionarVetor) {
						vetorRespostas[j] = resposta;
						verRandom = true;
					}
				}
			}
		}

		for (int i = 0; i < (novaMatriz.length); i++) {
			novaMatriz[vetorPerguntas[i]][0] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], 0);
			novaMatriz[vetorPerguntas[i]][1] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], vetorRespostas[2]);
			novaMatriz[vetorPerguntas[i]][2] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], vetorRespostas[3]);
			novaMatriz[vetorPerguntas[i]][3] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], vetorRespostas[1]);
			novaMatriz[vetorPerguntas[i]][4] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], vetorRespostas[0]);
			novaMatriz[vetorPerguntas[i]][5] = perg.getPerguntasRespostasIndex(vetorPerguntas[i], 5);
		}
		JOptionPane.showMessageDialog(null, "Teste");
	}

	// Criacao do Formulario
	public Formulario() {

		// Criacao do Frame
		JFrame frame = new JFrame("Quiz do Yuri");
		frame.setSize(450, 500);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);

		// Adicionando componentes
		frame.add(painelCentral());

		// Popular Perguntas e Respostas
		perg.populaMatriz();

		// Tornando visivel
		frame.setVisible(true);

	}

	// Criacao do Painel Central
	private JPanel painelCentral() {

		// Criacao do Painel
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setBounds(10, 10, 400, 430);
		painel.setBackground(Color.PINK);

		// Componentes do Painel
		btnComecar = new JButton("Começar");
		btnComecar.setBounds(50, 50, 100, 30);

		btnComecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRandom();
				for (int i = 0; i < 2; i++) {

					resposta = gerarPergunta(i);
					validaResposta(i, resposta);
				}

			}
		});

		JButton btnGerar = new JButton("Gerar nova Sequência");
		btnGerar.setBounds(180, 50, 170, 30);

		// ADd ao Painel
		painel.add(btnComecar);
		painel.add(btnGerar);

		return painel;
	}

	// Gerar Pergunta com as devidas respostas
	private int gerarPergunta(int pergunta) {

		// Mostrando Informações para o Usuários
		opcaoResposta = JOptionPane.showOptionDialog(null,
				novaMatriz[pergunta][0] + "\n " + "\n01 - " + novaMatriz[pergunta][1] + "\n02 - "
						+ novaMatriz[pergunta][2] + "\n03 - " + novaMatriz[pergunta][3] + "\n04 - "
						+ novaMatriz[pergunta][4],
				"Sistema de Perguntas", 0, 1, null, opcoesRespostas, 0);
		return opcaoResposta;
	}

	// Valida Resposta Certa
	private boolean validaResposta(int pergunta, int opcaoResposta) {
		acertou = false;
		opcaoResposta++;
		// Verificando qual a resposta correta
		if (perg.getPerguntasRespostasIndex(pergunta, 5)
				.equals((perg.getPerguntasRespostasIndex(pergunta, (opcaoResposta))))) {

			JOptionPane.showMessageDialog(null, "Acertou");
			acertou = true;
		} else {
			JOptionPane.showMessageDialog(null, "Errou");
		}
		return acertou;
	}

}
