/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Pago;
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
public class Pagodatos {
    
    public int registrarPago (Pago pago){
        int resultado = 0;
        String sql = "INSERT INTO (id_pago, tipo_pago) values (?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, pago.getId_pago());
            ps.setString(2, pago.getTipo_pago());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("error al agergar pago : " + e);
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
    
    public int eliminarPago (Integer id_pago){
        int resultado = 0;
        String sql = "DELETE pago where ig_pego = '" + id_pago + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el pago : " + e);
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
    
    public int actualizarPago (Pago pago) {
        int resultado = 0;
        String sql = "UPDATE pago set tipo_pago = ? where id_pago = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pago.getTipo_pago());
            ps.setInt(2, pago.getId_pago());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ha podido actualizar el pago");
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
    
    public List listarPago (){
        List<Pago> pagoList = new ArrayList <>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM pago";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pago pago = new Pago (
                        rs.getInt(1),
                        rs.getString(2)
                ); 
                pagoList.add(pago);
            }
        } catch (SQLException e) {
            System.out.println(" SQLException : " + e.getMessage());
        }
        return pagoList;
    }
    
}
