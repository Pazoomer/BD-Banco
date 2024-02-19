
package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaSaldoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.Fechas;
import bancoBluePersistencia.herramientas.GeneradorNumeros;
import bancoblueDominio.Cuenta;
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
 * Opera las cuentas con la base de datos
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class CuentasDAO implements ICuentasDAO{
    
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    /**
     * Constructor que recibe la conexion con la base de datos
     * @param conexionBD Conexion con la base de datos
     */
    public CuentasDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Cancela una cuenta, cambiando su estado a cerrada.
     *
     * @param cuentaCerrable Contiene los datos necesarios para cerrar una
     * cuenta.
     * @return true si la cancelación fue exitosa, false en caso contrario.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    @Override
    public boolean cancelar(CuentaCerrableDTO cuentaCerrable) throws PersistenciaException {
        String sentenciaSQLCliente = """
        UPDATE Cuentas SET estado = "cancelada" 
        WHERE num_cuenta = ?
                                       """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comandoCliente = conexion.prepareStatement(sentenciaSQLCliente);) {

            comandoCliente.setLong(1, cuentaCerrable.getNumeroCuenta());

            // Ejecutar actualizaciones
            int filasAfectadasCliente = comandoCliente.executeUpdate();

            // Confirmar o revertir transacción
            if (filasAfectadasCliente > 0) {
                logger.log(Level.INFO, "Se cerro la cuenta");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            // Manejar la excepción y revertir la transacción
            logger.log(Level.SEVERE, "No se puede cerrar la cuenta", ex);
            throw new PersistenciaException("No se pudo cerrar la cuenta", ex);
        }

    }

    /**
     * Consulta la lista de cuentas asociadas a un cliente.
     *
     * @param clienteConsultable Contiene los datos necesarios para consultar
     * las cuentas de un cliente.
     * @return Lista de cuentas asociadas al cliente.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    @Override
    public List<Cuenta> consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT num_cuenta, fecha_apertura, saldo, estado, codigo
        FROM Cuentas
        WHERE id_cliente = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            
            comando.setLong(1, clienteConsultable.getId());
            ResultSet resultados = comando.executeQuery();

            List<Cuenta> listaCuentas = new LinkedList<>();

            while (resultados.next()) {

                long num_cuenta = resultados.getLong("num_cuenta");
                Date fecha_apertura = resultados.getDate("fecha_apertura");
                long saldo = resultados.getLong("saldo");
                String estado = resultados.getString("estado");
                long codigo=resultados.getLong("codigo");

                Cuenta cuenta = new Cuenta(codigo,saldo, Fechas.convertidorLocalDateTime(fecha_apertura), num_cuenta,clienteConsultable.getId(), estado);
                listaCuentas.add(cuenta);

            }
            if (listaCuentas.isEmpty()) {
                logger.log(Level.INFO, "Se consultaron 0 cuentas");
                return null;
            }
            logger.log(Level.INFO, "Se consultaron {0} cuentas", listaCuentas.size());
            return listaCuentas;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuentaNueva Contiene los datos necesarios para crear una nueva
     * cuenta.
     * @return Cuenta creada con la información proporcionada.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNueva) throws PersistenciaException {
        String sentenciaSQL = """
        INSERT INTO cuentas (num_cuenta, saldo, id_cliente, estado)
        VALUES (?, 0.0, ?, 'abierta');
                              """;

        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            long nuevoNumCuenta;

            do {
                nuevoNumCuenta = GeneradorNumeros.generarNumeroAleatorio16Digitos();
                comando.setLong(1, nuevoNumCuenta);
            } while (comprobarExistenciaCuenta(nuevoNumCuenta));  // Comprobar si el número ya existe

            Date fechaAhora = Date.valueOf(LocalDate.now());

            comando.setLong(2, cuentaNueva.getIdCliente());

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} cuentas", numRegistrosInsertados);

            ResultSet idsGenerado = comando.getGeneratedKeys();
            idsGenerado.next();

            long idCuentaGenerado = idsGenerado.getLong(1);

            Cuenta cuenta = new Cuenta(idCuentaGenerado, 0.0, Fechas.convertidorLocalDateTime(fechaAhora), nuevoNumCuenta, cuentaNueva.getIdCliente(), "abierta");

            logger.log(Level.INFO, "Se agregó la cuenta con ID {0}", idCuentaGenerado);
            return cuenta;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo agregar la cuenta", ex);
            throw new PersistenciaException("No se pudo agregar la cuenta", ex);
        }
    }

    /**
     * Comprueba si el numero de cuenta ya existe
     * @param numCuenta Numero de cuenta A comprobar
     * @return Verdadero si la cuenta no existe
     * @throws PersistenciaException cuando ocurre un error en la base de datos
     */
    private boolean comprobarExistenciaCuenta(long numCuenta) throws PersistenciaException {
        String consultaSQL = "SELECT COUNT(*) AS cuenta_existente FROM cuentas WHERE num_cuenta = ?";

        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(consultaSQL)) {
            comando.setLong(1, numCuenta);

            ResultSet resultados = comando.executeQuery();
            resultados.next();

            int cuentaExistente = resultados.getInt("cuenta_existente");
            return cuentaExistente > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede acceder a la base de datos", ex);
            throw new PersistenciaException("No se pudo acceder a la base de datos", ex);
        }

    }

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
    @Override
    public Cuenta consultar(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException, ValidacionDTOException {
        String sentenciaSQL = """
        SELECT codigo, fecha_apertura, saldo, estado, id_cliente
        FROM cuentas
        WHERE num_cuenta=?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

            comando.setLong(1, cuentaConsultableUsuario.getNumeroCuenta());

            ResultSet resultados = comando.executeQuery();
            
            if (resultados.next()) {

                long codigo = resultados.getLong("codigo");
                Date fecha_apertura = resultados.getDate("fecha_apertura");
                long saldo = resultados.getLong("saldo");
                String estado = resultados.getString("estado");
                long id_cliente = resultados.getLong("id_cliente");

                if (estado.equalsIgnoreCase("cancelada")) {
                    throw new ValidacionDTOException("No se pudo consultar la cuenta");
                }

                Cuenta cuenta = new Cuenta(codigo, saldo, Fechas.convertidorLocalDateTime(fecha_apertura), cuentaConsultableUsuario.getNumeroCuenta(), id_cliente, estado);
                logger.log(Level.INFO, "Se consultaron {0} cuentas", 1);
                return cuenta;
            } else {
                logger.log(Level.INFO, "No existe la cuenta", 1);
                return null;
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar la cuenta", ex);
            throw new PersistenciaException("No se pudo consultar la cuenta", ex);
        } catch (ValidacionDTOException ex) {
            logger.log(Level.INFO, "La cuenta fue cancelada");
            throw new ValidacionDTOException("La cuenta fue cancelada");
        }
    }

    /**
     * Consulta el nombre de cliente asociado a una cuenta.
     *
     * @param cuentaConsultableUsuario Contiene los datos necesarios para
     * consultar el nombre del cliente asociado a una cuenta.
     * @return Nombre del cliente asociado a la cuenta.
     * @throws PersistenciaException Cuando ocurre un error en la base de datos.
     */
    @Override
    public String consultarCliente(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT CL.nombre_completo AS nombre_completo
        FROM Cuentas C
        JOIN Clientes CL ON C.id_cliente = CL.id
        WHERE C.num_cuenta = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

            comando.setLong(1, cuentaConsultableUsuario.getNumeroCuenta());

            ResultSet resultados = comando.executeQuery();

            if (resultados.next()) {

                String nombre_completo = resultados.getString("nombre_completo");

                logger.log(Level.INFO, "Se consultaron {0} clientes", 1);
                return nombre_completo;

            } else {
                logger.log(Level.INFO, "No existe el cliente", 1);
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

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
    @Override
    public boolean cambiarMonto(CuentaSaldoDTO cuentaSaldo) throws PersistenciaException, ValidacionDTOException {
        String consultaSQL = """
        SELECT saldo, estado
        FROM Cuentas
        WHERE codigo=?;
                             """;

        String actualizacionSQL = """
        UPDATE Cuentas SET saldo = ?
        WHERE codigo = ?;
                                  """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement consultaCuenta = conexion.prepareStatement(consultaSQL); 
            PreparedStatement actualizacionCuenta = conexion.prepareStatement(actualizacionSQL)) {

            consultaCuenta.setLong(1, cuentaSaldo.getCodigo());

            ResultSet resultadosConsulta = consultaCuenta.executeQuery();

            if (resultadosConsulta.next()) {
                double saldo = resultadosConsulta.getDouble("saldo");
                String estado = resultadosConsulta.getString("estado");

                if (estado.equalsIgnoreCase("cancelada")) {
                    throw new ValidacionDTOException("La cuenta fue cancelada");
                }

                logger.log(Level.INFO, "Se consultaron {0} cuentas", 1);
                

                double saldoNuevo = saldo + cuentaSaldo.getSaldo();

                if (saldoNuevo < 0) {
                    throw new ValidacionDTOException("No hay suficiente dinero en la cuenta");
                }

                actualizacionCuenta.setDouble(1, saldoNuevo);
                actualizacionCuenta.setDouble(2, cuentaSaldo.getCodigo());

                int filasAfectadasCuenta = actualizacionCuenta.executeUpdate();

                if (filasAfectadasCuenta > 0) {
                    logger.log(Level.INFO, "Se actualizó el saldo");
                    return true;
                } else {
                    logger.log(Level.WARNING, "No se actualizó el saldo");
                    return false;
                }

            } else {
                logger.log(Level.INFO, "No existe la cuenta", 1);
                return false;
            }

        } catch (SQLException ex) {
            // Manejar la excepción y revertir la transacción
            logger.log(Level.SEVERE, "No se puede actualizar la cuenta", ex);
            throw new PersistenciaException("No se pudo actualizar la cuenta", ex);
        }
    }

}
