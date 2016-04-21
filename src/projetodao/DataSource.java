package projetodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection con;

    public DataSource(String nomeBD) throws SQLException {
        String url, user, pass;
        url = "jdbc:mysql://localhost:3306/" + nomeBD;
        user = "root";
        pass = "";
        DriverManager.getConnection(url, user, pass);
    }

    public Connection getCon() {
        return con;
    }
}
