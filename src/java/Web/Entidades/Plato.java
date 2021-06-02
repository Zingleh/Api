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
public class Plato 
{
    private int id_plato, precio_unitario;
    private String nombre_plato, fk_id_articulo;

    public Plato() {
    }

    public Plato(int id_plato, int precio_unitario, String nombre_plato, String fk_id_articulo) {
        this.id_plato = id_plato;
        this.precio_unitario = precio_unitario;
        this.nombre_plato = nombre_plato;
        this.fk_id_articulo = fk_id_articulo;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getFk_id_articulo() {
        return fk_id_articulo;
    }

    public void setFk_id_articulo(String fk_id_articulo) {
        this.fk_id_articulo = fk_id_articulo;
    }
    
    
}
