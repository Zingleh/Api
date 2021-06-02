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
public class Articulo 
{
    private String id_articulo, nombre_articulo, fk_id_familia_artic;
    private int stock, stock_critico;

    public Articulo() {
    }

    public Articulo(String id_articulo, String nombre_articulo, String fk_id_familia_artic, int stock, int stock_critico) {
        this.id_articulo = id_articulo;
        this.nombre_articulo = nombre_articulo;
        this.fk_id_familia_artic = fk_id_familia_artic;
        this.stock = stock;
        this.stock_critico = stock_critico;
    }

    public String getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(String id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getFk_id_familia_artic() {
        return fk_id_familia_artic;
    }

    public void setFk_id_familia_artic(String fk_id_familia_artic) {
        this.fk_id_familia_artic = fk_id_familia_artic;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_critico() {
        return stock_critico;
    }

    public void setStock_critico(int stock_critico) {
        this.stock_critico = stock_critico;
    }
    
    
}
