package AccesoADatos;

import Entidades.Miembro;
import Entidades.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MiembroData {

    private Connection con;

    public MiembroData() {
        con = ConexionGestion.getConexion();
    }

    public void crearMiembro(Miembro miembro) {

        String sql = "INSERT INTO miembro(Dni, Apellido, Nombre, Estado) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, true);
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

    public Miembro buscarMiembro(int id) {
        String sql = "SELECT * FROM `miembro` WHERE IdMiembro=?";
        Miembro miembro = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

}
