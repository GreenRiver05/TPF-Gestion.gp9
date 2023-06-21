package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IncorporacionData {

    private Connection con;

    public IncorporacionData() {
        con = ConexionGestion.getConexion();
    }

    public void crearIncorporacion(Incorporacion incorporacion) { //FUNCA

        String sql = "INSERT INTO incorporacion (IdEquipo, IdMiembro,FechaIncorporacion) VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, incorporacion.getEquipo().getIdEquipo());
            ps.setInt(2, incorporacion.getMiembro().getIdMiembro());
            ps.setDate(3, Date.valueOf(incorporacion.getFechaIncorporacion()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                incorporacion.setIdIncorporacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Incorporacion registrada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Incorporacion no registrada.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ya pertenece a un equipo");
        }
        
    }

    public ArrayList<Incorporacion> buscarPorEquipo(Equipo equipo) { //FUNCA
        String sql = "SELECT miembro.Nombre, miembro.Apellido, miembro.Dni, miembro.Estado, incorporacion.FechaIncorporacion,"
                + " proyecto.Nombre, proyecto.Estado, incorporacion.Idincorporacion\n"
                + "FROM incorporacion, miembro, equipo, proyecto\n"
                + "WHERE equipo.IdEquipo = incorporacion.IdEquipo\n"
                + "AND incorporacion.IdMiembro = miembro.IdMiembro\n"
                + "and equipo.IdProyecto = proyecto.IdProyecto\n"
                + "AND equipo.Nombre = ?";

        ArrayList<Incorporacion> incorporacionesXEquipo = new ArrayList();

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getNombre());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    Incorporacion incorporacion = new Incorporacion();
                    Miembro miembro = new Miembro();
                    Proyecto proyecto = new Proyecto();
                    miembro.setNombre(rs.getString(1));
                    miembro.setApellido(rs.getString(2));
                    miembro.setDni(rs.getInt(3));
                    miembro.setEstado(rs.getBoolean(4));
                    incorporacion.setFechaIncorporacion(rs.getDate(5).toLocalDate());
                    proyecto.setNombre(rs.getString(6));
                    proyecto.setEstado(rs.getBoolean(7));
                    incorporacion.setIdIncorporacion(rs.getInt(8));
                    equipo.setProyecto(proyecto);
                    incorporacion.setEquipo(equipo);
                    incorporacion.setMiembro(miembro);
                    incorporacionesXEquipo.add(incorporacion);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Miembros para el equipo " + equipo.getNombre());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Incorporacion " + ex.getMessage());
        }

        return incorporacionesXEquipo;
    }

    public ArrayList<Incorporacion> buscarPorMiembro(Miembro miembro) { //FUNCA
        Proyecto proyecto = new Proyecto();
        Equipo equipo = new Equipo();
        Incorporacion incorporacion = new Incorporacion();
        ArrayList<Incorporacion> incorporacionesXMiembro = new ArrayList();
        String sql = "SELECT equipo.Nombre, equipo.Estado , incorporacion.FechaIncorporacion, proyecto.Nombre, proyecto.Estado, incorporacion.Idincorporacion\n"
                + "FROM incorporacion, miembro, equipo, proyecto\n"
                + "WHERE miembro.IdMiembro=incorporacion.IdMiembro\n"
                + "AND incorporacion.IdEquipo = equipo.IdEquipo\n"
                + "AND equipo.IdProyecto = proyecto.IdProyecto\n"
                + "AND miembro.Dni=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, miembro.getDni());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    proyecto.setNombre(rs.getString(4));
                    proyecto.setEstado(rs.getBoolean(5));
                    equipo.setProyecto(proyecto);
                    equipo.setNombre(rs.getString(1));
                    equipo.setEstado(rs.getBoolean(2));
                    incorporacion.setEquipo(equipo);
                    incorporacion.setIdIncorporacion(rs.getInt(6));
                    incorporacion.setFechaIncorporacion(rs.getDate(3).toLocalDate());
                    incorporacionesXMiembro.add(incorporacion);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Incorporacion alguna para " + miembro.getDni());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Incorporacion " + ex.getMessage());
        }

        return incorporacionesXMiembro;
    }

    public void eliminar(int idIncorporacion) { //FUNCA
        String sql = "DELETE FROM incorporacion WHERE IdIncorporacion=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idIncorporacion);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Incorporacion eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Incorporacion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Incorporacion" + ex.getMessage());
        }

    }

    public Incorporacion obtenerIdIncorporacion(String nombreProyecto, String nombreEquipo, int dni) {
        String sql = "SELECT incorporacion.IdIncorporacion\n"
                + "FROM equipo, miembro, incorporacion, proyecto\n"
                + "WHERE equipo.Nombre = ?\n"
                + "AND miembro.Dni = ?\n"
                + "AND proyecto.Nombre = ?\n"
                + "AND equipo.IdEquipo = incorporacion.IdEquipo\n"
                + "AND miembro.IdMiembro = incorporacion.IdMiembro";

        Incorporacion incorporacion = new Incorporacion();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreEquipo);
            ps.setString(3, nombreProyecto);
            ps.setInt(2, dni);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No existe Tarea.");
            } else {
                incorporacion.setIdIncorporacion(rs.getInt(1));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());

        }

        return incorporacion;

    }
}
