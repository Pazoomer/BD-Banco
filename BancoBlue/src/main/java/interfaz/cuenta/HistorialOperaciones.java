
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
 *
 * @author victo
 */
public class HistorialOperaciones extends javax.swing.JFrame {

    private final MenuCuenta menuCuenta;
    private final Cuenta cuenta;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private List<Operacion> listaOperaciones;
    /**
     * Creates new form HistorialOperaciones
     * @param menuCuenta
     * @param cuenta
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
        actualizarInformacion();
        this.setSize(660, 410);
        this.setLocation(400, 200);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        etqTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radiobtnTransferencia = new javax.swing.JRadioButton();
        radiobtnRetiroSinCuenta = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cmbxDia = new javax.swing.JComboBox<>();
        cmbxFecha = new javax.swing.JComboBox<>();
        cmbxAnio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        cmbxOperaciones = new javax.swing.JTable();
        btnActualizar = new javax.swing.JToggleButton();

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

        cmbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbxFecha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbxAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));

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
                    .addComponent(radiobtnRetiroSinCuenta)
                    .addComponent(jLabel3))
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
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
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobtnTransferencia)
                    .addComponent(radiobtnRetiroSinCuenta)
                    .addComponent(cmbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void actualizarTabla() {
        if (listaOperaciones != null) {
            TablaOperaciones tablaModel = new TablaOperaciones(listaOperaciones, cuentasDAO, operacionesDAO, clientesDAO);
            cmbxOperaciones.setModel(tablaModel);
        }

    }

    private void actualizarInformacion(){
        
        String anioStr = (String) this.cmbxAnio.getSelectedItem();
        String diaStr = (String) this.cmbxDia.getSelectedItem();
        String mesStr = (String) this.cmbxFecha.getSelectedItem();
        
        // Convertir los valores a enteros
        int anio = Integer.parseInt(anioStr);
        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);

        // Obtener la fecha actual
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, anio);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.DAY_OF_MONTH, dia);

        // Crear un objeto Timestamp usando la fecha configurada
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        
        CuentaConsultableDTO cuentaConsultable = new CuentaConsultableDTO();

        cuentaConsultable.setCodigo(cuenta.getCodigo());

        try {
            List<Operacion> listaCuentas = operacionesDAO.consultar(cuentaConsultable);

            listaOperaciones = new ArrayList<>();

            // Filtrar las operaciones según la fecha y el tipo seleccionado
            for (Operacion operacion : listaCuentas) {
                if (operacion.getFechaCreacion().after(timestamp)) {
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
    private javax.swing.JComboBox<String> cmbxAnio;
    private javax.swing.JComboBox<String> cmbxDia;
    private javax.swing.JComboBox<String> cmbxFecha;
    private javax.swing.JTable cmbxOperaciones;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radiobtnRetiroSinCuenta;
    private javax.swing.JRadioButton radiobtnTransferencia;
    // End of variables declaration//GEN-END:variables
}
