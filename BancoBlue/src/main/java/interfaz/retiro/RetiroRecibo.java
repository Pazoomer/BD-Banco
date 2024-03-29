
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
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("¡Folio generado!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 20, 310, 50);

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Creado el:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 100, 100, 25);

        etqFechaHoraCreacionDinamico.setFont(new java.awt.Font("Corbel", 0, 20)); // NOI18N
        etqFechaHoraCreacionDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqFechaHoraCreacionDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqFechaHoraCreacionDinamico.setText("Fecha de creacion");
        getContentPane().add(etqFechaHoraCreacionDinamico);
        etqFechaHoraCreacionDinamico.setBounds(110, 100, 220, 25);

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Caduca el:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(330, 100, 100, 25);

        etqFechaHoraCaducidadDinamico.setFont(new java.awt.Font("Corbel", 0, 20)); // NOI18N
        etqFechaHoraCaducidadDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqFechaHoraCaducidadDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqFechaHoraCaducidadDinamico.setText("Fecha de caducacion");
        getContentPane().add(etqFechaHoraCaducidadDinamico);
        etqFechaHoraCaducidadDinamico.setBounds(430, 100, 220, 25);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Retiro con valor de:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 130, 146, 23);

        etqMontoDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        etqMontoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMontoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMontoDinamico.setText("Monto");
        getContentPane().add(etqMontoDinamico);
        etqMontoDinamico.setBounds(230, 150, 170, 50);

        jLabel8.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Folio de operación:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 210, 170, 25);

        etqFolioDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqFolioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqFolioDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqFolioDinamico.setText("Folio");
        getContentPane().add(etqFolioDinamico);
        etqFolioDinamico.setBounds(180, 210, 160, 25);

        jLabel10.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contraseña:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(344, 210, 110, 25);

        etqContraseniaDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqContraseniaDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqContraseniaDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqContraseniaDinamico.setText("Contraseña");
        getContentPane().add(etqContraseniaDinamico);
        etqContraseniaDinamico.setBounds(460, 210, 180, 25);

        jLabel12.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número de cuenta:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(130, 250, 145, 23);

        etqNumCuentaDinamico.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        etqNumCuentaDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNumCuentaDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqNumCuentaDinamico.setText("Numero de cuenta");
        getContentPane().add(etqNumCuentaDinamico);
        etqNumCuentaDinamico.setBounds(320, 250, 200, 23);

        jLabel16.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Motivo:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(130, 280, 60, 23);

        etqMotivoDinamico.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        etqMotivoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMotivoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqMotivoDinamico.setText("Motivo");
        getContentPane().add(etqMotivoDinamico);
        etqMotivoDinamico.setBounds(320, 280, 200, 23);

        jLabel18.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cantidad Total:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(130, 310, 140, 23);

        etqTotalDinamico.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqTotalDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqTotalDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqTotalDinamico.setText("Cantidad total");
        getContentPane().add(etqTotalDinamico);
        etqTotalDinamico.setBounds(380, 310, 140, 23);

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
        btnTerminar.setBounds(250, 347, 130, 40);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 20, 140, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 5.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-3, -4, 660, 410);

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
