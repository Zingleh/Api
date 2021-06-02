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
public class Detalle_Reserva 
{
    private String fk_sc_id_servicio, fk_id_habitacion, fk_rut_huesped;
    private int cantidad;

    public Detalle_Reserva() {
    }

    public Detalle_Reserva(String fk_sc_id_servicio, String fk_id_habitacion, String fk_rut_huesped, int cantidad) {
        this.fk_sc_id_servicio = fk_sc_id_servicio;
        this.fk_id_habitacion = fk_id_habitacion;
        this.fk_rut_huesped = fk_rut_huesped;
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

    public String getFk_rut_huesped() {
        return fk_rut_huesped;
    }

    public void setFk_rut_huesped(String fk_rut_huesped) {
        this.fk_rut_huesped = fk_rut_huesped;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
