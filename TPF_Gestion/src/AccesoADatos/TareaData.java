
package AccesoADatos;

import Entidades.Incorporacion;
import Entidades.Miembro;
import Entidades.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class TareaData {

    //"INSERT INTO tarea(IdIncorporacion, Nombre, FechaComienzo, FechaCierre, Estado) VALUES (?,?,?,?,?)" TAREA
    private Connection con;

    public TareaData() {
        con = ConexionGestion.getConexion();
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
}
