
package interfaz.cuenta;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaCerrableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cuenta;
import interfaz.cliente.MenuPrincipal;
import interfaz.retiro.RetiroMonto;
import interfaz.transferencia.TransferenciaNumeroBeneficiario;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Permite operar las opciones de una cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class MenuCuenta extends javax.swing.JFrame {

    private Cuenta cuenta;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final MenuPrincipal menuPrincipal;
    /**
     * Constructor con los datos del cliente y la cuenta
     * @param menuPrincipal Pantalla a mostrar cuando se cierra esta
     * @param cuenta Cuenta con la que trabaja
     * @param clientesDAO Permite operar con clientes
     * @param cuentasDAO Permite operar con cuentas
     * @param operacionesDAO Permite operar con operaciones
     */
    public MenuCuenta(MenuPrincipal menuPrincipal, Cuenta cuenta, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        etqNumeroTarjetaDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        etqNumeroTarjetaDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqNumeroTarjetaDinamico.setText("Numero de cuenta");
        getContentPane().add(etqNumeroTarjetaDinamico);
        etqNumeroTarjetaDinamico.setBounds(130, 20, 398, 43);

        etqFechaApertura.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        etqFechaApertura.setText("Fecha de apertura:");
        getContentPane().add(etqFechaApertura);
        etqFechaApertura.setBounds(170, 130, 172, 22);

        etqFechaAperturaDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        etqFechaAperturaDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqFechaAperturaDinamico.setText("Fecha");
        getContentPane().add(etqFechaAperturaDinamico);
        etqFechaAperturaDinamico.setBounds(360, 120, 170, 30);

        etqSaldo.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        etqSaldo.setForeground(new java.awt.Color(255, 255, 255));
        etqSaldo.setText("Saldo actual:");
        getContentPane().add(etqSaldo);
        etqSaldo.setBounds(140, 200, 153, 30);

        etqSaldoActualDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        etqSaldoActualDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqSaldoActualDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqSaldoActualDinamico.setText("Saldo");
        getContentPane().add(etqSaldoActualDinamico);
        etqSaldoActualDinamico.setBounds(300, 200, 229, 30);

        btnTransferir.setBackground(new java.awt.Color(0, 2, 20));
        btnTransferir.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransferir);
        btnTransferir.setBounds(6, 281, 140, 50);

        btnHistorialOperaciones.setBackground(new java.awt.Color(0, 2, 20));
        btnHistorialOperaciones.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnHistorialOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorialOperaciones.setText("Historial de operaciones");
        btnHistorialOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialOperacionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnHistorialOperaciones);
        btnHistorialOperaciones.setBounds(355, 347, 290, 50);

        btnRetiroSinCuenta.setBackground(new java.awt.Color(0, 2, 20));
        btnRetiroSinCuenta.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnRetiroSinCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiroSinCuenta.setText("Retiros sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetiroSinCuenta);
        btnRetiroSinCuenta.setBounds(6, 347, 220, 50);

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

        btnDesactivarCuenta.setBackground(new java.awt.Color(0, 2, 20));
        btnDesactivarCuenta.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnDesactivarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivarCuenta.setText("Desactivar cuenta");
        btnDesactivarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesactivarCuenta);
        btnDesactivarCuenta.setBounds(414, 280, 230, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tarjeta.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, -20, 470, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 9.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -4, 654, 410);

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
        RetiroMonto registrar=new RetiroMonto(this,cuenta, operacionesDAO);
        this.setVisible(false);
        registrar.setVisible(true);
    }
    
    /**
     * Inicia una transferencia
     */
    private void transferencia(){
        TransferenciaNumeroBeneficiario registrar=new TransferenciaNumeroBeneficiario(this,cuenta,cuentasDAO, operacionesDAO);
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
                this.btnDesactivarCuenta.setEnabled(false);
            }
        
        LocalDateTime fechaApertura=cuenta.getFechaApertura();
        
        LocalDate fechaAperturaSimple = fechaApertura.toLocalDate();
        double saldo=cuenta.getSaldo();
        
        this.etqFechaAperturaDinamico.setText(fechaAperturaSimple.toString());
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
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
