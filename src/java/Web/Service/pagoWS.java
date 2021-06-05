/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Pago;
import Web.Metodos.Pagodatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "pagoWS")
public class pagoWS {
    
    Pagodatos pd = new Pagodatos();
    Pago EntidadPago = new Pago();
    
    @WebMethod
    public boolean crearPago( @WebParam(name = "id_pago") int id_articulo,
            @WebParam (name = "tipo_pago") String tipo_pago){
        EntidadPago.setId_pago(id_articulo);
        EntidadPago.setTipo_pago(tipo_pago);
        pd.registrarPago(EntidadPago);
        return true;
    }
    
    @WebMethod
    public boolean eliminarArticulo (@WebParam(name = "id_pago") int id_pago){
        pd.registrarPago(EntidadPago);
        return true;
    }
    
    @WebMethod
    public boolean actualizarPago( @WebParam(name = "id_pago") int id_articulo,
            @WebParam (name = "tipo_pago") String tipo_pago){
        EntidadPago.setId_pago(id_articulo);
        EntidadPago.setTipo_pago(tipo_pago);
        pd.actualizarPago(EntidadPago);
        return true;
    }
    
    @WebMethod
    public List<Pago> listarPagos(){
        List pagoList = pd.listarPago();
        return pagoList;
    }

}
