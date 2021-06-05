/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Habitacion;
import Web.Metodos.HabitacionDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "HabitacionWS")
public class HabitacionWS {
    
    HabitacionDatos hs = new HabitacionDatos();
    Habitacion EntidadHabitacion = new Habitacion();
    
     public boolean crearHabitacion ( @WebParam(name = "id_habitacion") String id_habitacion,
            @WebParam (name = "tamaño") String tamaño,
            @WebParam (name = "estado") String estado){
         EntidadHabitacion.setId_habitacion(id_habitacion);
         EntidadHabitacion.setTamaño(tamaño);
         EntidadHabitacion.setEstado(estado);
         
         hs.registrarHabitacion(EntidadHabitacion);
         return true;
     }
     
     @WebMethod
    public boolean eliminarHabitacion (@WebParam(name = "id_habitacion") String id_habitacion){
        hs.eliminarHabitacion(id_habitacion);
        return true;
    }
    
         public boolean actualizarHabitacion ( @WebParam(name = "id_habitacion") String id_habitacion,
            @WebParam (name = "tamaño") String tamaño,
            @WebParam (name = "estado") String estado){
         EntidadHabitacion.setId_habitacion(id_habitacion);
         EntidadHabitacion.setTamaño(tamaño);
         EntidadHabitacion.setEstado(estado);
         
         hs.actualizarHabitacion(EntidadHabitacion);
         return true;
     }
         
         
    @WebMethod
    public List<Habitacion> listarHabitacions(){
        List habitacionList = hs.listarHabitacion();
        return habitacionList;
    }  

}
