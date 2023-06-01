package Entidades;

import java.time.LocalDate;

public class Tarea {

    private int idTarea;

    private Incorporacion Incorporacion;

    private String nombre;

    private LocalDate comienzo;

    private LocalDate cierre;

    private boolean Estado;

    public Tarea(int idTarea, Incorporacion Incorporacion, String nombre, LocalDate comienzo, LocalDate cierre, boolean Estado) {
        this.idTarea = idTarea;
        this.Incorporacion = Incorporacion;
        this.nombre = nombre;
        this.comienzo = comienzo;
        this.cierre = cierre;
        this.Estado = Estado;
    }

    public Tarea(Incorporacion Incorporacion, String nombre, LocalDate comienzo, LocalDate cierre, boolean Estado) {
        this.Incorporacion = Incorporacion;
        this.nombre = nombre;
        this.comienzo = comienzo;
        this.cierre = cierre;
        this.Estado = Estado;
    }

    public Tarea() {
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public Incorporacion getIncorporacion() {
        return Incorporacion;
    }

    public void setIncorporacion(Incorporacion Incorporacion) {
        this.Incorporacion = Incorporacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getComienzo() {
        return comienzo;
    }

    public void setComienzo(LocalDate comienzo) {
        this.comienzo = comienzo;
    }

    public LocalDate getCierre() {
        return cierre;
    }

    public void setCierre(LocalDate cierre) {
        this.cierre = cierre;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", Incorporacion=" + Incorporacion + ", nombre=" + nombre + ", comienzo=" + comienzo + ", cierre=" + cierre + ", Estado=" + Estado + '}';
    }

   
}
