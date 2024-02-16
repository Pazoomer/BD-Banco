
package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaActualizableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface ICuentasDAO {
    Cuenta agregar(CuentaNuevaDTO cuentaNuevo) throws PersistenciaException;
    //boolean actualizarEstado (CuentaActualizableDTO cuentaActualizable) throws PersistenciaException;
    //boolean actualizarSaldo (CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException;
    boolean cancelar (CuentaCerrableDTO cuentaCerrableDTO) throws PersistenciaException;
    Cuenta consultar(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException;
    List<Cuenta> consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;
}
