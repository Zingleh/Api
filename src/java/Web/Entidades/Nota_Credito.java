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
public class Nota_Credito 
{
    private int id_nota;
    private Date fecha;
    private String fk_id_factura;

    public Nota_Credito() {
    }

    public Nota_Credito(int id_nota, Date fecha, String fk_id_factura) {
        this.id_nota = id_nota;
        this.fecha = fecha;
        this.fk_id_factura = fk_id_factura;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFk_id_factura() {
        return fk_id_factura;
    }

    public void setFk_id_factura(String fk_id_factura) {
        this.fk_id_factura = fk_id_factura;
    }
    
    
}
