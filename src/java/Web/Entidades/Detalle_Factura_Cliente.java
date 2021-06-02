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
public class Detalle_Factura_Cliente 
{
    private String fk_sc_id_servicio, fk_id_habitacion, fk_id_factura;
    private int cantidad;

    public Detalle_Factura_Cliente() {
    }

    public Detalle_Factura_Cliente(String fk_sc_id_servicio, String fk_id_habitacion, String fk_id_factura, int cantidad) {
        this.fk_sc_id_servicio = fk_sc_id_servicio;
        this.fk_id_habitacion = fk_id_habitacion;
        this.fk_id_factura = fk_id_factura;
        this.cantidad = cantidad;
    }

    public String getFk_sc_id_servicio() {
        return fk_sc_id_servicio;
    }

    public void setFk_sc_id_servicio(String fk_sc_id_servicio) {
        this.fk_sc_id_servicio = fk_sc_id_servicio;
    }

    public String getFk_id_habitacion() {
        return fk_id_habitacion;
    }

    public void setFk_id_habitacion(String fk_id_habitacion) {
        this.fk_id_habitacion = fk_id_habitacion;
    }

    public String getFk_id_factura() {
        return fk_id_factura;
    }

    public void setFk_id_factura(String fk_id_factura) {
        this.fk_id_factura = fk_id_factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
