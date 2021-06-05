/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Pedido;
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
public class Detalle_PedidoDatos {
    public int registrarDetallePedido(Detalle_Pedido detallepedido) {
        int resultado = 0;
        String sql ="INSERT INTO detalle_pedido (cantidad , orden_pedido_id_pedido, articulo_id_articulo) values (?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detallepedido.getCantidad());
            ps.setInt(2, detallepedido.getFk_id_pedido());
            ps.setString(3, detallepedido.getFk_id_articulo());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al agregar detalle pedido");
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
    
    public int eliminarDetallePedido (Integer fk_id_pedido){
        int resultado = 0;
        String sql = "DELETE detalle_pedido where orden_pedido_id_pedido = '" + fk_id_pedido + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el detalle del pedido : " + e );
        } finally {
            try {
                if(cn != null){
                cn.close();
            }
            } catch (SQLException ex) {
                System.out.println("[SqlServerProductoDAO] Error al intentar cerrar la conexión: " + ex.getMessage());
            }

        }
        return resultado;
    }
    
    public int actualizarDetallePedido(Detalle_Pedido detallepedido){
        int resultado = 0;
        String sql = "UPDATE detalle_pedido set cantidad = ?, articulo_id_articulo = ? where orden_pedido_id_pedido = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setInt(1, detallepedido.getCantidad());
            ps.setString(2,detallepedido.getFk_id_articulo() );
            ps.setInt(3, detallepedido.getFk_id_pedido());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el dettale del pedido : " + e);
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
    
    public List listarDetallePedido() {
        List <Detalle_Pedido> detallepedidoList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM detalle_pedido";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Detalle_Pedido detallepedido = new Detalle_Pedido(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
                detallepedidoList.add(detallepedido);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return detallepedidoList;
    }
    
}
