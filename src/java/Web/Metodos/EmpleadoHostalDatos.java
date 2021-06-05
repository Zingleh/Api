/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Empleado_Hostal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EmpleadoHostalDatos {
    public int registrarEmpleadoHostal (Empleado_Hostal empleadohostal){
        int resultado = 0;
        String sql = "INSERT INTO (id_trabajador, sueldo, cargo, usuario_id_usuario values (?,?,?,?))";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, empleadohostal.getId_trabajador());
            ps.setInt(2, empleadohostal.getSueldo());
            ps.setString(3, empleadohostal.getCargo());
            ps.setString(4, empleadohostal.getFk_id_usuario());
            
            resultado= ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al Ingresar Empleado");
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
    
    public int eliminarEmpleadoHostal (String id_trabajador){
        int resultado = 0;
        String sql = "DELETE empleado_hostal where id_trabajador = '" + id_trabajador + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar al empleado : " + e);
        }finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }
        return resultado = 0;
    }
    
    public int actualizarEmpleagoHostal (Empleado_Hostal empleadohostal){
        int resultado = 0;
        String sql = "UPDATE empleado_hostal sueldo = ?, cargo = ?, usuario_id_usuario = ? where id_trabajador = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setInt(1, empleadohostal.getSueldo());
            ps.setString(2, empleadohostal.getCargo());
            ps.setString(3, empleadohostal.getFk_id_usuario());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado" + e);
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
    
    public List listarEmpleadoHostal () {
        List <Empleado_Hostal> empleadohostalList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM empleado_hostal";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Empleado_Hostal empleadohostal = new Empleado_Hostal (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                empleadohostalList.add(empleadohostal);
            }
        } catch (Exception e) {
        
        
        
    }
        return empleadohostalList;
    }    
    
}
