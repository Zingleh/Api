/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Habitacion;
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
public class HabitacionDatos {
    
    public int registrarHabitacion (Habitacion habitacion) {
        int resultado = 0;
        String sql = "INSERT INTO Habitacion (id_habitacion, tamaño, estado) values (?,?,?) ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, habitacion.getId_habitacion());
            ps.setString(2, habitacion.getTamaño());
            ps.setString(3, habitacion.getEstado());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar habitacion : " + e);
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
    
    public int eliminarHabitacion (String id_habitacion){
        int resultado = 0;
        String sql = "DELETE habitacion where id_habitacion = '" + id_habitacion + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" No se ha podido eliminar la habitacion" + e);
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
    
    public int actualizarHabitacion (Habitacion habitacion){
        int resultado = 0;
        String sql = "UPDATE habitacion set tamaño = ?, estado = ? where id_habitacion = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, habitacion.getTamaño());
            ps.setString(2, habitacion.getEstado());
            ps.setString(3, habitacion.getId_habitacion());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar habitacion : " + e);
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
    
    public List listarHabitacion (){
        List <Habitacion> habitacionList = new ArrayList <>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM habitacion";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Habitacion habitacion = new Habitacion(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                habitacionList.add(habitacion);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return habitacionList;
    }
    
}
