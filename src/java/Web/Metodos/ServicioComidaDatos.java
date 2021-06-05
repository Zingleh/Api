/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Servicio_Comida;
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
public class ServicioComidaDatos {
    
    public int registrarServicioComida(Servicio_Comida serviciocomida){
        int resultado = 0;
        String sql = "INSERT INTO servicio_comida (id_servicio, nombre_servicio, precio, platos_id_plato) values (?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, serviciocomida.getId_servicio());
            ps.setString(2, serviciocomida.getNombre_servicio());
            ps.setInt(3, serviciocomida.getPrecio());
            ps.setInt(4, serviciocomida.getFk_id_plato());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al Agregar Servicio de comida : " + e);
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
    
    public int eliminarServicioComida (String id_servicio){
        int resultado = 0;
        String sql = "DELETE servicio_comida where id_servicio = '" + id_servicio + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido eliminar el servicio de comida : " + e);
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
    
    public int actualizarServicioComida (Servicio_Comida serviciocomida){
        int resultado = 0;
        String sql = "UPDATE servicio_comida set nombre_servicio = ?, precio = ?, platos_id_plato = ? where id_servicio = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, serviciocomida.getNombre_servicio());
            ps.setInt(2, serviciocomida.getPrecio());
            ps.setInt(3, serviciocomida.getFk_id_plato());
            ps.setString(4, serviciocomida.getId_servicio());
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al actualizar servicio de comida : " + e);
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
    
    public List listarServicioComida(){
        List<Servicio_Comida> serviciocomidaList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM servicio_comida";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Servicio_Comida serviciocomida = new Servicio_Comida (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ); serviciocomidaList.add(serviciocomida);
            }
        } catch (SQLException e) {
            System.out.println("SQLEXCEPTION : " + e);
        }
        return serviciocomidaList;
    }
    
}
