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
public class Tipo_Habitacion 
{
    private String tipo_cama, fk_id_habitacion;
    private int cantidad_baño, precio;
    private char tipo_tv, tipo_wifi;

    public Tipo_Habitacion() {
    }

    public Tipo_Habitacion(String tipo_cama, String fk_id_habitacion, int cantidad_baño, int precio, char tipo_tv, char tipo_wifi) {
        this.tipo_cama = tipo_cama;
        this.fk_id_habitacion = fk_id_habitacion;
        this.cantidad_baño = cantidad_baño;
        this.precio = precio;
        this.tipo_tv = tipo_tv;
        this.tipo_wifi = tipo_wifi;
    }

    public String getTipo_cama() {
        return tipo_cama;
    }

    public void setTipo_cama(String tipo_cama) {
        this.tipo_cama = tipo_cama;
    }

    public String getFk_id_habitacion() {
        return fk_id_habitacion;
    }

    public void setFk_id_habitacion(String fk_id_habitacion) {
        this.fk_id_habitacion = fk_id_habitacion;
    }

    public int getCantidad_baño() {
        return cantidad_baño;
    }

    public void setCantidad_baño(int cantidad_baño) {
        this.cantidad_baño = cantidad_baño;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getTipo_tv() {
        return tipo_tv;
    }

    public void setTipo_tv(char tipo_tv) {
        this.tipo_tv = tipo_tv;
    }

    public char getTipo_wifi() {
        return tipo_wifi;
    }

    public void setTipo_wifi(char tipo_wifi) {
        this.tipo_wifi = tipo_wifi;
    }
    
    
}
