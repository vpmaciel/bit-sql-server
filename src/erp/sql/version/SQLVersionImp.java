package erp.sql.version;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import erp.server.config.Conexao;

final class SQLVersionImp {

    public static List<Object[]> pesquisar() {
	Connection connection = Conexao.connection;
	if (connection == null) {
	    return null;
	}

        List<Object[]> lista = new LinkedList<>();

        String sql =
            "SELECT @@version";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] row = new Object[1];
                row[0] = rs.getString(1);                

                lista.add(row);                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}