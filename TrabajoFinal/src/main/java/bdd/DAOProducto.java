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

    public static List<Productos> catalogoProducto() {
        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new ArrayList();
        try {
            conn = ConexionBD.conectarBD();
            System.out.println("Conectado a: " + conn.getMetaData().getURL());
            PreparedStatement pst = conn.prepareStatement("SELECT producto.id, producto.nombre, categoria_nombre, producto.precio, stock.cantidad FROM producto left join stock\n"
                    + "on stock.producto_id=producto.id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        (Categoria) rs.getObject("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad\n")
                );
                buscados.add(producto);
                
            }
            System.out.println("Tamaño del catálogo: " + buscados.size());
        } catch (SQLException e) {
            System.err.println("No se ha podido llenar el catalogo " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }

    public static List buscarProducto(String elegido) {
        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new <Productos>ArrayList();
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM producto WHERE UPPER(nombre) LIKE ?");
            pst.setString(1, "'%" + elegido.toUpperCase() + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        (Categoria) rs.getObject("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock\n")
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

    public static void insertarProducto(String nombre, Categoria categoria, double precio) {
        Connection conn = null;

        if (!catalogoProducto().contains(nombre)) {
            try {
                String sql2 = "INSERT INTO producto (nombre, categoria_nombre, precio "
                        + "VALUES (?, ?, ?)";
                conn = ConexionBD.conectarBD();
                try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                    pstmt.setString(1, nombre);
                    pstmt.setObject(2, categoria);
                    pstmt.setDouble(3, precio);

                }
            } catch (Exception e) {
                System.out.println("Error al insertar el producto.");
            } finally {
                ConexionBD.desconectarBD(conn);
            }
        }
    }

    public static void borrarProductoPorId(int id) {
        Connection conn = null;
        try {
            String sql2 = "DELETE FROM producto "
                    + "WHERE id=?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setInt(1, id);

            }
        } catch (Exception e) {
            System.out.println("Error al borrar el producto.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    public static void modificarProducto(String nombre, Categoria categoria, double precio) {
        Connection conn = null;
        try {
            String sql2 = "UPDATE producto\n"
                    + "SET \n"
                    + "nombre = ?,\n"
                    + "categoria_nombre = ?,\n"
                    + "precio = ?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setString(1, nombre);
                pstmt.setObject(2, categoria);
                pstmt.setDouble(3, precio);

            }
        } catch (Exception e) {
            System.out.println("Error al modificar el producto.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    public static void modificarStock(String nombre, int cantidad) {
        Connection conn = null;
        try {
            String sql2 = "UPDATE stock\n"
                    + "SET \n"
                    + "producto_id = (select * from producto\n"
                    + "where upper(nombre) like '%?%'),\n"
                    + "cantidad = ?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setString(1, nombre);
                pstmt.setInt(2, cantidad);

            }
        } catch (Exception e) {
            System.out.println("Error al modificar el stock.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }
}
