
package interfaz.registro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteActualizableDTO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import javax.swing.JOptionPane;

/**
 * Pantalla para registrar el nombre de usuario y contraseña del cliente
 * Clase documentada
 *
 * @author Jorge Zamora y Victoria Vega
 */
public class RegistrarseUsuario extends javax.swing.JFrame {

    private final ClienteNuevoDTO cliente;
    private final IClientesDAO clientesDAO;
    private final RegistrarseDomicilio domicilio;
    private final String operacionCliente;
    private final long id;
    /**
     * Constructor para registrar al usuario que crea al cliente con su nombre de usuario y contraseña
     * @param domicilio
     * @param cliente
     * @param clientesDAO
     * @param operacionCliente
     * @param id
     */
    public RegistrarseUsuario(RegistrarseDomicilio domicilio, ClienteNuevoDTO cliente, IClientesDAO clientesDAO, String operacionCliente,long id) {
        this.setUndecorated(true);
        this.setVisible(true);
        
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
        this.cliente=cliente;
        this.clientesDAO=clientesDAO;
        this.domicilio=domicilio;
        this.operacionCliente = operacionCliente;
        this.id = id;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        EtqNombreUsuario = new javax.swing.JLabel();
        CmpNombreUsuario = new javax.swing.JTextField();
        EtqContrasenia = new javax.swing.JLabel();
        CmpContrasenia = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        btnGuardar.setBackground(new java.awt.Color(238, 107, 107));
        btnGuardar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(193, 63));
        btnGuardar.setMinimumSize(new java.awt.Dimension(193, 63));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(513, 353, 130, 40);

        EtqNombreUsuario.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqNombreUsuario.setForeground(new java.awt.Color(2, 178, 178));
        EtqNombreUsuario.setText("NOMBRE DE USUARIO");
        getContentPane().add(EtqNombreUsuario);
        EtqNombreUsuario.setBounds(60, 80, 300, 30);

        CmpNombreUsuario.setBackground(new java.awt.Color(17, 20, 44));
        CmpNombreUsuario.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpNombreUsuario);
        CmpNombreUsuario.setBounds(60, 110, 320, 40);

        EtqContrasenia.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqContrasenia.setForeground(new java.awt.Color(2, 178, 178));
        EtqContrasenia.setText("CONTRASEÑA");
        getContentPane().add(EtqContrasenia);
        EtqContrasenia.setBounds(60, 170, 260, 30);

        CmpContrasenia.setBackground(new java.awt.Color(17, 20, 44));
        CmpContrasenia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpContrasenia);
        CmpContrasenia.setBounds(60, 200, 320, 40);

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
        btnVolver.setBounds(10, 10, 110, 37);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario y contraseña");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 320, 160, 23);

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Domicilio");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(200, 320, 80, 20);

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Datos personales");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 320, 130, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 3.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 260, 350, 50);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la información");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 10, 400, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, -4, 660, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.domicilio.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Valida los campos, revisa en la base de datos la existencia del usuario y finalmente crea el cliente nuevo
     */
    private void confirmar(){
        String contrasenia = this.CmpContrasenia.getText();
        String nombreUsuario = this.CmpNombreUsuario.getText();

        if (contrasenia != null && !contrasenia.isEmpty() && nombreUsuario != null && !nombreUsuario.isEmpty()) {
            cliente.setNombreUsuario(nombreUsuario);
            cliente.setContrasenia(contrasenia);
            try {
                if (clientesDAO.validarNombreUsuarios(nombreUsuario)) {

                } else {
                    JOptionPane.showMessageDialog(this, "Nombre de usuario en uso");
                    return;
                }

            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el socio debido a un error en la base de datos");
            }
            try {
                if (operacionCliente.equalsIgnoreCase("agregar")) {
                    clientesDAO.agregar(cliente);
                    JOptionPane.showMessageDialog(this, "Se agrego el socio");

                    if (this.domicilio != null) {
                        this.domicilio.setVisible(false);
                        if (domicilio.datosPersonales != null) {
                            this.domicilio.datosPersonales.setVisible(false);
                        }
                        if (domicilio.datosPersonales.bienvenida != null) {
                            this.domicilio.datosPersonales.bienvenida.setVisible(true);
                        }

                    }
                } else if (operacionCliente.equalsIgnoreCase("actualizar")) {
                    ClienteActualizableDTO clienteActualizable = new ClienteActualizableDTO();

                    clienteActualizable.setApellidoMaterno(cliente.getApellidoMaterno());
                    clienteActualizable.setApellidopaterno(cliente.getApellidopaterno());
                    clienteActualizable.setCalle(cliente.getCalle());
                    clienteActualizable.setCiudad(cliente.getCiudad());
                    clienteActualizable.setCodigoPostal(cliente.getCodigoPostal());
                    clienteActualizable.setColonia(cliente.getColonia());
                    clienteActualizable.setContrasenia(cliente.getContrasenia());
                    clienteActualizable.setEstado(cliente.getEstado());
                    clienteActualizable.setFechaNacimiento(cliente.getFechaNacimiento());
                    clienteActualizable.setNombre(cliente.getNombre());
                    clienteActualizable.setNombreUsuario(cliente.getNombreUsuario());
                    clienteActualizable.setNumExterior(cliente.getNumExterior());
                    clienteActualizable.setId(id);

                    clientesDAO.actualizar(clienteActualizable);
                    JOptionPane.showMessageDialog(this, "Se actualizo el socio");

                    if (this.domicilio != null) {
                        this.domicilio.setVisible(false);
                        if (domicilio.datosPersonales != null) {
                            this.domicilio.datosPersonales.setVisible(false);
                        }
                        if (domicilio.datosPersonales.perfilCliente != null) {
                            this.domicilio.datosPersonales.perfilCliente.setVisible(true);
                        }

                    }
                }

                this.dispose();
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo modificar el cliente debido a un error en la base de datos");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CmpContrasenia;
    private javax.swing.JTextField CmpNombreUsuario;
    private javax.swing.JLabel EtqContrasenia;
    private javax.swing.JLabel EtqNombreUsuario;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
