package acao;

import javax.swing.table.DefaultTableModel;

public abstract class PadraoAcao {

	// Metodos Padroes
	public abstract boolean cadastrar(Object E);

	public abstract void alterar();

	public abstract DefaultTableModel selecionar();

	public abstract void excluir(int index);

	// Metodos para Reutiliza��o;
	public void metodoDeReutilizacao() {
		// Nao � obrigatorio nas classes que extenderem
	}
}
