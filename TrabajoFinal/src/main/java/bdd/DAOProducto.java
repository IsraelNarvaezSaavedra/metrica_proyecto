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

    //Para mostrar todo el catalogo de la tienda
    public static List<Productos> catalogoProducto() {
        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new ArrayList();

        try {

            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT p.id, p.nombre, p.categoria_nombre, p.precio, s.cantidad\n"
                    + "FROM producto p\n"
                    + "JOIN stock s ON s.producto_id = p.id\n"
                    + "\n"
                    + "UNION\n"
                    + "\n"
                    + "SELECT p.id, p.nombre, p.categoria_nombre, p.precio, NULL AS cantidad\n"
                    + "FROM producto p\n"
                    + "WHERE NOT EXISTS (\n"
                    + "    SELECT 1 FROM stock s WHERE s.producto_id = p.id\n"
                    + ")");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        Categoria.valueOf(rs.getString("categoria_nombre")),
                        rs.getDouble("precio"),
                        rs.getInt(5)
                );
                buscados.add(producto);

            }
        } catch (SQLException e) {
            System.err.println("No se ha podido llenar el catalogo " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }

    //Para buscar productos concretos
    public static List buscarProducto(String elegido) {

        Productos producto = null;
        Connection conn = null;
        List<Productos> buscados = new <Productos>ArrayList();

        try {

            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM producto left join stock\n"
                    + "on producto.id=stock.producto_id\n"
                    + "WHERE UPPER(nombre) LIKE ?");
            pst.setString(1, "%" + elegido.toUpperCase() + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        Categoria.valueOf(rs.getString("categoria_nombre")),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );
                buscados.add(producto);

            }

        } catch (SQLException e) {
            System.err.println("No se ha encontrado el producto " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }

    //Para insertar productos en la base de datos
    public static void insertarProducto(String nombre, Categoria categoria, double precio) {
        Connection conn = null;

        if (!catalogoProducto().contains(nombre)) {

            try {

                String sql2 = "INSERT INTO producto (nombre, categoria_nombre, precio)"
                        + "VALUES (?, ?, ?)";
                conn = ConexionBD.conectarBD();

                try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                    pstmt.setString(1, nombre);
                    pstmt.setObject(2, categoria);
                    pstmt.setDouble(3, precio);
                    pstmt.executeUpdate();

                }
            } catch (Exception e) {
                System.out.println("Error al insertar el producto.");
            } finally {
                ConexionBD.desconectarBD(conn);
            }
        }
    }

    //Para borrar productos a traves de su id
    public static void borrarProductoPorId(int id) {
        Connection conn = null;

        try {

            String sql2 = "DELETE FROM producto "
                    + "WHERE id=?";
            conn = ConexionBD.conectarBD();

            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el producto.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    //Para modificar los datos de un producto
    public static void modificarProducto(String nombre, Categoria categoria, double precio, int id) {
        Connection conn = null;

        try {

            String sql2 = "UPDATE producto SET nombre = ?, categoria_nombre = ?, precio = ? WHERE id = ?";
            conn = ConexionBD.conectarBD();

            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setString(1, nombre);
                pstmt.setObject(2, categoria);
                pstmt.setDouble(3, precio);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Error al modificar el producto." + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    //Para que cuando la gente compre se reduzca el stock
    public static void reducirStock(int productoId) {
        Connection conn = null;

        try {

            String sql = "UPDATE stock SET cantidad = cantidad - 1 WHERE producto_id = ? AND cantidad > 0";
            conn = ConexionBD.conectarBD();

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, productoId);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Error al reducir el stock: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

}
