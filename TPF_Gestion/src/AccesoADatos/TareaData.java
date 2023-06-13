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

public class TareaData {

   
    private Connection con;

    public TareaData() {
        con = ConexionGestion.getConexion();
    }

    public void crearTarea(Tarea tarea) {
        String sql = "INSERT INTO tarea(IdIncorporacion, Nombre, FechaComienzo, FechaCierre, Estado) VALUES (?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, tarea.getIncorporacion().getIdIncorporacion());
            ps.setString(2, tarea.getNombre());
            ps.setDate(3, Date.valueOf(tarea.getComienzo()));
            ps.setDate(4, Date.valueOf(tarea.getCierre()));
            ps.setBoolean(5, tarea.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                tarea.setIdTarea(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tarea registrada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Tarea no registrada.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
    }
    public ArrayList<Tarea> consultaInfoEquipo(int idEquipo) {
        ArrayList<Tarea> infoEquipo = new ArrayList();
        Incorporacion incorporacion = new Incorporacion();
        Tarea tarea = new Tarea();
        Miembro miembro = new Miembro();

        String sql = "SELECT miembro.Dni,miembro.Apellido,miembro.Nombre, miembro.Estado, tarea.Nombre \n"
                + "FROM incorporacion,miembro,tarea\n"
                + "WHERE incorporacion.IdEquipo =?\n"
                + "AND incorporacion.IdMiembro=miembro.IdMiembro\n"
                + "AND incorporacion.IdIncorporacion=tarea.IdIncorporacion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No existe Equipo.");
            } else {
                do {

                    miembro.setDni(rs.getInt(1));
                    miembro.setApellido(rs.getString(2));
                    miembro.setNombre(rs.getString(3));
                    miembro.setEstado(rs.getBoolean(4));
                    incorporacion.setMiembro(miembro);
                    tarea.setIncorporacion(incorporacion);
                    tarea.setNombre(rs.getString(5));
                    infoEquipo.add(tarea);

                } while (rs.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());

        }

        return infoEquipo;

    }
    public void finalizada(int id) {
        String sql = "UPDATE tarea SET  Estado=1 WHERE IdTarea=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Tarea Finalizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Tarea no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
    }
    public void enProceso(int id) {
        String sql = "UPDATE tarea SET  Estado=0 WHERE IdTarea=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Tarea en Proceso.");
            } else {
                JOptionPane.showMessageDialog(null, "Tarea no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
    }
    public void modificarTarea(Tarea tarea){
           String sql = "UPDATE tarea SET IdIncorporacion = ?, Nombre = ?, FechaComienzo = ?, FechaCierre = ?, Estado = ? WHERE IdTarea = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, tarea.getIncorporacion().getIdIncorporacion());
            ps.setString(2, tarea.getNombre());
            ps.setDate(3, Date.valueOf(tarea.getComienzo()));
            ps.setDate(4, Date.valueOf(tarea.getCierre()));
            ps.setBoolean(5, tarea.isEstado());
            ps.setInt(6, tarea.getIdTarea());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                tarea.setIdTarea(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tarea Modificada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Tarea no se pudo modificar registrada.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
    }
}
