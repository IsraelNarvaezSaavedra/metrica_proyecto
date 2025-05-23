/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuarioDAW
 */
public class DAOPersona {

    public void aniadirCliente(String nombreUsuario) {
        try {
            Connection conn = ConexionBD.conectarBD();
            PreparedStatement checkStmt = null;
            ResultSet rs = null;
            String nuevaPersona = "INSERT INTO cliente (id)\n"
                    + "SELECT id FROM persona WHERE usuario LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(nuevaPersona)) {

                pstmt.setString(1, nombreUsuario);
                pstmt.executeUpdate();

            } finally {
                ConexionBD.desconectarBD(conn);

            }
        } catch (SQLException e) {
            System.err.println("buscarProducto: " + e.getMessage());
        }
    }

    public static boolean esAdmin(String nombreUsuario) {
        boolean existe = false;
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT 1 FROM trabajador \n"
                    + "WHERE id = (\n"
                    + "SELECT id FROM persona \n"
                    + "WHERE usuario = ?\n"
                    + ")";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de persona: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return existe;
    }

    public void registrarPersona(String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String calle, String nCasa, String nombreUsuario, String contraseñaUsuario) {
        try {
            Connection conn = ConexionBD.conectarBD();
            PreparedStatement checkStmt = null;
            ResultSet rs = null;
            String nuevaPersona = "INSERT INTO persona (nombre, apellido, tlf, correo, ciudad_nombre, localidad, calle, ncasa, usuario, passwd) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(nuevaPersona)) {
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
                pstmt.executeUpdate();
            } finally {
                ConexionBD.desconectarBD(conn);
                aniadirCliente(nombreUsuario);
            }
        } catch (SQLException e) {
            System.err.println("No se ha podido registrar a persona " + e.getMessage());
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

    public static boolean existeCuentaPersona(String contraseña, String usuario) {
        boolean existe = false;
        Connection conn = null;
        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT 1 FROM persona WHERE (usuario = ? AND passwd = ?) AND ROWNUM = 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de persona: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return existe;
    }

    public static void borrarPersonaPorUsuario(String usuario) {
        Connection conn = null;
        try {
            String sql2 = "DELETE FROM persona "
                    + "WHERE usuario=?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setString(1, usuario);

            }
        } catch (Exception e) {
            System.out.println("Error al borrar la persona.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    public static void modificarPersona(int id, String nombre, String apellidos, String tlf, String email, String localidad, String ciudad, String calle, String nCasa, String nombreUsuario, String contraseñaUsuario) {
        Connection conn = null;
        try {
            String sql = "UPDATE persona SET nombre = ?, apellido = ?, tlf = ?, correo = ?, localidad = ?, ciudad_nombre = ?, calle = ?, ncasa = ?, usuario = ?, passwd = ? WHERE id = ?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, apellidos);
                pstmt.setString(3, tlf);
                pstmt.setString(4, email);
                pstmt.setString(5, localidad);
                pstmt.setString(6, ciudad);
                pstmt.setString(7, calle);
                pstmt.setString(8, nCasa);
                pstmt.setString(9, nombreUsuario);
                pstmt.setString(10, contraseñaUsuario);
                pstmt.setInt(11, id); // ID de la persona a modificar
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }
}
