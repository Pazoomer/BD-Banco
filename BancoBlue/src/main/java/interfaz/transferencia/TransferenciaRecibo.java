
package interfaz.transferencia;

import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.cuenta.MenuCuenta;

/**
 * Pantalla de cobrante de transferencia
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TransferenciaRecibo extends javax.swing.JFrame {

    private final Operacion transferencia;
    private final String nombreClienteDestino;
    private final Cuenta cuentaOrigen;
    private final MenuCuenta menuCuenta;

    /**
     * Constructor del recibo con los datos de la transferencia
     * @param menuCuenta Pantalla a mostrar al cerrarse
     * @param transferencia Transeferencia de donde saca los datos
     * @param nombreClienteDestino Calculada segun el numero de cuenta destino
     * @param cuentaOrigen Cuenta que realiza la transferencia
     */
    public TransferenciaRecibo(MenuCuenta menuCuenta, Operacion transferencia, String nombreClienteDestino, Cuenta cuentaOrigen) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.transferencia=transferencia;
        this.nombreClienteDestino=nombreClienteDestino;
        this.cuentaOrigen=cuentaOrigen;
        this.menuCuenta=menuCuenta;
        actualizarInformacion();
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqFechaHoraDinamico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etqMontoDinamico = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etqNombreBeneficiarioDinamico = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        etqNumTarjetaBeneficiarioDinamico = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        etqNumCuentaDinamico = new javax.swing.JLabel();
        etqMotivoDinamico = new javax.swing.JLabel();
        etqCantidadTotalDinamico = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        etqFechaHoraDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqFechaHoraDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqFechaHoraDinamico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqFechaHoraDinamico.setText("Fecha actual");
        getContentPane().add(etqFechaHoraDinamico);
        etqFechaHoraDinamico.setBounds(192, 87, 258, 25);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enviaste");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(293, 118, 80, 17);

        etqMontoDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        etqMontoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMontoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMontoDinamico.setText("monto");
        getContentPane().add(etqMontoDinamico);
        etqMontoDinamico.setBounds(206, 141, 226, 43);

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("a");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(15, 190, 10, 25);

        etqNombreBeneficiarioDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqNombreBeneficiarioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNombreBeneficiarioDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqNombreBeneficiarioDinamico.setText("Nombre del dueño");
        getContentPane().add(etqNombreBeneficiarioDinamico);
        etqNombreBeneficiarioDinamico.setBounds(37, 190, 269, 25);

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(318, 190, 6, 25);

        etqNumTarjetaBeneficiarioDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqNumTarjetaBeneficiarioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNumTarjetaBeneficiarioDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqNumTarjetaBeneficiarioDinamico.setText("Numero de la cuenta destino");
        getContentPane().add(etqNumTarjetaBeneficiarioDinamico);
        etqNumTarjetaBeneficiarioDinamico.setBounds(337, 190, 302, 25);

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Número de cuenta:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(114, 227, 145, 23);

        jLabel11.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Motivo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(114, 268, 58, 23);

        jLabel12.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cantidad Total:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(114, 309, 140, 23);

        etqNumCuentaDinamico.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        etqNumCuentaDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNumCuentaDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqNumCuentaDinamico.setText("numero de cuenta origen");
        getContentPane().add(etqNumCuentaDinamico);
        etqNumCuentaDinamico.setBounds(265, 227, 260, 23);

        etqMotivoDinamico.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        etqMotivoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMotivoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqMotivoDinamico.setText("motivo");
        getContentPane().add(etqMotivoDinamico);
        etqMotivoDinamico.setBounds(293, 268, 232, 23);

        etqCantidadTotalDinamico.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqCantidadTotalDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqCantidadTotalDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqCantidadTotalDinamico.setText("monto");
        getContentPane().add(etqCantidadTotalDinamico);
        etqCantidadTotalDinamico.setBounds(322, 309, 203, 23);

        btnTerminar.setBackground(new java.awt.Color(238, 107, 107));
        btnTerminar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnTerminar.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnTerminar);
        btnTerminar.setBounds(256, 350, 124, 37);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 20, 140, 60);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("¡Transferencia realizada!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 20, 470, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 5.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -5, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cerrar();
    }//GEN-LAST:event_formWindowClosed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    /**
     * Actualiza los datos de la pantalla
     */
    private void actualizarInformacion(){
        String montoPesos=FormatoPesos.convertidorPesos(transferencia.getMonto());
        this.etqCantidadTotalDinamico.setText(montoPesos);
        this.etqMontoDinamico.setText(montoPesos); 
        this.etqFechaHoraDinamico.setText(transferencia.getFechaCreacion().toString());
        this.etqMotivoDinamico.setText(transferencia.getMotivo());
        this.etqNombreBeneficiarioDinamico.setText(nombreClienteDestino);
        this.etqNumCuentaDinamico.setText(String.valueOf(cuentaOrigen.getNumeroCuenta()));
        this.etqNumTarjetaBeneficiarioDinamico.setText(String.valueOf(transferencia.getNumCuentaDestino()));
    }

    /**
     * Abre el menuCuenta
     */
    public void cerrar() {
        menuCuenta.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel etqCantidadTotalDinamico;
    private javax.swing.JLabel etqFechaHoraDinamico;
    private javax.swing.JLabel etqMontoDinamico;
    private javax.swing.JLabel etqMotivoDinamico;
    private javax.swing.JLabel etqNombreBeneficiarioDinamico;
    private javax.swing.JLabel etqNumCuentaDinamico;
    private javax.swing.JLabel etqNumTarjetaBeneficiarioDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
