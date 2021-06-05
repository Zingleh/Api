/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Plato;
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
public class PlatoDatos {
    public int registrarPlato (Plato plato){
        int resultado = 0;
        String sql = "INERT INTO platos (id_plato, nombre, precio_uni, articulo_id_articulo) values (?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, plato.getId_plato());
            ps.setString(2, plato.getNombre_plato());
            ps.setInt(3, plato.getPrecio_unitario());
            ps.setString(4, plato.getFk_id_articulo());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al agregar plato");
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
    
    public int eliminarPlato (Integer id_plato){
        int resultado = 0;
        String sql = "DELETE platos where id_plato = '" + id_plato + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ha podido eliminar el plato : " + e);
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
    
    public int actualizarPlato (Plato plato){
        int resultado = 0;
        String sql = "UPDATE platos set nombre = ?, precio_uni = ?, articulo_id_articulo = ? where id_plato = ? ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, plato.getNombre_plato());
            ps.setInt(2, plato.getPrecio_unitario());
            ps.setString(3, plato.getFk_id_articulo());
            ps.setInt(4, plato.getId_plato());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" no se ha podido actualizar el plato : " + e );
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
    
    public List listarPlatos (){
        List <Plato> platoList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM platos";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Plato plato = new Plato (
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                ); 
                platoList.add(plato);
            }
        } catch (SQLException e) {
            System.out.println("SqlException : " + e.getMessage());
        }
        return platoList;
    }
    
}
