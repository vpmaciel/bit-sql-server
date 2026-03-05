package erp.database.state;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import erp.arquitetura.Sis;
import erp.arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class DBStateJan extends JFrame {

    
    private JTabbedPane tabbedPane;
    private DBStatePainelPesq dBStatePainelPesq;

    public DBStateJan() {
	iniciarLayout();
	iniciarGui();
	iniciarControlador();
    }

    public void iniciarControlador() {
	addWindowListener(new Frame());
    }

    public DBStatePainelPesq getPedidoPlacaPainelPesq() {
	return dBStatePainelPesq;
    }

    public JTabbedPane getTabbedPane() {
	return tabbedPane;
    }

    
    
    public void iniciarGui() {
	setTitle(Sis.getNomeSistema() + " - " + "Database State");
	setIconImage(Imagem.getLogoTipoImage());
	tabbedPane = new JTabbedPane();	
	dBStatePainelPesq = new DBStatePainelPesq();
	tabbedPane.addTab("Data", dBStatePainelPesq);

	add(tabbedPane);
	setContentPane(tabbedPane);
	pack();

    }

    public void iniciarLayout() {
	setLayout(new FlowLayout(FlowLayout.CENTER));
	setPreferredSize(Sis.getTamanhoJanela());
	setMinimumSize(Sis.getTamanhoJanela());
	setSize(Sis.getTamanhoJanela());
	setMaximumSize(Sis.getTamanhoJanela());
    }
    
    public class Frame extends WindowAdapter {

	@Override
	public void windowActivated(WindowEvent e) {
	    dBStatePainelPesq.atualizar();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	    //getPedidoPlacaJanCad().setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	    dBStatePainelPesq.atualizar();
	}
    }
    
    public class FechaJanela implements ActionListener {

 	@Override
 	public void actionPerformed(ActionEvent actionEvent) {
 	    try {
 		setVisible(false);
 	    } catch (Exception e) {
 		e.printStackTrace();
 	    }
 	}
     }
}
