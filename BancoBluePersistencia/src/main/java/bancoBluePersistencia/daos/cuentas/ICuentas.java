
package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaActualizableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface ICuentas {
    Cuenta agregar(CuentaNuevaDTO cuentaNuevo) throws PersistenciaException;
    boolean actualizar (CuentaActualizableDTO cuentaActualizable) throws PersistenciaException;
    boolean eliminar (CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;
    Cuenta consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;
    List<Cuenta> consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;
}
