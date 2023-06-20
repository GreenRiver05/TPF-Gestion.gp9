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

public class ComentarioData {

    private Connection con;

    public ComentarioData() {
        con = ConexionGestion.getConexion();
    }

    public void crearComentario(Comentarios comentario) { //FUNCA
        String sql = "INSERT INTO comentarios(IdTarea, Comentario, FechaAvance) VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, comentario.getTarea().getIdTarea());
            ps.setString(2, comentario.getComentario());
            ps.setDate(3, Date.valueOf(comentario.getAvance()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                comentario.setIdComentario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comentario registrado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Comentario no registrado.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
    }

    public void modificarCometario(Comentarios comentario) { //FUNCA
        String sql = "UPDATE comentarios SET IdTarea = ?, Comentario = ?, FechaAvance = ? WHERE IdComentario = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, comentario.getTarea().getIdTarea());
            ps.setString(2, comentario.getComentario());
            ps.setDate(3, Date.valueOf(comentario.getAvance()));
            ps.setInt(4, comentario.getIdComentario());
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Comentario modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Comentario no existe");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentario" + ex.getMessage());
        }
    }

    public void eliminarComentario(int id) { //FUNCA
        String sql = "DELETE FROM comentarios WHERE IdComentario = ?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Comentario eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Comentario");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentario" + ex.getMessage());
        }
    }

    public ArrayList<Comentarios> listarComentariosXTarea(int idTarea) {
        ArrayList<Comentarios> listaComentario = new ArrayList();

        String sql = "SELECT comentarios.Comentario,comentarios.FechaAvance FROM comentarios,tarea"
                + " WHERE tarea.IdTarea = ? AND tarea.IdTarea = comentarios.IdTarea";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No existen Comentarios.");
            } else {
                do {

                    Comentarios comentario = new Comentarios();
                    comentario.setComentario(rs.getString(1));
                    comentario.setAvance(rs.getDate(2).toLocalDate());
                    listaComentario.add(comentario);

                } while (rs.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentario" + ex.getMessage());

        }

        return listaComentario;
    }
}
