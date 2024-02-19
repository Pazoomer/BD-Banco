
package interfaz.registro;

import bancoBluePersistencia.conexion.Conexion;
import bancoBluePersistencia.conexion.IConexion;
import bancoBluePersistencia.daos.clientes.ClientesDAO;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.CuentasDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.daos.operaciones.OperacionesDAO;
import interfazCobrarRetiro.CobrarRetiro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La primera interfaz que ve el usuario
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class Bienvenida extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    private final IConexion conexion;
    /**
     * Inicia la conexion con la base de datos
     */
    public Bienvenida() {
        this.setUndecorated(true);
        initComponents();
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setSize(660, 410);
        String cadenaConexion = "jdbc:mysql://localhost/bancobd";
        String usuario = "root";
        String contrasenia = "1234a";
        //1234a Contraseña de la base de datos en mi computadora
        //Itson Contrasseña en el Itson
        conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        clientesDAO = new ClientesDAO(conexion);
        cuentasDAO = new CuentasDAO(conexion);
        operacionesDAO=new OperacionesDAO(conexion);
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarSesion = new javax.swing.JButton();
        btnCobrarRetiro = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        btnIniciarSesion.setBackground(new java.awt.Color(238, 107, 107));
        btnIniciarSesion.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setMaximumSize(new java.awt.Dimension(193, 63));
        btnIniciarSesion.setMinimumSize(new java.awt.Dimension(193, 63));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion);
        btnIniciarSesion.setBounds(113, 310, 170, 40);

        btnCobrarRetiro.setBackground(new java.awt.Color(238, 107, 107));
        btnCobrarRetiro.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnCobrarRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrarRetiro.setText("Cobrar retiro");
        btnCobrarRetiro.setMaximumSize(new java.awt.Dimension(193, 63));
        btnCobrarRetiro.setMinimumSize(new java.awt.Dimension(193, 63));
        btnCobrarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarRetiroActionPerformed(evt);
            }
        });
        getContentPane().add(btnCobrarRetiro);
        btnCobrarRetiro.setBounds(473, 10, 170, 40);

        btnRegistrarse.setBackground(new java.awt.Color(238, 107, 107));
        btnRegistrarse.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setText("Regístrate");
        btnRegistrarse.setMaximumSize(new java.awt.Dimension(193, 63));
        btnRegistrarse.setMinimumSize(new java.awt.Dimension(193, 63));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse);
        btnRegistrarse.setBounds(370, 310, 140, 40);

        btnCerrar.setBackground(new java.awt.Color(238, 107, 107));
        btnCerrar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(10, 10, 110, 40);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 178, 178));
        jLabel3.setText("Hola!");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 150, 130, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 60, 140, 80);

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bienvenido");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 230, 180, 40);

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("¿Nuevo aquí?");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 290, 120, 20);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ó");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 330, 20, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -4, 660, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarRetiroActionPerformed
       cobrarRetiro();
    }//GEN-LAST:event_btnCobrarRetiroActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        registrarse();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cerrar();
    }//GEN-LAST:event_formWindowClosed

    /**
     * Abre una nueva ventana para cobrar retiro
     */
    private void cobrarRetiro(){
        CobrarRetiro registrar=new CobrarRetiro(clientesDAO, cuentasDAO, operacionesDAO, this);
       this.setVisible(false);
       registrar.setVisible(true);
    }
    
    /**
     * Abre una nueva ventana para registrarse
     */
    private void registrarse(){
        RegistrarseDatosPersonales registrar=new RegistrarseDatosPersonales(this,null,clientesDAO,0);
        this.setVisible(false);
        registrar.setVisible(true);
    }
    
    /**
     * Abre una nueva vetana para iniciar sesion
     */
    private void iniciarSesion(){
       IniciarSesion registrar=new IniciarSesion(this,clientesDAO,cuentasDAO,operacionesDAO);
        this.setVisible(false);
        registrar.setVisible(true); 
    }
    /**
     * Se asegura de cerrar la conexion cuando se cierra
     */
    private void cerrar(){
       if (conexion!=null) {
            try {
                conexion.obtenerConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(Bienvenida.class.getName()).log(Level.SEVERE, "No se pudo cerrar la conexion", ex);
            }
        } 
       System.exit(0); 
    }
    /**
     * Da inicio a la interfaz de las pantallas
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCobrarRetiro;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
