/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Entidades.Tipo_Habitacion;
import Web.Conexion.Conexion;
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
public class TipoHabitacionDatos {
    
    public int registrarTipoHabitacion(Tipo_Habitacion tipohabitacion){
        int resultado = 0;
        String sql ="INSERT INTO tipo_habitacion (tipo_cama, cantidad_baño, tipo_tv, tipo_wifi, precio, habitacion_id_habitacion) values (?,?,?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, tipohabitacion.getTipo_cama());
            ps.setInt(2, tipohabitacion.getCantidad_baño());
            ps.setString(3, tipohabitacion.getTipo_tv());
            ps.setString(3, tipohabitacion.getTipo_wifi());
            ps.setInt(5, tipohabitacion.getPrecio());
            ps.setString(6, tipohabitacion.getFk_id_habitacion());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al agregar tipo de habitacion : " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(" Error al intentar cerrar la conexión: " + ex.getMessage());
            }
        }  
        }   
        return resultado;
    }
    
    public int eliminarTipoHabitacion (String fk_id_habitacion){
        int resultado = 0;
        String sql = "DELETE tipo_habitacion where habitacion_id_habitacion = '" + fk_id_habitacion + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el tipo de habitacion");
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
    
    public int actualizarTipoHabitacion (Tipo_Habitacion tipohabitacion){
        int resultado = 0;
        String sql ="UPDATE tipo_habitacion ser tipo_cama = ?, cantidad_baño = ?, tipo_tv = ?, tipo_wifi =?, precio =? where habitacion_id_habitacion = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql); 
            ps.setString(1, tipohabitacion.getTipo_cama());
            ps.setInt(2, tipohabitacion.getCantidad_baño());
            ps.setString(3, tipohabitacion.getTipo_tv());
            ps.setString(4, tipohabitacion.getTipo_wifi());
            ps.setInt(5, tipohabitacion.getPrecio());
            ps.setString(6, tipohabitacion.getFk_id_habitacion());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo habitacion");
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
    
    public List listarTipoHabitacion(){
        List<Tipo_Habitacion> tipohabitacionList = new ArrayList <> ();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM tipo_habitacion";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Tipo_Habitacion tipohabitacion = new Tipo_Habitacion (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                tipohabitacionList.add(tipohabitacion);
            
        }
        } catch (SQLException e) {
            System.out.println("SQLException : " + e);
        }
        return tipohabitacionList;
    }
    
}
