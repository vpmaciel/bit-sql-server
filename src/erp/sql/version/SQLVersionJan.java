package erp.sql.version;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import erp.arquitetura.Sis;
import erp.arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class SQLVersionJan extends JFrame {

    
    private JTabbedPane tabbedPane;
    private SQLVersionPainelPesq sQLVersionPainelPesq;

    public SQLVersionJan() {
	iniciarLayout();
	iniciarGui();
	iniciarControlador();
    }

    public void iniciarControlador() {
	addWindowListener(new Frame());
    }

    public SQLVersionPainelPesq getPedidoPlacaPainelPesq() {
	return sQLVersionPainelPesq;
    }

    public JTabbedPane getTabbedPane() {
	return tabbedPane;
    }

    
    
    public void iniciarGui() {
	setTitle(Sis.getNomeSistema() + " - " + "SQL Version");
	setIconImage(Imagem.getLogoTipoImage());
	tabbedPane = new JTabbedPane();	
	sQLVersionPainelPesq = new SQLVersionPainelPesq();
	tabbedPane.addTab("Data", sQLVersionPainelPesq);	
	setContentPane(tabbedPane);
	pack();

    }

    public void iniciarLayout() {
	setLayout(new BorderLayout());
	setPreferredSize(Sis.getTamanhoJanela());
	setMinimumSize(Sis.getTamanhoJanela());
	setSize(Sis.getTamanhoJanela());
	setMaximumSize(Sis.getTamanhoJanela());
    }
    
    public class Frame extends WindowAdapter {

	@Override
	public void windowActivated(WindowEvent e) {
	    sQLVersionPainelPesq.atualizar();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	    setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	    sQLVersionPainelPesq.atualizar();
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
