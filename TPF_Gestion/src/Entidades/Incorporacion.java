package Entidades;

import java.time.LocalDate;

public class Incorporacion {

    private int idIncorporacion;

    private Equipo equipo;

    private Miembro miembro;

    private LocalDate fechaIncorporacion;

    public Incorporacion(int idIncorporacion, Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.idIncorporacion = idIncorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Incorporacion(Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.equipo = equipo;
        this.miembro = miembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Incorporacion() {
    }

    public int getIdIncorporacion() {
        return idIncorporacion;
    }

    public void setIdIncorporacion(int idIncorporacion) {
        this.idIncorporacion = idIncorporacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "Incorporacion{" + "idIncorporacion=" + idIncorporacion + ", equipo=" + equipo + ", miembro=" + miembro + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }

   

   
}
