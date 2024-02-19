package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaSaldoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cuenta;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cuenta.
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public interface ICuentasDAO {

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuentaNuevo Contiene los datos necesarios para crear una nueva
     * cuenta.
     * @return Cuenta creada con la información proporcionada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    Cuenta agregar(CuentaNuevaDTO cuentaNuevo) throws PersistenciaException;

    /**
     * Consulta la información de una cuenta para un usuario específico.
     *
     * @param cuentaConsultableUsuario Contiene los datos necesarios para
     * consultar una cuenta por usuario.
     * @return Cuenta con la información solicitada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     * @throws ValidacionDTOException Cuando hay un problema de validación en
     * los datos proporcionados.
     */
    Cuenta consultar(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException, ValidacionDTOException;

    /**
     * Consulta el nombre de cliente asociado a una cuenta.
     *
     * @param cuentaConsultableUsuario Contiene los datos necesarios para
     * consultar el nombre del cliente asociado a una cuenta.
     * @return Nombre del cliente asociado a la cuenta.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    String consultarCliente(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException;

    /**
     * Cancela una cuenta, cambiando su estado a cerrada.
     *
     * @param cuentaCerrable Contiene los datos necesarios para cerrar una
     * cuenta.
     * @return true si la cancelación fue exitosa, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    boolean cancelar(CuentaCerrableDTO cuentaCerrable) throws PersistenciaException;

    /**
     * Consulta la lista de cuentas asociadas a un cliente.
     *
     * @param clienteConsultable Contiene los datos necesarios para consultar
     * las cuentas de un cliente.
     * @return Lista de cuentas asociadas al cliente.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    List<Cuenta> consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;

    /**
     * Cambia el monto de una cuenta, realizando operaciones de depósito o
     * retiro.
     *
     * @param cuentaSaldo Contiene los datos necesarios para cambiar el monto de
     * una cuenta.
     * @return true si la operación fue exitosa, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     * @throws ValidacionDTOException Cuando hay un problema de validación en
     * los datos proporcionados.
     */
    boolean cambiarMonto(CuentaSaldoDTO cuentaSaldo) throws PersistenciaException, ValidacionDTOException;
}
