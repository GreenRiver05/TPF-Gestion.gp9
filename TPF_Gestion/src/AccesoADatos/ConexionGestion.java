package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionGestion {

    private static final String DATABASE_URL = "jdbc:mariadb://";  //jdbc:mysql://
    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_PUERTO = ":3306";
    private static final String DATABASE_DB = "/gestion_gp9_com2";
    private static final String DATABASE_USUARIO = "root";
    private static final String DATABASE_PASSWORD = "";

    private static ConexionGestion conexion = null;

    private ConexionGestion() {
        try {
            //Cargar drivers
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver" + ex.getMessage());
        }
    }
    public static Connection getConexion() {
        Connection con = null;

        if (conexion == null) {
            conexion = new ConexionGestion();
        }

        try {
            // Setup the connection with the DB
            con = DriverManager.getConnection(
                    DATABASE_URL
                    + DATABASE_HOST
                    + DATABASE_PUERTO
                    + DATABASE_DB
                    + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                    + "&user="
                    + DATABASE_USUARIO
                    + "&password="
                    + DATABASE_PASSWORD
            );

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la BD " + ex.getMessage());
        }

        return con;
    }

}
