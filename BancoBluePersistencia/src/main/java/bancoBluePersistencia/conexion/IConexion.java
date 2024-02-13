
package bancoBluePersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jorge Zamora 245103
 */
public interface IConexion {
    Connection obtenerConexion() throws SQLException;
}
