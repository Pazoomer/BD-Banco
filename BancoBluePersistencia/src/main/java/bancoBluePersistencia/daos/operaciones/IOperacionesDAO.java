
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableRetiroDTO;
import bancoBluePersistencia.dtos.operacion.OperacionEstadoDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Operación. Clase documentada
 *
 * @author Jorge Zamora y Victoria Vega
 */
public interface IOperacionesDAO {

    /**
     * Actualiza la información de una operación en la base de datos.
     *
     * @param operacionActualizable Contiene los datos necesarios para actualizar una operación.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    boolean actualizar(OperacionActualizableDTO operacionActualizable) throws PersistenciaException;

    /**
     * Cambia el estado de una operación en la base de datos.
     *
     * @param operacionEstado Contiene los datos necesarios para cambiar el estado de una operación.
     * @return true si el cambio de estado fue exitoso, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    boolean cambiarEstado(OperacionEstadoDTO operacionEstado) throws PersistenciaException;

    /**
     * Consulta la lista de operaciones asociadas a una cuenta.
     *
     * @param cuentaConsultable Contiene los datos necesarios para consultar las operaciones de una cuenta.
     * @return Lista de operaciones asociadas a la cuenta.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException;

     /**
     * Consulta la información de un retiro específico.
     *
     * @param operacionConsultableRetiro Contiene los datos necesarios para consultar un retiro específico.
     * @return Operación de retiro con la información solicitada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     * @throws ValidacionDTOException Cuando hay un problema de validación en los datos proporcionados.
     */
    Operacion consultar(OperacionConsultableRetiroDTO operacionConsultableRetiro) throws PersistenciaException, ValidacionDTOException;

     /**
     * Agrega una nueva operación a la base de datos.
     *
     * @param operacionNueva Contiene los datos necesarios para crear una nueva operación.
     * @return Operación creada con la información proporcionada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    Operacion agregarOperacion(OperacionNuevaDTO operacionNueva) throws PersistenciaException;

    /**
     * Consulta la cuenta asociada a una operación.
     *
     * @param operacionConsultable Contiene los datos necesarios para consultar la cuenta asociada a una operación.
     * @return Cuenta asociada a la operación.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    Cuenta consultarCuenta(OperacionConsultableDTO operacionConsultable) throws PersistenciaException;
}
