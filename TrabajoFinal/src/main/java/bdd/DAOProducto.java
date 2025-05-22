package bdd;

import entidades.Categoria;
import entidades.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

    public static List buscarProducto(String elegido) {
        System.out.println("se ha entrado al metodo buscar producto");
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
            System.out.println("se ha hecho la consulta");
            while (rs.next()) {
                System.out.println("se ha metido en el bucle y se va a aniadir a la lista: "+ rs.getString("nombre"));
                producto = new Productos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        Categoria.valueOf(rs.getString("categoria_nombre")),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );
                buscados.add(producto);
                System.out.println("Producto: " + rs.getString("nombre") + " | Stock: " + rs.getInt("cantidad"));
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
                String sql2 = "INSERT INTO producto (nombre, categoria_nombre, precio)"
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
