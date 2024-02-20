
package interfaz.transferencia;

import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import interfaz.cuenta.MenuCuenta;
import interfaz.errores.ErrorLlenarInformacion;
import javax.swing.JOptionPane;

/**
 * Pantalla que obtiene el cliente destino de una transferencia y lo muestra
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TransferenciaConfirmacion extends javax.swing.JFrame {

    final TransferenciaNumeroBeneficiario transferenciaNumeroBeneficiario;
    private final Cuenta cuentaOrigen;
    private final Cuenta cuentaDestino;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private String nombreClienteDestino;
    private final MenuCuenta menuCuenta;
            
    /**
     * Constructor que recibe datos y los muestra
     * @param menuCuenta Pantalla a mostrar al cerrarse
     * @param transferenciaNumeroBeneficiario Numero de la cuenta destino
     * @param cuentaOrigen Cuenta origen
     * @param cuentaDestino Cuenta destino
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public TransferenciaConfirmacion(MenuCuenta menuCuenta, TransferenciaNumeroBeneficiario transferenciaNumeroBeneficiario, Cuenta cuentaOrigen, Cuenta cuentaDestino, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.transferenciaNumeroBeneficiario = transferenciaNumeroBeneficiario;
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
        this.operacionesDAO=operacionesDAO;
        this.cuentasDAO=cuentasDAO;
        this.menuCuenta=menuCuenta;
        actualizarDatos();      
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etqNombreBeneficiarioDinamico = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etqNumeroCuentaBeneficiarioDinamico = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmpMotivo = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("Datos del beneficiario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(119, 132, 430, 43);

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del beneficiario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(47, 193, 246, 30);

        etqNombreBeneficiarioDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqNombreBeneficiarioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNombreBeneficiarioDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqNombreBeneficiarioDinamico.setText("Nombre");
        getContentPane().add(etqNombreBeneficiarioDinamico);
        etqNombreBeneficiarioDinamico.setBounds(303, 193, 294, 30);

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número de cuenta:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(47, 235, 191, 30);

        etqNumeroCuentaBeneficiarioDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqNumeroCuentaBeneficiarioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNumeroCuentaBeneficiarioDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqNumeroCuentaBeneficiarioDinamico.setText("Numero de cuenta");
        getContentPane().add(etqNumeroCuentaBeneficiarioDinamico);
        etqNumeroCuentaBeneficiarioDinamico.setBounds(303, 235, 294, 30);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Motivo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(141, 286, 77, 30);

        cmpMotivo.setBackground(new java.awt.Color(17, 20, 44));
        cmpMotivo.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        cmpMotivo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cmpMotivo);
        cmpMotivo.setBounds(230, 283, 281, 36);

        btnConfirmar.setBackground(new java.awt.Color(238, 107, 107));
        btnConfirmar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(264, 350, 140, 37);

        btnVolver.setBackground(new java.awt.Color(238, 107, 107));
        btnVolver.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(6, 6, 97, 37);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(149, 25, 347, 54);

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Número de cuenta");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 86, 140, 23);

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirmación");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(278, 86, 102, 23);

        jLabel8.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingresar monto");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(411, 86, 116, 23);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 6.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.transferenciaNumeroBeneficiario.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * Valida el motivo de la transferencia y abre la siguiente pantalla
     */
    private void confirmar(){
        String motivo=this.cmpMotivo.getText();
        
        if (motivo.isBlank()) {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
            return;
        }
        
        TransferenciaMonto transferenciaMonto=new TransferenciaMonto(menuCuenta,this,nombreClienteDestino, cuentaOrigen, cuentaDestino,motivo,cuentasDAO, operacionesDAO);
        this.setVisible(false);
        transferenciaMonto.setVisible(true);
    }
    
    /**
     * Actualiza la pantalla con los datos de la base de datos
     */
    private void actualizarDatos(){
        CuentaConsultableUsuarioDTO cuentaConsultableUsuario=new CuentaConsultableUsuarioDTO();
        cuentaConsultableUsuario.setNumeroCuenta(cuentaDestino.getNumeroCuenta());
        
        String nombreCliente;
        try {
            nombreCliente=cuentasDAO.consultarCliente(cuentaConsultableUsuario);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
            this.btnConfirmar.setEnabled(false);
            return;
        }
        this.btnConfirmar.setEnabled(true);
        
        this.nombreClienteDestino=nombreCliente;
        this.etqNombreBeneficiarioDinamico.setText(nombreCliente);
        this.etqNumeroCuentaBeneficiarioDinamico.setText(String.valueOf(cuentaDestino.getNumeroCuenta()));
    }
    /**
     * Cierra esta pantalla
     */
    public void cerrar(){
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField cmpMotivo;
    private javax.swing.JLabel etqNombreBeneficiarioDinamico;
    private javax.swing.JLabel etqNumeroCuentaBeneficiarioDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
