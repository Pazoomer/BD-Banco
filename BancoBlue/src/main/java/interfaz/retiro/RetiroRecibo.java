
package interfaz.retiro;

import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.cuenta.MenuCuenta;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Representa el recibo de un retiro sin cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public final class RetiroRecibo extends javax.swing.JFrame {
    Operacion retiro;
    Cuenta cuenta;
    MenuCuenta menuCuenta;

    /**
     * Crea la pantalla con los datos del retiro y la cuenta
     * @param retiro Retiro a mostrar
     * @param cuenta Cuenta a mostrar
     * @param menuCuenta Pantalla a la que vuelve al cerrarse
     */
    public RetiroRecibo(Operacion retiro,Cuenta cuenta,MenuCuenta menuCuenta) {
        this.setUndecorated(true);
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
        this.retiro = retiro;
        this.cuenta=cuenta;
        this.menuCuenta=menuCuenta;
        actualizarInformacion();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etqFechaHoraCreacionDinamico = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etqFechaHoraCaducidadDinamico = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        etqMontoDinamico = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        etqFolioDinamico = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        etqContraseniaDinamico = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        etqNumCuentaDinamico = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        etqMotivoDinamico = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        etqTotalDinamico = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("¡Folia generado!");

        jLabel2.setText("Creado el:");

        etqFechaHoraCreacionDinamico.setText("jLabel3");

        jLabel4.setText("Caduca el:");

        etqFechaHoraCaducidadDinamico.setText("jLabel5");

        jLabel6.setText("Retiro con valor de:");

        etqMontoDinamico.setText("jLabel7");

        jLabel8.setText("Folio de operación:");

        etqFolioDinamico.setText("jLabel9");

        jLabel10.setText("Contraseña;");

        etqContraseniaDinamico.setText("jLabel11");

        jLabel12.setText("Número de cuenta:");

        etqNumCuentaDinamico.setText("jLabel13");

        jLabel16.setText("Motivo:");

        etqMotivoDinamico.setText("jLabel17");

        jLabel18.setText("Cantidad Total:");

        etqTotalDinamico.setText("jLabel19");

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etqFolioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqContraseniaDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                .addComponent(etqTotalDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etqMotivoDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etqNumCuentaDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(144, 144, 144))))
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btnTerminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etqMontoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(279, 279, 279))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqFechaHoraCreacionDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(etqFechaHoraCaducidadDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(238, 238, 238))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etqFechaHoraCreacionDinamico)
                    .addComponent(jLabel4)
                    .addComponent(etqFechaHoraCaducidadDinamico))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(etqMontoDinamico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(etqFolioDinamico)
                    .addComponent(jLabel10)
                    .addComponent(etqContraseniaDinamico))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(etqNumCuentaDinamico))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(etqMotivoDinamico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(etqTotalDinamico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnTerminar)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       menuCuenta.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Actualiza la informacion de la pantalla
     */
    public void actualizarInformacion() {
        this.etqContraseniaDinamico.setText(String.valueOf(retiro.getContrasenia()));
        this.etqFechaHoraCreacionDinamico.setText(retiro.getFechaCreacion().toString());
        
        // Crear una instancia de Calendar y establecer el Timestamp actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(retiro.getFechaCreacion());

        // Añadir 10 minutos
        calendar.add(Calendar.MINUTE, 10);

        // Obtener el nuevo Timestamp después de añadir 10 minutos
        Timestamp nuevoTimestamp = new Timestamp(calendar.getTimeInMillis());
        
        this.etqFechaHoraCaducidadDinamico.setText(nuevoTimestamp.toString());
        
        this.etqFolioDinamico.setText(String.valueOf(retiro.getFolio()));
        this.etqMontoDinamico.setText(String.valueOf(retiro.getMonto()));
        this.etqTotalDinamico.setText(String.valueOf(retiro.getMonto()));
        this.etqMotivoDinamico.setText(retiro.getMotivo());
        this.etqNumCuentaDinamico.setText(String.valueOf(cuenta.getNumeroCuenta()));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel etqContraseniaDinamico;
    private javax.swing.JLabel etqFechaHoraCaducidadDinamico;
    private javax.swing.JLabel etqFechaHoraCreacionDinamico;
    private javax.swing.JLabel etqFolioDinamico;
    private javax.swing.JLabel etqMontoDinamico;
    private javax.swing.JLabel etqMotivoDinamico;
    private javax.swing.JLabel etqNumCuentaDinamico;
    private javax.swing.JLabel etqTotalDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
