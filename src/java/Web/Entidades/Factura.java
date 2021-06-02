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
public class Factura 
{
    private String id_factura,fk_rut_empresa, fk_nombre_empresa, fk_rut_proveedor, fk_id_proveedor, fk_eh_id_trabajador;
    private int precio_total, fk_id_pago;
    private Date fecha_factura;

    public Factura() {
    }

    public Factura(String id_factura, String fk_rut_empresa, String fk_nombre_empresa, String fk_rut_proveedor, String fk_id_proveedor, String fk_eh_id_trabajador, int precio_total, int fk_id_pago, Date fecha_factura) {
        this.id_factura = id_factura;
        this.fk_rut_empresa = fk_rut_empresa;
        this.fk_nombre_empresa = fk_nombre_empresa;
        this.fk_rut_proveedor = fk_rut_proveedor;
        this.fk_id_proveedor = fk_id_proveedor;
        this.fk_eh_id_trabajador = fk_eh_id_trabajador;
        this.precio_total = precio_total;
        this.fk_id_pago = fk_id_pago;
        this.fecha_factura = fecha_factura;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
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

    public String getFk_eh_id_trabajador() {
        return fk_eh_id_trabajador;
    }

    public void setFk_eh_id_trabajador(String fk_eh_id_trabajador) {
        this.fk_eh_id_trabajador = fk_eh_id_trabajador;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

    public int getFk_id_pago() {
        return fk_id_pago;
    }

    public void setFk_id_pago(int fk_id_pago) {
        this.fk_id_pago = fk_id_pago;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
    
    
}
