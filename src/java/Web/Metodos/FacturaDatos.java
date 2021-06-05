/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Factura;
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
public class FacturaDatos {
    public int registrarFactura(Factura factura){
        int resultado = 0;
        String sql = "INSERT INTO factura (id_factura, fecha_fac, precio_total, empresa_rut_empresa, empresa_nombre_empresa, proveedor_rut_pro, proveedor_id_pro, empleado_hostal_id_trabajador, pago_id_pago) values (?,?,?,?,?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, factura.getId_factura());
            ps.setDate(3, factura.getFecha_factura());
            ps.setInt(3, factura.getPrecio_total());
            ps.setString(4, factura.getFk_rut_empresa());
            ps.setString(5, factura.getFk_nombre_empresa());
            ps.setString(6, factura.getFk_rut_proveedor());
            ps.setString(7, factura.getFk_id_proveedor());
            ps.setString(8, factura.getFk_eh_id_trabajador());
            ps.setInt(9, factura.getFk_id_pago());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se puedo agregar Factura : " + e);
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
    
    public int eliminarFactura (String id_factura){
        int resultado = 0;
        String sql ="DELETE Factura where id_factura = '" + id_factura + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ah podido eliminar factura : " + e);
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
    
    public int actualizarFactura (Factura factura){
        int resultado = 0;
        String sql = "UPDATE factura set fecha_fac = ?, precio_total = ?, empresa_rut_empresa = ?, empresa_nombre_empresa = ?, proveedor_rut_pro = ?, proveedor_id_pro = ?, empleado_hostal_id_trabajador = ?, pago_id_pago where id_factura = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, factura.getFecha_factura());
            ps.setInt(2, factura.getPrecio_total());
            ps.setString(3, factura.getFk_rut_empresa());
            ps.setString(4, factura.getFk_nombre_empresa());
            ps.setString(5, factura.getFk_rut_proveedor());
            ps.setString(6, factura.getFk_id_proveedor());
            ps.setString(7, factura.getFk_eh_id_trabajador());
            ps.setInt(8, factura.getFk_id_pago());
            ps.setString(9, factura.getId_factura());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la factura");
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
    
    public List listarfactura (){
        List<Factura> facturaList = new ArrayList <>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM factura";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Factura factura = new Factura (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDate(9)
                ); facturaList.add(factura);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return facturaList;
        
        
    }
    
}
