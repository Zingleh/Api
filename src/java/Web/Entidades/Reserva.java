/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Entidades;

import java.sql.Date;

/**
 *
 * @author Kill
 */
public class Reserva 
{
    private String id_reserva, estado_reserva, fk_rut_empresa, fk_nombre_empresa, fk_id_orden_compra;
    private Date fecha_inicio, fecha_termino;

    public Reserva() {
    }

    public Reserva(String id_reserva, String estado_reserva, String fk_rut_empresa, String fk_nombre_empresa, String fk_id_orden_compra, Date fecha_inicio, Date fecha_termino) {
        this.id_reserva = id_reserva;
        this.estado_reserva = estado_reserva;
        this.fk_rut_empresa = fk_rut_empresa;
        this.fk_nombre_empresa = fk_nombre_empresa;
        this.fk_id_orden_compra = fk_id_orden_compra;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public String getFk_rut_empresa() {
        return fk_rut_empresa;
    }

    public void setFk_rut_empresa(String fk_rut_empresa) {
        this.fk_rut_empresa = fk_rut_empresa;
    }

    public String getFk_nombre_empresa() {
        return fk_nombre_empresa;
    }

    public void setFk_nombre_empresa(String fk_nombre_empresa) {
        this.fk_nombre_empresa = fk_nombre_empresa;
    }

    public String getFk_id_orden_compra() {
        return fk_id_orden_compra;
    }

    public void setFk_id_orden_compra(String fk_id_orden_compra) {
        this.fk_id_orden_compra = fk_id_orden_compra;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }
    
    
}
