package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Funcionario;
import dados.Dados;

public class AcaoFuncionario extends PadraoAcao {

	// Instanciando Classes
	Funcionario func = new Funcionario();
	Dados dados = new Dados();

	//
	// CRUD

	// Metodo Cadastrar Funcionario
	public boolean cadastrar(Funcionario func) {

		// Variavel verificadora
		boolean ver = false;

		// Verificando Dados OK
		if (situacaoVerificadoras() == true) {

			// Codigo Duplicado
			if (codigoDuplicado(func.getCodigoFunc()) == false) {

				// Adicionando no Banco de Dados
				try {
					dados.vetorFuncionario.add(func);
					ver = true;
				} catch (Exception e) {
					ver = false;
				}
			}
		} else {

			// Resetando valores nas Classes para nao dar Pau depois
			func.setVerDadosFunc(true);
			func.setVerDadosP(true);
		}

		return ver;

	}

	// Metodo Alterar Funcionario
	public void alterar() {

	}

	// Metodo Selecionar funcionario
	public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();

		// Add Colunas
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Sexo");
		modelo.addColumn("CPF");
		modelo.addColumn("Data Admissão");
		modelo.addColumn("Salário");
		modelo.addColumn("Descontos");

		// Add Linhas ao Modelo
		for (int i = 0; i < (dados.vetorFuncionario.size()); i++) {
			modelo.addRow(new Object[] { // Add Linha
					dados.vetorFuncionario.get(i).getCodigoFunc(), dados.vetorFuncionario.get(i).getNomeP(),
					dados.vetorFuncionario.get(i).getSexoP(), dados.vetorFuncionario.get(i).getCpfP(),
					dados.vetorFuncionario.get(i).getDtCadP(), dados.vetorFuncionario.get(i).getSalarioFunc(),
					calcularDescontos(dados.vetorFuncionario.get(i).getSalarioFunc()) //
			});
		}

		// Retornando
		return modelo;
	}

	// Metodo Excluir Funcionario
	public void excluir(int index) {

		// Realizando a exclusão
		dados.vetorFuncionario.remove(index);
	}

	public boolean cadastrar(Object E) {
		return false;
	}

	//
	// Metodos Verificadores
	//

	// Return Situacao Variaveis
	private boolean situacaoVerificadoras() {

		// Verificadora
		boolean ver = false;

		// Verificando
		if ((func.getVerDadosFunc() == true) && (func.getVerDadosP() == true)) {
			ver = true;
		}

		return ver;
	}

	// Verificar Duplicidade Cod Funcionario
	private boolean codigoDuplicado(int codigoFunc) {

		// Verificadora
		boolean duplicado = false;

		// Buscando no Banco
		for (int i = 0; i < (dados.vetorFuncionario.size()); i++) {

			// Verificando e atribuindo valor
			if (codigoFunc == dados.vetorFuncionario.get(i).getCodigoFunc()) {
				duplicado = true;

				// Mensagem para o usuario
				JOptionPane.showMessageDialog(null, "Código de funcionário duplicado. Tente novamente.",
						"Alerta do Sistema", 0);
				break;
			}
		}

		return duplicado;
	}

	// Calculo de Salarios
	private double calcularDescontos(double salario) {

		// Variavel
		double descontos = 0;

		// Realizar calculos

		return descontos;

	}

}
