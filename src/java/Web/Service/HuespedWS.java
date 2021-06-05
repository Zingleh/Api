/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Huesped;
import Web.Metodos.HuespedDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "HuespedWS")
public class HuespedWS {
    
    HuespedDatos huespedd = new HuespedDatos();
    Huesped EntidadHuesped = new Huesped();
    
    public boolean crearHuesped( @WebParam(name = "rut_huesped") String rut_huesped,
            @WebParam (name = "nombre_completo") String nombre_completo,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa){
        
        EntidadHuesped.setRut_huesped(rut_huesped);
        EntidadHuesped.setNombre_completo(nombre_completo);
        EntidadHuesped.setFk_rut_empresa(fk_rut_empresa);
        EntidadHuesped.setFk_nombre_empresa(fk_nombre_empresa);
        
        huespedd.registrarHuesped(EntidadHuesped);
        return true;
    }
    
    @WebMethod
    public boolean eliminarHuesped (@WebParam(name = "rut_huesped") String rut_huesped){
        huespedd.eliminarHuesped(rut_huesped);
        return true;
    }
    
        public boolean actualizarHuesped( @WebParam(name = "rut_huesped") String rut_huesped,
            @WebParam (name = "nombre_completo") String nombre_completo,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa){
        
        EntidadHuesped.setRut_huesped(rut_huesped);
        EntidadHuesped.setNombre_completo(nombre_completo);
        EntidadHuesped.setFk_rut_empresa(fk_rut_empresa);
        EntidadHuesped.setFk_nombre_empresa(fk_nombre_empresa);
        
        huespedd.actualizarhuesped(EntidadHuesped);
        return true;
    }
        
     @WebMethod
    public List<Huesped> listarHuespeds(){
        List huespedList = huespedd.listarHuesped();
        return huespedList;
    }   
        

}
