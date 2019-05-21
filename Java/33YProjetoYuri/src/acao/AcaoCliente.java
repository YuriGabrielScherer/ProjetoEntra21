package acao;

import javax.swing.table.DefaultTableModel;

import beans.Cliente;
import dados.Dados;

public class AcaoCliente extends PadraoAcao {

	// Instanciando classes
	Cliente cliente = new Cliente();
	Dados dados = new Dados();

	//
	// CRUD

	public boolean cadastrar(Object E) {
		// Metodo Cadastrar Cliente

		return false;
		

	}

	// Metodo Alterar Cliente
	public void alterar() {

	}

	// Metodo Selecionar Cliente
	public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();

		return modelo;
	}

	// Metodo Excluir Cliente
	public void excluir(int index) {

	}

	private void verificarDuplicidade() {
		// Metodo Verificar Duplicidade

	}

}
