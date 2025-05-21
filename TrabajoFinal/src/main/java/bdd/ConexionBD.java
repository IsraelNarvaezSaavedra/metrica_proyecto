package bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
public static Connection conectarBD() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDgame", "BDgame");
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
