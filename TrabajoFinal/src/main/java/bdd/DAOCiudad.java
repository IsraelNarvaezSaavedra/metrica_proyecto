package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCiudad {

    //Obtener todas las ciudades ordenadas por el nombre
    public List<String> obtenerCiudades() {
        List<String> ciudades = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionBD.conectarBD();
            String sql = "SELECT nombre FROM ciudad ORDER BY nombre";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ciudades.add(rs.getString("nombre"));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener ciudades: " + e.getMessage());
        } finally {
            ConexionBD.desconectarBD(conn);
        }

        return ciudades;
    }
}
