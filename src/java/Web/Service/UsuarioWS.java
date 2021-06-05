/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Usuario;
import Web.Metodos.UsuarioDatos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {
    UsuarioDatos ud = new UsuarioDatos();
    Usuario EntidadUsuario = new Usuario();
    
    @WebMethod
    public boolean crearUsuario( @WebParam(name = "id_usuario") String id_usuario,
            @WebParam (name = "contrasenia") String contrasenia,
            @WebParam (name = "rol") int rol){
        EntidadUsuario.setId_usuario(id_usuario);
        EntidadUsuario.setContrasenia(contrasenia);
        EntidadUsuario.setRol(id_usuario);
        
        ud.registrarUsuario(EntidadUsuario);
        return true;
    }
    
    @WebMethod
    public boolean eliminarUsuario (@WebParam(name = "id_usuario") String id_usuario){
        ud.eliminarUsuario(id_usuario);
        return true;
    }
    
     @WebMethod
    public boolean actualizarUsuario( @WebParam(name = "id_usuario") String id_usuario,
            @WebParam (name = "contrasenia") String contrasenia,
            @WebParam (name = "rol") int rol){
        EntidadUsuario.setId_usuario(id_usuario);
        EntidadUsuario.setContrasenia(contrasenia);
        EntidadUsuario.setRol(id_usuario);
        
        ud.actualizarUsuario(EntidadUsuario);
        return true;
    }
    
    @WebMethod
    public List<Usuario> listarUsuarios(){
        List usuarioList = ud.listarUsuario();
        return usuarioList;
    }
    
    

}
