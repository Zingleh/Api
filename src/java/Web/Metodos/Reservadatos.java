/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Reserva;
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
public class Reservadatos {
    
    public int registrarReserva (Reserva reserva){
        int resultado = 0;
        String sql = "INSERT INTO reserva (id_reserva, fecha_inicio, fecha_termino, estado_res, empresa_rut_empresa, empresa_nombre_empresa, orden_compra_id_ordencom) values (?,?,?,?,?,?,?) ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, reserva.getId_reserva());
            ps.setDate(2, reserva.getFecha_inicio());
            ps.setDate(3, reserva.getFecha_termino());
            ps.setString(4, reserva.getEstado_reserva());
            ps.setString(5, reserva.getFk_rut_empresa());
            ps.setString(6, reserva.getFk_nombre_empresa());
            ps.setString(7, reserva.getFk_id_orden_compra());
            
            resultado = ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("No se ha podido registrar la reserva : " + e);
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
    
    public int eliminarReserva (String id_reserva){
        int resultado = 0;
        String sql = "DELETE reserva where id_reserva = '" + id_reserva + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar la reserva del cliente : " + e);
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
    
    public int actualizarReserva (Reserva reserva){
        int resultado = 0;
        String sql = "UPDATE reserva set fecha_inicio = ?, fecha_termino = ?, estado_red = ?, empresa_rut_empresa = ?, empresa_nombre_empresa = ?, orden_compra_id_ordencom = ? where id_reserva = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, reserva.getFecha_inicio());
            ps.setDate(2, reserva.getFecha_termino());
            ps.setString(3, reserva.getEstado_reserva());
            ps.setString(4, reserva.getFk_rut_empresa());
            ps.setString(5, reserva.getFk_nombre_empresa());
            ps.setString(6, reserva.getFk_id_orden_compra());
            ps.setString(7, reserva.getId_reserva());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al actualizar la reserva : " + e);
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
    
    public List listarReserva(){
        List<Reserva> reservaList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM reserva";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Reserva reserva = new Reserva(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7)
                        
                );
                reservaList.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
        }
        return reservaList;
    }
    
}
