/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Orden_Pedido;
import Web.Metodos.OrdenPedidoDatos;
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
@WebService(serviceName = "OrdenPedidoWS")
public class OrdenPedidoWS {
    
    OrdenPedidoDatos opd = new OrdenPedidoDatos();
    Orden_Pedido EntidadOrden_Pedido = new Orden_Pedido();
    
    @WebMethod
    public boolean crearOrdenPedido( @WebParam(name = "fk_rut_proveedor") String fk_rut_proveedor,
            @WebParam (name = "fk_id_proveedor") String fk_id_proveedor,
            @WebParam (name = "id_pedido") int id_pedido,
            @WebParam (name = "fecha") Date fecha){
        EntidadOrden_Pedido.setId_pedido(id_pedido);
        EntidadOrden_Pedido.setFecha(fecha);
        EntidadOrden_Pedido.setFk_rut_proveedor(fk_rut_proveedor);
        EntidadOrden_Pedido.setFk_id_proveedor(fk_id_proveedor);
        
        opd.registrarOrdenPedido(EntidadOrden_Pedido);        
        return true;
    }
    
    @WebMethod
    public boolean eliminarOrdenPedido (@WebParam(name = "id_pedido") int id_pedido){
        opd.eliminarOrdenPedido(id_pedido);
        return true;
    }
    
        @WebMethod
    public boolean actualizarOrdenPedido( @WebParam(name = "fk_rut_proveedor") String fk_rut_proveedor,
            @WebParam (name = "fk_id_proveedor") String fk_id_proveedor,
            @WebParam (name = "id_pedido") int id_pedido,
            @WebParam (name = "fecha") Date fecha){
        EntidadOrden_Pedido.setId_pedido(id_pedido);
        EntidadOrden_Pedido.setFecha(fecha);
        EntidadOrden_Pedido.setFk_rut_proveedor(fk_rut_proveedor);
        EntidadOrden_Pedido.setFk_id_proveedor(fk_id_proveedor);
        
        opd.actualizarOrdenPedido(EntidadOrden_Pedido);
        return true;
    }
    
    
    @WebMethod
    public List<Orden_Pedido> listarOrden_Pedidos(){
        List ordenpedidoList = opd.listarOrdenPedido();
        return ordenpedidoList;
    }
}
