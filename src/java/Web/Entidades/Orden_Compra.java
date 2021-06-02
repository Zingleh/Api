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
public class Orden_Compra 
{
    private String id_orden_compra, fk_rut_empresa, fk_nombre_empresa;

    public Orden_Compra() {
    }

    public Orden_Compra(String id_orden_compra, String fk_rut_empresa, String fk_nombre_empresa) {
        this.id_orden_compra = id_orden_compra;
        this.fk_rut_empresa = fk_rut_empresa;
        this.fk_nombre_empresa = fk_nombre_empresa;
    }

    public String getId_orden_compra() {
        return id_orden_compra;
    }

    public void setId_orden_compra(String id_orden_compra) {
        this.id_orden_compra = id_orden_compra;
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
    
    
}
