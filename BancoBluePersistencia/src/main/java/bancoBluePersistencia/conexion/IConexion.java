
package bancoBluePersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Permite actualizarse facilmente en caso de cambios en la interfaz relacionado con las conexiones
 * Clase documentada
 * @author Jorge Zamora 245103
 */
public interface IConexion {
    /**
     * Obtiene la conexion con la base de datos
     * @return Connecion con la base de datos
     * @throws SQLException Cuando no se pudo conectar
     */
    Connection obtenerConexion() throws SQLException;
}
