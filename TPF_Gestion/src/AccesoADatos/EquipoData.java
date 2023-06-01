package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EquipoData {

    private Connection con;

    public EquipoData() {
        con = ConexionGestion.getConexion();
    }

    public void crearEquipo(Equipo equipo) {

        String sql = "INSERT INTO equipo(IdProyecto, Nombre, FechaCreacion, Estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Equipo registrado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Equipo no registrado.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }

    public Equipo buscarEquipo(int id) {
        String sql = "SELECT * FROM equipo WHERE IdEquipo=?";
        Equipo equipo = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt(1));
                equipo.getProyecto().setIdProyecto(rs.getInt(2));
                equipo.setNombre(rs.getString(3));
                equipo.setFechaCreacion(rs.getDate(4).toLocalDate());
                equipo.setEstado(rs.getBoolean(5));

            } else {
                JOptionPane.showMessageDialog(null, "Equipo Inexistente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo " + ex.getMessage());
        }

        return equipo;
    }

}


