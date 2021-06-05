/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Proveedor;
import Web.Metodos.ProveedorDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "ProveedorWS")
public class ProveedorWS {
    
    ProveedorDatos provd = new ProveedorDatos();
    Proveedor EntidadProveedor = new Proveedor();
    
    @WebMethod
    public boolean crearProveedor( @WebParam(name = "rut_proveedor") String rut_proveedor,
            @WebParam (name = "id_proveedor") String id_proveedor,
            @WebParam (name = "nombre_proveedor") String nombre_proveedor,
            @WebParam (name = "direccion_proveedor") String direccion_proveedor,
            @WebParam (name = "telefono_proveedor") String telefono_proveedor,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario,
            @WebParam (name = "correo_proveedor") String correo_proveedor){
        EntidadProveedor.setRut_proveedor(rut_proveedor);
        EntidadProveedor.setId_proveedor(id_proveedor);
        EntidadProveedor.setNombre_proveedor(nombre_proveedor);
        EntidadProveedor.setDireccion_proveedor(direccion_proveedor);
        EntidadProveedor.setCorreo_proveedor(correo_proveedor);
        EntidadProveedor.setTelefono_proveedor(telefono_proveedor);
        EntidadProveedor.setFk_id_usuario(fk_id_usuario);
        
        provd.registrarProveedor(EntidadProveedor);
        return true;
    }
    
    @WebMethod
    public boolean eliminarProveedor (@WebParam(name = "id_proveedor") String id_proveedor){
        provd.eliminarProveedor(id_proveedor);
        return true;
    }
    
    @WebMethod
    public boolean actualizarProveedor( @WebParam(name = "rut_proveedor") String rut_proveedor,
            @WebParam (name = "id_proveedor") String id_proveedor,
            @WebParam (name = "nombre_proveedor") String nombre_proveedor,
            @WebParam (name = "direccion_proveedor") String direccion_proveedor,
            @WebParam (name = "telefono_proveedor") String telefono_proveedor,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario,
            @WebParam (name = "correo_proveedor") String correo_proveedor){
        EntidadProveedor.setRut_proveedor(rut_proveedor);
        EntidadProveedor.setId_proveedor(id_proveedor);
        EntidadProveedor.setNombre_proveedor(nombre_proveedor);
        EntidadProveedor.setDireccion_proveedor(direccion_proveedor);
        EntidadProveedor.setCorreo_proveedor(correo_proveedor);
        EntidadProveedor.setTelefono_proveedor(telefono_proveedor);
        EntidadProveedor.setFk_id_usuario(fk_id_usuario);
        
        provd.actualizarProveedor(EntidadProveedor);
        return true;
    }
    
    @WebMethod
    public List<Proveedor> listarProveedors(){
        List proveedorList = provd.listarProveedor();
        return proveedorList;
    }

}
