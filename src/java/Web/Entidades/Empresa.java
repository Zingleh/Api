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
public class Empresa 
{
    private String rut_empresa,correo, nombre_empresa, razon_social, direccion, telefono, fk_id_usuario;

    public Empresa() {
    }

    public Empresa(String rut_empresa,String correo, String nombre_empresa, String razon_social, String direccion, String telefono, String fk_id_usuario) {
        this.rut_empresa = rut_empresa;
        this.correo = correo;
        this.nombre_empresa = nombre_empresa;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fk_id_usuario = fk_id_usuario;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFk_id_usuario() {
        return fk_id_usuario;
    }

    public void setFk_id_usuario(String fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }
    
    
}
