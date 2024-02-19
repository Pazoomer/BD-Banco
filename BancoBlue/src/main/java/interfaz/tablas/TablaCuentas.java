
package interfaz.tablas;

import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cuenta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Representa la tabla de cuentas de un cliente
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TablaCuentas extends AbstractTableModel {

    private final List<Cuenta> listaCuentas;
    private final String[] columnNames = {"Numero de cuenta", "Fecha de apertura", "Saldo actual", "estado"};

    public TablaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
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

    /**
     * Le coloca los valores a la tabla
     * @param rowIndex Fila de la tabla
     * @param columnIndex Columna de la tabla
     * @return Valores de la cuenta
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta cuenta = listaCuentas.get(rowIndex);

       return switch (columnIndex) {
           case 0 -> cuenta.getNumeroCuenta();
           case 1 -> cuenta.getFechaApertura().toLocalDate();
           case 2 -> FormatoPesos.convertidorPesos(cuenta.getSaldo());
           case 3 -> cuenta.getEstado();
           default -> null;
       };
    }
}
 

