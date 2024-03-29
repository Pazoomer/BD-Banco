
package interfaz.registro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import interfaz.errores.ErrorLlenarInformacion;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        EtqCalle.setBounds(20, 80, 90, 32);

        jLabel2.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 178, 178));
        jLabel2.setText("NÚM. exterior");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 70, 160, 36);

        EtqCP.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqCP.setForeground(new java.awt.Color(2, 178, 178));
        EtqCP.setText("C.P.");
        getContentPane().add(EtqCP);
        EtqCP.setBounds(480, 70, 46, 30);

        EtqColonia.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqColonia.setForeground(new java.awt.Color(2, 178, 178));
        EtqColonia.setText("COLONIA");
        getContentPane().add(EtqColonia);
        EtqColonia.setBounds(20, 170, 106, 32);

        EtqMunicipio.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqMunicipio.setForeground(new java.awt.Color(2, 178, 178));
        EtqMunicipio.setText("MUNICIPIO");
        getContentPane().add(EtqMunicipio);
        EtqMunicipio.setBounds(260, 170, 140, 32);

        EtqEstado.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqEstado.setForeground(new java.awt.Color(2, 178, 178));
        EtqEstado.setText("ESTADO");
        getContentPane().add(EtqEstado);
        EtqEstado.setBounds(450, 170, 110, 32);

        CmpCalle.setBackground(new java.awt.Color(17, 20, 44));
        CmpCalle.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpCalle.setForeground(new java.awt.Color(255, 255, 255));
        CmpCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpCalleActionPerformed(evt);
            }
        });
        getContentPane().add(CmpCalle);
        CmpCalle.setBounds(20, 110, 221, 36);

        CmpNumExt.setBackground(new java.awt.Color(17, 20, 44));
        CmpNumExt.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpNumExt.setForeground(new java.awt.Color(255, 255, 255));
        CmpNumExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpNumExtActionPerformed(evt);
            }
        });
        getContentPane().add(CmpNumExt);
        CmpNumExt.setBounds(260, 110, 143, 36);

        CmpCP.setBackground(new java.awt.Color(17, 20, 44));
        CmpCP.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpCP.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpCP);
        CmpCP.setBounds(480, 110, 136, 36);

        CmpColonia.setBackground(new java.awt.Color(17, 20, 44));
        CmpColonia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpColonia.setForeground(new java.awt.Color(255, 255, 255));
        CmpColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpColoniaActionPerformed(evt);
            }
        });
        getContentPane().add(CmpColonia);
        CmpColonia.setBounds(20, 200, 227, 36);

        CmpMunicipio.setBackground(new java.awt.Color(17, 20, 44));
        CmpMunicipio.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpMunicipio.setForeground(new java.awt.Color(255, 255, 255));
        CmpMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpMunicipioActionPerformed(evt);
            }
        });
        getContentPane().add(CmpMunicipio);
        CmpMunicipio.setBounds(260, 200, 175, 36);

        CmpEstado.setBackground(new java.awt.Color(17, 20, 44));
        CmpEstado.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpEstado.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpEstado);
        CmpEstado.setBounds(450, 200, 167, 36);

        btnSiguiente.setBackground(new java.awt.Color(238, 107, 107));
        btnSiguiente.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Continuar");
        btnSiguiente.setMaximumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente);
        btnSiguiente.setBounds(499, 357, 140, 40);

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
        btnVolver.setBounds(6, 6, 110, 40);

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario y contraseña");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 330, 158, 23);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Domicilio");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 330, 80, 23);

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Datos personales");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 330, 130, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 270, 350, 50);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese su domicilio");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 10, 360, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 2.png"))); // NOI18N
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
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
