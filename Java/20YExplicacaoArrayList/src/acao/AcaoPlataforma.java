package acao;

import javax.swing.table.DefaultTableModel;

import beans.Plataforma;
import dados.Dados;

public class AcaoPlataforma {
		
	// Verificar se a plataforma existe
	public void existePlataforma(String nomePlataforma) {

		// Verificar se existe a plataforma informada
		int linha = -1;

		for (int i = 0; i < Dados.arrayPlataforma.size(); i++) {
			if (nomePlataforma.equals(Dados.arrayPlataforma.get(i).getNome())) {
				linha = i;
				break;
			}
		}

		// Chamar método
		if (linha == -1) {
			Plataforma p = new Plataforma();
			p.setNome(nomePlataforma);
			p.setQuantidade(1);
			cadastrarPlataforma(p);
		} else {
			alterarPlataforma(linha);
		}

	}

	// Cadastrar plataforma
	private void cadastrarPlataforma(Plataforma p) {
		Dados.arrayPlataforma.add(p);
	}

	// Alterar plataforma
	private void alterarPlataforma(int indice) {

		// Obter dados da plataforma selecionada
		String nome = Dados.arrayPlataforma.get(indice).getNome();
		int quantidade = Dados.arrayPlataforma.get(indice).getQuantidade();
		quantidade++;

		// Criar um objeto da classe plataforma com os dados atualizados
		Plataforma p = new Plataforma();
		p.setNome(nome);
		p.setQuantidade(quantidade);

		Dados.arrayPlataforma.set(indice, p);
	}

	// Selecionar plataformas
	public DefaultTableModel selecionarPlataforma() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Plataforma");
		modelo.addColumn("Quantidade");

		for (int i = 0; i < Dados.arrayPlataforma.size(); i++) {
			modelo.addRow(new Object[] { Dados.arrayPlataforma.get(i).getNome(),
					Dados.arrayPlataforma.get(i).getQuantidade() });
		}

		return modelo;

	}
	
	// Atualizar plataformas
	public void atualizarPlataforma(String nomePlataforma, String nomeTemp) {
		
		//Obter a posição da plataforma
		int linha1 = -1, linha2 = -1;
		
		for(int i = 0; i < Dados.arrayPlataforma.size(); i++) {
			if(nomePlataforma.equals(Dados.arrayPlataforma.get(i).getNome())) {
				linha1 = i;
			}
			
			if(nomeTemp.equals(Dados.arrayPlataforma.get(i).getNome())) {
				linha2 = i;
			}
		}
		
		//Obter a quantidade de linhas
		int qtdRegistros1 = Dados.arrayPlataforma.get(linha1).getQuantidade();
		int qtdRegistros2 = Dados.arrayPlataforma.get(linha2).getQuantidade();
		
		qtdRegistros1++;
		qtdRegistros2--;
		
		//Instânciar objetos
		Plataforma p1 = new Plataforma();
		p1.setNome(nomePlataforma);
		p1.setQuantidade(qtdRegistros1);
		
		Plataforma p2 = new Plataforma();
		p2.setNome(nomeTemp);
		p2.setQuantidade(qtdRegistros2);

		Dados.arrayPlataforma.set(linha1, p1);
		Dados.arrayPlataforma.set(linha2, p2);
		
		
	}
	
}
























