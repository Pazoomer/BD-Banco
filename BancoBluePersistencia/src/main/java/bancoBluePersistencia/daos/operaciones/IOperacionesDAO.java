
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Operacion;
import java.util.List;

/**
 *
 * @author t1pas
 */
public interface IOperacionesDAO {
    //Operacion agregarTransferencia(OperacionNuevaDTO operacionTransferenciaNueva) throws PersistenciaException;
    boolean actualizar (OperacionActualizableDTO operacionActualizable) throws PersistenciaException;
    boolean cobrar (OperacionConsultableDTO operacionConsultableDTO) throws PersistenciaException;
    List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;
}
