package erp.sistema.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import erp.arquitetura.gui.Msg;
import erp.database.state.DBStateJan;
import erp.server.config.Conexao;
import erp.server.config.ServerJan;
import erp.sql.version.SQLVersionJan;


public final class MainController {

    public class FrameGerenteEventos extends WindowAdapter {

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
	    if (Msg.confirmarSairDoSistema() == JOptionPane.OK_OPTION) {
		System.exit(0);
	    }
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
    }

    public class MenuGerenteEventos implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

	    if (actionEvent.getSource() == mainJan.getMenuItemAjudaSobreSistema()) {
		Msg.ajuda();
		return;
	    }
	    
	    if (Conexao.connection == null) {
		mostrarFrame(serverJan);
		return;
	    }

	    if (actionEvent.getSource() == mainJan.getMenuItemArquivoConectar()) {
		mostrarFrame(serverJan);
	    }
	    if (actionEvent.getSource() == mainJan.getMenuItemControleDBState()) {
		mostrarFrame(dBStateJan);
	    }
	    
	    if (actionEvent.getSource() == mainJan.getMenuItemControleSQLVersion()) {
		mostrarFrame(sQLVersionJan);
	    }
	}
    }

    private static MainController mainControl;
    private static MainJan mainJan;
    private static DBStateJan dBStateJan;
    private static SQLVersionJan sQLVersionJan;
    private static ServerJan serverJan;


    public static synchronized MainController getInstance(MainJan mainJan) {
	if (mainControl == null) {
	    return new MainController(mainJan);
	}
	return mainControl;
    }

    public static MainJan getMainJan() {
	return mainJan;
    }

    public static DBStateJan getPedidoPlacaJan() {
	return dBStateJan;
    }

    public static ServerJan getServerJan() { //
	return serverJan;
    }

    public static void mostrarFrame(JFrame frame) {
	frame.setVisible(true);
	frame.toFront();
	frame.setLocationRelativeTo(null);
	mainJan.setLocationRelativeTo(null);
	frame.setResizable(false);
    }

    private MainController(MainJan mainJan) {
	MainController.mainJan = mainJan;
	criarFrames();
    }

    private void criarFrame(JFrame frame) {
	frame.pack();
	frame.setVisible(false);
    }

    private void criarFrames() {
	dBStateJan = new DBStateJan();
	criarFrame(dBStateJan);
	
	sQLVersionJan = new SQLVersionJan();
	criarFrame(sQLVersionJan);

	serverJan = new ServerJan();
	criarFrame(serverJan);
    }
}