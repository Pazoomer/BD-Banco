
package interfaz.registro;

import ejecutable.Bienvenida;
import bancoBluePersistencia.daos.clientes.IClientesDAO;
import bancoBluePersistencia.dtos.cliente.ClienteNuevoDTO;
import bancoBluePersistencia.excepciones.ValidacionDTOException;
import interfaz.cliente.PerfilCliente;
import interfaz.errores.ErrorLlenarInformacion;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 * Pantalla para registrar los datos del cliente
 * Clase documentada
 *
 * @author Jorge Zamora y Victoria Vega
 */
public class RegistrarseDatosPersonales extends javax.swing.JFrame {

    IClientesDAO clientesDAO;
    Bienvenida bienvenida;
    PerfilCliente perfilCliente;
    String operacionCliente;
    long id;
    /**
     * Contructor que recibe el perfil del cliente y define el tipo de operación de la pantalla
     * @param bienvenida Interfaz que se abre cuando se vuelve atras a esta
     * @param perfilCliente Cliente en construcción
     * @param clientesDAO Permite operar con clientes
     * @param id Identificador de un cliente en caso de que se una actualización de un cliente existente
     */
    public RegistrarseDatosPersonales(Bienvenida bienvenida,PerfilCliente perfilCliente, IClientesDAO clientesDAO, long id) {
        this.setUndecorated(true);
        this.setVisible(true);
        initComponents();
        this.setLocation(400, 200);
        this.setSize(660, 410);
        this.clientesDAO=clientesDAO;
        this.bienvenida = bienvenida;
        this.perfilCliente = perfilCliente;
        this.id=id;

        if (bienvenida != null) {
            operacionCliente="agregar";
        }else if (perfilCliente!=null) {
            operacionCliente="actualizar";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EtqNombre = new javax.swing.JLabel();
        EtqApellidoPaterno = new javax.swing.JLabel();
        EtqApellidoMaterno = new javax.swing.JLabel();
        EtqFechaNacimiento = new javax.swing.JLabel();
        CmpNombre = new javax.swing.JTextField();
        CmpApellidoMaterno = new javax.swing.JTextField();
        CmpApellidoPaterno = new javax.swing.JTextField();
        CmbxDia = new javax.swing.JComboBox<>();
        CmbxMes = new javax.swing.JComboBox<>();
        CmbxAnio = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        EtqNombre.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqNombre.setForeground(new java.awt.Color(2, 178, 178));
        EtqNombre.setText("NOMBRE(S)");
        getContentPane().add(EtqNombre);
        EtqNombre.setBounds(20, 80, 150, 32);

        EtqApellidoPaterno.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqApellidoPaterno.setForeground(new java.awt.Color(2, 178, 178));
        EtqApellidoPaterno.setText("APELLIDO PATERNO");
        getContentPane().add(EtqApellidoPaterno);
        EtqApellidoPaterno.setBounds(310, 80, 238, 32);

        EtqApellidoMaterno.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqApellidoMaterno.setForeground(new java.awt.Color(2, 178, 178));
        EtqApellidoMaterno.setText("APELLIDO MATERNO");
        getContentPane().add(EtqApellidoMaterno);
        EtqApellidoMaterno.setBounds(20, 170, 242, 32);

        EtqFechaNacimiento.setFont(new java.awt.Font("Heavitas", 0, 24)); // NOI18N
        EtqFechaNacimiento.setForeground(new java.awt.Color(2, 178, 178));
        EtqFechaNacimiento.setText("FECHA DE NACIMIENTO");
        getContentPane().add(EtqFechaNacimiento);
        EtqFechaNacimiento.setBounds(310, 170, 290, 32);

        CmpNombre.setBackground(new java.awt.Color(17, 20, 44));
        CmpNombre.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpNombre.setForeground(new java.awt.Color(255, 255, 255));
        CmpNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpNombreActionPerformed(evt);
            }
        });
        getContentPane().add(CmpNombre);
        CmpNombre.setBounds(20, 110, 222, 36);

        CmpApellidoMaterno.setBackground(new java.awt.Color(17, 20, 44));
        CmpApellidoMaterno.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        CmpApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpApellidoMaternoActionPerformed(evt);
            }
        });
        getContentPane().add(CmpApellidoMaterno);
        CmpApellidoMaterno.setBounds(20, 200, 222, 36);

        CmpApellidoPaterno.setBackground(new java.awt.Color(17, 20, 44));
        CmpApellidoPaterno.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmpApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        CmpApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmpApellidoPaternoActionPerformed(evt);
            }
        });
        getContentPane().add(CmpApellidoPaterno);
        CmpApellidoPaterno.setBounds(310, 110, 222, 36);

        CmbxDia.setBackground(new java.awt.Color(17, 20, 44));
        CmbxDia.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmbxDia.setForeground(new java.awt.Color(255, 255, 255));
        CmbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        CmbxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbxDiaActionPerformed(evt);
            }
        });
        getContentPane().add(CmbxDia);
        CmbxDia.setBounds(310, 200, 82, 36);

        CmbxMes.setBackground(new java.awt.Color(17, 20, 44));
        CmbxMes.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmbxMes.setForeground(new java.awt.Color(255, 255, 255));
        CmbxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        CmbxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbxMesActionPerformed(evt);
            }
        });
        getContentPane().add(CmbxMes);
        CmbxMes.setBounds(400, 200, 82, 36);

        CmbxAnio.setBackground(new java.awt.Color(17, 20, 44));
        CmbxAnio.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        CmbxAnio.setForeground(new java.awt.Color(255, 255, 255));
        CmbxAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        getContentPane().add(CmbxAnio);
        CmbxAnio.setBounds(490, 200, 106, 36);

        btnSiguiente.setBackground(new java.awt.Color(238, 107, 107));
        btnSiguiente.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Continuar");
        btnSiguiente.setMaximumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(193, 63));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente);
        btnSiguiente.setBounds(503, 353, 140, 40);

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
        btnVolver.setBounds(6, 6, 110, 40);

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario y contraseña");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 320, 158, 23);

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Domicilio");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 320, 80, 23);

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Datos personales");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 320, 128, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secuencia 1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 260, 350, 50);

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese sus datos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 360, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo 2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-3, -4, 660, 410);

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 330, 38, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CmpApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpApellidoMaternoActionPerformed

    private void CmpApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpApellidoPaternoActionPerformed

    private void CmpNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmpNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmpNombreActionPerformed

    private void CmbxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbxDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbxDiaActionPerformed

    private void CmbxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbxMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbxMesActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        confirmar();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (bienvenida!=null) {
            bienvenida.setVisible(true);
        }
        if (perfilCliente!=null) {
           perfilCliente.setVisible(true);
        }
        
    }//GEN-LAST:event_formWindowClosed

    /**
     * Valida los datos y los agrega al cliente en construcción
     */
    private void confirmar(){
        
        // Obtener valores de los campos
        String anioStr = (String) this.CmbxAnio.getSelectedItem();
        String diaStr = (String) this.CmbxDia.getSelectedItem();
        String mesStr = (String) this.CmbxMes.getSelectedItem();

        // Comprobar que ningún campo sea null
        if (anioStr != null && diaStr != null && mesStr != null
                && !anioStr.isEmpty() && !diaStr.isEmpty() && !mesStr.isEmpty()
                && this.CmpApellidoMaterno.getText() != null && this.CmpApellidoPaterno.getText() != null
                && this.CmpNombre.getText() != null
                && !this.CmpApellidoMaterno.getText().isEmpty() && !this.CmpApellidoPaterno.getText().isEmpty()
                && !this.CmpNombre.getText().isEmpty()) {
            
        // Convertir los valores a enteros
        int anio = Integer.parseInt(anioStr);
        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);

        Date fechaNacimiento = new Date(anio - 1900, mes - 1, dia);

            String apellidoMaterno = this.CmpApellidoMaterno.getText();
            String apellidoPaterno = this.CmpApellidoPaterno.getText();
            String nombre = this.CmpNombre.getText();

            ClienteNuevoDTO cliente = new ClienteNuevoDTO();
            cliente.setApellidoMaterno(apellidoMaterno);
            cliente.setApellidopaterno(apellidoPaterno);
            cliente.setFechaNacimiento(fechaNacimiento);
            cliente.setNombre(nombre);

            try {
                if (cliente.validarDatosPersonales()) {
                    RegistrarseDomicilio registrar = new RegistrarseDomicilio(this, cliente, clientesDAO,operacionCliente,id);
                    this.setVisible(false);
                    registrar.setVisible(true);
                }

            } catch (ValidacionDTOException validacionDTOException) {
                JOptionPane.showMessageDialog(this, "Debe ser mayor de edad");
            }

        } else {
            ErrorLlenarInformacion error=new ErrorLlenarInformacion();
            error.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbxAnio;
    private javax.swing.JComboBox<String> CmbxDia;
    private javax.swing.JComboBox<String> CmbxMes;
    private javax.swing.JTextField CmpApellidoMaterno;
    private javax.swing.JTextField CmpApellidoPaterno;
    private javax.swing.JTextField CmpNombre;
    private javax.swing.JLabel EtqApellidoMaterno;
    private javax.swing.JLabel EtqApellidoPaterno;
    private javax.swing.JLabel EtqFechaNacimiento;
    private javax.swing.JLabel EtqNombre;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
