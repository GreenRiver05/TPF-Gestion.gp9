package Entidades;

import java.time.LocalDate;

public class Incorporacion {

    private int idMiembroEq;

    private Equipo equipo;

    private Miembro miembro;

    private LocalDate fechaIncorporacion;

    public Incorporacion(int idMiembroEq, Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.idMiembroEq = idMiembroEq;
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

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
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
        return "Incorporacion{" + "idMiembroEq=" + idMiembroEq + ", equipo=" + equipo + ", miembro=" + miembro + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }

   
}
