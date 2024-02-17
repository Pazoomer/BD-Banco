
package interfaz.tablas;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoblueDominio.Cuenta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author t1pas
 */
public class TablaCuentas extends AbstractTableModel{
   private final List<Cuenta> listaCuentas;
    private final String[] columnNames = {"Numero de cuenta", "Fecha de apertura", "Saldo actual","estado"};
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final IClientesDAO clientesDAO;
    
    public TablaCuentas(List<Cuenta> listaCuentas, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO, IClientesDAO clientesDAO) {
        this.listaCuentas = listaCuentas;
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
    }

    @Override
    public int getRowCount() {
        return listaCuentas.size();
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
        Cuenta cuenta = listaCuentas.get(rowIndex);

            switch (columnIndex) {
                case 0:
                return cuenta.getNumeroCuenta();
            case 1:
                return cuenta.getFechaApertura().toLocalDate();
            case 2:
                return cuenta.getSaldo();
            case 3:
                return cuenta.getEstado();
            default:
                return null;
        }
    }
}
 

