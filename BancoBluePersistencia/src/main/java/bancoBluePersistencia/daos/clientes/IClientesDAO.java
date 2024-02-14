
package bancoBluePersistencia.daos.clientes;

import java.util.List;
import bancoBluePersistencia.dtos.cliente.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteInicioSesionDTO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;

/**
 *
 * @author Jorge Zamora 245103
 */
public interface IClientesDAO {
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    boolean actualizar (ClienteActualizableDTO clienteActualizable) throws PersistenciaException;
    Cliente consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;
    Cliente consultar(ClienteInicioSesionDTO clienteInicioSesion) throws PersistenciaException;
    List<Cliente> consultar() throws PersistenciaException;
    //boolean eliminar(ClienteEliminableDTO clienteEliminable) throws PersistenciaException; NO SE PUEDE ELIMINAR CLIENTES
    
}
