package bdd;

import entidades.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto {

    public List buscarProducto(String elegido) {
        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new <Productos>ArrayList();
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM producto WHERE UPPER(nombre) LIKE ?");
            pst.setString(1, "%" + elegido.toUpperCase() + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio\n")
                );
                buscados.add(producto);
            }

        } catch (SQLException e) {
            System.err.println("buscarProducto: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }
    
    

}
