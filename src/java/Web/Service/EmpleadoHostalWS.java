/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Empleado_Hostal;
import Web.Metodos.EmpleadoHostalDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ariel
 */
@WebService(serviceName = "EmpleadoHostalWS")
public class EmpleadoHostalWS {
    EmpleadoHostalDatos eh = new EmpleadoHostalDatos();
    Empleado_Hostal EntidadEmpleadoHostal = new Empleado_Hostal();
    
    @WebMethod
    public boolean crearEmpleadoHostal( @WebParam(name = "id_trabajador") String id_trabajador,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario,
            @WebParam (name = "sueldo") int sueldo,
            @WebParam (name = "scargo") String cargo){
        EntidadEmpleadoHostal.setId_trabajador(id_trabajador);
        EntidadEmpleadoHostal.setSueldo(sueldo);
        EntidadEmpleadoHostal.setCargo(cargo);
        EntidadEmpleadoHostal.setFk_id_usuario(fk_id_usuario);
        
        eh.registrarEmpleadoHostal(EntidadEmpleadoHostal);
        return true;
    }
    
     @WebMethod
    public boolean eliminarEmpleadoHostal (@WebParam(name = "id_trabajador") String id_trabajador){
        eh.eliminarEmpleadoHostal(id_trabajador);
        return true;
    }
    
    @WebMethod
    public boolean actualizarEmpleadoHostal( @WebParam(name = "id_trabajador") String id_trabajador,
            @WebParam (name = "fk_id_usuario") String fk_id_usuario,
            @WebParam (name = "sueldo") int sueldo,
            @WebParam (name = "scargo") String cargo){
        EntidadEmpleadoHostal.setId_trabajador(id_trabajador);
        EntidadEmpleadoHostal.setSueldo(sueldo);
        EntidadEmpleadoHostal.setCargo(cargo);
        EntidadEmpleadoHostal.setFk_id_usuario(fk_id_usuario);
        
        eh.actualizarEmpleagoHostal(EntidadEmpleadoHostal);
        return true;
    }
    
    @WebMethod
    public List<Empleado_Hostal> listarEmpleado_Hostals(){
        List empleadohostalList = eh.listarEmpleadoHostal();
        return empleadohostalList;
    }

}
