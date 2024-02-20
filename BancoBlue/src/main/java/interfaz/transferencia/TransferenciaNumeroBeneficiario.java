
package interfaz.transferencia;

import interfaz.cuenta.MenuCuenta;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cuenta;
import interfaz.errores.ErrorLlenarInformacion;
import interfaz.errores.ErrorNumCuenta;
import javax.swing.JOptionPane;

/**
 * Pantalla para seleccionar la cuenta destino de una transferencia
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class TransferenciaNumeroBeneficiario extends javax.swing.JFrame {

    final MenuCuenta menuCuenta;
    private final Cuenta cuenta;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
            
    /**
     * Constructor con los datos de la cuenta
     * @param menuCuenta Pantalla a mostrar al cerrarse
     * @param cuenta Cuenta a usar
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public TransferenciaNumeroBeneficiario(MenuCuenta menuCuenta, Cuenta cuenta,ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.cuenta=cuenta;
        this.menuCuenta=menuCuenta;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmpNumeroBeneficiario = new javax.swing.JTextField();
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

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("Realizar transferencia");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(52, 127, 560, 58);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el número de cuenta del beneficiario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(52, 203, 550, 30);

        cmpNumeroBeneficiario.setBackground(new java.awt.Color(17, 20, 44));
        cmpNumeroBeneficiario.setFont(new java.awt.Font("Lucida Sans", 0, 36)); // NOI18N
        cmpNumeroBeneficiario.setForeground(new java.awt.Color(255, 255, 255));
        cmpNumeroBeneficiario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cmpNumeroBeneficiario);
        cmpNumeroBeneficiario.setBounds(120, 260, 417, 50);

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
        btnConfirmar.setBounds(259, 349, 134, 37);

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 1.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(145, 19, 349, 61);

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
        jLabel7.setBounds(0, -5, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.menuCuenta.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * Valida los datos y abre la siguiente pantalla 
     */
    private void confirmar() {

        String textoBenficiario = this.cmpNumeroBeneficiario.getText();
        if (textoBenficiario.isBlank()) {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
            return;
        }

        long numBeneficiario;
        try {
            numBeneficiario = Long.parseLong(textoBenficiario);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lo ingresado debe ser un numero de 16 digitos");
            return;
        }
        
        if (numBeneficiario==cuenta.getNumeroCuenta()) {
            JOptionPane.showMessageDialog(this, "No puedes hacer una transferencia a la misma cuenta");
            return;
        }

        CuentaConsultableUsuarioDTO cuentaConsultableUsuario = new CuentaConsultableUsuarioDTO();
        cuentaConsultableUsuario.setNumeroCuenta(numBeneficiario);
        Cuenta cuentaConsultable = null;
        try {
            cuentaConsultable = cuentasDAO.consultar(cuentaConsultableUsuario);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, "La cuenta que marco esta cancelada, no puede recibir transferencias");
        }

        if (cuentaConsultable != null) {
            TransferenciaConfirmacion registrar = new TransferenciaConfirmacion( menuCuenta,this, cuenta, cuentaConsultable,cuentasDAO, operacionesDAO);
            this.setVisible(false);
            registrar.setVisible(true);
        }else{
           ErrorNumCuenta error=new ErrorNumCuenta();
           error.setVisible(true);
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
    private javax.swing.JTextField cmpNumeroBeneficiario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
