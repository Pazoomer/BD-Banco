
package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.Fechas;
import bancoBluePersistencia.herramientas.GeneradorNumeros;
import bancoblueDominio.Cliente;
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
 *
 * @author t1pas
 */
public class CuentasDAO implements ICuentasDAO{
    
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public CuentasDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }

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

    @Override
    public String consultarCliente(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException {
       String sentenciaSQL = """
        SELECT CL.nombre_completo AS nombre_completo
        FROM Cuentas C
        JOIN Clientes CL ON C.id_cliente = CL.id
        WHERE C.num_cuenta = ?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

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
    
    

}
