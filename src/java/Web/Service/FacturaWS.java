/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Factura;
import Web.Metodos.FacturaDatos;
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
@WebService(serviceName = "FacturaWS")
public class FacturaWS {
    FacturaDatos fd = new FacturaDatos();
    Factura EntidadFactura = new Factura();
    
    @WebMethod
    public boolean crearFactura( @WebParam(name = "id_factura") String id_factura,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa,
            @WebParam (name = "fk_rut_proveedor") String fk_rut_proveedor,
            @WebParam (name = "fk_id_proveedor") String fk_id_proveedor,
            @WebParam (name = "fk_eh_id_trabajador") String fk_eh_id_trabajador,
            @WebParam (name = "precio_total") int precio_total,
            @WebParam (name = "fk_id_pago") int fk_id_pago,
            @WebParam (name = "fecha_factura") Date fecha_factura){
        
        EntidadFactura.setId_factura(id_factura);
        EntidadFactura.setFecha_factura(fecha_factura);
        EntidadFactura.setPrecio_total(precio_total);
        EntidadFactura.setFk_rut_empresa(fk_rut_empresa);
        EntidadFactura.setFk_nombre_empresa(fk_nombre_empresa);
        EntidadFactura.setFk_rut_proveedor(fk_rut_proveedor);
        EntidadFactura.setFk_id_proveedor(fk_id_proveedor);
        EntidadFactura.setFk_eh_id_trabajador(fk_eh_id_trabajador);
        EntidadFactura.setFk_id_pago(fk_id_pago);
        
        fd.registrarFactura(EntidadFactura);
        return true;
    }
    
    @WebMethod
    public boolean eliminarfactura (@WebParam(name = "id_factura") String id_factura){
        fd.eliminarFactura(id_factura);
        return true;
    }
    
    @WebMethod
    public boolean actualizarFactura( @WebParam(name = "id_factura") String id_factura,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa,
            @WebParam (name = "fk_rut_proveedor") String fk_rut_proveedor,
            @WebParam (name = "fk_id_proveedor") String fk_id_proveedor,
            @WebParam (name = "fk_eh_id_trabajador") String fk_eh_id_trabajador,
            @WebParam (name = "precio_total") int precio_total,
            @WebParam (name = "fk_id_pago") int fk_id_pago,
            @WebParam (name = "fecha_factura") Date fecha_factura){
        
        EntidadFactura.setId_factura(id_factura);
        EntidadFactura.setFecha_factura(fecha_factura);
        EntidadFactura.setPrecio_total(precio_total);
        EntidadFactura.setFk_rut_empresa(fk_rut_empresa);
        EntidadFactura.setFk_nombre_empresa(fk_nombre_empresa);
        EntidadFactura.setFk_rut_proveedor(fk_rut_proveedor);
        EntidadFactura.setFk_id_proveedor(fk_id_proveedor);
        EntidadFactura.setFk_eh_id_trabajador(fk_eh_id_trabajador);
        EntidadFactura.setFk_id_pago(fk_id_pago);
        
        fd.actualizarFactura(EntidadFactura);
        return true;
    }
    
    @WebMethod
    public List<Factura> listarFacturas(){
        List facturaList = fd.listarfactura();
        return facturaList;
    }

}
