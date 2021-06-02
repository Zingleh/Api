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
public class Detalle_Factura_Proveedor 
{
    private String fk_id_factura, fk_id_articulo;
    private int cantidad;

    public Detalle_Factura_Proveedor() {
    }

    public Detalle_Factura_Proveedor(String fk_id_factura, String fk_id_articulo, int cantidad) {
        this.fk_id_factura = fk_id_factura;
        this.fk_id_articulo = fk_id_articulo;
        this.cantidad = cantidad;
    }

    public String getFk_id_factura() {
        return fk_id_factura;
    }

    public void setFk_id_factura(String fk_id_factura) {
        this.fk_id_factura = fk_id_factura;
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
    
    
}
