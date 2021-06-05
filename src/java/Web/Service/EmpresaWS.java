/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Empresa;
import Web.Metodos.EmpresaDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ariel
 */
@WebService(serviceName = "EmpresaWS")
public class EmpresaWS {
    
    EmpresaDatos ed = new EmpresaDatos();
    Empresa EntidadEmpresa = new Empresa();
    
    @WebMethod
    public boolean crearEmpresa( @WebParam(name = "rut_empresa") String rut_empresa,
            @WebParam (name = "correo") String correo,
            @WebParam (name = "nombre_empresa") String nombre_empresa,
            @WebParam (name = "razon_social") String razon_social,
            @WebParam (name = "direccion") String direccion,
            @WebParam (name = "telefono") String telefono,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario){
        EntidadEmpresa.setRut_empresa(rut_empresa);
        EntidadEmpresa.setNombre_empresa(nombre_empresa);
        EntidadEmpresa.setRazon_social(razon_social);
        EntidadEmpresa.setDireccion(direccion);
        EntidadEmpresa.setCorreo(correo);
        EntidadEmpresa.setTelefono(telefono);
        EntidadEmpresa.setFk_id_usuario(fk_id_usuario);
        
        ed.registrarEmpresa(EntidadEmpresa);
        return true;
    }
    
    @WebMethod
    public boolean eliminarEmpresa (@WebParam(name = "rut_empresa") String rut_empresa){
        ed.eliminarEmpresa(rut_empresa);
        return true;
    }
    
    @WebMethod
    public boolean actualizarEmpresa( @WebParam(name = "rut_empresa") String rut_empresa,
            @WebParam (name = "correo") String correo,
            @WebParam (name = "nombre_empresa") String nombre_empresa,
            @WebParam (name = "razon_social") String razon_social,
            @WebParam (name = "direccion") String direccion,
            @WebParam (name = "telefono") String telefono,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario){
        EntidadEmpresa.setRut_empresa(rut_empresa);
        EntidadEmpresa.setNombre_empresa(nombre_empresa);
        EntidadEmpresa.setRazon_social(razon_social);
        EntidadEmpresa.setDireccion(direccion);
        EntidadEmpresa.setCorreo(correo);
        EntidadEmpresa.setTelefono(telefono);
        EntidadEmpresa.setFk_id_usuario(fk_id_usuario);
        
        ed.actualizarEmpresa(EntidadEmpresa);
        return true;
    }
    
    @WebMethod
    public List<Empresa> listarEmpresas(){
        List empresaList = ed.listarEmpresa();
        return empresaList;
    }


}
