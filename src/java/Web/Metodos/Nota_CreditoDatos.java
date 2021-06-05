/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Nota_Credito;
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
public class Nota_CreditoDatos {
    public int registrarNotaCredito (Nota_Credito notacredito){
        int resultado = 0;
        String Sql = "INSERT INTRO nota_credito (id_nota, fecha, factura_id_factura) values (?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(Sql);
            ps.setInt(1, notacredito.getId_nota());
            ps.setDate(2, notacredito.getFecha());
            ps.setString(3, notacredito.getFk_id_factura());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar nota de credito :" + e);
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
    
    public int eliminarNotaCredito (Integer id_nota){
        int resultado = 0;
        String sql = "DELETE nota_credito where id_nota = '" + id_nota + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se ha podido eliminar la nota d ecredito : " + e);
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
    
    public int actualizarnotaCredito (Nota_Credito notacredito){
        int resultado = 0;
        String sql = "UPDATE nota_credito set fecha = ?, factura_id_factura = ? where id_nota = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps =cn.prepareStatement(sql);
            
            ps.setDate(1, notacredito.getFecha());
            ps.setString(2, notacredito.getFk_id_factura());
            ps.setInt(3, notacredito.getId_nota());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar nota de credito : " + e);
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
    
    public List listarNotaCredito(){
        List<Nota_Credito> notacreditoList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM nota_credito";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Nota_Credito notacredito = new Nota_Credito (
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getString(3)
                ); notacreditoList.add(notacredito);
            }
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return notacreditoList;
    }
    
}
