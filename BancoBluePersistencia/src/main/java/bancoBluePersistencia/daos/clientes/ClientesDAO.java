
package bancoBluePersistencia.daos.clientes;

import bancoBluePersistencia.conexion.IConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import bancoBluePersistencia.dtos.cliente.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteInicioSesionDTO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;
import java.sql.Date;

/**
 *
 * @author Jorge Zamora 245103
 */
public class ClientesDAO implements IClientesDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public ClientesDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        Connection conexion = null;

        try {
            //Establecer conexion
            conexion = this.conexionBD.obtenerConexion();
            conexion.setAutoCommit(false);

            // Insertar datos del cliente
            String sentenciaClienteSQL = """
            INSERT INTO Clientes (contrasenia, nombre_usuario, fecha_nacimiento, nombres, apellido_paterno, apellido_materno)
            VALUES (?,?,?,?,?,?);
        """;
            //Comando para añadir al cliente
            try (PreparedStatement comandoCliente = conexion.prepareStatement(sentenciaClienteSQL, Statement.RETURN_GENERATED_KEYS)) {
                
                comandoCliente.setString(1, clienteNuevo.getContrasenia());
                comandoCliente.setString(2, clienteNuevo.getNombreUsuario());
                comandoCliente.setDate(3, clienteNuevo.getFechaNacimiento());
                comandoCliente.setString(4, clienteNuevo.getNombre());
                comandoCliente.setString(5, clienteNuevo.getApellidopaterno());
                comandoCliente.setString(6, clienteNuevo.getApellidoMaterno());

                int numRegistrosInsertadosCliente = comandoCliente.executeUpdate();
                logger.log(Level.INFO, "Se agregaron {0} clientes", numRegistrosInsertadosCliente);

                ResultSet idsGeneradoCliente = comandoCliente.getGeneratedKeys();
                idsGeneradoCliente.next();
                long idClienteGenerado = idsGeneradoCliente.getLong(1);

                // Insertar datos del domicilio
                String sentenciaDomicilioSQL = """
                INSERT INTO Domicilios (calle, colonia, num_exterior, codigo_postal, ciudad, estado, id_cliente)
                VALUES (?,?,?,?,?,?,?);
            """;

                try (PreparedStatement comandoDomicilio = conexion.prepareStatement(sentenciaDomicilioSQL)) {
                    comandoDomicilio.setString(1, clienteNuevo.getCalle());
                    comandoDomicilio.setString(2, clienteNuevo.getColonia());
                    comandoDomicilio.setInt(3, clienteNuevo.getNumExterior());
                    comandoDomicilio.setInt(4, clienteNuevo.getCodigoPostal());
                    comandoDomicilio.setString(5, clienteNuevo.getCiudad());
                    comandoDomicilio.setString(6, clienteNuevo.getEstado());
                    comandoDomicilio.setLong(7, idClienteGenerado);

                    int numRegistrosInsertadosDomicilio = comandoDomicilio.executeUpdate();
                    logger.log(Level.INFO, "Se agregaron {0} domicilios", numRegistrosInsertadosDomicilio);
                }

                conexion.commit();
                Cliente cliente = new Cliente(idClienteGenerado, clienteNuevo.getContrasenia(), clienteNuevo.getFechaNacimiento(), clienteNuevo.getNombreUsuario(), clienteNuevo.getNombre(), clienteNuevo.getApellidopaterno(), clienteNuevo.getApellidoMaterno(), clienteNuevo.getCiudad(), clienteNuevo.getCalle(), clienteNuevo.getColonia(), clienteNuevo.getNumExterior(), clienteNuevo.getCodigoPostal(), clienteNuevo.getEstado());
                return cliente;
            }
            //Si algo falla devuelva la base de datos a un estado seguro
        } catch (SQLException ex) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException rollbackEx) {
                    logger.log(Level.SEVERE, "Error al revertir la transacción", rollbackEx);
                }
            }

            logger.log(Level.SEVERE, "No se puede guardar el cliente o el domicilio del cliente", ex);
            throw new PersistenciaException("No se pudo guardar el cliente o el domicilio del cliente", ex);
            
        } finally {
            try {
                if (conexion != null) {
                    conexion.commit();
                    conexion.setAutoCommit(true);
                    conexion.close();
                }
            } catch (SQLException closeEx) {
                logger.log(Level.SEVERE, "Error al cerrar la conexión", closeEx);
            }
        }
    }

    @Override
    public boolean actualizar(ClienteActualizableDTO clienteActualizable) throws PersistenciaException {
        String sentenciaSQLCliente =   """
        UPDATE Clientes SET contrasenia = ?, nombre_usuario = ?, fecha_nacimiento = ?, nombres=?, 
        apellido_paterno=?, apellido_materno=? WHERE id = ?
                                       """;
        String sentenciaSQLDomicilio = """
        UPDATE Domicilios SET  calle=?, colonia=?, num_exterior=?, codigo_postal=?, ciudad=?,
        estado=? WHERE id_cliente=?
                                       """;

        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comandoCliente = conexion.prepareStatement(sentenciaSQLCliente); 
            PreparedStatement comandoDomicilio = conexion.prepareStatement(sentenciaSQLDomicilio);) {
            // Desactivar autocommit
            conexion.setAutoCommit(false);

            // Cliente
            comandoCliente.setString(1, clienteActualizable.getContrasenia());
            comandoCliente.setString(2, clienteActualizable.getNombreUsuario());
            comandoCliente.setDate(3, clienteActualizable.getFechaNacimiento());
            comandoCliente.setString(4, clienteActualizable.getNombre());
            comandoCliente.setString(5, clienteActualizable.getApellidopaterno());
            comandoCliente.setString(6, clienteActualizable.getApellidoMaterno());
            comandoCliente.setLong(7, clienteActualizable.getId());

            // Domicilio
            comandoDomicilio.setString(1, clienteActualizable.getCalle());
            comandoDomicilio.setString(2, clienteActualizable.getColonia());
            comandoDomicilio.setLong(3, clienteActualizable.getNumExterior());
            comandoDomicilio.setLong(4, clienteActualizable.getCodigoPostal());
            comandoDomicilio.setString(5, clienteActualizable.getCiudad());
            comandoDomicilio.setString(6, clienteActualizable.getEstado());
            comandoDomicilio.setLong(7, clienteActualizable.getId());

            // Ejecutar actualizaciones
            int filasAfectadasCliente = comandoCliente.executeUpdate();
            int filasAfectadasDomicilio = comandoDomicilio.executeUpdate();

            // Confirmar o revertir transacción
            if (filasAfectadasCliente > 0 && filasAfectadasDomicilio > 0) {
                conexion.commit();
                logger.log(Level.INFO, "Se actualizó el cliente y el domicilio");
                return true;
            } else {
                conexion.rollback();
                logger.log(Level.WARNING, "No se actualizó ningún cliente ni domicilio");
                return false;
            }
        } catch (SQLException ex) {
            // Manejar la excepción y revertir la transacción
            logger.log(Level.SEVERE, "No se puede actualizar el cliente o el domicilio del cliente", ex);
            throw new PersistenciaException("No se pudo actualizar el cliente o el domicilio del cliente", ex);
        }
    }
    
    @Override
    public Cliente consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT c.id,
        c.contrasenia,
        c.nombre_usuario,
        c.fecha_nacimiento,                
        c.nombres,
        c.apellido_paterno,
        c.apellido_materno,
        d.codigo,
        d.calle,
        d.colonia,
        d.num_exterior,
        d.codigo_postal,
        d.ciudad,
        d.estado
        FROM clientes c
        JOIN Domicilios d ON c.id = d.id_cliente
        WHERE ID=?;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

            comando.setLong(1, clienteConsultable.getId());

            ResultSet resultados = comando.executeQuery();

            if (resultados.next()) {

                int id_cliente = resultados.getInt("id");
                String contrasenia = resultados.getString("contrasenia");
                String nombre_usuario = resultados.getString("nombre_usuario");
                Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");
                String nombres = resultados.getString("nombres");
                String apellido_paterno = resultados.getString("apellido_paterno");
                String apellido_materno = resultados.getString("apellido_materno");

                int codigo_domicilio = resultados.getInt("codigo");
                String calle = resultados.getString("calle");
                String colonia = resultados.getString("colonia");
                int num_exterior = resultados.getInt("num_exterior");
                int codigo_postal = resultados.getInt("codigo_postal");
                String ciudad = resultados.getString("ciudad");
                String estado = resultados.getString("estado");

                Cliente cliente = new Cliente(id_cliente, contrasenia, fecha_nacimiento, nombre_usuario, nombres,
                        apellido_materno, apellido_paterno, codigo_domicilio, ciudad, calle, colonia, num_exterior, codigo_postal, estado);

                logger.log(Level.INFO, "Se consultaron {0} clientes", 1);
                return cliente;

            } else {
                logger.log(Level.INFO, "No existe el cliente", 1);
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        String sentenciaSQL = """
        SELECT c.id,
            c.contrasenia,
            c.nombre_usuario,
            c.fecha_nacimiento,                
            c.nombres,
            c.apellido_paterno,
            c.apellido_materno,
            d.codigo,
            d.calle,
            d.colonia,
            d.num_exterior,
            d.codigo_postal,
            d.ciudad,
            d.estado
        FROM clientes c
        JOIN Domicilios d ON c.id = d.id_cliente;
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            ResultSet resultados = comando.executeQuery();

            List<Cliente> listaClientes = new LinkedList<>();

            while (resultados.next()) {

                int id_cliente = resultados.getInt("id");
                String contrasenia = resultados.getString("contrasenia");
                String nombre_usuario = resultados.getString("nombre_usuario");
                Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");
                String nombres = resultados.getString("nombres");
                String apellido_paterno = resultados.getString("apellido_paterno");
                String apellido_materno = resultados.getString("apellido_materno");

                int codigo_domicilio = resultados.getInt("codigo");
                String calle = resultados.getString("calle");
                String colonia = resultados.getString("colonia");
                int num_exterior = resultados.getInt("num_exterior");
                int codigo_postal = resultados.getInt("codigo_postal");
                String ciudad = resultados.getString("ciudad");
                String estado = resultados.getString("estado");

                Cliente cliente = new Cliente(id_cliente, contrasenia, fecha_nacimiento, nombre_usuario, nombres,
                        apellido_materno, apellido_paterno, codigo_domicilio, ciudad, calle, colonia, num_exterior, codigo_postal, estado);
                listaClientes.add(cliente);
            }
            logger.log(Level.INFO, "Se consultaron {0} clientes", listaClientes.size());
            return listaClientes;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

    @Override
    public Cliente consultar(ClienteInicioSesionDTO clienteInicioSesion) throws PersistenciaException {
       String sentenciaSQL = """
        SELECT c.id,
        c.contrasenia,
        c.nombre_usuario,
        c.fecha_nacimiento,                
        c.nombres,
        c.apellido_paterno,
        c.apellido_materno,
        d.codigo,
        d.calle,
        d.colonia,
        d.num_exterior,
        d.codigo_postal,
        d.ciudad,
        d.estado
        FROM clientes c
        JOIN Domicilios d ON c.id = d.id_cliente
        WHERE contrasenia=? AND nombre_usuario=?;
                              """;
        try (
            Connection conexion = this.conexionBD.obtenerConexion(); 
            PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {

            comando.setString(1, clienteInicioSesion.getContrasenia());
            comando.setString(2, clienteInicioSesion.getNombreUsuario());

            ResultSet resultados = comando.executeQuery();

            if (resultados.next()) {

                int id_cliente = resultados.getInt("id");
                String contrasenia = resultados.getString("contrasenia");
                String nombre_usuario = resultados.getString("nombre_usuario");
                Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");
                String nombres = resultados.getString("nombres");
                String apellido_paterno = resultados.getString("apellido_paterno");
                String apellido_materno = resultados.getString("apellido_materno");

                int codigo_domicilio = resultados.getInt("codigo");
                String calle = resultados.getString("calle");
                String colonia = resultados.getString("colonia");
                int num_exterior = resultados.getInt("num_exterior");
                int codigo_postal = resultados.getInt("codigo_postal");
                String ciudad = resultados.getString("ciudad");
                String estado = resultados.getString("estado");

                Cliente cliente = new Cliente(id_cliente, contrasenia, fecha_nacimiento, nombre_usuario, nombres,
                        apellido_materno, apellido_paterno, codigo_domicilio, ciudad, calle, colonia, num_exterior, codigo_postal, estado);

                logger.log(Level.INFO, "Se consultaron {0} clientes", 1);
                return cliente;

            } else {
                logger.log(Level.INFO, "No existe el cliente", 1);
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }

    @Override
    public boolean validarNombreUsuarios(String nombreConsultable) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT nombre_usuario    
        FROM clientes
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL);) {
            ResultSet resultados = comando.executeQuery();

            List<String> listaNombresUsuario = new LinkedList<>();

            while (resultados.next()) {

                String nombre_usuario = resultados.getString("nombre_usuario");

                listaNombresUsuario.add(nombre_usuario);
            }
            logger.log(Level.INFO, "Se consultaron {0} clientes", listaNombresUsuario.size());

            if (listaNombresUsuario.contains(nombreConsultable)) {
                return false;
            }
            return true;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede consultar el cliente", ex);
            throw new PersistenciaException("No se pudo consultar el cliente", ex);
        }
    }
    
}
