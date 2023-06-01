/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author La Maquina
 */
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
        Proyecto proyecto = new Proyecto();

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

    
    
    
    
}
