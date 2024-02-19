
package interfaz.registro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import javax.swing.JOptionPane;

/**
 * Pantalla para registrar el domicilio del cliente
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class RegistrarseDomicilio extends javax.swing.JFrame {

    ClienteNuevoDTO cliente;
    IClientesDAO clientesDAO;
    RegistrarseDatosPersonales datosPersonales;
    String operacionCliente;
    long id;
    /**
     * Constructor que recibe las operaciones y permite colocar el domicilio
     * @param datosPersonales Pantalla a mostrar cuando se cierra esta
     * @param cliente Cliente construido y mandado
     * @param clientesDAO Permite operar con clientes
     * @param operacionCliente Define el tipo de operacion del cliente
     * @param id Identificador del cliente en caso de ser una actualización
     */
    public RegistrarseDomicilio(RegistrarseDatosPersonales datosPersonales, ClienteNuevoDTO cliente, IClientesDAO clientesDAO, String operacionCliente,long id) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
        this.cliente=cliente;
        this.clientesDAO=clientesDAO;
        this.datosPersonales=datosPersonales;
        this.operacionCliente=operacionCliente;
        this.id=id;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EtqCalle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EtqCP = new javax.swing.JLabel();
        EtqColonia = new javax.swing.JLabel();
        EtqMunicipio = new javax.swing.JLabel();
        EtqEstado = new javax.swing.JLabel();
        CmpCalle = new javax.swing.JTextField();
        CmpNumExt = new javax.swing.JTextField();
        CmpCP = new javax.swing.JTextField();
        CmpColonia = new javax.swing.JTextField();
        CmpMunicipio = new javax.swing.JTextField();
        CmpEstado = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        EtqCalle.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqCalle.setForeground(new java.awt.Color(2, 178, 178));
        EtqCalle.setText("CALLE");
        getContentPane().add(EtqCalle);
        EtqCalle.setBounds(21, 104, 76, 32);

        jLabel2.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 178, 178));
        jLabel2.setText("NÚM. exterior");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 98, 146, 36);

        EtqCP.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqCP.setForeground(new java.awt.Color(2, 178, 178));
        EtqCP.setText("C.P.");
        getContentPane().add(EtqCP);
        EtqCP.setBounds(484, 104, 46, 32);

        EtqColonia.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqColonia.setForeground(new java.awt.Color(2, 178, 178));
        EtqColonia.setText("COLONIA");
        getContentPane().add(EtqColonia);
        EtqColonia.setBounds(15, 232, 106, 32);

        EtqMunicipio.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqMunicipio.setForeground(new java.awt.Color(2, 178, 178));
        EtqMunicipio.setText("MUNICIPIO");
        getContentPane().add(EtqMunicipio);
        EtqMunicipio.setBounds(260, 232, 124, 32);

        EtqEstado.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqEstado.setForeground(new java.awt.Color(2, 178, 178));
        EtqEstado.setText("ESTADO");
        getContentPane().add(EtqEstado);
        EtqEstado.setBounds(453, 232, 98, 32);

        CmpCalle.setBackground(new java.awt.Color(17, 20, 44));
        CmpCalle.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpCalle.setForeground(new java.awt.Color(255, 255, 255));
        CmpCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpCalleActionPerformed(evt);
            }
        });
        getContentPane().add(CmpCalle);
        CmpCalle.setBounds(21, 137, 221, 36);

        CmpNumExt.setBackground(new java.awt.Color(17, 20, 44));
        CmpNumExt.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpNumExt.setForeground(new java.awt.Color(255, 255, 255));
        CmpNumExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpNumExtActionPerformed(evt);
            }
        });
        getContentPane().add(CmpNumExt);
        CmpNumExt.setBounds(260, 137, 143, 36);

        CmpCP.setBackground(new java.awt.Color(17, 20, 44));
        CmpCP.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpCP.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpCP);
        CmpCP.setBounds(484, 137, 136, 36);

        CmpColonia.setBackground(new java.awt.Color(17, 20, 44));
        CmpColonia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpColonia.setForeground(new java.awt.Color(255, 255, 255));
        CmpColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpColoniaActionPerformed(evt);
            }
        });
        getContentPane().add(CmpColonia);
        CmpColonia.setBounds(15, 263, 227, 36);

        CmpMunicipio.setBackground(new java.awt.Color(17, 20, 44));
        CmpMunicipio.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpMunicipio.setForeground(new java.awt.Color(255, 255, 255));
        CmpMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpMunicipioActionPerformed(evt);
            }
        });
        getContentPane().add(CmpMunicipio);
        CmpMunicipio.setBounds(260, 263, 175, 36);

        CmpEstado.setBackground(new java.awt.Color(17, 20, 44));
        CmpEstado.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpEstado.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpEstado);
        CmpEstado.setBounds(453, 263, 167, 36);

        btnSiguiente.setBackground(new java.awt.Color(238, 107, 107));
        btnSiguiente.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setMaximumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente);
        btnSiguiente.setBounds(447, 335, 192, 62);

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
        btnVolver.setBounds(6, 6, 192, 62);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese su domicilio");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 20, 360, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CmpCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpCalleActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        confirmar();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void CmpColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpColoniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpColoniaActionPerformed

    private void CmpMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpMunicipioActionPerformed

    private void CmpNumExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpNumExtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpNumExtActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void confirmar(){
        // Obtener valores de los campos
        String codigoPostalStr = this.CmpCP.getText();
        String calle = this.CmpCalle.getText();
        String colonia = this.CmpColonia.getText();
        String estado = this.CmpEstado.getText();
        String municipio = this.CmpMunicipio.getText();
        String numExtStr = this.CmpNumExt.getText();

        // Comprobar que ningún campo sea null o esté vacío
        if (codigoPostalStr != null && calle != null && colonia != null
                && estado != null && municipio != null && numExtStr != null
                && !codigoPostalStr.isEmpty() && !calle.isEmpty() && !colonia.isEmpty()
                && !estado.isEmpty() && !municipio.isEmpty() && !numExtStr.isEmpty()) {

            int codigoPostal=0;
            int numExt=0;
            try {
                codigoPostal = Integer.parseInt(this.CmpCP.getText());
                numExt = Integer.parseInt(this.CmpNumExt.getText());

                // Verificar que ambos valores son números válidos antes de continuar
                if (codigoPostal < 0 || numExt < 0) {
                    JOptionPane.showMessageDialog(this, "El código postal y el número exterior deben ser números positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Sale del método si hay un error
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos para el código postal y el número exterior.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Configurar los valores en el objeto cliente
            cliente.setCalle(calle);
            cliente.setColonia(colonia);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setEstado(estado);
            cliente.setCiudad(municipio);
            cliente.setNumExterior(numExt);

            // Realizar la acción si todos los campos son válidos
            if (true) {
                RegistrarseUsuario registrar = new RegistrarseUsuario(this,cliente, clientesDAO,operacionCliente,id);
                this.setVisible(false);
                registrar.setVisible(true);
            }
        } else {
            // Mostrar un mensaje de error o realizar alguna otra acción
            // porque algunos campos son null o están vacíos
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CmpCP;
    private javax.swing.JTextField CmpCalle;
    private javax.swing.JTextField CmpColonia;
    private javax.swing.JTextField CmpEstado;
    private javax.swing.JTextField CmpMunicipio;
    private javax.swing.JTextField CmpNumExt;
    private javax.swing.JLabel EtqCP;
    private javax.swing.JLabel EtqCalle;
    private javax.swing.JLabel EtqColonia;
    private javax.swing.JLabel EtqEstado;
    private javax.swing.JLabel EtqMunicipio;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
