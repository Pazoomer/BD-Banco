
package interfaz.cliente;

import interfaz.registro.IniciarSesion;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.daos.cuentas.ICuentasDAO;
import bancoBluePersistencia.daos.operaciones.IOperacionesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteConsultableDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaNuevaDTO;
import bancoBluePersistencia.dtos.cuenta.CuentaSaldoDTO;
import bancoBluePersistencia.excepciones.PersistenciaException;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import bancoblueDominio.Cliente;
import bancoblueDominio.Cuenta;
import interfaz.cuenta.MenuCuenta;
import interfaz.tablas.TablaCuentas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pantalla de menu principal que maneja el cliente y sus cuentas
 * Clase documentada
 * @author Jorge Zamora y Victoria Vega
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final IniciarSesion iniciarSesion;
    private final Cliente cliente;
    private final IClientesDAO clientesDAO;
    private List<Cuenta> listaCuentas;
    private final ICuentasDAO cuentasDAO;
    private final IOperacionesDAO operacionesDAO;
    /**
     * Constructor que usa los datos del cliente para accerde a sus cuentas
     * @param iniciarSesion Pantalla a mostrar en caso de volver
     * @param cliente Cliente del que obtiene los datos
     * @param clientesDAO Opera clientes
     * @param cuentasDAO Opera cuentas
     * @param operacionesDAO Opera operaciones
     */
    public MenuPrincipal(IniciarSesion iniciarSesion, Cliente cliente, IClientesDAO clientesDAO,ICuentasDAO cuentasDAO,IOperacionesDAO operacionesDAO) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.iniciarSesion=iniciarSesion;
        this.cliente=cliente;
        this.clientesDAO=clientesDAO;
        this.cuentasDAO=cuentasDAO;
        this.operacionesDAO=operacionesDAO;
        this.setSize(660, 410);
        this.setLocation(400, 200);
        actualizarTabla();
         // Agrega un escuchador de clics a la tabla
        tablaCuentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaCuentas.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    // Obtener la cuenta seleccionada
                    Cuenta cuentaSeleccionada = listaCuentas.get(filaSeleccionada);
                    menuCuenta(cuentaSeleccionada);
                }
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        btnPerfil = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        etqCuentas = new javax.swing.JLabel();
        btnAgregarCuenta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JToggleButton();
        lblInformacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        tablaCuentas.setBackground(new java.awt.Color(17, 20, 44));
        tablaCuentas.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        tablaCuentas.setForeground(new java.awt.Color(255, 255, 255));
        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número de tarjeta", "Fecha de apertura", "Estado"
            }
        ));
        tablaCuentas.setGridColor(new java.awt.Color(255, 255, 255));
        tablaCuentas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tablaCuentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaCuentas);
        if (tablaCuentas.getColumnModel().getColumnCount() > 0) {
            tablaCuentas.getColumnModel().getColumn(0).setHeaderValue("Número de tarjeta");
            tablaCuentas.getColumnModel().getColumn(1).setHeaderValue("Fecha de apertura");
            tablaCuentas.getColumnModel().getColumn(2).setHeaderValue("Estado");
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 89, 651, 265);

        btnPerfil.setBackground(new java.awt.Color(238, 107, 107));
        btnPerfil.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setText("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(btnPerfil);
        btnPerfil.setBounds(6, 6, 84, 37);

        btnCerrarSesion.setBackground(new java.awt.Color(238, 107, 107));
        btnCerrarSesion.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(475, 6, 170, 37);

        etqCuentas.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        etqCuentas.setForeground(new java.awt.Color(2, 178, 178));
        etqCuentas.setText("CUENTAS");
        getContentPane().add(etqCuentas);
        etqCuentas.setBounds(10, 60, 100, 23);

        btnAgregarCuenta.setBackground(new java.awt.Color(238, 107, 107));
        btnAgregarCuenta.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnAgregarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCuenta.setText("Agregar cuenta");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCuenta);
        btnAgregarCuenta.setBounds(445, 360, 200, 37);

        btnActualizar.setBackground(new java.awt.Color(238, 107, 107));
        btnActualizar.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(6, 360, 133, 37);

        lblInformacion.setBackground(new java.awt.Color(255, 255, 255));
        lblInformacion.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblInformacion.setForeground(new java.awt.Color(255, 255, 255));
        lblInformacion.setText("Haga clic en una cuenta para usarla");
        getContentPane().add(lblInformacion);
        lblInformacion.setBounds(154, 49, 324, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 9.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -4, 650, 410);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.iniciarSesion.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        agregarCuenta();
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        perfilCliente();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * Crea la pantalla para acceder al perfil del cliente
     */
    private void perfilCliente(){
       PerfilCliente perfilCliente=new PerfilCliente(this, cliente,clientesDAO);
        this.setVisible(false);
        perfilCliente.setVisible(true); 
    }
    
    /**
     * Crea la pantalla para acceder al menu de una cuenta
     * @param cuenta Cuenta a mostrar
     */
    private void menuCuenta(Cuenta cuenta){
        MenuCuenta menuCuenta=new MenuCuenta(this, cuenta, clientesDAO, cuentasDAO,operacionesDAO);
        this.setVisible(false);
        menuCuenta.setVisible(true);
        actualizarTabla();
    }

    /**
     * Genera una cuenta y la agrega al cliente en la base de datos
     */
    private void agregarCuenta() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de crear una nueva cuenta?, esta accion no se puede revertir", "Crear nueva cuenta", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            CuentaNuevaDTO cuentaNueva = new CuentaNuevaDTO();
            cuentaNueva.setIdCliente(this.cliente.getId());

            try {
                Cuenta cuenta = cuentasDAO.agregar(cuentaNueva);

                //ESTE CODIGO SERA ELIMINADO ANTES DE SU SALIDA AL PUBLICO
                CuentaSaldoDTO cuentaSaldo = new CuentaSaldoDTO();
                cuentaSaldo.setSaldo(100);
                cuentaSaldo.setCodigo(cuenta.getCodigo());
                cuentasDAO.cambiarMonto(cuentaSaldo);
                //ESTE CODIGO SERA ELIMINADO ANTES DE SU SALIDA AL PUBLICO

            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la cuenta debido a un error en la base de datos");
                return;
            } catch (ValidacionDTOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "Su nueva cuenta ha sido creada con exito");
        
        //ESTE CODIGO SERA ELIMINADO ANTES DE SU SALIDA AL PUBLICO
        JOptionPane.showMessageDialog(this, "ADVERTENCIA: su cuenta iniciaria con un monto de $100.00 pesos mexicanos para fines de prueba, esto no se hara cuando salga al publico");
        //ESTE CODIGO SERA ELIMINADO ANTES DE SU SALIDA AL PUBLICO
    }
    
    /**
     * Actualiza los datos de la tabla con las cuentas de la base de datos
     */
    private void actualizarTabla(){
        ClienteConsultableDTO clienteConsultable=new ClienteConsultableDTO();
        
        clienteConsultable.setId(cliente.getId());

        try {
            this.listaCuentas=cuentasDAO.consultar(clienteConsultable);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la informacion debido a un error en la base de datos");
        }
        if (listaCuentas!=null) {
          TablaCuentas tablaModel = new TablaCuentas(listaCuentas);
        tablaCuentas.setModel(tablaModel);  
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JButton btnAgregarCuenta;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JLabel etqCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JTable tablaCuentas;
    // End of variables declaration//GEN-END:variables
}
