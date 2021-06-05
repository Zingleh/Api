/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Tipo_Habitacion;
import Web.Metodos.TipoHabitacionDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "TipoHabitacionWS")
public class TipoHabitacionWS {
    
    TipoHabitacionDatos thd = new TipoHabitacionDatos();
    Tipo_Habitacion EntidadTipo_Habitacion = new Tipo_Habitacion();
    
    @WebMethod
    public boolean crearTipoHabitacion( @WebParam(name = "tipo_cama") String tipo_cama,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "cantidad_baño") int cantidad_baño,
            @WebParam (name = "precio") int precio,
            @WebParam (name = "tipo_tv") String tipo_tv,
            @WebParam (name = "tipo_wifi") String tipo_wifi){
        EntidadTipo_Habitacion.setTipo_cama(tipo_cama);
        EntidadTipo_Habitacion.setCantidad_baño(cantidad_baño);
        EntidadTipo_Habitacion.setTipo_tv(tipo_tv);
        EntidadTipo_Habitacion.setTipo_wifi(tipo_wifi);
        EntidadTipo_Habitacion.setPrecio(precio);
        EntidadTipo_Habitacion.setFk_id_habitacion(fk_id_habitacion);
        
        thd.registrarTipoHabitacion(EntidadTipo_Habitacion);
        return true;
    }
    
    @WebMethod
    public boolean eliminarTipoHabitacion (@WebParam(name = "fk_id_habitacion") String fk_id_habitacion){
        thd.eliminarTipoHabitacion(fk_id_habitacion);
        return true;
    }
    
    @WebMethod
    public boolean actualizarTipoHabitacion( @WebParam(name = "tipo_cama") String tipo_cama,
            @WebParam (name = "fk_id_habitacion") String fk_id_habitacion,
            @WebParam (name = "cantidad_baño") int cantidad_baño,
            @WebParam (name = "precio") int precio,
            @WebParam (name = "tipo_tv") String tipo_tv,
            @WebParam (name = "tipo_wifi") String tipo_wifi){
        EntidadTipo_Habitacion.setTipo_cama(tipo_cama);
        EntidadTipo_Habitacion.setCantidad_baño(cantidad_baño);
        EntidadTipo_Habitacion.setTipo_tv(tipo_tv);
        EntidadTipo_Habitacion.setTipo_wifi(tipo_wifi);
        EntidadTipo_Habitacion.setPrecio(precio);
        EntidadTipo_Habitacion.setFk_id_habitacion(fk_id_habitacion);
        
        thd.actualizarTipoHabitacion(EntidadTipo_Habitacion);
        return true;
    }
    
    @WebMethod
    public List<Tipo_Habitacion> listarTipo_Habitacions(){
        List tipohabitacionList = thd.listarTipoHabitacion();
        return tipohabitacionList;
    }

}
