/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Entidades;

/**
 *
 * @author Kill
 */
public class Habitacion 
{
    private String id_habitacion;
    private char tamaño, estado;

    public Habitacion() {
    }

    public Habitacion(String id_habitacion, char tamaño, char estado) {
        this.id_habitacion = id_habitacion;
        this.tamaño = tamaño;
        this.estado = estado;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public char getTamaño() {
        return tamaño;
    }

    public void setTamaño(char tamaño) {
        this.tamaño = tamaño;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
}
