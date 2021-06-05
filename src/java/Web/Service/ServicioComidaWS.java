/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Servicio_Comida;
import Web.Metodos.ServicioComidaDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "ServicioComidaWS")
public class ServicioComidaWS {
    
    ServicioComidaDatos scd = new ServicioComidaDatos();
    Servicio_Comida EntidadServicio_Comida = new Servicio_Comida();
    
    @WebMethod
    public boolean crearServicioComida( @WebParam(name = "id_servicio") String id_servicio,
            @WebParam (name = "nombre_servicio") String nombre_servicio,
            @WebParam (name = "precio") int precio,
            @WebParam (name = "fk_id_plato") int fk_id_plato){
        EntidadServicio_Comida.setId_servicio(id_servicio);
        EntidadServicio_Comida.setNombre_servicio(nombre_servicio);
        EntidadServicio_Comida.setPrecio(precio);
        EntidadServicio_Comida.setFk_id_plato(fk_id_plato);
        
        scd.registrarServicioComida(EntidadServicio_Comida);
        return true;
    }
    
    @WebMethod
    public boolean eliminarServicioComida(@WebParam(name = "id_servicio") String id_servicio){
        scd.eliminarServicioComida(id_servicio);
        return true;
    }
    
    @WebMethod
    public boolean actualizarServicioComida( @WebParam(name = "id_servicio") String id_servicio,
            @WebParam (name = "nombre_servicio") String nombre_servicio,
            @WebParam (name = "precio") int precio,
            @WebParam (name = "fk_id_plato") int fk_id_plato){
        EntidadServicio_Comida.setId_servicio(id_servicio);
        EntidadServicio_Comida.setNombre_servicio(nombre_servicio);
        EntidadServicio_Comida.setPrecio(precio);
        EntidadServicio_Comida.setFk_id_plato(fk_id_plato);
        
        scd.registrarServicioComida(EntidadServicio_Comida);
        return true;
    }
    
    @WebMethod
    public List<Servicio_Comida> listarServicio_Comidas(){
        List serviciocomidaList = scd.listarServicioComida();
        return serviciocomidaList;
    }
    
    
    

}
