/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Service;
import Web.Conexion.Conexion;
import Web.Entidades.Reserva;
import Web.Metodos.Reservadatos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alumno
 */
@WebService(serviceName = "ReservaWS")
public class ReservaWS {
    
    Reservadatos rd = new Reservadatos();
    Reserva EntidadReserva = new Reserva();
    
    @WebMethod
    public boolean crearRserva( @WebParam(name = "id_reserva") String id_reserva,
            @WebParam (name = "estado_reserva") String estado_reserva,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa,
            @WebParam (name = "fk_id_orden_compra") String fk_id_orden_compra,
            @WebParam (name = "fecha_inicio") Date fecha_inicio,
            @WebParam (name = "fecha_termino") Date fecha_termino){
        
        EntidadReserva.setId_reserva(id_reserva);
        EntidadReserva.setFecha_inicio(fecha_inicio);
        EntidadReserva.setFecha_termino(fecha_termino);
        EntidadReserva.setEstado_reserva(estado_reserva);
        EntidadReserva.setFk_rut_empresa(fk_rut_empresa);
        EntidadReserva.setFk_nombre_empresa(fk_nombre_empresa);
        EntidadReserva.setFk_id_orden_compra(fk_id_orden_compra);
        
        rd.registrarReserva(EntidadReserva);
        return true;
    }
    
    @WebMethod
    public boolean eliminarReserva (@WebParam(name = "id_reserva") String id_reserva){
        rd.eliminarReserva(id_reserva);
        return true;
    }
    
    @WebMethod
    public boolean actualizarReserva( @WebParam(name = "id_reserva") String id_reserva,
            @WebParam (name = "estado_reserva") String estado_reserva,
            @WebParam (name = "fk_rut_empresa") String fk_rut_empresa,
            @WebParam (name = "fk_nombre_empresa") String fk_nombre_empresa,
            @WebParam (name = "fk_id_orden_compra") String fk_id_orden_compra,
            @WebParam (name = "fecha_inicio") Date fecha_inicio,
            @WebParam (name = "fecha_termino") Date fecha_termino){
        
        EntidadReserva.setId_reserva(id_reserva);
        EntidadReserva.setFecha_inicio(fecha_inicio);
        EntidadReserva.setFecha_termino(fecha_termino);
        EntidadReserva.setEstado_reserva(estado_reserva);
        EntidadReserva.setFk_rut_empresa(fk_rut_empresa);
        EntidadReserva.setFk_nombre_empresa(fk_nombre_empresa);
        EntidadReserva.setFk_id_orden_compra(fk_id_orden_compra);
        
        rd.actualizarReserva(EntidadReserva);
        return true;
    }
    
    @WebMethod
    public List<Reserva> listarReservas(){
        List reservaList = rd.listarReserva();
        return reservaList;
    }

}
