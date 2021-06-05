/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Metodos;
import Web.Conexion.Conexion;
import Web.Entidades.Empresa;
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
public class EmpresaDatos {
    public int registrarEmpresa(Empresa empresa){
        int resultado = 0;
        String sql = "INSERT INTO empresa (rut_empresa, nombre_empresa, razon_social, direccion, correo, telefono, usuario_id_usuario) values (?,?,?,?,?,?,?)";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, empresa.getRut_empresa());
            ps.setString(2, empresa.getNombre_empresa());
            ps.setString(3, empresa.getRazon_social());
            ps.setString(4, empresa.getDireccion());
            ps.setString(5, empresa.getCorreo());
            ps.setString(6, empresa.getTelefono());
            ps.setString(7, empresa.getFk_id_usuario());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e ) {
            System.out.println("error al agregar empresa : " + e);
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
    
    public int eliminarEmpresa (String rut_empresa){
        int resultado = 0;
        String sql = "DELETE empresa hwere rut_empresa = '" + rut_empresa + "'";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("no se a podido eliminar empresa : " + e);
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
    
    public int actualizarEmpresa (Empresa empresa) {
        int resultado = 0;
        String sql = "UPDATE empresa set nombre_empresa = ?, razon_social = ?, direccion = ?, correo, telefono = ? , usuario_id_usuario = ? where rut_empresa = ?";
        Connection cn = Conexion.Miconexion();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, empresa.getNombre_empresa());
            ps.setString(2, empresa.getRazon_social());
            ps.setString(3, empresa.getDireccion());
            ps.setString(4, empresa.getCorreo());
            ps.setString(5, empresa.getTelefono());
            ps.setString(6, empresa.getFk_id_usuario());
            ps.setString(7, empresa.getRut_empresa());
            
            resultado = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la empresa : " + e);
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
    
    public List listarEmpresa (){
        List <Empresa> empresaList = new ArrayList<>();
        Connection cn = Conexion.Miconexion();
        try {
            String query = "SELECT * FROM empresa";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Empresa empresa = new Empresa (
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ); empresaList.add(empresa);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return empresaList;
    }
    
}
