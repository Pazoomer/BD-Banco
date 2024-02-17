
package interfaz.transferencia;

import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;

/**
 *
 * @author victo
 */
public class TransferenciaRecibo extends javax.swing.JFrame {

    private final Operacion transferencia;
    private final String nombreClienteDestino;
    private final Cuenta cuentaOrigen;
    private final TransferenciaMonto transferenciaMonto;
    /**
     * Creates new form TransferenciaRecibo
     * @param transferenciaMonto
     * @param transferencia
     * @param nombreClienteDestino
     * @param cuentaOrigen
     */
    public TransferenciaRecibo(TransferenciaMonto transferenciaMonto, Operacion transferencia, String nombreClienteDestino, Cuenta cuentaOrigen) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.transferencia=transferencia;
        this.nombreClienteDestino=nombreClienteDestino;
        this.cuentaOrigen=cuentaOrigen;
        this.transferenciaMonto=transferenciaMonto;
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

        jLabel1 = new javax.swing.JLabel();
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
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("¡Transferencia realizada!");

        etqFechaHoraDinamico.setText("jLabel2");

        jLabel3.setText("Enviaste");

        etqMontoDinamico.setText("jLabel4");

        jLabel5.setText("a");

        etqNombreBeneficiarioDinamico.setText("jLabel6");

        jLabel7.setText("-");

        etqNumTarjetaBeneficiarioDinamico.setText("jLabel8");

        jLabel9.setText("Número de cuenta:");

        jLabel11.setText("Motivo:");

        jLabel12.setText("Cantidad Total:");

        etqNumCuentaDinamico.setText("jLabel2");

        etqMotivoDinamico.setText("jLabel6");

        etqCantidadTotalDinamico.setText("jLabel8");

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etqCantidadTotalDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqNombreBeneficiarioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etqNumTarjetaBeneficiarioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etqMotivoDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(etqNumCuentaDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 141, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(etqMontoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(etqFechaHoraDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnTerminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(etqFechaHoraDinamico)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(etqMontoDinamico)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(etqNombreBeneficiarioDinamico)
                    .addComponent(jLabel7)
                    .addComponent(etqNumTarjetaBeneficiarioDinamico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(etqNumCuentaDinamico))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(etqMotivoDinamico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(etqCantidadTotalDinamico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnTerminar)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.transferenciaMonto.transferenciaConfirmacion.transferenciaNumeroBeneficiario.menuCuenta.setVisible(true);
        this.transferenciaMonto.transferenciaConfirmacion.transferenciaNumeroBeneficiario.dispose();
        this.transferenciaMonto.transferenciaConfirmacion.dispose();
        this.transferenciaMonto.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void actualizarInformacion(){
        this.etqCantidadTotalDinamico.setText(String.valueOf(transferencia.getMonto()));
        this.etqMontoDinamico.setText(String.valueOf(transferencia.getMonto())); 
        this.etqFechaHoraDinamico.setText(transferencia.getFechaCreacion().toString());
        this.etqMotivoDinamico.setText(transferencia.getMotivo());
        this.etqNombreBeneficiarioDinamico.setText(nombreClienteDestino);
        this.etqNumCuentaDinamico.setText(String.valueOf(cuentaOrigen.getNumeroCuenta()));
        this.etqNumTarjetaBeneficiarioDinamico.setText(String.valueOf(transferencia.getNumCuentaDestino()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
