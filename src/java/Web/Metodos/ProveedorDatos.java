/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Proveedor;
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
public class ProveedorDatos {
    public int registrarProveedor(Proveedor proveedor){
        int resultado = 0;
        String sql = "INSERT INTO proveedor (rut_pro, id_pro, nombre_pro, direccion_pro, correo_pro, telefono_pro, usuario_id_usuario) values (?,?,?,?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, proveedor.getRut_proveedor());
            ps.setString(2, proveedor.getId_proveedor());
            ps.setString(3, proveedor.getNombre_proveedor());
            ps.setString(4, proveedor.getDireccion_proveedor());
            ps.setString(5, proveedor.getCorreo_proveedor());
            ps.setString(6, proveedor.getTelefono_proveedor());
            ps.setString(7, proveedor.getFk_id_usuario());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar proveedor : " + e);
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
    
    public int eliminarProveedor (String id_proveedor){
        int resultado = 0;
        String sql = "DELETE proveedor where id_proveedor = '" + id_proveedor + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ha podido eliminar el proveedor : " + e);
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
    
    public int actualizarProveedor (Proveedor proveedor){
        int resultado = 0;
        String sql = "UPDATE proveedor set rut_pro = ?, nombre_pro = ?, direccion_pro = ?, correo_pro = ?, telefono_pro = ?, usuario_id_usuario = ? where id_pro = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, proveedor.getRut_proveedor());
            ps.setString(2, proveedor.getNombre_proveedor());
            ps.setString(3, proveedor.getDireccion_proveedor());
            ps.setString(4, proveedor.getCorreo_proveedor());
            ps.setString(5, proveedor.getTelefono_proveedor());
            ps.setString(6, proveedor.getFk_id_usuario());
            ps.setString(7, proveedor.getId_proveedor());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el proveedor");
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
    
    public List listarProveedor (){
        List<Proveedor> proveedorList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM proveedor";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Proveedor proveedor = new Proveedor (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                        
                );
                proveedorList.add(proveedor);
            }
        } catch (SQLException e) {
            System.out.println("SqlException error : " + e.getMessage());
        }
        return proveedorList;
    }
    
}
