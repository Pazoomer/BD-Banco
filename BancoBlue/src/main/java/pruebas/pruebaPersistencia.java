
package pruebas;

import bancoBluePersistencia.conexion.Conexion;
import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteInicioSesionDTO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;

/**
 *
 * @author t1pas
 */
public class pruebaPersistencia {

    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/bancobd";
        String usuario = "root";
        String contrasenia = "1234a";
        //1234a
        //Itson
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        
        ClienteConsultableDTO clienteConsultable=new ClienteConsultableDTO();
        clienteConsultable.setId(1);
        
        ClienteNuevoDTO clienteNuevo=new ClienteNuevoDTO();
        clienteNuevo.setApellidoMaterno("a");
        clienteNuevo.setApellidopaterno("a");
        clienteNuevo.setCalle("a");
        clienteNuevo.setCiudad("a");
        clienteNuevo.setCodigoPostal(1);
        clienteNuevo.setColonia("a");
        clienteNuevo.setContrasenia("a");
        clienteNuevo.setEstado("a");
        clienteNuevo.setFechaNacimiento(null);
        clienteNuevo.setNombre("a");
        clienteNuevo.setNombreUsuario("a");
        clienteNuevo.setNumExterior(1);
        
        ClienteActualizableDTO clienteActualizable=new ClienteActualizableDTO();
        clienteActualizable.setId(3);
        clienteActualizable.setApellidoMaterno("b");
        clienteActualizable.setApellidopaterno("b");
        clienteActualizable.setCalle("b");
        clienteActualizable.setCiudad("b");
        clienteActualizable.setCodigoPostal(2);
        clienteActualizable.setColonia("b");
        clienteActualizable.setContrasenia("b");
        clienteActualizable.setEstado("b");
        clienteActualizable.setFechaNacimiento(null);
        clienteActualizable.setNombre("b");
        clienteActualizable.setNombreUsuario("b");
        clienteActualizable.setNumExterior(2);

        ClienteInicioSesionDTO clienteInicioSesion = new ClienteInicioSesionDTO();
        clienteInicioSesion.setContrasenia("cebolla8");
        clienteInicioSesion.setNombreUsuario("CarlitosMora");
        /*
        try {
            //System.out.println(clientesDAO.consultar(clienteInicioSesion));
            //System.out.println(clientesDAO.actualizar(clienteActualizable));
            //System.out.println(clientesDAO.agregar(clienteNuevo));
            //System.out.println(clientesDAO.consultar());
            //System.out.println(clientesDAO.consultar(clienteConsultable));
        } catch (PersistenciaException persistenciaException) {
        }
         */

    }
}
