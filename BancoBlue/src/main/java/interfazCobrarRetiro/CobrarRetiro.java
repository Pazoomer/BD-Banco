
package interfazCobrarRetiro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableRetiroDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Operacion;
import interfaz.registro.Bienvenida;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class CobrarRetiro extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final Bienvenida bienvenida;

    public CobrarRetiro(IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO, Bienvenida bienvenida) {
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.operacionesDAO = operacionesDAO;
        this.bienvenida = bienvenida;
        this.initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmpFolioOperacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmpContrasenia = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Cobrar Retiro");

        jLabel2.setText("Folio de operación:");

        jLabel3.setText("Contraseña:");

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
                .addContainerGap(289, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(cmpFolioOperacion)
                            .addComponent(jLabel3)
                            .addComponent(cmpContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmpFolioOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmpContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnConfirmar)
                .addGap(52, 52, 52))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
                                                   
            String contraseniaTexto=this.cmpContrasenia.getText();
            String folioTexto=this.cmpFolioOperacion.getText();
            
            if (contraseniaTexto.isBlank()) {
                JOptionPane.showMessageDialog(this, "No puede dejar campos vacios");
            }
            if (folioTexto.isBlank()) {
                JOptionPane.showMessageDialog(this, "No puede dejar campos vacios");
            }
          
        long folio = -1;
        int contrasenia = -1;
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
        Operacion retiro=null;
        System.out.println("c"+contrasenia);
        System.out.println("f"+folio);
        try {

            retiro=operacionesDAO.consultar(operacionConsultableRetiro);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error en la base de datos");
            return;
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            return;
        }
        if (retiro!=null) {
            RetiroCobradoRecibo registrar=new RetiroCobradoRecibo(retiro,bienvenida,operacionesDAO,cuentasDAO);
            this.setVisible(false);
            registrar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "No hay retiro con esos datos");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.bienvenida.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField cmpContrasenia;
    private javax.swing.JTextField cmpFolioOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
