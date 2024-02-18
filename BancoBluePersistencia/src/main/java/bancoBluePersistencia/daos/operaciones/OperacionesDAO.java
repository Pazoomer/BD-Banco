package bancoBluePersistencia.daos.operaciones;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionActualizableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableRetiroDTO;
import bancoBluePersistencia.dtos.operacion.OperacionEstadoDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.Contraseñas;
import bancoBluePersistencia.herramientas.Fechas;
import bancoBluePersistencia.herramientas.GeneradorNumeros;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t1pas
 */
public class OperacionesDAO implements IOperacionesDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public OperacionesDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Operacion agregarOperacion(OperacionNuevaDTO operacionNueva) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Operaciones (monto, motivo, codigo_cuenta, tipo) VALUES (?, ?, ?, ?)";

        long folio = 0;
        int contrasenia = 0;
        String estado = "ERROR";
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            conexion.setAutoCommit(false);

            // Obtener la fecha y hora actual
            java.util.Date fechaActual = new java.util.Date();

            // Crear un objeto Timestamp usando la fecha actual
            Timestamp fechaAhora = new Timestamp(fechaActual.getTime());

            // Crear una instancia de Calendar y establecer el Timestamp actual
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaAhora);

            // Añadir 10 minutos
            calendar.add(Calendar.MINUTE, 10);

            // Obtener el nuevo Timestamp después de añadir 10 minutos
            Timestamp fechaCaducidad = new Timestamp(calendar.getTimeInMillis());

            comando.setDouble(1, operacionNueva.getMonto());
            comando.setString(2, operacionNueva.getMotivo());
            comando.setLong(3, operacionNueva.getCodigoCuenta());
            comando.setString(4, operacionNueva.getTipo());

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} operaciones", numRegistrosInsertados);

            ResultSet idsGenerado = comando.getGeneratedKeys();
            idsGenerado.next();

            long idOperacionGenerado = idsGenerado.getLong(1);

            if (operacionNueva.getTipo().equalsIgnoreCase("transferencia")) {
                // Intentar agregar la transferencia
                agregarTransferencia(idOperacionGenerado, operacionNueva.getNumCuentaDestino(), conexion);
            } else if (operacionNueva.getTipo().equalsIgnoreCase("retiro sin cuenta")) {
                folio = generarFolio();
                contrasenia = GeneradorNumeros.generarNumeroAleatorio8Digitos();
                estado = "disponible";
                agregarRetiroSinCuenta(idOperacionGenerado, fechaCaducidad, folio, contrasenia,conexion);
            } else {
                logger.log(Level.SEVERE, "El tipo de operación no es válido");
                throw new PersistenciaException("El tipo de operación no es válido");
            }

            agregarCuentaOperacion(idOperacionGenerado, operacionNueva.getCodigoCuenta(),conexion);

            conexion.commit();
            conexion.setAutoCommit(true);

            Operacion operacion = new Operacion(idOperacionGenerado, operacionNueva.getMonto(), operacionNueva.getMotivo(),
                    operacionNueva.getTipo(), fechaAhora,
                    operacionNueva.getCodigoCuenta(), estado, folio, contrasenia, operacionNueva.getNumCuentaDestino());

            return operacion;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la operación", ex);
            throw new PersistenciaException("No se pudo agregar la operación", ex);
        }
    }

    private void agregarTransferencia(long codigoOperacion, long numCuentaDestino, Connection conexion)
            throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Transferencias (codigo, numero_cuenta_destino) VALUES (?, ?)";

        try (PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setLong(1, codigoOperacion);
            comando.setLong(2, numCuentaDestino);

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} transferencias", numRegistrosInsertados);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la transferencia", ex);
            throw new PersistenciaException("No se pudo agregar la transferencia", ex);
        }
    }

    private void agregarRetiroSinCuenta(long codigoOperacion, Timestamp caducidad, long folio, int contrasenia,Connection conexion) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO Retiros_sin_cuenta (codigo, num_folio, contrasenia,sal, estado, fecha_hora_caducidad)
            VALUES (?, ?,?,?,"disponible",?);
                              """;

        try (PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            
            String sal=Contraseñas.generarSal();
                String contraseniaConSal;
                try {
                    contraseniaConSal=Contraseñas.encriptarContraseña(String.valueOf(contrasenia), sal);
                } catch (NoSuchAlgorithmException ex) {
                    throw new PersistenciaException("Sistema desactualizado, actualize su version para seguir", ex);
                }

            comando.setLong(1, codigoOperacion);
            comando.setLong(2, folio);
            comando.setString(3, contraseniaConSal);
            comando.setString(4, sal);
            
            //En la base de datos se le va a aumentar 10 min a la caducidad
            comando.setTimestamp(5, caducidad);

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} Retiros_sin_cuenta", numRegistrosInsertados);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la Retiros_sin_cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la Retiros_sin_cuenta", ex);
        }
    }
    
    private long generarFolio() throws PersistenciaException {
        String consultaSQL = "SELECT COUNT(*) AS folios_existentes FROM Retiros_sin_cuenta";

        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(consultaSQL)) {

            ResultSet resultados = comando.executeQuery();
            resultados.next();

            int cuentaExistente = resultados.getInt("folios_existentes");
            return cuentaExistente+1;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede acceder a la base de datos", ex);
            throw new PersistenciaException("No se pudo acceder a la base de datos", ex);
        }

    }

    private void agregarCuentaOperacion(long codigoOperacion, long codigoCuenta,Connection conexion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Cuenta_Operacion (codigo_cuenta, codigo_operacion) VALUES (?, ?)";

        try (PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

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

            long numero_cuenta_destino=-1;
            String estado="";
            int folio=-1;
            while (resultados.next()) {

                //Operacion
                long codigo = resultados.getLong("codigo_operacion");
                String tipo = resultados.getString("tipo");
                String motivo = resultados.getString("motivo");
                Timestamp fecha_hora_creacion = resultados.getTimestamp("fecha_hora_creacion");
                long monto = resultados.getLong("monto");

                if (tipo.equalsIgnoreCase("Transferencia")) {
                    //Transferencia
                    numero_cuenta_destino = resultados.getLong("numero_cuenta_destino");
                } else if (tipo.equalsIgnoreCase("Retiro sin cuenta")) {
                    //Retiro sin cuenta
                    estado = resultados.getString("estado_retiro");
                    folio = resultados.getInt("num_folio");
                } else {
                    throw new PersistenciaException("Estado de la base de datos incosistente");
                }

                Operacion operacion = new Operacion(codigo,monto, motivo, tipo,fecha_hora_creacion,cuentaConsultable.getCodigo(), estado,folio,numero_cuenta_destino);
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
    public boolean cambiarEstado(OperacionEstadoDTO operacionEstado) throws PersistenciaException {
        String sentenciaSQLCliente = """
        UPDATE Retiros_sin_cuenta SET estado = ? 
        WHERE codigo = ?
                                     """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comandoCliente = conexion.prepareStatement(sentenciaSQLCliente);) {

            comandoCliente.setString(1, operacionEstado.getEstado());
            comandoCliente.setLong(2, operacionEstado.getCodigo());

            // Ejecutar actualizaciones
            int filasAfectadasCliente = comandoCliente.executeUpdate();

            // Confirmar o revertir transacción
            if (filasAfectadasCliente > 0) {
                logger.log(Level.INFO, "Se cambio el estado");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            // Manejar la excepción y revertir la transacción
            logger.log(Level.SEVERE, "No se puede cambiar el estado", ex);
            throw new PersistenciaException("No se pudo cambiar el estado", ex);
        }
    }

    @Override
    public Operacion consultar(OperacionConsultableRetiroDTO operacionConsultableRetiro) throws PersistenciaException, ValidacionDTOException {
       String sentenciaSQL = """
            SELECT o.codigo,
            o.tipo,
            o.motivo,                     
            o.fecha_hora_creacion,                    
            o.monto,                
            o.codigo_cuenta,
            r.contrasenia,
            r.sal,
            r.estado,
            r.fecha_hora_caducidad
            FROM Operaciones o
            JOIN Retiros_sin_cuenta r ON o.codigo = r.codigo
            WHERE num_folio=?;
                              """;
        try (Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, operacionConsultableRetiro.getFolio());

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    
                    String contraseniaGuardada = resultados.getString("contrasenia");
                    String salt = resultados.getString("sal");
                    String estado = resultados.getString("estado");

                    Timestamp fecha_hora_caducidad = resultados.getTimestamp("fecha_hora_caducidad");

                    // Obtener la fecha y hora actuales 
                    Timestamp timestampActual = new Timestamp(System.currentTimeMillis());

                    String tipo = resultados.getString("tipo");

                    try {
                        if (estado.equalsIgnoreCase("cobrada")) {
                            logger.log(Level.INFO, "El retiro ya ha sido cobrada");
                            throw new ValidacionDTOException("El retiro ya ha sido cobrada");
                            
                        }else if (estado.equalsIgnoreCase("vencida")) {
                            logger.log(Level.INFO, "El retiro vencio");
                            throw new ValidacionDTOException("El retiro vencio");
                            
                        }else if (!tipo.equalsIgnoreCase("Retiro sin cuenta")) {
                            logger.log(Level.INFO, "El retiro de esta operacion no es posible");
                            throw new ValidacionDTOException("El retiro de esta operacion no es posible");
                            
                        }else if (!fecha_hora_caducidad.after(timestampActual))  {
                            logger.log(Level.INFO, "El retiro vencio");
                            throw new ValidacionDTOException("El retiro vencio");
                        }
                        if (Contraseñas.verificarContraseña(String.valueOf(operacionConsultableRetiro.getContrasenia()), contraseniaGuardada, salt)) {

                            Long codigo_operacion = resultados.getLong("codigo");
                            String motivo = resultados.getString("motivo");
                            
                            Double monto = resultados.getDouble("monto");
                            Long codigo_cuenta = resultados.getLong("codigo_cuenta");
                            
                            Timestamp fecha_hora_creacion = resultados.getTimestamp("fecha_hora_creacion");
                            
                            Operacion operacion = new Operacion(codigo_operacion, monto, motivo, tipo, fecha_hora_creacion, codigo_cuenta,estado,operacionConsultableRetiro.getFolio(),operacionConsultableRetiro.getContrasenia());

                            logger.log(Level.INFO, "Se consultaron {0} operaciones", 1);
                            return operacion;
                        } else {
                            // Contraseña incorrecta
                            logger.log(Level.INFO, "Folio o contraseña incorrecta");
                            return null;
                        }
                    } catch (NoSuchAlgorithmException ex) {
                        // Manejo de NoSuchAlgorithmException
                        logger.log(Level.SEVERE, "Error al verificar el folio", ex);
                        throw new PersistenciaException("Error al verificar el folio", ex);
                    }
                } else {
                    // Usuario no encontrado
                    logger.log(Level.INFO, "No existe el folio");
                    return null;
                }
            }
        } catch (SQLException ex) {
            // Manejo de SQLException
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

    @Override
    public Cuenta consultarCuenta(OperacionConsultableDTO operacionConsultable) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT C.codigo, C.num_cuenta, C.fecha_apertura, C.saldo, C.estado, C.id_cliente
        FROM Cuentas C
        JOIN Operaciones O ON O.codigo_cuenta = C.codigo
        WHERE O.codigo_cuenta = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

            comando.setLong(1, operacionConsultable.getCodigo());

            ResultSet resultados = comando.executeQuery();

            if (resultados.next()) {

                long codigo = resultados.getLong("codigo");
                long num_cuenta = resultados.getLong("num_cuenta");
                Timestamp fecha_apertura = resultados.getTimestamp("fecha_apertura");
                Double saldo = resultados.getDouble("saldo");
                String estado = resultados.getString("estado");
                long id_cliente = resultados.getLong("id_cliente");

                Cuenta cuenta = new Cuenta(codigo, saldo, Fechas.convertirTimestampALocalDateTime(fecha_apertura), num_cuenta, id_cliente, estado);

                logger.log(Level.INFO, "Se consultaron {0} cuentas", 1);
                return cuenta;

            } else {
                logger.log(Level.INFO, "No existe la cuenta", 1);
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar la cuenta", ex);
            throw new PersistenciaException("No se pudo consultar la cuenta", ex);
        }
    }
}

