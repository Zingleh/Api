/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Entidades.Usuario;
import Web.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ariel
 */
public class UsuarioDatos {
    public int registrarUsuario(Usuario usuario){
        int resultado = 0;
        String sql = "INSERT INTO usuario (id_usuario, contraseña, rol) values (?,?,?) ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getId_usuario());
            ps.setString(2, usuario.getContrasenia());
            ps.setString(3, usuario.getRol());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario : " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        } 
        return resultado;
    }
    
    public int eliminarUsuario(String id_usuario) {
        int resultado = 0;
        String sql = "DELETE usuario where id_usuario = '" + id_usuario + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ha podido eliminar usuario : " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        } 
        return resultado;
    }
    
    public int actualizarUsuario (Usuario usuario){
        int resultado = 0;
        String sql = "UPDATE usuario set contraseña = ?, rol = ? where id_usuario = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getRol());
            ps.setString(3, usuario.getId_usuario());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al actualizar usuario" + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        } 
        return resultado;
    }
    
    public List listarUsuario (){
        List<Usuario> usuarioList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM usuario";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Usuario usuario = new Usuario (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("SQLException : " + e);
        }
        return usuarioList;
    }
}
