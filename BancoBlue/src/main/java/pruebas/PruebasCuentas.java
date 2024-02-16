
package pruebas;

import bancoBluePersistencia.conexion.Conexion;
import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.CuentasDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;

/**
 *
 * @author t1pas
 */
public class PruebasCuentas {
    
    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/bancobd";
        String usuario = "root";
        String contrasenia = "1234a";
        //1234a
        //Itson
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        ICuentasDAO cuentasDAO = new CuentasDAO(conexion);
        
        CuentaNuevaDTO cuentaNueva=new CuentaNuevaDTO();
        cuentaNueva.setIdCliente(1);
        
        ClienteConsultableDTO clienteConsultable= new ClienteConsultableDTO();
        clienteConsultable.setId(1);
        
        CuentaCerrableDTO cuentaCerrableDTO=new CuentaCerrableDTO();
        cuentaCerrableDTO.setNumeroCuenta(128572707638894l);
       
        try {
            System.out.println(cuentasDAO.cancelar(cuentaCerrableDTO));
            //System.out.println(cuentasDAO.consultar(clienteConsultable));
            //cuentasDAO.agregar(cuentaNueva);
        } catch (PersistenciaException persistenciaException) {
        }
         

    }
}
