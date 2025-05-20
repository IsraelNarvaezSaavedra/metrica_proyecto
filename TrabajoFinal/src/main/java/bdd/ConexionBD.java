package bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
public static Connection conectarBD() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        return DriverManager.getConnection(url, "BDgame", "BDgame");
    }

    public static void desconectarBD(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al desconectar BD: " + e.getMessage());
            }
        }
    }
}
