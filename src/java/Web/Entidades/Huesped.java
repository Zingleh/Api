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
public class Huesped 
{
    private String rut_huesped, nombre_completo, fk_rut_empresa, fk_nombre_empresa;

    public Huesped() {
    }

    public Huesped(String rut_huesped, String nombre_completo, String fk_rut_empresa, String fk_nombre_empresa) {
        this.rut_huesped = rut_huesped;
        this.nombre_completo = nombre_completo;
        this.fk_rut_empresa = fk_rut_empresa;
        this.fk_nombre_empresa = fk_nombre_empresa;
    }

    public String getRut_huesped() {
        return rut_huesped;
    }

    public void setRut_huesped(String rut_huesped) {
        this.rut_huesped = rut_huesped;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
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
