package bdd;

import entidades.Cliente;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPersona {
    
    
    public static List<Cliente> listaDePersonas() {
        Cliente cliente = null;
        Connection conn = null;
        List<Cliente> buscados = new ArrayList();

        try {

            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("select * from persona");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("tlf"),
                        rs.getString("correo"),
                        rs.getString("ciudad_nombre"),
                        rs.getString("localidad"),
                        rs.getString("calle"),
                        rs.getString("ncasa"),
                        rs.getString("usuario"),
                        rs.getString("passwd")
                        
                );
                buscados.add(cliente);

            }
        } catch (SQLException e) {
            System.err.println("No se ha podido llenar el catalogo " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return buscados;
    }
    
    //Se aniade una persona a la tabla cliente
    public void aniadirCliente(String nombreUsuario) {
        try {
            Connection conn = ConexionBD.conectarBD();
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

    public static int buscarUsuario(String usuario) {
        Connection conn = null;
        int id = 0;
        try {
            conn = ConexionBD.conectarBD();
            PreparedStatement pst = conn.prepareStatement("SELECT id FROM persona WHERE usuario LIKE ?");
            pst.setString(1, usuario);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("No se ha encontrado el producto " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }
        return id;
    }

    //Para registrar personas en la base de datos
    public void registrarPersona(Cliente cliente) {
        try {

            Connection conn = ConexionBD.conectarBD();
            String nuevaPersona = "INSERT INTO persona (nombre, apellido, tlf, correo, ciudad_nombre, localidad, calle, ncasa, usuario, passwd) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement pstmt = conn.prepareStatement(nuevaPersona)) {

                pstmt.setString(1, cliente.getNombre());
                pstmt.setString(2, cliente.getApellidos());
                pstmt.setString(3, cliente.getTlf());
                pstmt.setString(4, cliente.getEmail());
                pstmt.setString(5, cliente.getLocalidad());
                pstmt.setString(6, cliente.getCiudad());
                pstmt.setString(7, cliente.getCalle());
                pstmt.setString(8, cliente.getnCasa());
                pstmt.setString(9, cliente.getNombreUsuario());
                pstmt.setString(10, cliente.getContraseñaUsuario());
                pstmt.executeUpdate();

            } finally {
                ConexionBD.desconectarBD(conn);
                aniadirCliente(cliente.getNombreUsuario());
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
    public static void modificarPersona(Cliente cliente) {
        Connection conn = null;

        try {
            String sql = "UPDATE persona SET nombre = ?, apellido = ?, tlf = ?, correo = ?, localidad = ?, ciudad_nombre = ?, calle = ?, ncasa = ?, usuario = ?, passwd = ? WHERE id = ?";
            conn = ConexionBD.conectarBD();

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, cliente.getNombre());
                pstmt.setString(2, cliente.getApellidos());
                pstmt.setString(3, cliente.getTlf());
                pstmt.setString(4, cliente.getEmail());
                pstmt.setString(5, cliente.getLocalidad());
                pstmt.setString(6, cliente.getCiudad());
                pstmt.setString(7, cliente.getCalle());
                pstmt.setString(8, cliente.getnCasa());
                pstmt.setString(9, cliente.getNombreUsuario());
                pstmt.setString(10, cliente.getContraseñaUsuario());
                pstmt.setInt(11, cliente.getId());
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
