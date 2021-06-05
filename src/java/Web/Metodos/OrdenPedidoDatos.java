/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Orden_Pedido;
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
public class OrdenPedidoDatos {
    public int registrarOrdenPedido(Orden_Pedido ordenpedido){
        int resultado = 0;
        String sql = "INSERT INTO orden_predido (id_pedido, fecha, proveedor_rut_pro, proveedor_id_pro) values (?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ordenpedido.getId_pedido());
            ps.setDate(2, ordenpedido.getFecha());
            ps.setString(3, ordenpedido.getFk_rut_proveedor());
            ps.setString(4, ordenpedido.getFk_id_proveedor());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al agregar orden pedido : " + e);
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
    
    public int eliminarOrdenPedido(Integer id_pedido){
        int resultado = 0;
        String sql = "DELETE orden_pedido where = '" + id_pedido + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar orden de pedido : " + e);
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
    
    public int actualizarOrdenPedido(Orden_Pedido ordenpedido){
        int resultado = 0;
        String sql ="UPDATE orden_pedido set fecha = ?, proveedor_rut_pro = ?, proveedor_id_pro = ? where id_pedido = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, ordenpedido.getFecha());
            ps.setString(2, ordenpedido.getFk_rut_proveedor());
            ps.setString(3, ordenpedido.getFk_id_proveedor());
            ps.setInt(4, ordenpedido.getId_pedido());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al actualizar orden pedido : " + e);
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
    
    public List listarOrdenPedido(){
        List<Orden_Pedido> ordenpedidoList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM orden_pedido";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Orden_Pedido ordenpedido = new Orden_Pedido (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4)
                ); 
                ordenpedidoList.add(ordenpedido);
            }
        } catch (SQLException e ) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return ordenpedidoList;
    }
    
}
