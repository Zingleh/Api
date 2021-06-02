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
public class Detalle_Pedido 
{
    private String fk_id_articulo;
    private int cantidad, fk_id_pedido;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(String fk_id_articulo, int cantidad, int fk_id_pedido) {
        this.fk_id_articulo = fk_id_articulo;
        this.cantidad = cantidad;
        this.fk_id_pedido = fk_id_pedido;
    }

    public String getFk_id_articulo() {
        return fk_id_articulo;
    }

    public void setFk_id_articulo(String fk_id_articulo) {
        this.fk_id_articulo = fk_id_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFk_id_pedido() {
        return fk_id_pedido;
    }

    public void setFk_id_pedido(int fk_id_pedido) {
        this.fk_id_pedido = fk_id_pedido;
    }
    
    
}
