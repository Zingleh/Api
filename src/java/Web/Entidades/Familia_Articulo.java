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
public class Familia_Articulo 
{
    private String id_familia_articulo, nombre_familia_articulo;

    public Familia_Articulo() {
    }

    public Familia_Articulo(String id_familia_articulo, String nombre_familia_articulo) {
        this.id_familia_articulo = id_familia_articulo;
        this.nombre_familia_articulo = nombre_familia_articulo;
    }

    public String getId_familia_articulo() {
        return id_familia_articulo;
    }

    public void setId_familia_articulo(String id_familia_articulo) {
        this.id_familia_articulo = id_familia_articulo;
    }

    public String getNombre_familia_articulo() {
        return nombre_familia_articulo;
    }

    public void setNombre_familia_articulo(String nombre_familia_articulo) {
        this.nombre_familia_articulo = nombre_familia_articulo;
    }
    
    
}
