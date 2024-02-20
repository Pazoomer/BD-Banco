
package interfaz.transferencia;

import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.cuenta.MenuCuenta;
import interfaz.errores.ErrorLlenarInformacion;
import interfaz.errores.ErrorSaldoInsuficiente;
import javax.swing.JOptionPane;

/**
 * Pantalla que opera el monto de la transferencia
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public final class TransferenciaMonto extends javax.swing.JFrame {

    final TransferenciaConfirmacion transferenciaConfirmacion;
    private Cuenta cuentaOrigen;
    private final Cuenta cuentaDestino;
    private final String motivo;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final String nombreClienteDestino;
    private final MenuCuenta menuCuenta;
        
    /**
     * Constructor que añade el monto a la transferencia
     * @param menuCuenta Pantalla a mostrar al terminar
     * @param transferenciaConfirmacion Pantalla a mostrar al cerrarse
     * @param nombreClienteDestino Nombre del destinatario
     * @param cuentaOrigen Cuenta origen
     * @param cuentaDestino Cuenta destino
     * @param motivo Motivo de la transferencia
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public TransferenciaMonto(MenuCuenta menuCuenta, TransferenciaConfirmacion transferenciaConfirmacion, String nombreClienteDestino, Cuenta cuentaOrigen, Cuenta cuentaDestino, String motivo, ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
         this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.transferenciaConfirmacion=transferenciaConfirmacion;
        this.cuentaDestino=cuentaDestino;
        this.cuentaOrigen=cuentaOrigen;
        this.menuCuenta=menuCuenta;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.motivo=motivo;
        this.nombreClienteDestino=nombreClienteDestino;
        actualizarInformacion();
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etqSaldoDisponibleDinamico = new javax.swing.JLabel();
        cmpMonto = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el monto total de la transferencia:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(68, 151, 499, 30);

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo disponible:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(169, 208, 150, 23);

        etqSaldoDisponibleDinamico.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqSaldoDisponibleDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqSaldoDisponibleDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqSaldoDisponibleDinamico.setText("saldo");
        getContentPane().add(etqSaldoDisponibleDinamico);
        etqSaldoDisponibleDinamico.setBounds(325, 208, 116, 23);

        cmpMonto.setBackground(new java.awt.Color(17, 20, 44));
        cmpMonto.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        cmpMonto.setForeground(new java.awt.Color(255, 255, 255));
        cmpMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cmpMonto);
        cmpMonto.setBounds(186, 243, 251, 55);

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
        btnConfirmar.setBounds(249, 338, 134, 37);

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 3.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(149, 23, 347, 62);

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número de cuenta");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 86, 140, 23);

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmación");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(278, 86, 102, 23);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingresar monto");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(411, 86, 116, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 6.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -10, 650, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.transferenciaConfirmacion.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Actualiza la informacion de la pantalla
     */
    public void actualizarInformacion() {

        CuentaConsultableUsuarioDTO cuentaConsultableUsuario = new CuentaConsultableUsuarioDTO();
        cuentaConsultableUsuario.setNumeroCuenta(this.cuentaOrigen.getNumeroCuenta());
        try {
            cuentaOrigen=cuentasDAO.consultar(cuentaConsultableUsuario);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
            this.btnConfirmar.setEnabled(false);
            return;
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, "La cuenta ha sido cancelada");
            this.btnConfirmar.setEnabled(false);
            return;
        }
        this.btnConfirmar.setEnabled(true);
        this.etqSaldoDisponibleDinamico.setText(String.valueOf(cuentaOrigen.getSaldo())); 
        
    }
    
    /**
     * Valida el monto y lo coloca en la transferencia, despues abre l siguiente pantalla
     */
    public void confirmar(){
        String montoTexto=this.cmpMonto.getText();
        
        if (montoTexto.isBlank()) {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
            return;
        }

        long monto;
        try {
            monto = Long.parseLong(montoTexto);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lo ingresado debe ser un numero");
            return;
        }
        
        if (monto<=0) {
           JOptionPane.showMessageDialog(this, "Lo ingresado no puede ser negativo ni 0");
            return; 
        }
        
        if (monto>cuentaOrigen.getSaldo()) {
           ErrorSaldoInsuficiente error=new ErrorSaldoInsuficiente();
           error.setVisible(true);
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de realizar la transferencia?, esta accion no se puede revertir", "Confirmacion final", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            
            OperacionNuevaDTO operacionNueva=new OperacionNuevaDTO();
            operacionNueva.setCodigoCuenta(this.cuentaOrigen.getCodigo());
            operacionNueva.setMonto(monto);
            operacionNueva.setMotivo(motivo);
            operacionNueva.setNumCuentaDestino(this.cuentaDestino.getNumeroCuenta());
            operacionNueva.setNumCuentaOrigen(this.cuentaOrigen.getNumeroCuenta());
            operacionNueva.setTipo("transferencia");
            
            Operacion transferencia;
            try {
                transferencia=operacionesDAO.agregarOperacion(operacionNueva);
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
                return;
            }
        
            TransferenciaRecibo transferenciaRecibo=new TransferenciaRecibo(menuCuenta,transferencia,nombreClienteDestino,cuentaOrigen);
            this.setVisible(false);
            transferenciaRecibo.setVisible(true);
        }
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
    private javax.swing.JTextField cmpMonto;
    private javax.swing.JLabel etqSaldoDisponibleDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
