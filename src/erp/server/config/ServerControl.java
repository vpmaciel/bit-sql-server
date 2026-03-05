package erp.server.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import erp.arquitetura.gui.Msg;
import erp.sistema.main.MainController;

final class ServerControl {

    public class FechaJanela implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {
		getServerJan().setVisible(false);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public class Frame extends WindowAdapter {

	@Override
	public void windowActivated(WindowEvent e) {
	    getServerJan().reiniciarGui();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	    getServerJan().setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	    server = new Server();
	}
    }

    public class ConectaUserSQL implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	    try {

		server = new Server();

		int mensagem = Msg.confirmarConectarServidor();

		if (((getServerPainelCad().getGuiServidor().getText()) == null)
			|| (getServerPainelCad().getGuiServidor().getText().length() == 0)) {
		    getServerPainelCad().getGuiServidor().requestFocus();
		    Msg.avisoCampoObrigatorio("SERVER");
		    return;
		}
		
		if (((getServerPainelCad().getGuiPorta().getText()) == null)
			|| (getServerPainelCad().getGuiPorta().getText().length() == 0)) {
		    getServerPainelCad().getGuiPorta().requestFocus();
		    Msg.avisoCampoObrigatorio("PORT NUMBER");
		    return;
		}
		
		if (((getServerPainelCad().getGuiDatabase().getText()) == null)
			|| (getServerPainelCad().getGuiDatabase().getText().length() == 0)) {
		    getServerPainelCad().getGuiDatabase().requestFocus();
		    Msg.avisoCampoObrigatorio("DATABASE");
		    return;
		}
		
		if (((getServerPainelCad().getGuiUsuario().getText()) == null)
			|| (getServerPainelCad().getGuiUsuario().getText().length() == 0)) {
		    getServerPainelCad().getGuiUsuario().requestFocus();
		    Msg.avisoCampoObrigatorio("USER");
		    return;
		}
		
		if (((getServerPainelCad().getGuiSenha().getText()) == null)
			|| (getServerPainelCad().getGuiSenha().getText().length() == 0)) {
		    getServerPainelCad().getGuiSenha().requestFocus();
		    Msg.avisoCampoObrigatorio("PASSWORD");
		    return;
		}
		
		

		if (mensagem == JOptionPane.YES_OPTION) {
		    atualizarObjeto();
		    Msg.sucessoConectarServidor();
		    getServerPainelCad().getGuiDatabase().requestFocus();
		}

		Conexao.conectarSQLAuth(server.getServidor(),server.getPorta(), server.getDatabaseName(), server.getUsuario(), server.getSenha());
		Msg.sucessoConectarServidor();
		getServerJan().setVisible(false);
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

		if (((getServerPainelCad().getGuiServidor().getText()) == null)
			|| (getServerPainelCad().getGuiServidor().getText().length() == 0)) {
		    getServerPainelCad().getGuiServidor().requestFocus();
		    Msg.avisoCampoObrigatorio("SERVER");
		    return;
		}
		
		if (((getServerPainelCad().getGuiPorta().getText()) == null)
			|| (getServerPainelCad().getGuiPorta().getText().length() == 0)) {
		    getServerPainelCad().getGuiPorta().requestFocus();
		    Msg.avisoCampoObrigatorio("PORT NUMBER");
		    return;
		}
		
		if (((getServerPainelCad().getGuiDatabase().getText()) == null)
			|| (getServerPainelCad().getGuiDatabase().getText().length() == 0)) {
		    getServerPainelCad().getGuiDatabase().requestFocus();
		    Msg.avisoCampoObrigatorio("DATABASE");
		    return;
		}

		if (mensagem == JOptionPane.YES_OPTION) {
		    atualizarObjeto();
		    getServerPainelCad().getGuiDatabase().requestFocus();
		}

		Conexao.conectarWindowsAuth(server.getServidor(),server.getPorta(), server.getDatabaseName());
		Msg.sucessoConectarServidor();		
		getServerJan().setVisible(false);

	    } catch (Exception e) {
		e.printStackTrace();
		Msg.erroConectarServidor();
	    }
	}
    }

    private Server server;
    
    ServerControl() {	
    }    

    public void atualizarGui() {
	if (server == null) {
	    return;
	}
	getServerPainelCad().getGuiSenha().setText(server.getSenha());
	getServerPainelCad().getGuiUsuario().setText(server.getUsuario());
	getServerPainelCad().getGuiDatabase().setText(server.getDatabaseName());
	getServerPainelCad().getGuiPorta().setText(server.getPorta());
	getServerPainelCad().getGuiServidor().setText(server.getServidor());

    }

    public void atualizarObjeto() {
	if (server == null) {
	    server = new Server();
	}
	server.setSenha(getServerPainelCad().getGuiSenha().getText());
	server.setPorta(getServerPainelCad().getGuiPorta().getText());
	server.setServidor(getServerPainelCad().getGuiServidor().getText());
	server.setUsuario(getServerPainelCad().getGuiUsuario().getText());
	server.setDatabaseName(getServerPainelCad().getGuiDatabase().getText());

    }

    public ServerJan getServerJan() {
	return MainController.getServerJan();
    }

    public ServerPainelCad getServerPainelCad() {
	return MainController.getServerJan().getServerPainelCad();
    }

    public Server getServer() {
	return server;
    }

    public void setServer(Server server) {
	this.server = server;
    }
}