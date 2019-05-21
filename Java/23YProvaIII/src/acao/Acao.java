package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Produtos;
import dados.Dados;

public class Acao {

	// Cadastrar Produto
	public void addProduto(String nome) {

		// Variaveis
		int index = retornarCodigo(nome);
		int valorAtual = retornarQuantidade(index);

		// Incrementando
		valorAtual++;

		// Atualizando no banco
		Dados.vetorProdutos.set(index, criarObjeto(index, valorAtual));
	}

	// Diminuir produto
	public void tirarProduto(String nome) {

		// variaveis
		int index = retornarCodigo(nome);
		int valorAtual = retornarQuantidade(index);

		// Verificando
		if (valorAtual == 0) {
			JOptionPane.showMessageDialog(null, "N�o pode tirar de 0");
		} else {
			valorAtual--;
		}

		// Atualizando no Banco
		Dados.vetorProdutos.set(index, criarObjeto(index, valorAtual));

	}

	// Read Produtos
	public DefaultTableModel readProduto() {
		DefaultTableModel modelo = new DefaultTableModel();

		// Add Column
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");

		// Add linhas
		for (int i = 0; i < (Dados.vetorProdutos.size()); i++) {
			modelo.addRow(new Object[] { // --------
					Dados.vetorProdutos.get(i).getNome(), // -------
					Dados.vetorProdutos.get(i).getQuantidade(), });
		}
		return modelo;
	}

	// Metodo Para retornar o indice do Produto
	private int retornarCodigo(String nome) {

		// Variavel
		int codigo = -1;

		// Realizando a busca dentro do vetor
		for (int i = 0; i < (Dados.vetorProdutos.size()); i++) {
			if (nome.equals(Dados.vetorProdutos.get(i).getNome())) {
				codigo = i;
			}
		}

		// validacao
		if (codigo == -1) {
			JOptionPane.showMessageDialog(null, "C�digo n�o encontrado");
		}

		return codigo;

	}

	// Metodo para retornar a quantidade existente dentro do Vetor
	private int retornarQuantidade(int index) {

		// variavel
		int quantidade = -1;
		quantidade = Dados.vetorProdutos.get(index).getQuantidade();

		return quantidade;
	}

	// metodo privado para criar objeto
	private Produtos criarObjeto(int index, int quantidade) {
		// Criando Objeto
		Produtos p = new Produtos();
		p.setNome(Dados.vetorProdutos.get(index).getNome());
		p.setQuantidade(quantidade);

		return p;
	}

	// Metodo para adicionar os produtos existentes
	public void popularVetor() {

		// Instanciando
		Produtos prod1 = new Produtos();
		prod1.setNome("Camisa Amarela");

		Produtos prod2 = new Produtos();
		prod2.setNome("Camisa Verde");

		Produtos prod3 = new Produtos();
		prod3.setNome("Carro Gol");

		Produtos prod4 = new Produtos();
		prod4.setNome("Edif�cio Master");

		Produtos prod5 = new Produtos();
		prod5.setNome("Cal�a Preta");

		Produtos prod6 = new Produtos();
		prod6.setNome("Cal�a Amarela");

		Produtos prod7 = new Produtos();
		prod7.setNome("Perfume Kaiak");

		Produtos prod8 = new Produtos();
		prod8.setNome("Poltrona Sof�");

		// Add no banco
		Dados.vetorProdutos.add(prod1);
		Dados.vetorProdutos.add(prod2);
		Dados.vetorProdutos.add(prod3);
		Dados.vetorProdutos.add(prod4);
		Dados.vetorProdutos.add(prod5);
		Dados.vetorProdutos.add(prod6);
		Dados.vetorProdutos.add(prod7);
		Dados.vetorProdutos.add(prod8);

	}
}
