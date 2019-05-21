package acao;

import javax.swing.table.DefaultTableModel;

import beans.Estatisticas;
import dados.Dados;

public class AcaoEstatisticas {

	// Popular Estatisticas
	public void popularEstatisticas() {

		// Instanciar

		Estatisticas est = new Estatisticas();
		est.setEstatistica("Muito abaixo do Peso");

		Estatisticas est1 = new Estatisticas();
		est1.setEstatistica("Abaixo do Peso");

		Estatisticas est2 = new Estatisticas();
		est2.setEstatistica("Peso normal");

		Estatisticas est3 = new Estatisticas();
		est3.setEstatistica("Acima do peso");

		Estatisticas est4 = new Estatisticas();
		est4.setEstatistica("Obesidade I");

		Estatisticas est5 = new Estatisticas();
		est5.setEstatistica("Obesidade II (severa)");

		Estatisticas est6 = new Estatisticas();
		est6.setEstatistica("Obesidade III (m�rbida)");

		// Add no Banco
		Dados.vetorEstatisticas.add(est);
		Dados.vetorEstatisticas.add(est1);
		Dados.vetorEstatisticas.add(est2);
		Dados.vetorEstatisticas.add(est3);
		Dados.vetorEstatisticas.add(est4);
		Dados.vetorEstatisticas.add(est5);
		Dados.vetorEstatisticas.add(est6);

	}

	// Metodo Retornar o Modelo de Tabela
	public DefaultTableModel readEst() {

		// Instanciar
		DefaultTableModel modelo = new DefaultTableModel();

		// Add Coluns
		modelo.addColumn("Estatistica");
		modelo.addColumn("Quantidade");

		// Linhas
		for (int i = 0; i < (Dados.vetorEstatisticas.size()); i++) {
			modelo.addRow(new Object[] { // -------
					Dados.vetorEstatisticas.get(i).getEstatistica(), // --------
					Dados.vetorEstatisticas.get(i).getQnt(), });
		}

		// retornando
		return modelo;

	}

	// Verificando qual IMC o rapaz se encaixa
	private int verificaSituacao(Double imc) {

		// Variavel
		int posicao = -1;

		if (imc < 17) {
			posicao = 0;

		} else if (imc >= 17 && imc <= 18.49) {
			posicao = 1;
		} else if (imc >= 18.5 && imc <= 24.99) {
			posicao = 2;
		} else if (imc >= 25 && imc <= 29.99) {
			posicao = 3;
		} else if (imc >= 30 && imc <= 34.99) {
			posicao = 4;
		} else if (imc >= 35 && imc <= 39.99) {
			posicao = 5;
		} else if (imc > 40) {
			posicao = 6;
		}

		return posicao;
	}

	// contabilizar imc
	private void contImc(int index) {

		// Variavel
		int qntAtual = 0;

		// Percorrendo vetor
		qntAtual = Dados.vetorEstatisticas.get(index).getQnt();

		// Incrementando
		qntAtual++;

		// Novo Objeto para setar.
		Estatisticas est = new Estatisticas();
		est.setEstatistica(Dados.vetorEstatisticas.get(index).getEstatistica());
		est.setQnt(qntAtual);

		// Setando
		Dados.vetorEstatisticas.set(index, est);
	}

	// Subtrair imc
	private void subImc(int index) {

		// Variavel
		int qntAtual = 0;

		// Percorrendo vetor
		qntAtual = Dados.vetorEstatisticas.get(index).getQnt();

		// Incrementando
		qntAtual--;

		// Novo Objeto para setar.
		Estatisticas est = new Estatisticas();
		est.setEstatistica(Dados.vetorEstatisticas.get(index).getEstatistica());
		est.setQnt(qntAtual);

		// Setando
		Dados.vetorEstatisticas.set(index, est);
	}

	// Contabilizar novo Cadastro Tabela
	public void contabilizarEstatisticas(Double imc) {
		contImc(verificaSituacao(imc));
	}

	// Atualizar os j� existentes
	public void atualizarEstatisticas(Double imcNovo, Double imcAntigo) {

		if (imcNovo > 0) {
			contImc(verificaSituacao(imcNovo));
		}

		subImc(verificaSituacao(imcAntigo));

	}

}
