package formulario;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;

public class PanelTeste extends JPanel {
	
	public PanelTeste() {
		  // setting up black JPanel
        JPanel panel = new JPanel();
        panel.setSize(100, 100);
        panel.setBackground(Color.BLACK);
        panel.setVisible(false);

        // adding blackJPanel
        add(panel);
	}

}
