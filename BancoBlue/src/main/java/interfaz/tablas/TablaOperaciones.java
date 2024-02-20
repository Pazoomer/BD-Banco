package interfaz.tablas;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa la tabla de operaciones de una cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TablaOperaciones extends AbstractTableModel {

    private final List<Operacion> listaOperaciones;
    private final String[] columnNames = {"Tipo", "Monto", "Fecha/Hora Creación", "Estado", "Nombre del beneficiario"};
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;

    /**
     * Constructor que recibe la lista y constuye la tabla
     * @param listaOperaciones Lista de operaciones
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     * @param clientesDAO Opera clientes
     */
    public TablaOperaciones(List<Operacion> listaOperaciones, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO, IClientesDAO clientesDAO) {
        this.listaOperaciones = listaOperaciones;
        this.cuentasDAO = cuentasDAO;
        this.operacionesDAO = operacionesDAO;
    }

    @Override
    public int getRowCount() {
        return listaOperaciones.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Operacion operacion = listaOperaciones.get(rowIndex);

        return switch (operacion.getTipo().toLowerCase()) {
            case "transferencia" -> getValueForTransferencia(operacion, columnIndex);
            case "retiro sin cuenta" -> getValueForRetiroSinCuenta(operacion, columnIndex);
            default -> null;
        };
    }

    private Object getValueForTransferencia(Operacion operacion, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Transferencia";
            case 1 -> FormatoPesos.convertidorPesos(operacion.getMonto());
            case 2 -> operacion.getFechaCreacion();
            case 3 -> "";
            case 4 -> getValueForCuenta(operacion.getCodigoCuenta());
            default -> null;
        };
    }

    private Object getValueForRetiroSinCuenta(Operacion operacion, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Retiro sin cuenta";
            case 1 -> FormatoPesos.convertidorPesos(operacion.getMonto());
            case 2 -> operacion.getFechaCreacion();
            case 3 -> operacion.getEstado();
            default -> null;
        };
    }

    /**
     * Obtiene el nombre del creador de un retiro
     * @param codigoCuenta Codigo que rastrea al cliente de la cuenta
     * @return Cadena con el nombre del dueño de la cuenta
     */
    private String getValueForCuenta(long codigoCuenta) {
        OperacionConsultableDTO operacionConsultable = new OperacionConsultableDTO();
        operacionConsultable.setCodigo(codigoCuenta);

        try {
            Cuenta cuenta = operacionesDAO.consultarCuenta(operacionConsultable);
            if (cuenta != null) {
                CuentaConsultableUsuarioDTO cuentaConsultableUsuario = new CuentaConsultableUsuarioDTO();
                cuentaConsultableUsuario.setNumeroCuenta(cuenta.getNumeroCuenta());

                return cuentasDAO.consultarCliente(cuentaConsultableUsuario);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(TablaOperaciones.class.getName()).log(Level.SEVERE, "Error al acceder a la base de datos en la tabla", ex);
            return "No encontrado";
        }
        return "Tu recibiste";
    }
}
