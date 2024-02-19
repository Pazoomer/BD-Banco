
package interfazCobrarRetiro;

import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaSaldoDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionEstadoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.registro.Bienvenida;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class RetiroCobradoRecibo extends javax.swing.JFrame {

    Operacion retiro;
    Bienvenida bienvenida;
    IOperacionesDAO operacionesDAO;
    ICuentasDAO cuentasDAO;
    /**
     * Creates new form RetiroCobradoRecibo
     */
    public RetiroCobradoRecibo(Operacion retiro,Bienvenida bienvenida,IOperacionesDAO operacionesDAO,ICuentasDAO cuentasDAO) {
        this.setUndecorated(true);
        initComponents();
        this.retiro=retiro;
        this.bienvenida=bienvenida;
        this.operacionesDAO=operacionesDAO;
        this.cuentasDAO=cuentasDAO;
        actualizarInformacion();
        this.setLocation(400, 200);
        this.setSize(660, 410);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitulo = new javax.swing.JLabel();
        etqFechaHoraDinamico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etqMontoDinamico = new javax.swing.JLabel();
        etqNombreClienteDinamico = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        etqNumTarjetClienteDinamico = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        etqMotivoDinamico = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        etqTotalDinamico = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labTitulo.setText("¡Retiro validado!");

        etqFechaHoraDinamico.setText("jLabel2");

        jLabel3.setText("Recibiste");

        etqMontoDinamico.setText("jLabel4");

        etqNombreClienteDinamico.setText("jLabel5");

        jLabel6.setText("de");

        jLabel7.setText("-");

        etqNumTarjetClienteDinamico.setText("jLabel8");

        jLabel11.setText("Motivo:");

        etqMotivoDinamico.setText("jLabel12");

        jLabel13.setText("Cantidad Total:");

        etqTotalDinamico.setText("jLabel14");

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqMotivoDinamico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etqTotalDinamico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etqNombreClienteDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(etqNumTarjetClienteDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labTitulo)
                            .addComponent(etqFechaHoraDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etqMontoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTerminar)
                        .addGap(276, 276, 276))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(labTitulo)
                .addGap(18, 18, 18)
                .addComponent(etqFechaHoraDinamico)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(etqMontoDinamico)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombreClienteDinamico)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(etqNumTarjetClienteDinamico))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(etqMotivoDinamico))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(etqTotalDinamico))
                .addGap(36, 36, 36)
                .addComponent(btnTerminar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       bienvenida.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void actualizarInformacion() {
        

        OperacionConsultableDTO operacionConsultable = new OperacionConsultableDTO();
        operacionConsultable.setCodigo(retiro.getCodigoCuenta());

        Cuenta cuenta;
        String cliente;
        try {
            cuenta = operacionesDAO.consultarCuenta(operacionConsultable);
            this.etqNumTarjetClienteDinamico.setText(String.valueOf(cuenta.getNumeroCuenta()));

            CuentaConsultableUsuarioDTO cuentaConsultableUsuario = new CuentaConsultableUsuarioDTO();
            cuentaConsultableUsuario.setNumeroCuenta(cuenta.getNumeroCuenta());

            cliente = cuentasDAO.consultarCliente(cuentaConsultableUsuario);
            
            CuentaSaldoDTO cuentaSaldo = new CuentaSaldoDTO();
            cuentaSaldo.setCodigo(cuenta.getCodigo());
            cuentaSaldo.setSaldo(retiro.getMonto() * -1);

            cuentasDAO.cambiarMonto(cuentaSaldo);
            
            OperacionEstadoDTO operacionEstado=new OperacionEstadoDTO();
            operacionEstado.setEstado("cobrada");
            operacionEstado.setCodigo(retiro.getCodigo());
            
            operacionesDAO.cambiarEstado(operacionEstado);

            this.etqNombreClienteDinamico.setText(cliente);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos al consultar la cuenta del registro");
            this.dispose();
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(this, ex);
            this.dispose();
        }
        this.etqFechaHoraDinamico.setText(retiro.getFechaCreacion().toString());
        this.etqMontoDinamico.setText(String.valueOf(retiro.getMonto()));
        this.etqTotalDinamico.setText(String.valueOf(retiro.getMonto()));
        this.etqMotivoDinamico.setText(retiro.getMotivo());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel etqFechaHoraDinamico;
    private javax.swing.JLabel etqMontoDinamico;
    private javax.swing.JLabel etqMotivoDinamico;
    private javax.swing.JLabel etqNombreClienteDinamico;
    private javax.swing.JLabel etqNumTarjetClienteDinamico;
    private javax.swing.JLabel etqTotalDinamico;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labTitulo;
    // End of variables declaration//GEN-END:variables
}
