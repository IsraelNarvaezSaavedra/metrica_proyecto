package bdd;

import entidades.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProducto {
    
    public Productos buscarProducto(String elegido) {
        Productos producto = null;
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("select * from producto where nombre like upper(%?%)");
            pst.setString(1, elegido);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                producto = new Productos(producto, rs.getString("password"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("buscarPorLogin: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return producto;
    }
    
}
