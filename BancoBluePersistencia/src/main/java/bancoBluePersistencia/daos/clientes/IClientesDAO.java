
package bancoBluePersistencia.daos.clientes;

import java.util.List;
import bancoBluePersistencia.dtos.cliente.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteInicioSesionDTO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;

/**
 * Interfaz que permite operar con clientes en la base de datos
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public interface IClientesDAO {
    /**
     * Agrega un nuevo cliente a la base de datos
     *
     * @param clienteNuevo contiene todos los datos que un cliente tiene antes
     * de entrar a la base de datos
     * @return Cliente con todos los datos
     * @throws PersistenciaException Cuando ocurre un error en la base de datos
     */
    Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;

    /**
     * Actualiza la información de un cliente en la base de datos.
     *
     * @param clienteActualizable Contiene los datos actualizables de un
     * cliente.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    boolean actualizar(ClienteActualizableDTO clienteActualizable) throws PersistenciaException;

    /**
     * Consulta la información de un cliente en la base de datos.
     *
     * @param clienteConsultable Contiene los datos necesarios para consultar un
     * cliente.
     * @return Cliente con la información solicitada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    Cliente consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException;

    /**
     * Consulta la información de un cliente para el inicio de sesión.
     *
     * @param clienteInicioSesion Contiene el nombre de usuario y contraseña
     * sesión.
     * @return Cliente con la información requerida para el inicio de sesión.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    Cliente consultar(ClienteInicioSesionDTO clienteInicioSesion) throws PersistenciaException;

    /**
     * Consulta la lista de todos los clientes en la base de datos.
     *
     * @return Lista de clientes almacenados en la base de datos.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    List<Cliente> consultar() throws PersistenciaException;

    /**
     * Valida si un nombre de usuario ya existe en la base de datos.
     *
     * @param nombreConsultable Nombre de usuario a ser validado.
     * @return true si el nombre de usuario ya existe, false si es único.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    boolean validarNombreUsuarios(String nombreConsultable) throws PersistenciaException;
}
