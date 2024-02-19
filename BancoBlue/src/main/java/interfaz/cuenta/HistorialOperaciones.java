
package interfaz.cuenta;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.tablas.TablaOperaciones;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Represente el historial de operaciones de una cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class HistorialOperaciones extends javax.swing.JFrame {

    private final MenuCuenta menuCuenta;
    private final Cuenta cuenta;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private List<Operacion> listaOperaciones;
    /**
     * Constructor que usa la cuenta para obtener su historial
     * @param menuCuenta Patanlla que se muestra cuando se cierra esta
     * @param cuenta Cuenta a sacarle el historial
     * @param clientesDAO Opera clientes
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public HistorialOperaciones(MenuCuenta menuCuenta, Cuenta cuenta, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.menuCuenta = menuCuenta;
        this.cuenta=cuenta;
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.radiobtnRetiroSinCuenta.setSelected(true);
        this.radiobtnTransferencia.setSelected(true);
        this.setSize(660, 410);
        this.setLocation(400, 200);
        cmbxAnioHasta.setSelectedIndex(cmbxAnioHasta.getItemCount()-1);
        this.cmbxDiaHasta.setSelectedIndex(cmbxDiaHasta.getItemCount()-1);
        this.cmbxFechaHasta.setSelectedIndex(cmbxFechaHasta.getItemCount()-1);
        actualizarInformacion(); 
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        etqTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radiobtnTransferencia = new javax.swing.JRadioButton();
        radiobtnRetiroSinCuenta = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cmbxDiaHasta = new javax.swing.JComboBox<>();
        cmbxFechaHasta = new javax.swing.JComboBox<>();
        cmbxAnioHasta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        cmbxOperaciones = new javax.swing.JTable();
        btnActualizar = new javax.swing.JToggleButton();
        cmbxDiaDesde = new javax.swing.JComboBox<>();
        cmbxFechaDesde = new javax.swing.JComboBox<>();
        cmbxAnioDesde = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        etqTitulo.setText("Historial de operaciones");

        jLabel2.setText("Filtrar por:");

        jLabel3.setText("Tipo de operación:");

        radiobtnTransferencia.setText("Transferencia");

        radiobtnRetiroSinCuenta.setText("Retiro sin cuenta");

        jLabel4.setText("Fecha:");

        cmbxDiaHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbxFechaHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbxAnioHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

        cmbxOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre del beneficiario", "Tipo de operación", "Estado", "Fecha", "Monto"
            }
        ));
        jScrollPane1.setViewportView(cmbxOperaciones);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        cmbxDiaDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbxFechaDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbxAnioDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

        jLabel1.setText("Desde:");

        jLabel5.setText("Hasta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnVolver))
                .addGap(184, 184, 184)
                .addComponent(etqTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(radiobtnTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radiobtnRetiroSinCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbxDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbxFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbxDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(278, 278, 278))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(etqTitulo))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cmbxDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobtnTransferencia)
                    .addComponent(radiobtnRetiroSinCuenta)
                    .addComponent(cmbxDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.menuCuenta.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarInformacion();
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * Actualiza la tabla
     */
    private void actualizarTabla() {
        if (listaOperaciones != null) {
            TablaOperaciones tablaModel = new TablaOperaciones(listaOperaciones, cuentasDAO, operacionesDAO, clientesDAO);
            cmbxOperaciones.setModel(tablaModel);
        }

    }

    /**
     * Obtiene la informacion del historial de la base de datos
     */
    private void actualizarInformacion(){
        
        String anioStrHasta = (String) this.cmbxAnioHasta.getSelectedItem();
        String diaStrHasta = (String) this.cmbxDiaHasta.getSelectedItem();
        String mesStrHasta = (String) this.cmbxFechaHasta.getSelectedItem();
        
        String anioStrDesde = (String) this.cmbxAnioDesde.getSelectedItem();
        String diaStrDesde = (String) this.cmbxDiaDesde.getSelectedItem();
        String mesStrDesde = (String) this.cmbxFechaDesde.getSelectedItem();
        
        // Convertir los valores a enteros
        int anioHasta = Integer.parseInt(anioStrHasta);
        int diaHasta = Integer.parseInt(diaStrHasta);
        int mesHasta = Integer.parseInt(mesStrHasta);
        
        // Convertir los valores a enteros
        int anioDesde = Integer.parseInt(anioStrDesde);
        int diaDesde = Integer.parseInt(diaStrDesde);
        int mesDesde = Integer.parseInt(mesStrDesde);

        // Obtener la fecha actual
        Calendar calendarHasta = Calendar.getInstance();

        calendarHasta.set(Calendar.YEAR, anioHasta);
        calendarHasta.set(Calendar.MONTH, mesHasta);
        calendarHasta.set(Calendar.DAY_OF_MONTH, diaHasta);
        
        Calendar calendarDesde = Calendar.getInstance();

        calendarDesde.set(Calendar.YEAR, anioDesde);
        calendarDesde.set(Calendar.MONTH, mesDesde);
        calendarDesde.set(Calendar.DAY_OF_MONTH, diaDesde);

        // Crear un objeto Timestamp usando la fecha configurada
        Timestamp timestampHasta = new Timestamp(calendarHasta.getTimeInMillis());
        
        Timestamp timestampDesde = new Timestamp(calendarDesde.getTimeInMillis());
        
        CuentaConsultableDTO cuentaConsultable = new CuentaConsultableDTO();

        cuentaConsultable.setCodigo(cuenta.getCodigo());

        try {
            List<Operacion> listaCuentas = operacionesDAO.consultar(cuentaConsultable);

            listaOperaciones = new ArrayList<>();

            // Filtrar las operaciones según la fecha y el tipo seleccionado
            for (Operacion operacion : listaCuentas) {
                if (operacion.getFechaCreacion().after(timestampDesde) && operacion.getFechaCreacion().before(timestampHasta)) {
                    if (this.radiobtnRetiroSinCuenta.isSelected() && operacion.getTipo().equalsIgnoreCase("retiro sin cuenta")) {
                        listaOperaciones.add(operacion);
                    } else if (this.radiobtnTransferencia.isSelected() && operacion.getTipo().equalsIgnoreCase("transferencia")) {
                        listaOperaciones.add(operacion);
                    }
                }
            }

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
        }
        actualizarTabla();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbxAnioDesde;
    private javax.swing.JComboBox<String> cmbxAnioHasta;
    private javax.swing.JComboBox<String> cmbxDiaDesde;
    private javax.swing.JComboBox<String> cmbxDiaHasta;
    private javax.swing.JComboBox<String> cmbxFechaDesde;
    private javax.swing.JComboBox<String> cmbxFechaHasta;
    private javax.swing.JTable cmbxOperaciones;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiobtnRetiroSinCuenta;
    private javax.swing.JRadioButton radiobtnTransferencia;
    // End of variables declaration//GEN-END:variables
}
