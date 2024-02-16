/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import bancoBluePersistencia.conexion.Conexion;
import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.CuentasDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.daos.operaciones.OperacionesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;

/**
 *
 * @author t1pas
 */
public class PruebasOperaciones {

    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/bancobd";
        String usuario = "root";
        String contrasenia = "1234a";
        //1234a
        //Itson
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        ICuentasDAO cuentasDAO = new CuentasDAO(conexion);
        IOperacionesDAO operacionesDAO=new OperacionesDAO(conexion);

        /*
        try {
            
        } catch (PersistenciaException | ValidacionDTOException persistenciaException) {

        }*/

    }
}
