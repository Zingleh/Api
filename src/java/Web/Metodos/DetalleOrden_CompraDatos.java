/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Orden_Compra;
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
public class DetalleOrden_CompraDatos {
    
    public int registrarDetalleOrdenCompra(Detalle_Orden_Compra detalleordencompra){
        int resultado = 0;
        String sql = "INSERT INTO detalle_orden_compra (cantidad, orden_compra_id_ordencom, servicio_comida_id_servicio, habitacion_id_habitacion, huesped_rut_hues) values (?,?,?,?,?)";
        Connection cn= Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detalleordencompra.getCantidad());
            ps.setString(2, detalleordencompra.getFk_id_orden_compra());
            ps.setString(3, detalleordencompra.getFk_sc_id_servicio());
            ps.setString(4, detalleordencompra.getFk_id_habitacion());
            ps.setString(5, detalleordencompra.getFk_rut_huesped());
            resultado= ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al intentar almacenar la informacion del detalle : "+ e);            
        }finally {
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
    
    public int eliminarDetalleOrden (String Fk_id_orden_compra){
        int resultado = 0;
        String sql = "DELETE detalle_orden_compra where orden_compra_id_ordencom = '" + Fk_id_orden_compra + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle de compra: " + e );
        }finally {
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
    
    public int actualizarOrdenCompra (Detalle_Orden_Compra detalleordencompra){
        int resultado = 0 ;
        String sql = "UPDATE detalle_orden_compra set cantidad = ?, servicio_comida_id_servicio, habitacion_id_habitacion, huesped_rut_hues where orden_compra_id_ordencom = ?";
        Connection cn= Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            
            ps.setInt(1, detalleordencompra.getCantidad());
            ps.setString(2, detalleordencompra.getFk_sc_id_servicio());
            ps.setString(3, detalleordencompra.getFk_id_habitacion());
            ps.setString(4, detalleordencompra.getFk_rut_huesped());
            ps.setString(5, detalleordencompra.getFk_id_habitacion());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al intentar actualizar la informacion del detalle de compra : " + e);
        }finally {
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
    
    public List listarDetalleOrdenCompra(){
        List<Detalle_Orden_Compra> DetalleOrdenCompraList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String queri = "SELECT * FROM detalle_orden_compra";
            PreparedStatement ps = cn.prepareCall(queri);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Detalle_Orden_Compra detalleordencompra = new Detalle_Orden_Compra (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                DetalleOrdenCompraList.add(detalleordencompra);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return DetalleOrdenCompraList;
        
    }
    
}
