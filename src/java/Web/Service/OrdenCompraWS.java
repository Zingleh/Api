/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Orden_Compra;
import Web.Metodos.OrdenCompradatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "OrdenCompraWS")
public class OrdenCompraWS {
    
    OrdenCompradatos ocd = new OrdenCompradatos();
    Orden_Compra EntidadCompradatos = new Orden_Compra();
    
    @WebMethod
    public boolean crearOrdenCompra( @WebParam(name = "id_orden_compra") String id_orden_compra,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa){
        
        EntidadCompradatos.setId_orden_compra(id_orden_compra);
        EntidadCompradatos.setFk_rut_empresa(fk_rut_empresa);
        EntidadCompradatos.setFk_nombre_empresa(fk_nombre_empresa);
        
        ocd.registrarOrdenCompra(EntidadCompradatos);
        return true;
    }
    
    @WebMethod
    public boolean eliminarOrdenCompra (@WebParam(name = "id_orden_compra") String id_orden_compra){
        ocd.eliminarOrdenCompra(id_orden_compra);
        return true;
    }
    
    @WebMethod
    public boolean actualizarOrdenCompra( @WebParam(name = "id_orden_compra") String id_orden_compra,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa){
        
        EntidadCompradatos.setId_orden_compra(id_orden_compra);
        EntidadCompradatos.setFk_rut_empresa(fk_rut_empresa);
        EntidadCompradatos.setFk_nombre_empresa(fk_nombre_empresa);
        
        ocd.actualizarOrdenCompra(EntidadCompradatos);
        return true;
    }
    
    
    @WebMethod
    public List<Orden_Compra> listarOrden_Compras(){
        List ordencompraList = ocd.listarOrdenCompra();
        return ordencompraList;
    }
}
