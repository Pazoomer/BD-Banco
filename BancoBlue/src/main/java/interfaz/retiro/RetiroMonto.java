
package interfaz.retiro;

import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.operacion.OperacionNuevaDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.herramientas.FormatoPesos;
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
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 178, 178));
        jLabel1.setText("Retiro sin cuenta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 50, 422, 58);

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nota: El folio tiene que aplicarse máximo a los 10 minutos de ser creado.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 120, 539, 23);

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese el monto total del retiro:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(126, 163, 400, 30);

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Saldo disponible:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(201, 205, 140, 23);

        etqSaldoDisponibleDinamico.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqSaldoDisponibleDinamico.setForeground(new java.awt.Color(255, 255, 255));
        etqSaldoDisponibleDinamico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etqSaldoDisponibleDinamico.setText("Saldo");
        getContentPane().add(etqSaldoDisponibleDinamico);
        etqSaldoDisponibleDinamico.setBounds(347, 205, 154, 23);

        cmpMonto.setBackground(new java.awt.Color(17, 20, 44));
        cmpMonto.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        cmpMonto.setForeground(new java.awt.Color(255, 255, 255));
        cmpMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(cmpMonto);
        cmpMonto.setBounds(208, 234, 227, 46);

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Motivo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(134, 306, 68, 22);

        cmpMotivo.setBackground(new java.awt.Color(17, 20, 44));
        cmpMotivo.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        cmpMotivo.setForeground(new java.awt.Color(255, 255, 255));
        cmpMotivo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(cmpMotivo);
        cmpMotivo.setBounds(208, 303, 285, 28);

        btnConfirmar.setBackground(new java.awt.Color(238, 107, 107));
        btnConfirmar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(243, 349, 134, 37);

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
        btnVolver.setBounds(6, 6, 97, 37);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 4.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -4, 650, 410);

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
        this.etqSaldoDisponibleDinamico.setText(FormatoPesos.convertidorPesos(cuenta.getSaldo()));
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
