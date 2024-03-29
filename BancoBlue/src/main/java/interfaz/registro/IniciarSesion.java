
package interfaz.registro;

import ejecutable.Bienvenida;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteInicioSesionDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;
import interfaz.cliente.MenuPrincipal;
import interfaz.errores.ErrorIniciarSesion;
import interfaz.errores.ErrorLlenarInformacion;
import javax.swing.JOptionPane;

/**
 * Interfaz que permite iniciar sesion al cliente
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class IniciarSesion extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final Bienvenida bienvenida;
    private final IOperacionesDAO operacionesDAO;
    /**
     * Constructor que recibe las conexiones para mandarlas posteriormente
     * @param bienvenida Interfaz de usuario que se muestra al salir de esta volviendo atras
     * @param clientesDAO Maneja las operaciones del cliente
     * @param cuentasDAO Maneja las operaciones de las cuentas
     * @param operacionesDAO Manejaa las operaciones de las operaciones
     */
    public IniciarSesion(Bienvenida bienvenida, IClientesDAO clientesDAO,ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        
        initComponents();
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.bienvenida=bienvenida;
        
        this.setSize(660, 410);
        this.setLocation(400, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EtqNombreUsuario = new javax.swing.JLabel();
        CmpNombreUsuario = new javax.swing.JTextField();
        EtqContrasenia = new javax.swing.JLabel();
        CmpContrasenia = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        EtqNombreUsuario.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqNombreUsuario.setForeground(new java.awt.Color(2, 178, 178));
        EtqNombreUsuario.setText("NOMBRE DE USUARIO");
        getContentPane().add(EtqNombreUsuario);
        EtqNombreUsuario.setBounds(183, 140, 280, 32);

        CmpNombreUsuario.setBackground(new java.awt.Color(17, 20, 44));
        CmpNombreUsuario.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpNombreUsuario);
        CmpNombreUsuario.setBounds(183, 177, 285, 36);

        EtqContrasenia.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqContrasenia.setForeground(new java.awt.Color(2, 178, 178));
        EtqContrasenia.setText("CONTRASEÑA");
        getContentPane().add(EtqContrasenia);
        EtqContrasenia.setBounds(183, 225, 180, 40);

        CmpContrasenia.setBackground(new java.awt.Color(17, 20, 44));
        CmpContrasenia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(CmpContrasenia);
        CmpContrasenia.setBounds(183, 271, 285, 36);

        btnConfirmar.setBackground(new java.awt.Color(238, 107, 107));
        btnConfirmar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Inicia sesión");
        btnConfirmar.setMaximumSize(new java.awt.Dimension(193, 63));
        btnConfirmar.setMinimumSize(new java.awt.Dimension(193, 63));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(250, 350, 160, 40);

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
        btnVolver.setBounds(538, 10, 100, 40);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido de nuevo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(195, 93, 257, 26);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(248, 19, 148, 62);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 1.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-3, -4, 660, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.bienvenida.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Valida y verifica el inicio de sesion del cliente
     */
    private void confirmar(){
       String contrasenia = this.CmpContrasenia.getText();
        String nombreUsuario = this.CmpNombreUsuario.getText();
        
        if (contrasenia != null && !contrasenia.isEmpty() && nombreUsuario != null && !nombreUsuario.isEmpty()) {

            ClienteInicioSesionDTO cliente = new ClienteInicioSesionDTO();
            cliente.setContrasenia(contrasenia);
            cliente.setNombreUsuario(nombreUsuario);

            try {
                Cliente clienteExistente = clientesDAO.consultar(cliente);
                if (clienteExistente != null) {
                    this.CmpContrasenia.setText("");
                    this.CmpNombreUsuario.setText("");
                    MenuPrincipal registrar = new MenuPrincipal(this, clienteExistente, clientesDAO,cuentasDAO,operacionesDAO);
                    this.setVisible(false);
                    registrar.setVisible(true);
                } else {
                    ErrorIniciarSesion error=new ErrorIniciarSesion();
                    error.setVisible(true);
                }
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el socio debido a un error en la base de datos");
            }
            
        } else {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
        } 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CmpContrasenia;
    private javax.swing.JTextField CmpNombreUsuario;
    private javax.swing.JLabel EtqContrasenia;
    private javax.swing.JLabel EtqNombreUsuario;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
