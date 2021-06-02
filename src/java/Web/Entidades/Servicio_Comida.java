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
public class Servicio_Comida 
{
    private String id_servicio, nombre_servicio;
    private int precio, fk_id_plato;

    public Servicio_Comida() {
    }

    public Servicio_Comida(String id_servicio, String nombre_servicio, int precio, int fk_id_plato) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.precio = precio;
        this.fk_id_plato = fk_id_plato;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getFk_id_plato() {
        return fk_id_plato;
    }

    public void setFk_id_plato(int fk_id_plato) {
        this.fk_id_plato = fk_id_plato;
    }
    
    
}
