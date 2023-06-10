package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public Equipo buscarEquipo(String nom) {
        String sql = "SELECT * FROM equipo WHERE Nombre=?";
        Equipo equipo = null;
        Proyecto proyecto=null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                equipo = new Equipo();
                proyecto=new Proyecto();
                
                equipo.setIdEquipo(rs.getInt(1));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
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
    
    
     public ArrayList<Equipo> listarEquipos(boolean estado) {
        ArrayList<Equipo> equipos = new ArrayList();
  
       
        String sql = "SELECT* FROM equipo WHERE estado =? ORDER BY nombre";
      
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se encontraron equipos con el estado " + estado);
            } else {
                do {
                    
                    Equipo equipo=new Equipo();
                    Proyecto proyecto=new Proyecto();
                    
                    equipo.setIdEquipo(rs.getInt(1));
                    proyecto.setIdProyecto(rs.getInt("idProyecto"));
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
      public void modificarEquipo(Equipo equipo) { 
      
         String sql ="UPDATE equipo SET IdProyecto=?,Nombre=?,FechaCreacion=?,Estado=? WHERE idEquipo=?";
                     
        try {
            PreparedStatement ps = con.prepareStatement(sql);   
            
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, true);
           

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

    public void bajaEquipo(int id) { //FUNCA
        String sql = "UPDATE equipo SET estado=0 WHERE idEquipo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Baja Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Equipo con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }

    public void altaEquipo(int id) { 
        String sql = "UPDATE equipo SET estado=1 WHERE idEquipo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Alta Realizada.");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Equipo con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
    }


} 


