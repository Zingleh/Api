/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Factura_Proveedor;
import Web.Metodos.Detalle_Factura_ProveedorDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ariel
 */
@WebService(serviceName = "DetalleFacturaProveedorWS")
public class DetalleFacturaProveedorWS {
    Detalle_Factura_ProveedorDatos dfp = new Detalle_Factura_ProveedorDatos();
    Detalle_Factura_Proveedor EntidadDetalleFacturaProveedor = new Detalle_Factura_Proveedor();
    
    @WebMethod
    public boolean crearDetalleFacturaProveedor( @WebParam(name = "fk_id_factura") String fk_id_factura,
            @WebParam (name = "fk_id_articulo") String fk_id_articulo,
            @WebParam (name = "cantidad") int cantidad){
        EntidadDetalleFacturaProveedor.setCantidad(cantidad);
        EntidadDetalleFacturaProveedor.setFk_id_factura(fk_id_factura);
        EntidadDetalleFacturaProveedor.setFk_id_articulo(fk_id_articulo);
        
        dfp.RegistrarDetalleProveedor(EntidadDetalleFacturaProveedor);
        return true;
    }
    
    @WebMethod
    public boolean eliminarArticulo (@WebParam(name = "fk_id_factura") String fk_id_factura){
        dfp.EliminarDetallePRoveedor(fk_id_factura);
        return true;
    }
    
    @WebMethod
    public boolean actualizarDetalleFacturaProveedor( @WebParam(name = "fk_id_factura") String fk_id_factura,
            @WebParam (name = "fk_id_articulo") String fk_id_articulo,
            @WebParam (name = "cantidad") int cantidad){
        EntidadDetalleFacturaProveedor.setCantidad(cantidad);
        EntidadDetalleFacturaProveedor.setFk_id_factura(fk_id_factura);
        EntidadDetalleFacturaProveedor.setFk_id_articulo(fk_id_articulo);
        
        dfp.ActualizarDetalleFacturaProveedor(EntidadDetalleFacturaProveedor);
        return true;
    }
    
    @WebMethod
    public List<Detalle_Factura_Proveedor> listarDetalle_Factura_Proveedors(){
        List detallefacturaproveedorList = dfp.listarDetalleProveedor();
        return detallefacturaproveedorList;
    }
    
    

}
