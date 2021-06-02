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
public class Orden_Pedido 
{
    private String fk_rut_proveedor, fk_id_proveedor;
    private int id_pedido;
    private Date fecha;

    public Orden_Pedido() {
    }

    public Orden_Pedido(String fk_rut_proveedor, String fk_id_proveedor, int id_pedido, Date fecha) {
        this.fk_rut_proveedor = fk_rut_proveedor;
        this.fk_id_proveedor = fk_id_proveedor;
        this.id_pedido = id_pedido;
        this.fecha = fecha;
    }

    public String getFk_rut_proveedor() {
        return fk_rut_proveedor;
    }

    public void setFk_rut_proveedor(String fk_rut_proveedor) {
        this.fk_rut_proveedor = fk_rut_proveedor;
    }

    public String getFk_id_proveedor() {
        return fk_id_proveedor;
    }

    public void setFk_id_proveedor(String fk_id_proveedor) {
        this.fk_id_proveedor = fk_id_proveedor;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
