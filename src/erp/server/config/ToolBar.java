package erp.server.config;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {
    JButton buttonConectarSQL = new JButton("Connect SQL User");
    JButton buttonConectarSO = new JButton("Connect SO User");

    public ToolBar() {

	setLayout(null);

	setPreferredSize(new Dimension(0, 40));
	setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
	buttonConectarSO.setBounds(0, 5, 120, 30);
	buttonConectarSO.setBackground(Color.GREEN);
	buttonConectarSQL.setBounds(140, 5, 120, 30);
	buttonConectarSQL.setBackground(Color.BLUE);
	add(buttonConectarSO);
	add(buttonConectarSQL);
    }
    public JButton getConectarUserBtn() {
	return buttonConectarSQL;
    }
    
    public JButton getConectarSOBtn() {
	return buttonConectarSO;
    }
}