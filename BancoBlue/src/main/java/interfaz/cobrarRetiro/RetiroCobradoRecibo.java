
package interfaz.cobrarRetiro;

import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cuenta.CuentaConsultableUsuarioDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaSaldoDTO;
import bancoBluePersistencia.dtos.operacion.OperacionConsultableDTO;
import bancoBluePersistencia.dtos.operacion.OperacionEstadoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoBluePersistencia.herramientas.FormatoPesos;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import ejecutable.Bienvenida;
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
     * @param retiro
     * @param bienvenida
     * @param operacionesDAO
     * @param cuentasDAO
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqFechaHoraDinamico = new javax.swing.JLabel();
        etqMontoDinamico = new javax.swing.JLabel();
        etqNombreClienteDinamico = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        etqNumTarjetClienteDinamico = new javax.swing.JLabel();
        etqMotivoDinamico = new javax.swing.JLabel();
        etqTotalDinamico = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        etqFechaHoraDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqFechaHoraDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqFechaHoraDinamico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqFechaHoraDinamico.setText("Fecha de cobro");
        getContentPane().add(etqFechaHoraDinamico);
        etqFechaHoraDinamico.setBounds(166, 85, 292, 25);

        etqMontoDinamico.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        etqMontoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMontoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMontoDinamico.setText("Monto");
        getContentPane().add(etqMontoDinamico);
        etqMontoDinamico.setBounds(190, 140, 247, 43);

        etqNombreClienteDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqNombreClienteDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNombreClienteDinamico.setText("Nombre del expendedor");
        getContentPane().add(etqNombreClienteDinamico);
        etqNombreClienteDinamico.setBounds(59, 200, 247, 25);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("de");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(26, 200, 40, 25);

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(318, 200, 6, 25);

        etqNumTarjetClienteDinamico.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        etqNumTarjetClienteDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqNumTarjetClienteDinamico.setText("Numero de cuenta");
        getContentPane().add(etqNumTarjetClienteDinamico);
        etqNumTarjetClienteDinamico.setBounds(337, 200, 297, 25);

        etqMotivoDinamico.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        etqMotivoDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqMotivoDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqMotivoDinamico.setText("Motivo");
        getContentPane().add(etqMotivoDinamico);
        etqMotivoDinamico.setBounds(311, 252, 211, 23);

        etqTotalDinamico.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqTotalDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqTotalDinamico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqTotalDinamico.setText("Monto");
        getContentPane().add(etqTotalDinamico);
        etqTotalDinamico.setBounds(331, 293, 191, 23);

        btnTerminar.setBackground(new java.awt.Color(238, 107, 107));
        btnTerminar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnTerminar.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnTerminar);
        btnTerminar.setBounds(250, 350, 124, 37);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 20, 140, 60);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("¡Retiro validado!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 20, 310, 50);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Recibiste");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 120, 80, 17);

        jLabel11.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Motivo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(114, 268, 58, 23);

        jLabel12.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cantidad Total:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(114, 309, 150, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 7.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       bienvenida.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Actualiza los datos de la pantalla
     */
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
        
        String monto=FormatoPesos.convertidorPesos(retiro.getMonto());
        this.etqMontoDinamico.setText(monto);
        this.etqTotalDinamico.setText(monto);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
