/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Factura_Cliente;
import Web.Metodos.Detalle_Factura_ClienteDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "DetalleFacturaClienteWS")
public class DetalleFacturaClienteWS {
    Detalle_Factura_ClienteDatos dfc = new Detalle_Factura_ClienteDatos();
    Detalle_Factura_Cliente EntidadDetalleFacturaCliente = new Detalle_Factura_Cliente();
    
     @WebMethod
    public boolean crearDetalleFacturaCliente( @WebParam(name = "fk_sc_id_servicio") String fk_sc_id_servicio,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "fk_id_factura") String fk_id_factura,
            @WebParam (name = "cantidad") int cantidad){
        EntidadDetalleFacturaCliente.setCantidad(cantidad);
        EntidadDetalleFacturaCliente.setFk_sc_id_servicio(fk_sc_id_servicio);
        EntidadDetalleFacturaCliente.setFk_id_factura(fk_id_factura);
        EntidadDetalleFacturaCliente.setFk_id_factura(fk_id_factura);
        
        dfc.RegistrarDetalleCliente(EntidadDetalleFacturaCliente);
        return true;
        
    }
    
    @WebMethod
    public boolean eliminarDetallefacturaCliente (@WebParam(name = "fk_id_factura") String fk_id_factura){
        dfc.EliminarDetalleFacturaCliente(fk_id_factura);
        return true;
    }
    
    public boolean actualizarDetalleFacturaCliente( @WebParam(name = "fk_sc_id_servicio") String fk_sc_id_servicio,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "fk_id_factura") String fk_id_factura,
            @WebParam (name = "cantidad") int cantidad){
        EntidadDetalleFacturaCliente.setCantidad(cantidad);
        EntidadDetalleFacturaCliente.setFk_sc_id_servicio(fk_sc_id_servicio);
        EntidadDetalleFacturaCliente.setFk_id_factura(fk_id_factura);
        EntidadDetalleFacturaCliente.setFk_id_factura(fk_id_factura);
        
        dfc.ActualizarDetalleFacturaCliente(EntidadDetalleFacturaCliente);
        return true;
        }
    
    @WebMethod
    public List<Detalle_Factura_Cliente> listarDetalle_Factura_Clientes(){
        List detallefacturaclienteList = dfc.listarDetalleCliente();
        return detallefacturaclienteList;
    }
}
