
package interfaz.retiro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoblueDominio.Cuenta;
import bancoblueDominio.Operacion;
import interfaz.cuenta.MenuCuenta;
import javax.swing.JOptionPane;

/**
 * Pantalla que coloca el monto a un retiro
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class RetiroMonto extends javax.swing.JFrame {

    MenuCuenta menuCuenta;
    Cuenta cuenta;
    IClientesDAO clientesDAO;
    ICuentasDAO cuentasDAO;
    IOperacionesDAO operacionesDAO;

    /**
     * Constructor que usa los datos de la cuenta para obtener su saldo
     * @param menuCuenta Pantalla a mostrar cuando se cierra esta
     * @param cuenta Cuenta a usar
     * @param clientesDAO Opera clientes
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public RetiroMonto(MenuCuenta menuCuenta, Cuenta cuenta, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
        this.menuCuenta = menuCuenta;
        this.cuenta = cuenta;
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.operacionesDAO = operacionesDAO;
        actualizarInformacion();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        etqSaldoDisponibleDinamico = new javax.swing.JLabel();
        cmpMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmpMotivo = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Retiro sin cuenta");

        jLabel2.setText("Nota: El folio tiene que aplicarse máximo a los 10 minutos de ser creado.");

        jLabel3.setText("Ingrese el monto total del retiro:");

        jLabel4.setText("Saldo disponible:");

        etqSaldoDisponibleDinamico.setText("jLabel5");

        jLabel6.setText("Ingrese el motivo del retiro");

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
                .addGap(0, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmpMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cmpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(etqSaldoDisponibleDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etqSaldoDisponibleDinamico))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(cmpMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(cmpMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnConfirmar)
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.menuCuenta.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Actualiza la informacion de la pantalla
     */
    private void actualizarInformacion(){
        this.etqSaldoDisponibleDinamico.setText(String.valueOf(cuenta.getSaldo()));
    }
    
    private void confirmar(){
       String montoTexto = this.cmpMonto.getText();
        String motivo = this.cmpMotivo.getText();
        
        if (montoTexto.isBlank()) {
            JOptionPane.showMessageDialog(this, "No puede dejar el monto vacio");
            return;
        }

        long monto;
        try {
            monto = Long.parseLong(montoTexto);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un numero");
            return;
        }
        
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de realizar un retiro?, esta accion no se puede revertir", "Confirmacion final", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            
            OperacionNuevaDTO operacionNueva=new OperacionNuevaDTO();
            operacionNueva.setMonto(monto);
            operacionNueva.setMotivo(motivo);
            operacionNueva.setTipo("retiro sin cuenta");
            operacionNueva.setNumCuentaOrigen(this.cuenta.getNumeroCuenta());
            operacionNueva.setCodigoCuenta(cuenta.getCodigo());
            
            Operacion retiro = null;
            try {
                retiro = operacionesDAO.agregarOperacion(operacionNueva);
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos");
            }
            if (retiro != null) {
                RetiroRecibo registrar = new RetiroRecibo(retiro, cuenta, menuCuenta);
                this.setVisible(false);
                registrar.setVisible(true);
            }

        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField cmpMonto;
    private javax.swing.JTextField cmpMotivo;
    private javax.swing.JLabel etqSaldoDisponibleDinamico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
