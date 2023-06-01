package AccesoADatos;

import Entidades.*;
import Entidades.Incorporacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class IncorporacionData {

    private Connection con;

    public IncorporacionData() {
        con = ConexionGestion.getConexion();
    }

    public void crearIncorporacion(Incorporacion incorporacion) {

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Incorporacion" + ex.getMessage());
        }
    }

    public Incorporacion buscarIncorporacion(int id) {
        String sql = "SELECT * FROM incorporacion WHERE IdIncorporacion=?";
        Incorporacion incorporacion = null;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                incorporacion = new Incorporacion();
                incorporacion.setIdIncorporacion(rs.getInt(1));
                incorporacion.getEquipo().setIdEquipo(rs.getInt(2));
                incorporacion.getMiembro().setIdMiembro(rs.getInt(3));
                incorporacion.setFechaIncorporacion(rs.getDate(4).toLocalDate());

            } else {
                JOptionPane.showMessageDialog(null, "Incorporacion Inexistente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Incorporacion " + ex.getMessage());
        }

        return incorporacion;
    }

}
