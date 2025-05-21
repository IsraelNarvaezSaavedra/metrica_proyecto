package bdd;

import entidades.Categoria;
import entidades.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto {
    
    public List todosLosProducto(String elegido) {
        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new <Productos>ArrayList();
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM producto");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"), 
                        (Categoria) rs.getObject("categoria"),
                        rs.getDouble("precio\n")
                );
                buscados.add(producto);
            }

        } catch (SQLException e) {
            System.err.println("No se han podido recoger todos los productos " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }
    
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
                        (Categoria) rs.getObject("categoria"),
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
    
    public void insertarProducto(String elegido, Categoria categoria, double precio) {
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO producto (nombre, categoria_nombre, precio)\n" +
"VALUES (?, ?, ?);");
            pst.setString(1, elegido);
            pst.setObject(2, categoria);
            pst.setDouble(3, precio);
            ResultSet rs = pst.executeQuery();
            
        } catch (SQLException e) {
            System.err.println("buscarProducto: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

}
