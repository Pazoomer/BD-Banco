
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        etqInformacionUsuario.setText("Información del Usuario");

        jLabel2.setText("Nombre completo");

        etqNombreUsuario.setText("Nombre de usuario");

        etqFechaNacimiento.setText("Fecha de nacimiento");

        etqCalle.setText("Calle");

        etqNumExterior.setText("Núm. Exterior");

        etqCP.setText("C.P.");

        etqColonia.setText("Colonia");

        etqMunicipio.setText("Municipio");

        etqEstado.setText("Estado");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCambiar.setText("Actualizar información");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnRecargar.setText("Recargar Informacion");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etqFechaNacimiento)
                        .addGap(0, 545, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etqInformacionUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnRecargar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCambiar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(etqCalle, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etqColonia, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etqCalleDinamico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                            .addComponent(etqColoniaDinamico, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etqFechaNacimientoDinamico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(etqNumExterior)
                                            .addComponent(etqMunicipio)
                                            .addComponent(etqNumExteriorDinamico)
                                            .addComponent(etqMunicipioDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(etqCP)
                                            .addComponent(etqEstado)
                                            .addComponent(etqCPDinamico)
                                            .addComponent(etqEstadoDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(etqNombreCompletoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etqNombreUsuario)
                                            .addComponent(etqNombreUsuarioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqInformacionUsuario)
                    .addComponent(btnVolver))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etqNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombreUsuarioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqNombreCompletoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(etqFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqFechaNacimientoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCalle)
                    .addComponent(etqNumExterior)
                    .addComponent(etqCP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCPDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqNumExteriorDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqCalleDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqColonia)
                    .addComponent(etqMunicipio)
                    .addComponent(etqEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqEstadoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqMunicipioDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqColoniaDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnRecargar))
                .addContainerGap())
        );

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
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
