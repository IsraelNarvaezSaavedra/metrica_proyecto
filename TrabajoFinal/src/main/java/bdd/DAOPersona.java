/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuarioDAW
 */
public class DAOPersona {
    public void registrarPersona(String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String calle, String nCasa, String nombreUsuario, String contraseñaUsuario){
        Connection conn = null;
        try {
            String sql2 = "INSERT INTO persona (nombre, apellido, tlf, correo, ciudad_nombre, localidad, calle, ncasa, usuario, passwd) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            conn = ConexionBD.conectarBD();
           try(PreparedStatement pstmt = conn.prepareStatement (sql2)){
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, tlf);
            pstmt.setString(4, email);
            pstmt.setString(5, ciudad);
            pstmt.setString(6, localidad);
            pstmt.setString(7, calle);
            pstmt.setString(8, nCasa);
            pstmt.setString(9, nombreUsuario);
            pstmt.setString(10, contraseñaUsuario);
           }
        } catch (Exception e) {
            System.out.println("Error al insertar usuario.");
        }
    }

    public static boolean existePersona(String correo, String usuario) {
        boolean existe = false;
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT 1 FROM persona WHERE (usuario = ? OR correo = ?) AND ROWNUM = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, correo);
            ResultSet rs = pst.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de persona: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return existe;
    }

}
