
package bancoBluePersistencia.daos;

import java.util.List;
import bancoBluePersistencia.dtos.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;

/**
 *
 * @author Jorge Zamora 245103
 */
public interface IClientesDAO {
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    boolean actualizar (ClienteActualizableDTO clienteActualizable) throws PersistenciaException;

    /**
     *
     * @param clienteConsultable
     * @return
     * @throws PersistenciaException
     */
    Cliente consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;
    List<Cliente> consultar() throws PersistenciaException;
    //boolean eliminar(ClienteEliminableDTO clienteEliminable) throws PersistenciaException; NO SE PUEDE ELIMINAR CLIENTES
    
}
