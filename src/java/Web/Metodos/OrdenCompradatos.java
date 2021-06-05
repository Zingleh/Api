/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Orden_Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alumno
 */
public class OrdenCompradatos {
    
    public int registrarOrdenCompra (Orden_Compra ordencompra){
        int resultado = 0;
        String sql = "INSERT INTO orden_compra (id_ordencom, empresa_rut_empresa, empresa_nombre_empresa) values (?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ordencompra.getId_orden_compra());
            ps.setString(2, ordencompra.getFk_rut_empresa());
            ps.setString(3, ordencompra.getFk_nombre_empresa());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar orden de compra : " + e);
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
    
    public int eliminarOrdenCompra (String id_orden_compra){
        int resultado = 0;
        String sql = "DELETE orden_compra where id_ordencom = '" + id_orden_compra + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar cliente");
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
    
    public int actualizarOrdenCompra (Orden_Compra ordencompra){
        int resultado = 0;
        String sql = "UPDATE orden_compra set empresa_rut_empresa = ?, empresa_nombre_empresa = ? where id_oredoncom = ? ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, ordencompra.getFk_rut_empresa());
            ps.setString(2, ordencompra.getFk_nombre_empresa());
            ps.setString(3, ordencompra.getId_orden_compra());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al actualizar orden de com : " + e);
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
    
    public List listarOrdenCompra(){
        List <Orden_Compra> ordencompraList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM orden_compra";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Orden_Compra ordencompra = new Orden_Compra (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                ); ordencompraList.add(ordencompra);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            
        }
        return ordencompraList;
        
    }
    
}
