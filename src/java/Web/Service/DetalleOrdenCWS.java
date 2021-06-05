/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Orden_Compra;
import Web.Metodos.DetalleOrden_CompraDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "DetalleOrdenCompra")
public class DetalleOrdenCWS {
    DetalleOrden_CompraDatos dm = new DetalleOrden_CompraDatos();
    Detalle_Orden_Compra EntidadDetalleCompra = new Detalle_Orden_Compra();
    
    @WebMethod
    public boolean crearDetalleCompra( @WebParam(name = "fk_id_orden_compra") String fk_id_orden_compra,
            @WebParam (name = "fk_sc_id_servicio") String fk_sc_id_servicio,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "fk_rut_huesped") String fk_rut_huesped,
            @WebParam (name = "cantidad") int cantidad){
            EntidadDetalleCompra.setCantidad(cantidad);
            EntidadDetalleCompra.setFk_id_orden_compra(fk_id_orden_compra);
            EntidadDetalleCompra.setFk_sc_id_servicio(fk_sc_id_servicio);
            EntidadDetalleCompra.setFk_id_habitacion(fk_id_habitacion);
            EntidadDetalleCompra.setFk_rut_huesped(fk_rut_huesped);
            
            dm.registrarDetalleOrdenCompra(EntidadDetalleCompra);
            
            return true;
        
    }
    
    @WebMethod
    public boolean eliminarDetalleCompra (@WebParam (name = "fk_id_orden_compra") String fk_id_orden_compra){
        dm.eliminarDetalleOrden(fk_id_orden_compra);
        return true;
        
    }
    
    @WebMethod
    public boolean actualizarDetalleCompra( @WebParam(name = "fk_id_orden_compra") String fk_id_orden_compra,
            @WebParam (name = "fk_sc_id_servicio") String fk_sc_id_servicio,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "fk_rut_huesped") String fk_rut_huesped,
            @WebParam (name = "cantidad") int cantidad){
            EntidadDetalleCompra.setCantidad(cantidad);
            EntidadDetalleCompra.setFk_id_orden_compra(fk_id_orden_compra);
            EntidadDetalleCompra.setFk_sc_id_servicio(fk_sc_id_servicio);
            EntidadDetalleCompra.setFk_id_habitacion(fk_id_habitacion);
            EntidadDetalleCompra.setFk_rut_huesped(fk_rut_huesped);
            
            dm.actualizarOrdenCompra(EntidadDetalleCompra);
        return true;
    }
    
    @WebMethod
    public List<Detalle_Orden_Compra> listarDetalle_Orden_Compras(){
        List detalleordencompraList = dm.listarDetalleOrdenCompra();
        return detalleordencompraList;
    }
    
    
    

    }

