package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    private static final String url = "jdbc:mysql://localhost:3306/perifa";
    private static String user = "root";
    private static String password = "123";

    private static Connection conn;
    
    public static Connection getConexao() {

        try {
            if (conn == null ) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
}