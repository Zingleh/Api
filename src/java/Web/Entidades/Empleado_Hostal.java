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
public class Empleado_Hostal 
{
    private String id_trabajador, fk_id_usuario;
    private int sueldo;
    private char cargo;

    public Empleado_Hostal() {
    }

    public Empleado_Hostal(String id_trabajador, String fk_id_usuario, int sueldo, char cargo) {
        this.id_trabajador = id_trabajador;
        this.fk_id_usuario = fk_id_usuario;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public String getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(String id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getFk_id_usuario() {
        return fk_id_usuario;
    }

    public void setFk_id_usuario(String fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public char getCargo() {
        return cargo;
    }

    public void setCargo(char cargo) {
        this.cargo = cargo;
    }
    
    
}
