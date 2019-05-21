package acao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Usuario;
import dados.Dados;

public class Acao {

	// Instanciando Classes
	private AcaoEstatisticas acaoEst = new AcaoEstatisticas();
	// Metodos CRUD

	// Metodo Cadastrar
	public boolean cadastrarUsuario(Usuario user) {

		// Variavel
		boolean ver = false;
		try {
			// Realizando o cadastro
			if (nomeDuplicado(user.getNome()) == true) {

				// Add na Tabela Usuario
				Dados.vetorUsuario.add(user);

				ver = true;

				// Add Estatisticas
				acaoEst.contabilizarEstatisticas(user.getImc());

			} else {
				JOptionPane.showMessageDialog(null, "Usu�rio com nome duplicado, tente novamente!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro. Tente novamente.");
		}

		return ver;

	}

	// Metodo Read
	public DefaultTableModel readUsuario() {

		// Instanciando Classe
		DefaultTableModel modelo = new DefaultTableModel();

		// Add Colunas
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Altura");
		modelo.addColumn("Peso");
		modelo.addColumn("IMC");

		// Add Linhas
		for (int i = 0; i < (Dados.vetorUsuario.size()); i++) {
			modelo.addRow(new Object[] { // -----
					Dados.vetorUsuario.get(i).getNome(), // -----
					Dados.vetorUsuario.get(i).getIdade(), // -----
					Dados.vetorUsuario.get(i).getAltura(), // -----
					Dados.vetorUsuario.get(i).getPeso(), // -----
					Dados.vetorUsuario.get(i).getImc(), // -----

			});
		} // Fech. For

		// Retornando o Modelo
		return modelo;
	}

	// Metodo Excluir
	public void excluirUsuario(int index) {

		// Realizando Exclusao
		try {

			// Decrementando no Vetor Estatisticas
			acaoEst.atualizarEstatisticas(0.0, Dados.vetorUsuario.get(index).getImc());

			// Removendo
			Dados.vetorUsuario.remove(index);
			JOptionPane.showMessageDialog(null, "Usu�rio exclu�do com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir registro. Tente novamente.");
		}

	}

	// Metodo alterar
	public void alterarUsuario(Usuario user, int index, double imcAntigo) {

		// Realizando alteracao
		Dados.vetorUsuario.set(index, user);

		// Add Estatisticas
		acaoEst.atualizarEstatisticas(user.getImc(), imcAntigo);

	}

	// Metodo Calcular imc
	public double calculaImc(double peso, double altura) {

		// Realizando calculo
		double resposta = peso / (altura * altura);

		return resposta;

	}

	// ------
	// Realizar Verificacoes
	// ------

	private boolean nomeDuplicado(String nomeNovo) {

		// Variavel
		boolean ver = true;

		// Realizando a busca
		for (int i = 0; i < (Dados.vetorUsuario.size()); i++) {

			// Verificando a duplicidade de Nomes
			if (nomeNovo.equalsIgnoreCase(Dados.vetorUsuario.get(i).getNome())) {
				ver = false;
				break;
			}

		}

		// Retornando valor
		return ver;

	}

}