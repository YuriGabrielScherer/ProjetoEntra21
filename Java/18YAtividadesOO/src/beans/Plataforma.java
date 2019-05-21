package beans;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class Plataforma {

	public static ArrayList<Plataforma> vetorPlataformas = new ArrayList<Plataforma>();

	private String plataforma;

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public void cadastrarPlataformas() {
		Plataforma p1 = new Plataforma();
		p1.setPlataforma("PC");
		Plataforma p2 = new Plataforma();
		p2.setPlataforma("Playstation 3");
		Plataforma p3 = new Plataforma();
		p3.setPlataforma("Playstation 4");
		Plataforma p4 = new Plataforma();
		p4.setPlataforma("Android");
		Plataforma p5 = new Plataforma();
		p5.setPlataforma("iOS");
		Plataforma p6 = new Plataforma();
		p6.setPlataforma("Xbox 360");
		Plataforma p7 = new Plataforma();
		p7.setPlataforma("Xbox One");

		vetorPlataformas.add(p1);
		vetorPlataformas.add(p2);
		vetorPlataformas.add(p3);
		vetorPlataformas.add(p4);
		vetorPlataformas.add(p5);
		vetorPlataformas.add(p6);
		vetorPlataformas.add(p7);
	}

	public DefaultComboBoxModel<Plataforma> dadosPlataforma() {

		DefaultComboBoxModel<Plataforma> dados = new DefaultComboBoxModel<Plataforma>();
		for (int i = 0; i < vetorPlataformas.size(); i++) {
			dados.addElement(vetorPlataformas.get(i));
		}

		return dados;

	}

	public String toString() {
		return this.plataforma;
	}

}
