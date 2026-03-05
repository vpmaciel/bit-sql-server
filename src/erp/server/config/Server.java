package erp.server.config;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Server implements Serializable {

    private String databaseName;
    private String usuario;
    private String senha;
    private String porta;
    private String servidor;

    public String getDatabaseName() {
	return databaseName;
    }

    public void setDatabaseName(String databaseName) {
	this.databaseName = databaseName;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getPorta() {
	return porta;
    }

    public void setPorta(String porta) {
	this.porta = porta;
    }

    public String getServidor() {
	return servidor;
    }

    public void setServidor(String servidor) {
	this.servidor = servidor;
    }

    @Override
    public String toString() {
	return this.databaseName;
    }
}
