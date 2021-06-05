/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Detalle_Factura_Proveedor;
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
public class Detalle_Factura_ProveedorDatos {
    
    public int RegistrarDetalleProveedor (Detalle_Factura_Proveedor detallefacturaproveedor){
        int resultado = 0;
        String sql = "INSERT INTO detalle_factura_proveedor (cantidad, factura_id_factura, articulo_id_articulo) values (?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detallefacturaproveedor.getCantidad());
            ps.setString(2, detallefacturaproveedor.getFk_id_factura());
            ps.setString(3, detallefacturaproveedor.getFk_id_articulo());
            
            resultado = ps.executeUpdate();
            ps.close();
                    
        } catch (SQLException e) {
            System.out.println("Error al agregar detalle de proveedor: " + e);
        }finally {
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
    
    public int EliminarDetallePRoveedor (String fk_id_factura) {
        int resultado = 0;
        String sql = "DELETE detalle_factura_proveedor where factura_id_factura = '" + fk_id_factura + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se puedo eliminar detalle de venta" + e);
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
    
    public int ActualizarDetalleFacturaProveedor (Detalle_Factura_Proveedor detallefacturaproveedor){
        int resultado = 0;
        String sql = "UPDATE detalle_factura_proveedor cantidad = ?, articulo_id_articulo = ? where factura_id_factura = ?";
        Connection cn= Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detallefacturaproveedor.getCantidad());
            ps.setString(2, detallefacturaproveedor.getFk_id_articulo());
            ps.setString(3, detallefacturaproveedor.getFk_id_factura());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al Actualizar el detalle de factura de proveedor" + e);
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
    
    public List listarDetalleProveedor (){
        List <Detalle_Factura_Proveedor> detallefacturaproveedorList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM detalle_factura_proveedor";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Detalle_Factura_Proveedor detallefacturaproveedor = new Detalle_Factura_Proveedor (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                detallefacturaproveedorList.add(detallefacturaproveedor);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido listar el detalle de proveedor" + e);
        }
        return detallefacturaproveedorList;
    }
    
}
