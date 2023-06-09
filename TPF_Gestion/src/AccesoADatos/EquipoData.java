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

public class EquipoData {

    private Connection con;

    public EquipoData() {
        con = ConexionGestion.getConexion();
    }

    public void crearEquipo(Equipo equipo) { //FUNCA

        String sql = "INSERT INTO equipo(IdProyecto, Nombre, FechaCreacion, Estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, equipo.isEstado()); // Modificacion
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

    public Equipo buscarEquipo(String nom) { //FUNCA
        String sql = "SELECT equipo.IdEquipo,equipo.IdProyecto,equipo.Nombre,equipo.FechaCreacion,equipo.Estado,proyecto.Nombre"
                + " FROM equipo,proyecto WHERE equipo.Nombre=? AND proyecto.IdProyecto = equipo.IdProyecto";
        Equipo equipo = null;
        Proyecto proyecto = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                equipo = new Equipo();
                proyecto = new Proyecto();

                equipo.setIdEquipo(rs.getInt(1));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setNombre(rs.getString(6));
                equipo.setProyecto(proyecto);
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

    public ArrayList<Equipo> listarEquiposSinRepetir(boolean estado) {
        ArrayList<Equipo> equipos = new ArrayList();

        String sql = "SELECT DISTINCTROW equipo.Nombre FROM equipo WHERE equipo.estado =? ORDER BY equipo.nombre";  //sin repetir
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos con el estado " + estado);
            } else {
                do {

                    Equipo equipo = new Equipo();
                    equipo.setNombre(rs.getString(1));
                    equipos.add(equipo);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo " + ex.getMessage());
        }
        return equipos;
    }

    public ArrayList<Equipo> listarEquiposPorProyectos(String nombre) {
        ArrayList<Equipo> equipos = new ArrayList();

        String sql = "SELECT* FROM equipo,proyecto WHERE proyecto.Nombre =? AND equipo.IdProyecto = proyecto.IdProyecto ORDER BY equipo.nombre;"; //MODIFICADOOOOOOOOOOOOOOOOOOOOOOOOO

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos para ese proyecto ");
            } else {
                do {

                    Equipo equipo = new Equipo();
                    Proyecto proyecto = new Proyecto();

                    equipo.setIdEquipo(rs.getInt(1));
                    proyecto.setIdProyecto(rs.getInt(2));
                    proyecto.setNombre(rs.getString(7)); //AGREGADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
                    equipo.setProyecto(proyecto);
                    equipo.setNombre(rs.getString(3));
                    equipo.setFechaCreacion(rs.getDate(4).toLocalDate());
                    equipo.setEstado(rs.getBoolean(5));

                    equipos.add(equipo);

                } while (rs.next());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo " + ex.getMessage());
        }
        return equipos;
    }

    public ArrayList<Equipo> listarEquipos(boolean estado) { //FUNCA
        ArrayList<Equipo> equipos = new ArrayList();

        String sql = "SELECT* FROM equipo,proyecto WHERE equipo.estado =? AND equipo.IdProyecto = proyecto.IdProyecto ORDER BY equipo.nombre"; //MODIFICADOOOOOOOOOOOOOOOOOOOOOOOOO

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos con el estado " + estado);
            } else {
                do {

                    Equipo equipo = new Equipo();
                    Proyecto proyecto = new Proyecto();

                    equipo.setIdEquipo(rs.getInt(1));
                    proyecto.setIdProyecto(rs.getInt("idProyecto"));
                    proyecto.setNombre(rs.getString(7)); //AGREGADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
                    equipo.setProyecto(proyecto);
                    equipo.setNombre(rs.getString(3));
                    equipo.setFechaCreacion(rs.getDate(4).toLocalDate());
                    equipo.setEstado(rs.getBoolean(5));

                    equipos.add(equipo);

                } while (rs.next());

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo " + ex.getMessage());
        }
        return equipos;

    }

    public void modificarEquipo(Equipo equipo) { //FUNCA

        String sql = "UPDATE equipo SET IdProyecto=?,Nombre=?,FechaCreacion=?,Estado=? WHERE idEquipo=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, equipo.isEstado()); //Modificacion
            ps.setInt(5, equipo.getIdEquipo());

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Equipo modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El equipo no se encontro.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }

    public void bajaEquipo(String nombre) { //FUNCA
        String sql = "UPDATE equipo SET estado=0 WHERE nombre=?"; // Modificacion por nombre
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Baja Realizada.");
            } //else {
            //  JOptionPane.showMessageDialog(null, "No existe Equipo con ese Nombre");
            // }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }

    public void altaEquipo(String nombre) { //FUNCA
        String sql = "UPDATE equipo SET estado=1 WHERE nombre=?"; // Modificacion por nombre
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Alta Realizada.");
            }// else {
            //  JOptionPane.showMessageDialog(null, "No existe Equipo con ese Nombre");
            //}
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }

    public ArrayList<Equipo> listarTodosEquipos() {
        ArrayList<Equipo> equipos = new ArrayList();

        String sql = "SELECT * FROM equipo WHERE ?";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos con el estado ");
            } else {
                do {
                    Equipo equipo = new Equipo();
                    equipo.setNombre(rs.getString(3));
                    equipo.setIdEquipo(rs.getInt(1));
                    equipos.add(equipo);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo " + ex.getMessage());
        }
        return equipos;
    }
}
