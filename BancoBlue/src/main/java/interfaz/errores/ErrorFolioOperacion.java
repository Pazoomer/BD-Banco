
package interfaz.errores;

/**
 *
 * @author victo
 */
public class ErrorFolioOperacion extends javax.swing.JFrame {

    /**
     * Creates new form ErrorFolioOperacion
     */
    public ErrorFolioOperacion() {
        this.setUndecorated(true);
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("Aviso");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 80, 137, 58);

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("El folio ha caducado o es incorrecto, verífique la información.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 180, 602, 30);

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
        btnConfirmar.setBounds(240, 270, 150, 37);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 9.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -4, 650, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
