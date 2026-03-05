package erp.server.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JOptionPane;

import erp.arquitetura.gui.Msg;
import erp.sistema.main.MainController;

final class ServerControl {

    public class FechaJanela implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {
		getDatabaseJanCad().setVisible(false);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public class Frame extends WindowAdapter {

	@Override
	public void windowActivated(WindowEvent e) {
	    getDatabaseJanCad().reiniciarGui();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	    getDatabaseJanCad().setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	    server = new Server();
	}
    }

    public class Home implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {
		MainController.mostrarFrame(MainController.getMainJan());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public class ConectaUserSQL implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {

		server = new Server();

		int mensagem = Msg.confirmarConectarServidor();

		if (((getDBPainelCad().getGuiServidor().getText()) == null)
			|| (getDBPainelCad().getGuiServidor().getText().length() == 0)) {
		    getDBPainelCad().getGuiServidor().requestFocus();
		    Msg.avisoCampoObrigatorio("SERVER");
		    return;
		}
		
		if (((getDBPainelCad().getGuiPorta().getText()) == null)
			|| (getDBPainelCad().getGuiPorta().getText().length() == 0)) {
		    getDBPainelCad().getGuiPorta().requestFocus();
		    Msg.avisoCampoObrigatorio("PORT NUMBER");
		    return;
		}
		
		if (((getDBPainelCad().getGuiDatabase().getText()) == null)
			|| (getDBPainelCad().getGuiDatabase().getText().length() == 0)) {
		    getDBPainelCad().getGuiDatabase().requestFocus();
		    Msg.avisoCampoObrigatorio("DATABASE");
		    return;
		}
		
		if (((getDBPainelCad().getGuiUsuario().getText()) == null)
			|| (getDBPainelCad().getGuiUsuario().getText().length() == 0)) {
		    getDBPainelCad().getGuiUsuario().requestFocus();
		    Msg.avisoCampoObrigatorio("USER");
		    return;
		}
		
		if (((getDBPainelCad().getGuiSenha().getText()) == null)
			|| (getDBPainelCad().getGuiSenha().getText().length() == 0)) {
		    getDBPainelCad().getGuiSenha().requestFocus();
		    Msg.avisoCampoObrigatorio("PASSWORD");
		    return;
		}
		
		

		if (mensagem == JOptionPane.YES_OPTION) {
		    atualizarObjeto();
		    Msg.sucessoConectarServidor();
		    getDBPainelCad().getGuiDatabase().requestFocus();
		}

		setConnection(Conexao.conectarSQLAuth(server.getServidor(),server.getPorta(), server.getDatabaseName(), server.getUsuario(), server.getSenha()));
		Msg.sucessoConectarServidor();

	    } catch (Exception e) {
		e.printStackTrace();
		Msg.erroConectarServidor();
	    }
	}
    }
    
    public class ConectaUserSO implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {

		server = new Server();

		int mensagem = Msg.confirmarConectarServidor();

		if (((getDBPainelCad().getGuiServidor().getText()) == null)
			|| (getDBPainelCad().getGuiServidor().getText().length() == 0)) {
		    getDBPainelCad().getGuiServidor().requestFocus();
		    Msg.avisoCampoObrigatorio("SERVIDOR");
		    return;
		}
		
		if (((getDBPainelCad().getGuiPorta().getText()) == null)
			|| (getDBPainelCad().getGuiPorta().getText().length() == 0)) {
		    getDBPainelCad().getGuiPorta().requestFocus();
		    Msg.avisoCampoObrigatorio("PORTA");
		    return;
		}
		
		if (((getDBPainelCad().getGuiDatabase().getText()) == null)
			|| (getDBPainelCad().getGuiDatabase().getText().length() == 0)) {
		    getDBPainelCad().getGuiDatabase().requestFocus();
		    Msg.avisoCampoObrigatorio("DATABASE");
		    return;
		}

		if (mensagem == JOptionPane.YES_OPTION) {
		    atualizarObjeto();
		    getDBPainelCad().getGuiDatabase().requestFocus();
		}

		setConnection(Conexao.conectarWindowsAuth(server.getServidor(),server.getPorta(), server.getDatabaseName()));
		Msg.sucessoConectarServidor();		

	    } catch (Exception e) {
		e.printStackTrace();
		Msg.erroConectarServidor();
	    }
	}
    }

    private Connection connection;
    private Server server;
    
    ServerControl() {
	setConnection(null);
    }    

    public void atualizarGui() {
	if (server == null) {
	    return;
	}
	getDBPainelCad().getGuiSenha().setText(server.getSenha());
	getDBPainelCad().getGuiUsuario().setText(server.getUsuario());
	getDBPainelCad().getGuiDatabase().setText(server.getDatabaseName());
	getDBPainelCad().getGuiPorta().setText(server.getPorta());
	getDBPainelCad().getGuiServidor().setText(server.getServidor());

    }

    public void atualizarObjeto() {
	if (server == null) {
	    server = new Server();
	}
	server.setSenha(getDBPainelCad().getGuiSenha().getText());
	server.setPorta(getDBPainelCad().getGuiPorta().getText());
	server.setServidor(getDBPainelCad().getGuiServidor().getText());
	server.setUsuario(getDBPainelCad().getGuiUsuario().getText());
	server.setDatabaseName(getDBPainelCad().getGuiDatabase().getText());

    }

    public ServerJan getDatabaseJanCad() {
	return MainController.getUsuarioJan();
    }

    public ServerPainelCad getDBPainelCad() {
	return MainController.getUsuarioJan().getUsuarioPainelCad();
    }

    public Server getConta() {
	return server;
    }

    public void setUsuario(Server usuario) {
	this.server = usuario;
    }

    public Connection getConnection() {
	return connection;
    }

    public void setConnection(Connection connection) {
	this.connection = connection;
    }
}