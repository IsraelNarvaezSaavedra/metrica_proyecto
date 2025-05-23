package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPersona {
    
    //Se aniade una persona a la tabla cliente
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
            System.err.println("Error no se ha podido aniadir al cliente " + e.getMessage());
        }
    }

    //Para saber si el usuario que ha hecho el login es admin (trabajador) o no
    public static boolean esAdmin(String nombreUsuario) {
        boolean esAdmin = true;
        Connection conn = null;

        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT t.id FROM trabajador t \n"
                    + "JOIN persona p ON t.id = p.id \n"
                    + "WHERE p.usuario = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();
            esAdmin = rs.next();

        } catch (SQLException e) {
            System.err.println("Error, no se ha podido comprobar si es admin: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return esAdmin;
    }

    //Para registrar personas en la base de datos
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

    //Para que no se repita ni el correo ni el usuario
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


    //Para comprobar si ya existia esa persona de antes
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
            System.err.println("Error al verificar existencia de la cuenta de la persona: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return existe;
    }

    //Para borrar personas a traves de su nombre de usuario
    public static void borrarPersonaPorUsuario(String usuario) {
        Connection conn = null;

        try {
            String sql2 = "DELETE FROM persona "
                    + "WHERE usuario=?";
            conn = ConexionBD.conectarBD();
            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                pstmt.setString(1, usuario);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la persona.");
        } finally {
            ConexionBD.desconectarBD(conn);
        }
    }

    //Para modificar los datos de la personas
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
                pstmt.setInt(11, id);
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
