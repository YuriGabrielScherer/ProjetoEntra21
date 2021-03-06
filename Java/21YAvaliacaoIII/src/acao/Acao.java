package acao;

import javax.swing.table.DefaultTableModel;

import beans.Funcionario;
import beans.Setor;
import dados.Dados;

public class Acao {

	// Instanciando Banco de Dados
	private Dados dados = new Dados();

	// Metodos CRUD

	// Cadastrar Funcionario
	public void cadastrarFuncionario(Funcionario func) {

		func.setSalarioLiquido(calcularLiquido(func));
		// Adicionando no banco
		Dados.vetorFuncionario.add(func);

	}

	// Read
	public DefaultTableModel readFuncionario() {

		// Instanciando novo Modelo
		DefaultTableModel modeloTabela = new DefaultTableModel();

		// Colunas
		modeloTabela.addColumn("Funcion�rio");
		modeloTabela.addColumn("Sal�rio L�quido");

		// Adicionando Linhas
		for (int i = 0; i < (dados.vetorFuncionario.size()); i++) {
			modeloTabela.addRow(new Object[] { // Retornando as linhas
					dados.vetorFuncionario.get(i).getNome(), // Na Tabela
					dados.vetorFuncionario.get(i).getSalarioLiquido() // Func
			});
		}

		// Retornar
		return modeloTabela;

	}

	// Metodo calcular o salario
	public Double calcularLiquido(Funcionario func) {

		// Variavel
		double liquido = func.getSalarioBruto();

		// Imposto de Rendas
		liquido = liquido - calculaImposto(func.getSalarioBruto(), func.getSetor());

		// Validacoes
		if (func.getClubeFidelidade() == true) {
			liquido = liquido - 100;
		}

		if (func.getPlanoSaude() == true) {
			liquido = liquido - (liquido * 0.03);
		}

		if (func.getVlTransporte() == true) {
			liquido = liquido - calculaTransporte(func.getSalarioBruto());
		}

		if (func.getQntFaltas() == 0) {
			liquido = liquido + 100;
		}

		return liquido;
	}

	// Metodos individuais
	public double calculaImposto(Double bruto, int index) {

		// Descontando o Imposto de Renda
		double impostoRenda = dados.vetorSetores.get(index).getImposto();
		impostoRenda = bruto * (impostoRenda / 100);

		return (impostoRenda);
	}

	// Metodo valeTransporte
	public double calculaTransporte(Double bruto) {

		// Realizando calculo
		double transp = bruto * 0.06;

		return transp;

	}

}
