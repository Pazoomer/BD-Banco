
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionTransferenciaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.herramientas.Fechas;
import bancoBluePersistencia.herramientas.GeneradorNumeros;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t1pas
 */
public class OperacionesDAO implements IOperacionesDAO{

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public OperacionesDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }



    public Operacion agregarOperacion(OperacionTransferenciaNuevaDTO operacionTransferenciaNueva) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO Operaciones (monto, motivo, fecha_creacion, codigoCuenta, tipo)
            VALUES (?, ?, ?, ?, 'Transferencia');
                              """;

        Connection conexion = null; // Declarar la variable fuera del bloque try

        try {
            conexion = this.conexionBD.obtenerConexion();
            conexion.setAutoCommit(false); // Desactivar la confirmación automática

            try (PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

                Date fechaAhora = Date.valueOf(LocalDate.now());

                comando.setLong(1, operacionTransferenciaNueva.getMonto());
                comando.setString(2, operacionTransferenciaNueva.getMotivo());
                comando.setDate(3, fechaAhora);
                comando.setLong(4, operacionTransferenciaNueva.getCodigoCuenta());

                int numRegistrosInsertados = comando.executeUpdate();
                logger.log(Level.INFO, "Se agregaron {0} operaciones", numRegistrosInsertados);

                ResultSet idsGenerado = comando.getGeneratedKeys();
                idsGenerado.next();

                long idOperacionGenerado = idsGenerado.getLong(1);

                Operacion operacion = new Operacion(idOperacionGenerado, operacionTransferenciaNueva.getMonto(), operacionTransferenciaNueva.getMotivo(), "Transferencia", Fechas.convertidorLocalDateTime(fechaAhora), operacionTransferenciaNueva.getCodigoCuenta(), operacionTransferenciaNueva.getNumCuentaDestino());

                logger.log(Level.INFO, "Se agregó la operación con ID {0}", idOperacionGenerado);

                // Intentar agregar la transferencia
                agregarTransferencia(idOperacionGenerado, operacionTransferenciaNueva.getNumCuentaDestino());

                // Si llegamos aquí, todo ha tenido éxito, confirmamos los cambios
                conexion.commit();
                conexion.setAutoCommit(true); // Reestablecer la confirmación automática

                return operacion;

            } catch (SQLException ex) {
                // Si hay una excepción, hacemos un rollback para revertir los cambios
                try {
                    if (conexion != null) {
                        conexion.rollback();
                        conexion.setAutoCommit(true); // Reestablecer la confirmación automática
                    }
                } catch (SQLException rollbackEx) {
                    logger.log(Level.SEVERE, "Error al hacer rollback", rollbackEx);
                }

                logger.log(Level.SEVERE, "No se pudo agregar la operación", ex);
                throw new PersistenciaException("No se pudo agregar la operación", ex);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener la conexión", e);
            throw new PersistenciaException("Error al obtener la conexión", e);
        } finally {
            // Asegurarse de cerrar la conexión en caso de excepción
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException closeEx) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexión", closeEx);
                }
            }
        }
    }

    private void agregarTransferencia(long codigoOperacion, long numCuentaDestino) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO Transferencias (codigo, numero_cuenta_destino)
            VALUES (?, ?);
                              """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, codigoOperacion);
            comando.setLong(2, numCuentaDestino);

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} transferencias", numRegistrosInsertados);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la transferencia", ex);
            throw new PersistenciaException("No se pudo agregar la transferencia", ex);
        }
    }

    @Override
    public boolean actualizar(OperacionActualizableDTO operacionActualizable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
