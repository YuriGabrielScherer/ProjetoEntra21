package beans;

public class Funcionario {

	private String nome;

	private double salarioBruto, salarioLiquido;
	private int qntFaltas, setor;
	private boolean planoSaude, clubeFidelidade, vlTransporte;

	// Metodos Get e Set

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public int getQntFaltas() {
		return qntFaltas;
	}

	public void setQntFaltas(int qntFaltas) {
		this.qntFaltas = qntFaltas;
	}

	public boolean getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(boolean planoSaude) {
		this.planoSaude = planoSaude;
	}

	public boolean getClubeFidelidade() {
		return clubeFidelidade;
	}

	public void setClubeFidelidade(boolean clubeFidelidade) {
		this.clubeFidelidade = clubeFidelidade;
	}

	public boolean getVlTransporte() {
		return vlTransporte;
	}

	public void setVlTransporte(boolean vlTransporte) {
		this.vlTransporte = vlTransporte;
	}
}
