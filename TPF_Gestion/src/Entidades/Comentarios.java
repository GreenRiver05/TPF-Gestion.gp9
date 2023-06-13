package Entidades;

import java.time.LocalDate;

public class Comentarios {

    private int idComentario;

    private Tarea tarea;

    private String comentario;

    private LocalDate avance;

    public Comentarios(int idComentario, Tarea tarea, String comentario, LocalDate avance) {
        this.idComentario = idComentario;
        this.tarea = tarea;
        this.comentario = comentario;
        this.avance = avance;
    }

    public Comentarios(Tarea tarea, String comentario, LocalDate avance) {
        this.tarea = tarea;
        this.comentario = comentario;
        this.avance = avance;
    }

    public Comentarios() {
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getAvance() {
        return avance;
    }

    public void setAvance(LocalDate avance) {
        this.avance = avance;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "idComentario=" + idComentario + ", tarea=" + tarea + ", comentario=" + comentario + ", avance=" + avance + '}';
    }  
}
