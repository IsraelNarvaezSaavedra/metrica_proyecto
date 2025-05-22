/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;

import static bdd.DAOProducto.catalogoProducto;
import entidades.Categoria;
import entidades.Productos;
import entidades.Valoracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isran
 */
public class DAOValoracion {

    public static void ponerValoracion(int producto_id, int cliente_id, String comentario, Double valoracion) {
        Connection conn = null;

        try {
            String sql2 = "INSERT INTO valoracion (producto_id, cliente_id, comentario, valoracion) "
                    + "VALUES (?, ?, ?, ?)";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setInt(1, producto_id);
                pstmt.setInt(2, cliente_id);
                pstmt.setString(3, comentario);
                pstmt.setDouble(4, valoracion);

            }
        } catch (Exception e) {
            System.out.println("Error al insertar el producto.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    public static List<Valoracion> valoracionProducto() {
        Valoracion resenia=null;
        Connection conn = null;
        List<Valoracion> buscados = new ArrayList();
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("select valoracion.cliente_id, persona.nombre, producto.nombre , valoracion.comentario, valoracion.valoracion from persona left join cliente\n"
                    + "on persona.id=cliente.id left join valoracion\n"
                    + "on cliente.id=valoracion.cliente_id left join producto\n"
                    + "on valoracion.producto_id=producto.id\n"
                    + "where producto.id=?");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                resenia = new Valoracion(
                        rs.getInt("producto_id"),
                        rs.getInt("cliente_id"),
                        rs.getString("comentario"),
                        rs.getDouble("valoracion")
                );
                buscados.add(resenia);

            }
        } catch (SQLException e) {
            System.err.println("No se ha podido llenar el catalogo " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }
}
