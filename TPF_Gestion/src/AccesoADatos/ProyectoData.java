package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProyectoData {

    private Connection con;

    public ProyectoData() {
        con = ConexionGestion.getConexion();
    }

    public void crearProyectos(Proyecto proyecto) {

        String sql = "INSERT INTO proyecto(Nombre, Descripcion, FechaInicial, Estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicial()));
            ps.setBoolean(4, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proyecto registrado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Proyecto no registrado.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }

    }
    public List<Proyecto> listarProyectos(boolean estado) {
        ArrayList<Proyecto> listaProyecto = new ArrayList();

        String sql = "SELECT * FROM proyecto WHERE estado =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No existen Proyectos.");
            } else {
                do {
                    Proyecto proyecto = new Proyecto();
                    proyecto.setIdProyecto(rs.getInt(1));
                    proyecto.setNombre(rs.getString(2));
                    proyecto.setDescripcion(rs.getString(3));
                    proyecto.setFechaInicial(rs.getDate(4).toLocalDate());
                    proyecto.setEstado(rs.getBoolean(5));
                    listaProyecto.add(proyecto);
                } while (rs.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }

        return listaProyecto;

    }
    public Proyecto buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM proyecto WHERE Nombre=?";
        Proyecto proyecto = new Proyecto();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setFechaInicial(rs.getDate("FechaInicial").toLocalDate());
                proyecto.setEstado(rs.getBoolean("Estado"));

            } else {
                JOptionPane.showMessageDialog(null, "Proyecto Inexistente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto " + ex.getMessage());
        }

        return proyecto;

    }

    public void modificarProyecto(Proyecto proyecto) {
        String sql = "UPDATE proyecto SET Nombre=?, Descripcion=?, FechaInicial=?, Estado=? WHERE idProyecto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicial()));
            ps.setBoolean(4, proyecto.isEstado());
            ps.setInt(5, proyecto.getIdProyecto());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Proyecto modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Proyecto no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }
    }

    public void finalizado(int id) {
        String sql = "UPDATE proyecto SET  Estado=0 WHERE IdProyecto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Proyecto Finalizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Proyecto no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }
    }

    public void enProceso(int id) {
        String sql = "UPDATE proyecto SET  Estado=1 WHERE IdProyecto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Proyecto en Proceso.");
            } else {
                JOptionPane.showMessageDialog(null, "Proyecto no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }
    }

}
