
package interfaz.cobrarRetiro;

import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableRetiroDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Operacion;
import ejecutable.Bienvenida;
import interfaz.errores.ErrorFolioOperacion;
import interfaz.errores.ErrorLlenarInformacion;
import javax.swing.JOptionPane;

/**
 * Permite cobrar el retiro sin cuenta
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class CobrarRetiro extends javax.swing.JFrame {

    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final Bienvenida bienvenida;

    public CobrarRetiro(ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO, Bienvenida bienvenida) {
        this.setUndecorated(true);
        this.cuentasDAO = cuentasDAO;
        this.operacionesDAO = operacionesDAO;
        this.bienvenida = bienvenida;
        this.initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmpFolioOperacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmpContrasenia = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cobrar retiro");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 90, 180, 30);

        jLabel2.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 178, 178));
        jLabel2.setText("Folio de operación");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 130, 194, 42);

        cmpFolioOperacion.setBackground(new java.awt.Color(17, 20, 44));
        cmpFolioOperacion.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        cmpFolioOperacion.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cmpFolioOperacion);
        cmpFolioOperacion.setBounds(180, 180, 287, 36);

        jLabel3.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 178, 178));
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 230, 122, 37);

        cmpContrasenia.setBackground(new java.awt.Color(17, 20, 44));
        cmpContrasenia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        cmpContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cmpContrasenia);
        cmpContrasenia.setBounds(180, 270, 287, 36);

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
        btnConfirmar.setBounds(260, 340, 134, 40);

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
        btnVolver.setBounds(6, 12, 97, 37);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(248, 19, 148, 62);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 7.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        siguiente();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.bienvenida.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void siguiente() {
        String contraseniaTexto = this.cmpContrasenia.getText();
        String folioTexto = this.cmpFolioOperacion.getText();

        if (contraseniaTexto.isBlank()) {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
        }
        if (folioTexto.isBlank()) {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
        }

        long folio;
        int contrasenia;
        try {
            folio = Long.parseLong(folioTexto);
            contrasenia = Integer.parseInt(contraseniaTexto);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lo ingresado deben ser numeros");
            return;
        }
        OperacionConsultableRetiroDTO operacionConsultableRetiro = new OperacionConsultableRetiroDTO();
        operacionConsultableRetiro.setContrasenia(contrasenia);
        operacionConsultableRetiro.setFolio(folio);
        Operacion retiro;
        try {

            retiro = operacionesDAO.consultar(operacionConsultableRetiro);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error en la base de datos");
            return;
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            return;
        }
        if (retiro != null) {
            RetiroCobradoRecibo registrar = new RetiroCobradoRecibo(retiro, bienvenida, operacionesDAO, cuentasDAO);
            this.setVisible(false);
            registrar.setVisible(true);
        } else {
            ErrorFolioOperacion error = new ErrorFolioOperacion();
            error.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField cmpContrasenia;
    private javax.swing.JTextField cmpFolioOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
