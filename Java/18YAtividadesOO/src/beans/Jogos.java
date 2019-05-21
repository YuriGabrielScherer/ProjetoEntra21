package beans;

import javax.swing.JOptionPane;

//Beans é uma representação de algum objeto
public class Jogos {

	// Atributos
	private String nomeJogo, generoJogo, plataformaJogo;
	private double valorJogo;
	private byte classificacaoJogo;

	private static boolean dadosValidos = true;

	// Metodos Get
	public String getNomeJogo() {
		return nomeJogo;
	}

	public String getGeneroJogo() {
		return generoJogo;
	}

	public String getPlataformaJogo() {
		return plataformaJogo;
	}

	public double getValorJogo() {
		return valorJogo;
	}

	public byte getClassificacaoJogo() {
		return classificacaoJogo;
	}

	public boolean getdadosValidos() {
		return dadosValidos;
	}

	// Metodos SET

	public void setNomeJogo(String nomeJogo) {

		// Validando a entrada de dados de Nome
		try {
			this.nomeJogo = nomeJogo;
		} catch (Exception e) {
			// Tratativa de Erros
			dadosValidos = false;
			JOptionPane.showMessageDialog(null, "Erro ao inserir o nome do jogo.\nErro: " + e.getMessage(),
					"Aviso do Sistema", 0, null);
			
		}

	}

	public void setClassificacaoJogo(String classificacaoJogo) {

		// Validando a entrada de dados de Idade
		try {
			this.classificacaoJogo = Byte.parseByte(classificacaoJogo);
		} catch (Exception e) {
			// Tratativa de Erro
			dadosValidos = false;
			JOptionPane.showMessageDialog(null,
					"Classificação Indicativa inválida.\nDigite apenas a idade mínima recomendada!\nErro: "
							+ e.getMessage(),
					"Aviso do Sistema", 0, null);

		}

	}

	public void setValorJogo(double valorJogo) {

		// Validando a Entrada de Dados de Valor
		try {
			this.valorJogo = valorJogo;
		} catch (Exception e) {
			// Tratativas de erros
			dadosValidos = false;
			JOptionPane.showMessageDialog(null,
					"Valor do jogo inválido.\nDigite apenas o valor de custo, sem unidade monetária!\nErro: "
							+ e.getMessage(),
					"Aviso do Sistema", 0, null);
			
		}

	}

	public void setPlataformaJogo(String plataformaJogo) {

		// Validando a entrada de dados de Plataforma
		try {
			this.plataformaJogo = plataformaJogo;
		} catch (Exception e) {
			// Tratativa de erros
			dadosValidos = false;
			JOptionPane.showMessageDialog(null, "Erro ao inserir plataforma\nErro: " + e.getMessage(),
					"Aviso do Sistema", 0, null);

		}

	}

	public void setGeneroJogo(String generoJogo) {
		// Validando a entrada de dados para Genero
		try {
			this.generoJogo = generoJogo;
		} catch (Exception e) {
			// Tratativas de Erros
			dadosValidos = false;
			JOptionPane.showMessageDialog(null, "Erro ao inserir gênero. \nErro: " + e.getMessage(), "Aviso do Sistema",
					0, null);
			
		}

	}

	public void setdadosValidos(boolean valor) {
		this.dadosValidos = valor;
	}

}
