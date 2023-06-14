package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
