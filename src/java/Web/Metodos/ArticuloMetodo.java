/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Web.Metodos;

import Web.Entidades.Articulo;
import Web.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * id_articulo nombre_arituclo stock stock critico fam_artic_id_famiart
 * @author ariel
 */
public class ArticuloMetodo {
    public int registrarArticulo (Articulo articulo){
        int resultado = 0;
        String sql =("INSERT INTO ARTICULO (id_articulo, nombre_articulo, stock, stock_critico, fam_artic_id_fami_art) values (?,?,?,?,?))");
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,articulo.getId_articulo());
            ps.setString(2,articulo.getNombre_articulo());
            ps.setInt(3,articulo.getStock());
            ps.setInt(4, articulo.getStock_critico());
            ps.setString(5, articulo.getFk_id_familia_artic());
            
            resultado = ps.executeUpdate();
            ps.close ();        
        } catch (SQLException e) {
            System.out.println("No se han podiddo ingresar los datos del articulo" + e);
        } finally {
            try {
                if (cn!=null){
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error al intentar cerrar la conexion");
            }
        }
        return resultado;
        
    };
    
    public int EliminarArticulo (String id_articulo){
       int resultado = 0;
       String sql = "DELETE Articulo where id_articulo = '" +id_articulo + "'";
       Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Eliminar el Articulo :" + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }
        return resultado;
    }
    public int actualizarArticulo (Articulo articulo){
        int resultado = 0;
        String sql = "UPDATE articulo set nombre_articulo = ? ,stock = ? ,stock_critico = ? ,fam_artic_id_fami_art = ? where id_articulo = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(5, articulo.getId_articulo());
            ps.setString(4, articulo.getFk_id_familia_artic());
            ps.setInt(3, articulo.getStock_critico());
            ps.setInt(2, articulo.getStock());
            ps.setString(1, articulo.getNombre_articulo());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al intentar actualizar el articulo" + ex);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                
            } catch (SQLException ex) {
                System.out.println("Error al intentar cerrar la conexión: " + ex.getMessage());

            }
        }
       return resultado;        
    }
    
    public List ListarArticulo () {
        List <Articulo> ArticuloList = new ArrayList <>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM articulo";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Articulo articulo = new Articulo (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                ArticuloList.add(articulo);
            }
        } catch (SQLException ex)
        {System.out.println("SQLException: " + ex.getMessage());      }
        return ArticuloList;
    }
    
    
}

