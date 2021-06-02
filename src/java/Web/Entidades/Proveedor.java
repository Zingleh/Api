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
public class Proveedor 
{
   private String rut_proveedor, id_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, fk_id_usuario;
   private String correo_proveedor;

    public Proveedor() {
    }

    public Proveedor(String rut_proveedor, String id_proveedor, String nombre_proveedor, String direccion_proveedor, String telefono_proveedor, String fk_id_usuario, String correo_proveedor) {
        this.rut_proveedor = rut_proveedor;
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.fk_id_usuario = fk_id_usuario;
        this.correo_proveedor = correo_proveedor;
    }

    public String getRut_proveedor() {
        return rut_proveedor;
    }

    public void setRut_proveedor(String rut_proveedor) {
        this.rut_proveedor = rut_proveedor;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getFk_id_usuario() {
        return fk_id_usuario;
    }

    public void setFk_id_usuario(String fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo_proveedor) {
        this.correo_proveedor = correo_proveedor;
    }
   
   
}
