
package bancoBluePersistencia.daos.cuentas;

import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaActualizableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.herramientas.Fechas;
import bancoblueDominio.Cuenta;
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
public class CuentasDAO implements ICuentasDAO{
    
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public CuentasDAO(IConexion conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNuevo) throws PersistenciaException {
        String sentenciaSQL = """
        INSERT INTO cuentas (num_cuenta,fecha_apertura, id_cliente,estado)
        values(?,?,?,?);
                              """;
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); 
                PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            Date fecha_ahora=Date.valueOf(LocalDate.now());
            
            comando.setLong(1, cuentaNuevo.getNumeroCuenta());
            comando.setDate(2, fecha_ahora);
            comando.setInt(3, cuentaNuevo.getIdCliente());
            comando.setString(4, cuentaNuevo.getEstado());

            int numRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} cuentas", numRegistrosInsertados);

            ResultSet idsGenerado = comando.getGeneratedKeys();
            idsGenerado.next();
            
            Cuenta cuenta = new Cuenta(idsGenerado.getLong("id"),0, Fechas.convertidorLocalDateTime(fecha_ahora),cuentaNuevo.getNumeroCuenta(),cuentaNuevo.getIdCliente(),cuentaNuevo.getEstado());
            return cuenta;
            
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se puede guardar la cuenta", ex);
            throw new PersistenciaException("No se pudo guardar la cuenta", ex);
        }
    }

    @Override
    public boolean actualizar(CuentaActualizableDTO cuentaActualizable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancelar(CuentaConsultableDTO cuentaConsultable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta consultar(CuentaConsultableUsuarioDTO cuentaConsultableUsuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> consultar(ClienteConsultableDTO clienteConsultable) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
