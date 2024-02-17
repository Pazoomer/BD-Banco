
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableRetiroDTO;
import bancoBluePersistencia.dtos.operacion.OperacionEstadoDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Operacion;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface IOperacionesDAO {
    //Operacion agregarTransferencia(OperacionNuevaDTO operacionTransferenciaNueva) throws PersistenciaException;
    boolean actualizar (OperacionActualizableDTO operacionActualizable) throws PersistenciaException;
    boolean cambiarEstado (OperacionEstadoDTO operacionEstado) throws PersistenciaException;
    List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;
    Operacion consultar(OperacionConsultableRetiroDTO operacionConsultableRetiro) throws PersistenciaException,ValidacionDTOException;
    Operacion agregarOperacion(OperacionNuevaDTO operacionNueva) throws PersistenciaException;
}
