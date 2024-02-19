
package interfaz.cuenta;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cliente;
import bancoblueDominio.Cuenta;
import interfaz.cliente.MenuPrincipal;
import interfaz.retiro.RetiroMonto;
import interfaz.transferencia.TransferenciaNumeroBeneficiario;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 * Permite operar las opciones de una cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class MenuCuenta extends javax.swing.JFrame {

    private final Cliente cliente;
    private Cuenta cuenta;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final MenuPrincipal menuPrincipal;
    /**
     * Constructor con los datos del cliente y la cuenta
     * @param menuPrincipal Pantalla a mostrar cuando se cierra esta
     * @param cliente Cliente con el que trabaja
     * @param cuenta Cuenta con la que trabaja
     * @param clientesDAO Permite operar con clientes
     * @param cuentasDAO Permite operar con cuentas
     * @param operacionesDAO Permite operar con operaciones
     */
    public MenuCuenta(MenuPrincipal menuPrincipal,Cliente cliente, Cuenta cuenta, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.cliente=cliente;
        this.cuenta=cuenta;
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.menuPrincipal=menuPrincipal;
        actualizarInformacion();
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqNumeroTarjetaDinamico = new javax.swing.JLabel();
        etqFechaApertura = new javax.swing.JLabel();
        etqFechaAperturaDinamico = new javax.swing.JLabel();
        etqSaldo = new javax.swing.JLabel();
        etqSaldoActualDinamico = new javax.swing.JLabel();
        btnTransferir = new javax.swing.JButton();
        btnHistorialOperaciones = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnDesactivarCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        etqNumeroTarjetaDinamico.setText("jLabel1");

        etqFechaApertura.setText("Fecha de apertura:");

        etqFechaAperturaDinamico.setText("jLabel3");

        etqSaldo.setText("Saldo actual:");

        etqSaldoActualDinamico.setText("jLabel5");

        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        btnHistorialOperaciones.setText("Historial de operaciones");
        btnHistorialOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialOperacionesActionPerformed(evt);
            }
        });

        btnRetiroSinCuenta.setText("Retiros sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnDesactivarCuenta.setText("Desactivar cuenta");
        btnDesactivarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de cuenta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRetiroSinCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorialOperaciones))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(etqFechaApertura, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqFechaAperturaDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTransferir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDesactivarCuenta))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(etqSaldo)
                                    .addGap(18, 18, 18)
                                    .addComponent(etqSaldoActualDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(225, 225, 225))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(etqNumeroTarjetaDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(189, 189, 189))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVolver)
                        .addComponent(btnDesactivarCuenta))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etqNumeroTarjetaDinamico)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqFechaApertura)
                    .addComponent(etqFechaAperturaDinamico))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqSaldo)
                    .addComponent(etqSaldoActualDinamico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnTransferir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorialOperaciones)
                    .addComponent(btnRetiroSinCuenta))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.menuPrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnDesactivarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarCuentaActionPerformed
        cancelarCuenta();
    }//GEN-LAST:event_btnDesactivarCuentaActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        transferencia();
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        retiroSinCuenta();
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

    private void btnHistorialOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialOperacionesActionPerformed
        historial();
    }//GEN-LAST:event_btnHistorialOperacionesActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Abre el historial de la cuenta
     */
    private void historial() {
        HistorialOperaciones historialOperaciones = new HistorialOperaciones(this, cuenta, clientesDAO, cuentasDAO, operacionesDAO);
        this.setVisible(false);
        historialOperaciones.setVisible(true);
    }

    /**
     * Inicia un retiro sin cuenta
     */
    private void retiroSinCuenta() {
        RetiroMonto registrar=new RetiroMonto(this,cuenta,  clientesDAO,  cuentasDAO, operacionesDAO);
        this.setVisible(false);
        registrar.setVisible(true);
    }
    
    /**
     * Inicia una transferencia
     */
    private void transferencia(){
        TransferenciaNumeroBeneficiario registrar=new TransferenciaNumeroBeneficiario(this,cliente,cuenta,clientesDAO, cuentasDAO, operacionesDAO);
        this.setVisible(false);
        registrar.setVisible(true);
    }
    
    /**
     * Inicia la opcion de cancelar la cuenta
     */
    private void cancelarCuenta() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de cancelar la cuenta?, esta accion no se puede revertir", "Cancelar cuenta", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {

            if (!(this.cuenta.getSaldo()==0)) {
               JOptionPane.showMessageDialog(this, "Para cancelar la cuenta el saldo debe ser 0"); 
               return;
            }
            CuentaCerrableDTO cuentaCerrable = new CuentaCerrableDTO();

            cuentaCerrable.setNumeroCuenta(this.cuenta.getNumeroCuenta());

            try {
                cuentasDAO.cancelar(cuentaCerrable);
                this.btnDesactivarCuenta.setEnabled(false);
                this.btnRetiroSinCuenta.setEnabled(false);
                this.btnTransferir.setEnabled(false);
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo cancelar la cuenta debido a un error en la base de datos");
            }
        }
    }

    /**
     * Actualiza la información de la cuenta
     */
    private void actualizarInformacion(){
        
        long numCuenta=this.cuenta.getNumeroCuenta();
        
        CuentaConsultableUsuarioDTO CuentaConsultableUsuarioDTO=new CuentaConsultableUsuarioDTO();
        
        CuentaConsultableUsuarioDTO.setNumeroCuenta(numCuenta);
        
            try {
                cuenta=cuentasDAO.consultar(CuentaConsultableUsuarioDTO);
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo consultar la informacion de la cuenta debido a un error en la base de datos");
                return;
            }catch(ValidacionDTOException ej){
                JOptionPane.showMessageDialog(this, "Esta cuenta esta cancelada, no se pueden realizar operaciones");
                this.btnRetiroSinCuenta.setEnabled(false);
                this.btnTransferir.setEnabled(false);
            }
        
        LocalDateTime fechaApertura=cuenta.getFechaApertura();
        double saldo=cuenta.getSaldo();
        
        this.etqFechaAperturaDinamico.setText(fechaApertura.toString());
        this.etqNumeroTarjetaDinamico.setText(String.valueOf(numCuenta));
        this.etqSaldoActualDinamico.setText(FormatoPesos.convertidorPesos(saldo));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesactivarCuenta;
    private javax.swing.JButton btnHistorialOperaciones;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel etqFechaApertura;
    private javax.swing.JLabel etqFechaAperturaDinamico;
    private javax.swing.JLabel etqNumeroTarjetaDinamico;
    private javax.swing.JLabel etqSaldo;
    private javax.swing.JLabel etqSaldoActualDinamico;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
