package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MiembroData {

    private Connection con;

    public MiembroData() {
        con = ConexionGestion.getConexion();
    }

    public void crearMiembro(Miembro miembro) { //FUNCA

        String sql = "INSERT INTO miembro(Dni, Apellido, Nombre, Estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.isEstado()); // modificacion
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                miembro.setIdMiembro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Miembro registrado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Miembro no registrado.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
    }

    public Miembro buscarMiembroDNI(int dni) {//FUNCA
        String sql = "SELECT idMiembro,Dni, Apellido, Nombre, Estado FROM miembro WHERE Dni=?";
        Miembro miembro = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro = new Miembro();
                miembro.setIdMiembro(rs.getInt(1));
                miembro.setDni(rs.getInt(2));
                miembro.setApellido(rs.getString("Apellido"));
                miembro.setNombre(rs.getString("Nombre"));
                miembro.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Miembro Inexistente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }

        return miembro;
    }

    public Miembro buscarMiembroPorApellido(String Apellido) { //FUNCA
        String sql = "SELECT * FROM `miembro` WHERE Apellido=?";
        Miembro miembro = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Apellido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro = new Miembro();
                miembro.setIdMiembro(rs.getInt(1));
                miembro.setDni(rs.getInt(2));
                miembro.setNombre(rs.getString(4));
                miembro.setApellido(rs.getString(3));
                miembro.setEstado(rs.getBoolean(5));

            } else {
                JOptionPane.showMessageDialog(null, "Miembro Inexistente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }

        return miembro;
    }

    public ArrayList<Miembro> listarTodosLosMiembros() {
        ArrayList<Miembro> listarTodos = new ArrayList();
        String sql = "SELECT nombre, Apellido,dni FROM miembro WHERE ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {

                    Miembro miembro = new Miembro();
                    miembro.setNombre(rs.getString(1));
                    miembro.setApellido(rs.getString(2));
                    miembro.setDni(rs.getInt(3));
                    listarTodos.add(miembro);

                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Miembros para el proyecto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return listarTodos;

    }

    public ArrayList<Miembro> listarMiembrosSinEquipos() {
        ArrayList<Miembro> listarTodos = new ArrayList();
        String sql = "SELECT m.idMiembro, m.nombre, m.apellido,m.Dni\n"
                + "FROM miembro m\n"
                + "WHERE NOT EXISTS (\n"
                + "    SELECT 1\n"
                + "    FROM incorporacion i\n"
                + "    WHERE i.idMiembro = m.idMiembro\n"
                + ")";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {

                    Miembro miembro = new Miembro();
                    miembro.setIdMiembro(rs.getInt(1));
                    miembro.setNombre(rs.getString(2));
                    miembro.setApellido(rs.getString(3));
                    miembro.setDni(rs.getInt(4));
                    listarTodos.add(miembro);

                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Todos los miembros estan en un Equipos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return listarTodos;

    }

    public ArrayList<Miembro> buscarMiembrosXProyecto(String nombre) { //FUNCA
        String sql = "SELECT miembro.Nombre, miembro.Apellido, miembro.dni\n"
                + "FROM incorporacion, miembro, equipo, proyecto\n"
                + "WHERE equipo.IdEquipo = incorporacion.IdEquipo\n"
                + "AND incorporacion.IdMiembro = miembro.IdMiembro\n"
                + "and equipo.IdProyecto = proyecto.IdProyecto\n"
                + "AND proyecto.nombre = ?";

        ArrayList<Miembro> miembroXEquipo = new ArrayList();

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {

                    Miembro miembro = new Miembro();
                    miembro.setNombre(rs.getString(1));
                    miembro.setApellido(rs.getString(2));
                    miembro.setDni(rs.getInt(3));
                    miembroXEquipo.add(miembro);

                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Miembros para el proyecto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return miembroXEquipo;
    }

    public ArrayList<Miembro> listarMiembrosPorEstado(boolean estado) {//FUNCA
        ArrayList<Miembro> miembross = new ArrayList();
        String sql = "SELECT* FROM miembro WHERE Estado =? ORDER BY Apellido";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron miembros con el estado " + estado);
            } else {
                do {
                    Miembro miembro = new Miembro();
                    miembro.setIdMiembro(rs.getInt("idMiembro"));
                    miembro.setDni(rs.getInt("Dni"));
                    miembro.setNombre(rs.getString("Nombre"));
                    miembro.setApellido(rs.getString("Apellido"));
                    miembro.setEstado(rs.getBoolean("Estado"));
                    miembross.add(miembro);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return miembross;

    }

    public ArrayList<Miembro> listarMiembrosXEquipo(String nombre) {//FUNCA
        ArrayList<Miembro> miembross = new ArrayList();
        String sql = "SELECT DISTINCTROW miembro.Dni,miembro.Apellido,miembro.Nombre, miembro.Estado\n"
                + "                FROM incorporacion,miembro,equipo\n"
                + "                WHERE equipo.Nombre = ?\n"
                + "                AND incorporacion.IdMiembro=miembro.IdMiembro\n"
                + "                AND equipo.IdEquipo = incorporacion.IdEquipo";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron miembros con el estado ");
            } else {
                do {
                    Miembro miembro = new Miembro();
                    miembro.setDni(rs.getInt("Dni"));
                    miembro.setNombre(rs.getString("Nombre"));
                    miembro.setApellido(rs.getString("Apellido"));
                    miembro.setEstado(rs.getBoolean("Estado"));
                    miembross.add(miembro);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return miembross;

    }

    public ArrayList<Miembro> listarMiembroXEquipoYProyecto(String equipo, String proyecto) {
        ArrayList<Miembro> miembros = new ArrayList();
        String sql = "SELECT miembro.Dni,miembro.Apellido,miembro.Nombre, miembro.Estado\n"
                + "                FROM incorporacion,miembro,equipo,proyecto\n"
                + "                WHERE equipo.Nombre =? AND proyecto.Nombre =?\n"
                + "                AND incorporacion.IdMiembro=miembro.IdMiembro\n"
                + "                AND equipo.IdEquipo = incorporacion.IdEquipo\n"
                + "                AND proyecto.IdProyecto = equipo.IdProyecto";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            ps.setString(2, proyecto);
            ResultSet rs=ps.executeQuery();
            

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron miembros con el estado ");

            } else {
                do {
                    Miembro miembro = new Miembro();
                    miembro.setDni(rs.getInt("Dni"));
                    miembro.setNombre(rs.getString("Nombre"));
                    miembro.setApellido(rs.getString("Apellido"));
                    miembro.setEstado(rs.getBoolean("Estado"));
                    miembros.add(miembro);

                } while (rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        return miembros;

    }

    public void bajaMiembro(int dni) { //FUNCA
        String sql = "UPDATE miembro SET Estado=0 WHERE Dni=?"; //CAMBIAMOS POR DNI
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Baja Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Miembro con ese Dni");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
    }

    public void altaMiembro(int dni) {//FUNCA

        String sql = "UPDATE miembro SET Estado=1 WHERE Dni=?"; //CAMBIAMOS POR DNI
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Alta Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Miembro con ese Dni");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }

    }

    public void modificarMiembro(Miembro miembro) {//FUNCA
        String sql = "UPDATE miembro SET Dni=? ,Apellido=?, Nombre=?, Estado=? WHERE idMiembro=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.isEstado());
            ps.setInt(5, miembro.getIdMiembro());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Miembro modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Miembro no existente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
    }

}
