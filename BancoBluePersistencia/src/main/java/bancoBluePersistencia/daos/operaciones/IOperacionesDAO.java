
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionTransferenciaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Operacion;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface IOperacionesDAO {
    //Operacion agregarTransferencia(OperacionTransferenciaNuevaDTO operacionTransferenciaNueva) throws PersistenciaException;
    boolean actualizar (OperacionActualizableDTO operacionActualizable) throws PersistenciaException;
    List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;
}
