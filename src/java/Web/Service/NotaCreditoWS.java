/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Nota_Credito;
import Web.Metodos.Nota_CreditoDatos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "NotaCreditoWS")
public class NotaCreditoWS {
    Nota_CreditoDatos ncd = new Nota_CreditoDatos();
    Nota_Credito EntidadNota_Credito = new Nota_Credito();
    
     @WebMethod
    public boolean crearNotaCredito( @WebParam(name = "id_nota") int id_nota,
            @WebParam (name = "fecha") Date fecha,
            @WebParam (name = "stock") int stock,
            @WebParam (name = "fk_id_factura") String fk_id_factura){
        
        EntidadNota_Credito.setId_nota(id_nota);
        EntidadNota_Credito.setFecha(fecha);
        EntidadNota_Credito.setFk_id_factura(fk_id_factura);
        
        ncd.registrarNotaCredito(EntidadNota_Credito);
        return true;
    }
    
    @WebMethod
    public boolean eliminarNotaCredito (@WebParam(name = "id_nota") int id_nota){
        ncd.eliminarNotaCredito(id_nota);
        return true;
    }
    @WebMethod
        public boolean actualizarNotaCredito( @WebParam(name = "id_nota") int id_nota,
            @WebParam (name = "fecha") Date fecha,
            @WebParam (name = "stock") int stock,
            @WebParam (name = "fk_id_factura") String fk_id_factura){
        
        EntidadNota_Credito.setId_nota(id_nota);
        EntidadNota_Credito.setFecha(fecha);
        EntidadNota_Credito.setFk_id_factura(fk_id_factura);
        
        ncd.actualizarnotaCredito(EntidadNota_Credito);
        return true;
    }
        
        
    @WebMethod
    public List<Nota_Credito> listarNota_Creditos(){
        List notacreditoList = ncd.listarNotaCredito();
        return notacreditoList;
    }

}
