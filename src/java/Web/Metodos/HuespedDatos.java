/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Huesped;
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
public class HuespedDatos {
    public int registrarHuesped (Huesped huesped){
        int resultado = 0 ;
        String sql ="INSERT INTO huesped (rut_hues, nombre_completo, empresa_rut_empresa, empresa_nombre_empresa) values (?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, huesped.getRut_huesped());
            ps.setString(2, huesped.getNombre_completo());
            ps.setString(3, huesped.getFk_rut_empresa());
            ps.setString(4, huesped.getFk_nombre_empresa());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(" Error al agragar huesped : " + e);
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
    
    public int eliminarHuesped (String rut_hues){
        int resultado = 0;
        String sql = "DELETE huesped where = '" + rut_hues + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ah podido eliminar el huesped : " + e);
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
    
    public int actualizarhuesped (Huesped huesped){
        int resultado = 0;
        String sql ="UPDATE huesped set nombre_completo = ?, empresa_rut_empresa = ?, empresa_nombre_empresa = ? where rut_hues = ? ";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, huesped.getNombre_completo());
            ps.setString(2, huesped.getFk_rut_empresa());
            ps.setString(3, huesped.getNombre_completo());
            ps.setString(4, huesped.getRut_huesped());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al intentar editar huesped : " + e);
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
    
    public List listarHuesped (){
        List <Huesped> huespedList = new ArrayList <>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM huesped";
            PreparedStatement ps = cn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Huesped huesped = new Huesped (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                huespedList.add(huesped);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return huespedList;
    }
    
}
