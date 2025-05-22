package bdd;

import entidades.Valoracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOValoracion {

    public static void ponerValoracion(int producto_id, int cliente_id, String comentario, Double valoracion) {
        Connection conn = null;
        try {
            String sql = "INSERT INTO valoracion (producto_id, cliente_id, comentario, valoracion) VALUES (?, ?, ?, ?)";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, producto_id);
                pstmt.setInt(2, cliente_id);
                pstmt.setString(3, comentario);
                pstmt.setDouble(4, valoracion);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al insertar la valoración: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    public static List<Valoracion> valoracionProducto(int id) {
        List<Valoracion> valoraciones = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT valoracion.producto_id, valoracion.cliente_id, valoracion.comentario, valoracion.valoracion " +
                         "FROM valoracion " +
                         "JOIN cliente ON valoracion.cliente_id = cliente.id " +
                         "JOIN producto ON valoracion.producto_id = producto.id " +
                         "WHERE producto.id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Valoracion v = new Valoracion(
                    rs.getInt("producto_id"),
                    rs.getInt("cliente_id"),
                    rs.getString("comentario"),
                    rs.getDouble("valoracion")
                );
                valoraciones.add(v);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener valoraciones: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return valoraciones;
    }
}
