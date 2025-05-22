/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;

import static bdd.DAOProducto.catalogoProducto;
import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
