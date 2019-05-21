package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JButton testButton;
	private JPanel panelMain;
	private PanelTeste panel;

	public Formulario() {

		// setting up JFrame
		getContentPane().setLayout(null);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// creating main JPanel (white)
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setOpaque(false);
		panelMain.setBounds(10, 27, 255, 159);
		panelMain.setSize(500, 500);
		panelMain.setLayout(null);
		getContentPane().add(panelMain);

		// creating JButton in the main JPanel (white)
		testButton = new JButton("Button from main class");
		testButton.setBounds(10, 10, 100, 20);
		panelMain.add(testButton);

		testButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// creating new JPanelOne object from JPanelOne class containing black JPanel
				panel = new PanelTeste();

				
				// adding black JPanel to main JPanel (white)
				panelMain.add(panel);
				
				
				revalidate();
				repaint();

			}
		});
		

	}
}
