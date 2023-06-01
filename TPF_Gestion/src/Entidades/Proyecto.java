package Entidades;

import java.time.LocalDate;

public class Proyecto {

    private int IdProyecto;

    private String nombre;

    private String descripcion;

    private LocalDate fechaInicial;

    private boolean estado;

    public Proyecto(int IdProyecto, String nombre, String descripcion, LocalDate fechaInicial, boolean estado) {
        this.IdProyecto = IdProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.estado = estado;
    }

    public Proyecto(String nombre, String descripcion, LocalDate fechaInicial, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.estado = estado;
    }

    public Proyecto() {
    }

    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int IdProyecto) {
        this.IdProyecto = IdProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "IdProyecto=" + IdProyecto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicial=" + fechaInicial + ", estado=" + estado + '}';
    }

    
}
