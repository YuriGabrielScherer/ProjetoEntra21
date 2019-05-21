package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import banco.BancoDados;
import beans.Generos;
import beans.Jogos;
import beans.Plataforma;

//Aqui são todas as funcionalidades do Sistema

public class Acao {

	// Instanciando a Classe Jogos para Cadastrar
	private Jogos beanJogos = new Jogos();

	// Instanciando a classe Plataforma
	private Plataforma plat = new Plataforma();

	// Instanciado classe Generos
	private Generos genero = new Generos();

	// Criar sempre especie de CRUD
	// Geralmente publicos

	// Cadastro
	public boolean cadastrar(Jogos jogo) {

		boolean cadastroRealizado = false;

		if (beanJogos.getdadosValidos() == true) {

			// Metodo verificador jogos duplicados
			if (jogoDuplicado(jogo.getNomeJogo(), jogo.getPlataformaJogo()) == true) {
				cadastroRealizado = false;
			} else {
				BancoDados.arrayJogos.add(jogo);
				cadastroRealizado = true;
			}
		} else {
			beanJogos.setdadosValidos(true);

		}

		return cadastroRealizado;

	}

	// Read de Dados dentro do Banco
	// Retornará defaultablemodel porque vamos atualizar a tabela
	// com essas informações
	public DefaultTableModel readJogo() {

		// Define o modelo seguido
		DefaultTableModel modeloTabela = new DefaultTableModel();

		// Add Colunas ao Modelo
		modeloTabela.addColumn("Jogo");
		modeloTabela.addColumn("Gênero");
		modeloTabela.addColumn("Plataforma");
		modeloTabela.addColumn("Classificação");
		modeloTabela.addColumn("Valor");

		// Add Linhas
		for (int i = 0; i < (BancoDados.arrayJogos.size()); i++) {
			modeloTabela.addRow(new Object[] { // Pegando os valores do ArrayList
					BancoDados.arrayJogos.get(i).getNomeJogo(), // Passando a posicao
					BancoDados.arrayJogos.get(i).getGeneroJogo(), // E o que quero pegar
					BancoDados.arrayJogos.get(i).getPlataformaJogo(),
					BancoDados.arrayJogos.get(i).getClassificacaoJogo(), BancoDados.arrayJogos.get(i).getValorJogo() });
		}

		// Retornando o Modelo de Tabela
		return modeloTabela;

	}

	// Update dos Dados
	public void updateJogos(int indice, Jogos jogo) {

		// Inteiro para o index do Array
		// Objeto jogo porque o array é do tipo Jogos.

		if (beanJogos.getdadosValidos() == true) {
			try {
				BancoDados.arrayJogos.set(indice, jogo);

				JOptionPane.showMessageDialog(null, "Jogo atualizado com sucesso!", "Aviso do Sistema", 1, null);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro!\nErro: " + e.getMessage(),
						"Aviso do Sistema", 0, null);
			}
		} else {
			beanJogos.setdadosValidos(true);
		}

	}

	// Exclusao de Dados
	public void excluirJogo(int indice) {
		try {
			BancoDados.arrayJogos.remove(indice);

			JOptionPane.showMessageDialog(null, "Jogo excluído com sucesso!", "Aviso do Sistema", 1, null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir registro!\nErro: " + e.getMessage(),
					"Aviso do Sistema", 0, null);
		}

	}

	// Metodo Estatisticas
	public void retornaPlataforma() {

		// String Mensagem
		String mensagem = "PLATAFORMAS CADASTRADAS";

		// Variaveis contadoras
		int contador = 0;

		// Verificando
		for (int i = 0; i < (plat.vetorPlataformas.size()); i++) {

			// Zerando contadora
			contador = 0;

			// Verificando quais estao cadastados
			for (int j = 0; j < (BancoDados.arrayJogos.size()); j++) {

				if (plat.vetorPlataformas.get(i).getPlataforma()
						.equalsIgnoreCase(BancoDados.arrayJogos.get(j).getPlataformaJogo().toString())) {

					// Contabilizando
					contador++;
				}
			}

			// Add na Variavel mensagem
			if (contador != 0) {
				mensagem += "\n" + plat.vetorPlataformas.get(i).getPlataforma() + " - " + contador;
			}

		}

		// Mostrando mensagem para o Usuario
		JOptionPane.showMessageDialog(null, mensagem, "Alerta do Sistema", 1, null);

	}

	// Metodo para Generos
	public void retornaGeneros() {

		// String mensagem
		String mensagem = "GÊNEROS CADASTRADOS";

		// Variavel contadora
		int contador = 0;

		// Realizando buscas
		for (int i = 0; i < (genero.vetorGenero.size()); i++) {

			// Zerando contadora
			contador = 0;

			// Busca pelos cadastrados
			for (int j = 0; j < (BancoDados.arrayJogos.size()); j++) {
				if (genero.vetorGenero.get(i).getGenero()
						.equalsIgnoreCase(BancoDados.arrayJogos.get(j).getGeneroJogo().toString())) {
					contador++;
				}
			}

			// Verificacao se existe dados
			if (contador != 0) {
				mensagem += "\n " + genero.vetorGenero.get(i).getGenero() + " - " + contador;

			}
		}

		// Mostrando para o usuario
		JOptionPane.showMessageDialog(null, mensagem, "Alerta do Sistema", 1, null);
	}

	// Metodo para Verificar duplicidade dos Jogos
	private boolean jogoDuplicado(String nomeJogo, String plataformaJogo) {

		// Variavel verificadora
		boolean jogoDuplicado = false;

		// Fazendo busca no Banco de Dados
		for (int i = 0; i < (BancoDados.arrayJogos.size()); i++) {

			// Verificando campos
			if (nomeJogo.equalsIgnoreCase(BancoDados.arrayJogos.get(i).getNomeJogo())) {
				if (plataformaJogo.equalsIgnoreCase(BancoDados.arrayJogos.get(i).getPlataformaJogo())) {

					// Mensagem para o usuario
					JOptionPane.showMessageDialog(null,
							"O Jogo " + nomeJogo + " já está cadastrado na plataforma " + plataformaJogo
									+ ".\nMude a plataforma ou o jogo e tente novamente.",
							"Alerta do Sistema", 0, null);
					jogoDuplicado = true;
					break;
				}
			}
		}

		return jogoDuplicado;
	}

}
