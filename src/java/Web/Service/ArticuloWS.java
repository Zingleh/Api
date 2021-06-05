/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Articulo;
import Web.Metodos.ArticuloMetodo;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ariel
 */
@WebService(serviceName = "ArticuloWS")
public class ArticuloWS {
    
    ArticuloMetodo am = new ArticuloMetodo();
    Articulo EntidadArticulo = new Articulo();
    
    @WebMethod
    public boolean crearArticulo( @WebParam(name = "id_articulo") String id_articulo,
            @WebParam (name = "nombre_articulo") String nombre_articulo,
            @WebParam (name = "stock") int stock,
            @WebParam (name = "stock_critico") int stock_critico,
            @WebParam (name = "fam_artic_id_fami_art") String fk_id_familia_artic){
            EntidadArticulo.setId_articulo(id_articulo);
            EntidadArticulo.setNombre_articulo(nombre_articulo);
            EntidadArticulo.setStock(stock);
            EntidadArticulo.setStock_critico(stock_critico);
            EntidadArticulo.setFk_id_familia_artic(fk_id_familia_artic);
            
            am.registrarArticulo(EntidadArticulo);
            
            return true;
        
    }
    @WebMethod
    public boolean eliminarArticulo (@WebParam(name = "id_articulo") String id_articulo){
        am.EliminarArticulo(id_articulo);
        return true;
    }
    
    @WebMethod
    public boolean actualizarArticulo( @WebParam(name = "id_articulo") String id_articulo,
            @WebParam (name = "nombre_articulo") String nombre_articulo,
            @WebParam (name = "stock") int stock,
            @WebParam (name = "stock_critico") int stock_critico,
            @WebParam (name = "fam_artic_id_fami_art") String fk_id_familia_artic){
            EntidadArticulo.setId_articulo(id_articulo);
            EntidadArticulo.setNombre_articulo(nombre_articulo);
            EntidadArticulo.setStock(stock);
            EntidadArticulo.setStock_critico(stock_critico);
            EntidadArticulo.setFk_id_familia_artic(fk_id_familia_artic);
            
            am.actualizarArticulo(EntidadArticulo);
        return true;
    }
    
    @WebMethod
    public List<Articulo> listarArticulos(){
        List articuloList = am.ListarArticulo();
        return articuloList;
    }
    

}
