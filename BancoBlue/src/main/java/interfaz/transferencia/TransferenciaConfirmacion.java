
package interfaz.transferencia;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;
import bancoblueDominio.Cuenta;
import interfaz.cuenta.MenuCuenta;
import javax.swing.JOptionPane;

/**
 * Pantalla que obtiene el cliente destino de una transferencia y lo muestra
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TransferenciaConfirmacion extends javax.swing.JFrame {

    final TransferenciaNumeroBeneficiario transferenciaNumeroBeneficiario;
    private final Cliente cliente;
    private final Cuenta cuentaOrigen;
    private final Cuenta cuentaDestino;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private String nombreClienteDestino;
    private final MenuCuenta menuCuenta;
            
    /**
     * Constructor que recibe datos y los muestra
     * @param menuCuenta Pantalla a mostrar al cerrarse
     * @param transferenciaNumeroBeneficiario Numero de la cuenta destino
     * @param cliente Cliente origen
     * @param cuentaOrigen Cuenta origen
     * @param cuentaDestino Cuenta destino
     * @param clientesDAO Opera clientes
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public TransferenciaConfirmacion(MenuCuenta menuCuenta, TransferenciaNumeroBeneficiario transferenciaNumeroBeneficiario, Cliente cliente, Cuenta cuentaOrigen, Cuenta cuentaDestino, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.transferenciaNumeroBeneficiario = transferenciaNumeroBeneficiario;
        this.cliente = cliente;
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
        this.operacionesDAO=operacionesDAO;
        this.clientesDAO=clientesDAO;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Datos del beneficiario");

        jLabel2.setText("Nombre del beneficiario:");

        etqNombreBeneficiarioDinamico.setText("jLabel3");

        jLabel4.setText("Número de cuenta:");

        etqNumeroCuentaBeneficiarioDinamico.setText("jLabel5");

        jLabel6.setText("Motivo:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmpMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etqNombreBeneficiarioDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(etqNumeroCuentaBeneficiarioDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etqNombreBeneficiarioDinamico))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etqNumeroCuentaBeneficiarioDinamico))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(56, 56, 56))
        );

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
            JOptionPane.showMessageDialog(this, "No puede dejar vacio el motivo");
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
