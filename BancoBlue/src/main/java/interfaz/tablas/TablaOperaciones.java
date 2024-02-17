package interfaz.tablas;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TablaOperaciones extends AbstractTableModel {
    private final List<Operacion> listaOperaciones;
    private final String[] columnNames = {"Tipo", "Monto", "Motivo", "Fecha/Hora Creación", "Estado","Nombre del beneficiario"};
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final IClientesDAO clientesDAO;
    
    public TablaOperaciones(List<Operacion> listaOperaciones, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO, IClientesDAO clientesDAO) {
        this.listaOperaciones = listaOperaciones;
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
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

        if (operacion.getTipo().equalsIgnoreCase("Transferencia")) {
            switch (columnIndex) {
                case 0:
                    return "Transferencia";
                case 1:
                    return operacion.getMonto();
                case 2:
                    return operacion.getMotivo();
                case 3:
                    return operacion.getFechaCreacion();
                case 5:
                    OperacionConsultableDTO operacionConsultable=new OperacionConsultableDTO();
                    operacionConsultable.setCodigo(operacion.getCodigo());
                    String nombre="No encontrado";
                {
                    try {
                        Cuenta cuenta=operacionesDAO.consultarCuenta(operacionConsultable);
                        
                        CuentaConsultableUsuarioDTO cuentaConsultableUsuario=new CuentaConsultableUsuarioDTO();
                        cuentaConsultableUsuario.setNumeroCuenta(cuenta.getNumeroCuenta());
                        
                        nombre=cuentasDAO.consultarCliente(cuentaConsultableUsuario);
                    } catch (PersistenciaException ex) {
                        Logger.getLogger(TablaOperaciones.class.getName()).log(Level.SEVERE, "Error al acceder a la base de datos en la tabla", ex);
                    }
                    return nombre;
                }
                default:
                    return null; // Si hay más columnas, ajusta según tu estructura de datos
            }
        } else if (operacion.getTipo().equalsIgnoreCase("Retiro sin cuenta")) {
            switch (columnIndex) {
                case 0:
                    return "Retiro sin cuenta";
                case 1:
                    return operacion.getMonto();
                case 2:
                    return operacion.getMotivo();
                case 3:
                    return operacion.getFechaCreacion();
                case 4:
                    return operacion.getEstado();
                default:
                    return null; // Si hay más columnas, ajusta según tu estructura de datos
            }
        }

        return null;
    }
}
