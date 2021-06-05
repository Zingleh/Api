/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Entidades.Detalle_Factura_Cliente;
import Web.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * cantidad Servicio_comida_id_servicio Habitacion_id_Habitacion Factura_Id_Factura
 * @author Ariel
 */
public class Detalle_Factura_ClienteDatos {
    public int RegistrarDetalleCliente (Detalle_Factura_Cliente detallefacturacliente){
        int resultado = 0 ;
        String sql = "INSERT INTO detalle_factura_cliente (cantidad, servicio_comida_id_servicio, habitacion_id_habitacion, factura_id_factura) values (?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detallefacturacliente.getCantidad());
            ps.setString(2, detallefacturacliente.getFk_sc_id_servicio());
            ps.setString(3, detallefacturacliente.getFk_id_habitacion());
            ps.setString(4,detallefacturacliente.getFk_id_factura());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al Agregar detalle de cliente:" + e);
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
    
    public int EliminarDetalleFacturaCliente(String fk_id_factura){
        int resultado = 0;
        String sql ="DELETE detalle_factura_cliente where factura_id_factura = '" + fk_id_factura + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el detalle de factura para cliente: "+ e);
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
    
    public int ActualizarDetalleFacturaCliente (Detalle_Factura_Cliente detallefacturacliente){
        int resultado = 0;
        String sql = "UPDATE detalle_factura_cliente set cantidad = ?, servicio_comida_id_servicio = ?, habitacion_id_habitacion = ? where factura_id_factura = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setInt(1, detallefacturacliente.getCantidad());
            ps.setString(2, detallefacturacliente.getFk_sc_id_servicio());
            ps.setString(3, detallefacturacliente.getFk_id_habitacion());
            ps.setString(4, detallefacturacliente.getFk_id_factura());
            
            resultado = ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de orden de compra: " + e);
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
    
    public List listarDetalleCliente(){
        List<Detalle_Factura_Cliente> detallefacturaclienteList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM detalle_factura_cliente";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Detalle_Factura_Cliente detallefacturacliente = new Detalle_Factura_Cliente (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                detallefacturaclienteList.add(detallefacturacliente);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return detallefacturaclienteList;
        
    }
    
}
 