package Entidades;

public class Miembro {

    private int idMiembro;

    private int dni;

    private String apellido;

    private String nombre;

    private boolean Estado;

    public Miembro(int idMiembro, int dni, String apellido, String nombre, boolean Estado) {
        this.idMiembro = idMiembro;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.Estado = Estado;
    }

    public Miembro(int dni, String apellido, String nombre, boolean Estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.Estado = Estado;
    }

    public Miembro() {
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return  apellido + " " + nombre;
    }

  
}
