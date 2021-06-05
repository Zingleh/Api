/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Plato;
import Web.Metodos.PlatoDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "PlatoWS")
public class PlatoWS {
    
    PlatoDatos platod = new PlatoDatos();
    Plato EntidadPlato = new Plato();
    
    @WebMethod
    public boolean crearPlato( @WebParam(name = "id_plato") int id_plato,
            @WebParam (name = "precio_unitario") int precio_unitario,
            @WebParam (name = "nombre_plato") String nombre_plato,
            @WebParam (name = "fk_id_articulo") String fk_id_articulo){
        
        EntidadPlato.setId_plato(id_plato);
        EntidadPlato.setNombre_plato(nombre_plato);
        EntidadPlato.setPrecio_unitario(precio_unitario);
        EntidadPlato.setFk_id_articulo(fk_id_articulo);
        
        platod.registrarPlato(EntidadPlato);
        return true;
    }
    
    @WebMethod
    public boolean eliminarPlato (@WebParam(name = "id_plato") int id_plato){
        platod.eliminarPlato(id_plato);
        return true;
    }
    
    @WebMethod
    public boolean actualizarPlato( @WebParam(name = "id_plato") int id_plato,
            @WebParam (name = "precio_unitario") int precio_unitario,
            @WebParam (name = "nombre_plato") String nombre_plato,
            @WebParam (name = "fk_id_articulo") String fk_id_articulo){
        
        EntidadPlato.setId_plato(id_plato);
        EntidadPlato.setNombre_plato(nombre_plato);
        EntidadPlato.setPrecio_unitario(precio_unitario);
        EntidadPlato.setFk_id_articulo(fk_id_articulo);
        
        platod.actualizarPlato(EntidadPlato);
        return true;
    }
    
    @WebMethod
    public List<Plato> listarPlatos(){
        List platosList = platod.listarPlatos();
        return platosList;
    }

}
