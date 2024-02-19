
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Ingrese el monto total de la transferencia:");

        jLabel2.setText("Saldo disponible:");

        etqSaldoDisponibleDinamico.setText("jLabel3");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etqSaldoDisponibleDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cmpMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etqSaldoDisponibleDinamico))
                .addGap(18, 18, 18)
                .addComponent(cmpMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnConfirmar)
                .addGap(47, 47, 47))
        );

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
            JOptionPane.showMessageDialog(this, "No puede dejar el campo vacio");
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
            JOptionPane.showMessageDialog(this, "No tiene suficiente saldo en la cuenta");
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
        
            TransferenciaRecibo transferenciaRecibo=new TransferenciaRecibo(menuCuenta,this,transferencia,nombreClienteDestino,cuentaOrigen);
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
    // End of variables declaration//GEN-END:variables
}
