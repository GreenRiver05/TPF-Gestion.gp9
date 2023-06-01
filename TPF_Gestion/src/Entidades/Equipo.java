package Entidades;

import java.time.LocalDate;

public class Equipo {

    private int idEquipo;

    private Proyecto proyecto;

    private int nombre;

    private LocalDate fechaCreacion;

    private boolean estado;

    public Equipo(int idEquipo, Proyecto proyecto, int nombre, LocalDate fechaCreacion, boolean estado) {
        this.idEquipo = idEquipo;
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Equipo(Proyecto proyecto, int nombre, LocalDate fechaCreacion, boolean estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", proyecto=" + proyecto + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }

   
}
