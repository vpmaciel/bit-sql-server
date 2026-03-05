package erp.server.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection connection = null;

    public static Connection conectarSQLAuth(String servidor, String porta, String banco, String usuario, String senha)
            throws SQLException {

        String url = "jdbc:sqlserver://" + servidor + ":" + porta + ";"
                + "databaseName=" + banco + ";"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=5;";
        connection = DriverManager.getConnection(url, usuario, senha); 
        return connection;
    }

    public static Connection conectarWindowsAuth(String servidor, String porta, String banco)
            throws SQLException {

        String url = "jdbc:sqlserver://" + servidor + ":" + porta + ";"
                + "databaseName=" + banco + ";"
                + "integratedSecurity=true;"
                + "authenticationScheme=NativeAuthentication;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=5;";

        connection = DriverManager.getConnection(url);
        return connection;
    }

}