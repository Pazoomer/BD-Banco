
package interfaz.cliente;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cliente;
import interfaz.registro.RegistrarseDatosPersonales;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 * Permite revisar el perfil del cliente y actualizarlo
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public final class PerfilCliente extends javax.swing.JFrame {

    private final MenuPrincipal menuPrincipal;
    private Cliente cliente;
    private final IClientesDAO clientesDAO;
    /**
     * Construcor que coloca los datos del cliente
     * @param menuPrincipal Pantalla a mostrarse alcerrarse
     * @param cliente Cliente a mostrar
     * @param clientesDAO Opera clientes
     */
    public PerfilCliente(MenuPrincipal menuPrincipal, Cliente cliente, IClientesDAO clientesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.menuPrincipal=menuPrincipal;
        this.cliente=cliente;
        this.clientesDAO=clientesDAO;
        actualizarInformacion();
        this.setSize(660, 430);
        this.setLocation(400, 200);
        this.etqCPDinamico.setEnabled(false);
        this.etqCalleDinamico.setEnabled(false);
        this.etqColoniaDinamico.setEnabled(false);
        this.etqEstadoDinamico.setEnabled(false);
        this.etqEstadoDinamico.setEnabled(false);
        this.etqFechaNacimiento.setEnabled(false);
        this.etqMunicipioDinamico.setEnabled(false);
        this.etqNombreCompletoDinamico.setEnabled(false);
        this.etqNombreUsuarioDinamico.setEnabled(false);
        this.etqNumExteriorDinamico.setEnabled(false);
        this.etqFechaNacimientoDinamico.setEnabled(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqInformacionUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etqNombreUsuario = new javax.swing.JLabel();
        etqFechaNacimiento = new javax.swing.JLabel();
        etqCalle = new javax.swing.JLabel();
        etqNumExterior = new javax.swing.JLabel();
        etqCP = new javax.swing.JLabel();
        etqColonia = new javax.swing.JLabel();
        etqMunicipio = new javax.swing.JLabel();
        etqEstado = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnCambiar = new javax.swing.JButton();
        etqNombreUsuarioDinamico = new javax.swing.JTextField();
        etqNombreCompletoDinamico = new javax.swing.JTextField();
        etqCPDinamico = new javax.swing.JTextField();
        etqFechaNacimientoDinamico = new javax.swing.JTextField();
        etqNumExteriorDinamico = new javax.swing.JTextField();
        etqCalleDinamico = new javax.swing.JTextField();
        etqEstadoDinamico = new javax.swing.JTextField();
        etqMunicipioDinamico = new javax.swing.JTextField();
        etqColoniaDinamico = new javax.swing.JTextField();
        btnRecargar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        etqInformacionUsuario.setFont(new java.awt.Font("Lucida Sans", 0, 36)); // NOI18N
        etqInformacionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        etqInformacionUsuario.setText("Información del Usuario");
        getContentPane().add(etqInformacionUsuario);
        etqInformacionUsuario.setBounds(20, 10, 419, 43);

        jLabel2.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 178, 178));
        jLabel2.setText("Nombre ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(6, 67, 91, 32);

        etqNombreUsuario.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqNombreUsuario.setForeground(new java.awt.Color(2, 178, 178));
        etqNombreUsuario.setText("Nombre de usuario");
        getContentPane().add(etqNombreUsuario);
        etqNombreUsuario.setBounds(331, 67, 202, 32);

        etqFechaNacimiento.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqFechaNacimiento.setForeground(new java.awt.Color(2, 178, 178));
        etqFechaNacimiento.setText("Fecha de nacimiento");
        getContentPane().add(etqFechaNacimiento);
        etqFechaNacimiento.setBounds(6, 146, 220, 32);

        etqCalle.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqCalle.setForeground(new java.awt.Color(2, 178, 178));
        etqCalle.setText("Calle");
        getContentPane().add(etqCalle);
        etqCalle.setBounds(6, 217, 54, 32);

        etqNumExterior.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqNumExterior.setForeground(new java.awt.Color(2, 178, 178));
        etqNumExterior.setText("Núm. Exterior");
        getContentPane().add(etqNumExterior);
        etqNumExterior.setBounds(207, 217, 145, 32);

        etqCP.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqCP.setForeground(new java.awt.Color(2, 178, 178));
        etqCP.setText("C.P.");
        getContentPane().add(etqCP);
        etqCP.setBounds(431, 217, 46, 32);

        etqColonia.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqColonia.setForeground(new java.awt.Color(2, 178, 178));
        etqColonia.setText("Colonia");
        getContentPane().add(etqColonia);
        etqColonia.setBounds(6, 288, 81, 32);

        etqMunicipio.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqMunicipio.setForeground(new java.awt.Color(2, 178, 178));
        etqMunicipio.setText("Municipio");
        getContentPane().add(etqMunicipio);
        etqMunicipio.setBounds(207, 288, 102, 32);

        etqEstado.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        etqEstado.setForeground(new java.awt.Color(2, 178, 178));
        etqEstado.setText("Estado");
        getContentPane().add(etqEstado);
        etqEstado.setBounds(431, 288, 74, 32);

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
        btnVolver.setBounds(535, 6, 110, 37);

        btnCambiar.setBackground(new java.awt.Color(238, 107, 107));
        btnCambiar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar.setText("Actualizar información");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiar);
        btnCambiar.setBounds(375, 360, 270, 37);

        etqNombreUsuarioDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqNombreUsuarioDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqNombreUsuarioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqNombreUsuarioDinamico);
        etqNombreUsuarioDinamico.setBounds(331, 98, 275, 30);

        etqNombreCompletoDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqNombreCompletoDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqNombreCompletoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqNombreCompletoDinamico);
        etqNombreCompletoDinamico.setBounds(6, 98, 300, 30);

        etqCPDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqCPDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqCPDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqCPDinamico);
        etqCPDinamico.setBounds(431, 248, 186, 30);

        etqFechaNacimientoDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqFechaNacimientoDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqFechaNacimientoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqFechaNacimientoDinamico);
        etqFechaNacimientoDinamico.setBounds(6, 177, 155, 30);

        etqNumExteriorDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqNumExteriorDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqNumExteriorDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqNumExteriorDinamico);
        etqNumExteriorDinamico.setBounds(207, 248, 206, 30);

        etqCalleDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqCalleDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqCalleDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqCalleDinamico);
        etqCalleDinamico.setBounds(6, 248, 183, 30);

        etqEstadoDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqEstadoDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqEstadoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqEstadoDinamico);
        etqEstadoDinamico.setBounds(431, 319, 186, 30);

        etqMunicipioDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqMunicipioDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqMunicipioDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqMunicipioDinamico);
        etqMunicipioDinamico.setBounds(207, 319, 206, 30);

        etqColoniaDinamico.setBackground(new java.awt.Color(17, 20, 44));
        etqColoniaDinamico.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        etqColoniaDinamico.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(etqColoniaDinamico);
        etqColoniaDinamico.setBounds(6, 319, 183, 30);

        btnRecargar.setBackground(new java.awt.Color(238, 107, 107));
        btnRecargar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnRecargar.setForeground(new java.awt.Color(255, 255, 255));
        btnRecargar.setText("Recargar información");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecargar);
        btnRecargar.setBounds(10, 360, 260, 37);

        jLabel1.setForeground(new java.awt.Color(17, 20, 44));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 3.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       this.menuPrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        cambiarInformacion();
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        actualizarInformacion();
    }//GEN-LAST:event_btnRecargarActionPerformed

    /**
     * Inicia el proceso para actualizar la información del cliente
     */
    public void cambiarInformacion(){
  
        RegistrarseDatosPersonales registrar=new RegistrarseDatosPersonales(null, this,clientesDAO,cliente.getId());
        this.setVisible(false);
        registrar.setVisible(true);
        
        actualizarInformacion();
       
    }
    
    /**
     * Recopila los datos del cliente de la base de datos
     */
    public void actualizarInformacion() {
        
        ClienteConsultableDTO clienteConsultable=new ClienteConsultableDTO();
        
        clienteConsultable.setId(cliente.getId());

        try {
            cliente=clientesDAO.consultar(clienteConsultable);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la informacion debido a un error en la base de datos");
        }
        
        //Domicilio
        String calle=cliente.getCalle();
        String ciudad=cliente.getCiudad();
        int cp=cliente.getCodigoPostal();
        String colonia=cliente.getColonia();
        String estado=cliente.getEstado();
        int numExt=cliente.getNumExterior();

        //Cliente
        Date nacimiento=cliente.getFechaNacimiento();
        String nombreCompleto=cliente.getNombreCompleto();
        String nombreUsuario=cliente.getNombreUsuario();
        
        this.etqCPDinamico.setText(String.valueOf(cp));
        this.etqCalleDinamico.setText(calle);
        this.etqColoniaDinamico.setText(colonia);
        this.etqEstadoDinamico.setText(estado);
        this.etqNumExteriorDinamico.setText(String.valueOf(numExt));
        
        this.etqFechaNacimientoDinamico.setText(nacimiento.toString());
        this.etqMunicipioDinamico.setText(ciudad);
        this.etqNombreCompletoDinamico.setText(nombreCompleto);
        this.etqNombreUsuarioDinamico.setText(nombreUsuario);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel etqCP;
    private javax.swing.JTextField etqCPDinamico;
    private javax.swing.JLabel etqCalle;
    private javax.swing.JTextField etqCalleDinamico;
    private javax.swing.JLabel etqColonia;
    private javax.swing.JTextField etqColoniaDinamico;
    private javax.swing.JLabel etqEstado;
    private javax.swing.JTextField etqEstadoDinamico;
    private javax.swing.JLabel etqFechaNacimiento;
    private javax.swing.JTextField etqFechaNacimientoDinamico;
    private javax.swing.JLabel etqInformacionUsuario;
    private javax.swing.JLabel etqMunicipio;
    private javax.swing.JTextField etqMunicipioDinamico;
    private javax.swing.JTextField etqNombreCompletoDinamico;
    private javax.swing.JLabel etqNombreUsuario;
    private javax.swing.JTextField etqNombreUsuarioDinamico;
    private javax.swing.JLabel etqNumExterior;
    private javax.swing.JTextField etqNumExteriorDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
