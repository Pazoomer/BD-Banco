
package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
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
import java.util.LinkedList;
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

    public Operacion agregarOperacion(OperacionNuevaDTO operacionNueva) throws PersistenciaException {
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

                comando.setLong(1, operacionNueva.getMonto());
                comando.setString(2, operacionNueva.getMotivo());
                comando.setDate(3, fechaAhora);
                comando.setLong(4, operacionNueva.getCodigoCuenta());

                int numRegistrosInsertados = comando.executeUpdate();
                logger.log(Level.INFO, "Se agregaron {0} operaciones", numRegistrosInsertados);

                ResultSet idsGenerado = comando.getGeneratedKeys();
                idsGenerado.next();

                long idOperacionGenerado = idsGenerado.getLong(1);

                Operacion operacion = new Operacion(idOperacionGenerado, operacionNueva.getMonto(), operacionNueva.getMotivo(), "Transferencia", Fechas.convertidorLocalDateTime(fechaAhora), operacionNueva.getCodigoCuenta(), operacionNueva.getNumCuentaDestino());

                logger.log(Level.INFO, "Se agregó la operación con ID {0}", idOperacionGenerado);

                if (operacionNueva.getTipo().equalsIgnoreCase("transferencia")) {
                    // Intentar agregar la transferencia
                    agregarTransferencia(idOperacionGenerado, operacionNueva.getNumCuentaDestino());
                } else if (operacionNueva.getTipo().equalsIgnoreCase("retiro sin cuenta")) {
                    agregarRetiroSinCuenta(idOperacionGenerado, operacionNueva.getFolio(), operacionNueva.getContraseña(),fechaAhora);
                } else {
                    logger.log(Level.SEVERE, "El tipo de operacion no es valido");
                    throw new PersistenciaException("El tipo de operacion no es valido");
                }
                
                agregarCuentaOperacion(idOperacionGenerado,operacionNueva.getCodigoCuenta());

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
                    conexion.setAutoCommit(true);
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
    
    private void agregarRetiroSinCuenta(long codigoOperacion, long folio, int contrasenia, Date caducidad) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO Retiros_sin_cuenta (codigo, num_folio, contrasenia, estado, fecha_hora_caducidad)
            VALUES (?, ?,?,"disponible",?);
                              """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, codigoOperacion);
            comando.setLong(2, folio);
            comando.setInt(3, contrasenia);
            
            //En la base de datos se le va a aumentar 10 min a la caducidad
            comando.setDate(4, caducidad);

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} Retiros_sin_cuenta", numRegistrosInsertados);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la Retiros_sin_cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la Retiros_sin_cuenta", ex);
        }
    }

    private void agregarCuentaOperacion(long codigoOperacion, long codigoCuenta) throws PersistenciaException {
        String sentenciaSQL = """
        INSERT INTO Cuenta_Operacion (codigo_cuenta, codigo_operacion)
        VALUES (?, ?);
                             """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, codigoCuenta);
            comando.setLong(2, codigoOperacion);

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} filas a la tabla Cuenta_Operacion", numRegistrosInsertados);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar a la tabla Cuenta_Operacion", ex);
            throw new PersistenciaException("No se pudo agregar a la tabla Cuenta_Operacion", ex);
        }
    }

    @Override
    public boolean actualizar(OperacionActualizableDTO operacionActualizable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Operacion> consultar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT 
            O.codigo AS codigo_operacion,
            O.tipo,
            O.motivo,
            O.fecha_hora_creacion,
            O.monto,
            T.numero_cuenta_destino,
            R.num_folio,
            R.contrasenia,
            R.estado AS estado_retiro,
            R.fecha_hora_caducidad AS caducidad_retiro
        FROM Operaciones O
        LEFT JOIN Transferencias T ON O.codigo = T.codigo
        LEFT JOIN Retiros_sin_cuenta R ON O.codigo = R.codigo
        WHERE O.codigo_cuenta = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            
            comando.setLong(1, cuentaConsultable.getCodigo());
            ResultSet resultados = comando.executeQuery();

            List<Operacion> listaOperaciones = new LinkedList<>();

            int numero_cuenta_destino=-1;
            String estado="";
            int folio=-1;
            int contrasenia=-1;
            while (resultados.next()) {

                //Operacion
                long codigo = resultados.getLong("codigo");
                String tipo = resultados.getString("tipo");
                String motivo = resultados.getString("motivo");
                Date fecha_hora_creacion = resultados.getDate("fecha_hora_creacion");
                long monto = resultados.getLong("monto");

                if (tipo.equalsIgnoreCase("Transferencia")) {
                    //Transferencia
                    numero_cuenta_destino = resultados.getInt("numero_cuenta_destino");
                } else if (tipo.equalsIgnoreCase("Retiro sin cuenta")) {
                    //Retiro sin cuenta
                    estado = resultados.getString("estado");
                    folio = resultados.getInt("folio");
                    contrasenia = resultados.getInt("contrasenia");
                } else {
                    throw new PersistenciaException("Estado de la base de datos incosistente");
                }

                Operacion operacion = new Operacion(codigo,monto, motivo, tipo,Fechas.convertidorLocalDateTime(fecha_hora_creacion), estado,folio,contrasenia,numero_cuenta_destino);
                listaOperaciones.add(operacion);

            }
            if (listaOperaciones.isEmpty()) {
                logger.log(Level.INFO, "Se consultaron 0 operaciones");
                return null;
            }
            logger.log(Level.INFO, "Se consultaron {0} operaciones", listaOperaciones.size());
            return listaOperaciones;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar la operacion", ex);
            throw new PersistenciaException("No se pudo consultar la operacion", ex);
        }
    }

    @Override
    public boolean cobrar(OperacionConsultableDTO operacionConsultableDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
