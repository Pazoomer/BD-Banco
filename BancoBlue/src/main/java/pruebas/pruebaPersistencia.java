
package pruebas;

import bancoBluePersistencia.conexion.Conexion;
import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.excepciones.PersistenciaException;

/**
 *
 * @author t1pas
 */
public class pruebaPersistencia {

    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost/bancoBD";
        String usuario = "root";
        String contrasenia = "Itson";
        //1234a
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        IClientesDAO clientesDAO = new ClientesDAO(conexion);

        try {
            System.out.println(clientesDAO.consultar());
        } catch (PersistenciaException persistenciaException) {
        }

    }
}
