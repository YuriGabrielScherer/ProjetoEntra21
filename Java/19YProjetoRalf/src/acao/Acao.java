package acao;

import javax.swing.table.DefaultTableModel;

import beans.Curso;
import dados.Dados;

public class Acao {

	// CRUD - Create, Read, Update, Delete
	// Geralmente publicos

	// Cadastro
	public void cadastrar(Curso c) {
		// Aqui faz apenas o cadastro
		Dados.arrayCursos.add(c);

	}

	// Selecao
	public DefaultTableModel selecionar() {

		// Define o modelo
		DefaultTableModel modelo = new DefaultTableModel();

		// As colunas
		modelo.addColumn("Curso");
		modelo.addColumn("Área do Curso");

		// Definir as Linhas
		for (int indice = 0; indice < Dados.arrayCursos.size(); indice++) {
			modelo.addRow(new Object[] { 
					Dados.arrayCursos.get(indice).getNomeCurso(),
					Dados.arrayCursos.get(indice).getAreaCurso() });
		}

		// Bloqueando alteracoes nas colunas
		boolean[] columnEditables = new boolean[] { false, false };

		return modelo;
	}

	// Alteracao
	public void alterar(int indice, Curso c) {

		Dados.arrayCursos.set(indice, c);

	}

	// Exclusao
	public void excluir(int indice) {

		Dados.arrayCursos.remove(indice);

	}

	// Metodos para validacao podem ser privados

}
