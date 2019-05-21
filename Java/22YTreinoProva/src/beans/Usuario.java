package beans;

import javax.swing.JOptionPane;

public class Usuario {

	// Definindo Parametros do Usuario
	private String nome;
	private byte idade;
	private double altura, imc, peso;

	// Metodos GET

	public double getPeso() {
		return peso;
	}

	public String getNome() {
		return nome;
	}

	public double getImc() {
		return imc;
	}

	public byte getIdade() {
		return idade;
	}

	public double getAltura() {
		return altura;
	}

	// Metodos SET

	public void setAltura(double altura) {
		try {
			this.altura = altura;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "insira um valor v�lido para a altura.");

		}

	}

	public void setIdade(byte idade) {
		try {
			this.idade = idade;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "insira um valor v�lido para a idade.");
		}
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeso(double peso) {

		try {
			this.peso = peso;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "insira um valor v�lido para o peso.");
		}
	}

}
