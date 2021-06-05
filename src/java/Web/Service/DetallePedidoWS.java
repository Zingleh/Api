/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Pedido;
import Web.Metodos.Detalle_PedidoDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "DetallePedidoWS")
public class DetallePedidoWS {
    Detalle_PedidoDatos dp = new Detalle_PedidoDatos();
    Detalle_Pedido EntidadDetallePedido = new Detalle_Pedido();
    
    @WebMethod
    public boolean crearDetallePedido( @WebParam(name = "fk_id_articulo") String fk_id_articulo,
            @WebParam (name = "cantidad") int cantidad,
            @WebParam (name = "fk_id_pedido") int fk_id_pedido){
        EntidadDetallePedido.setCantidad(cantidad);
        EntidadDetallePedido.setFk_id_pedido(fk_id_pedido);
        EntidadDetallePedido.setFk_id_articulo(fk_id_articulo);
        dp.registrarDetallePedido(EntidadDetallePedido);
        return true;
    }
    
    @WebMethod
    public boolean eliminarDetallePedido (@WebParam(name = "fk_id_pedido") int fk_id_pedido){
        dp.eliminarDetallePedido(fk_id_pedido);
        return true;
    }
    
    @WebMethod
    public boolean actualizarDetallePedido( @WebParam(name = "fk_id_articulo") String fk_id_articulo,
            @WebParam (name = "cantidad") int cantidad,
            @WebParam (name = "fk_id_pedido") int fk_id_pedido){
        EntidadDetallePedido.setCantidad(cantidad);
        EntidadDetallePedido.setFk_id_pedido(fk_id_pedido);
        EntidadDetallePedido.setFk_id_articulo(fk_id_articulo);
        dp.actualizarDetallePedido(EntidadDetallePedido);
        return true;
    }
    
    @WebMethod
    public List<Detalle_Pedido> listarDetalle_Pedidos(){
        List detallepedidoList = dp.listarDetallePedido();
        return detallepedidoList;
                
    }


}
