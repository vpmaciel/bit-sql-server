package erp.database.state;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import erp.server.config.Conexao;

final class DBStateImp {

    public static List<Object[]> pesquisar() {
	Connection connection = Conexao.connection;
	if (connection == null) {
	    return null;
	}

        List<Object[]> lista = new LinkedList<>();

        String sql =
            "SELECT name, state_desc " +
            "FROM sys.databases order by state_desc";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] row = new Object[2];
                row[0] = rs.getString("name");
                row[1] = rs.getString("state_desc");

                lista.add(row);                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}