/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorAdministrador;
import ups.edu.ec.modelo.Administrador;
import ups.edu.ec.modelo.EnumTipoAdministrador;

/**
 *
 * @author User
 */
public class VentanaCrearUsuario extends javax.swing.JInternalFrame {

    private Administrador administrador;
    private ControladorAdministrador controladorAdministrador;

    private String keyUnlock;

    /**
     * Creates new form VentanaCrearUsuario
     */
    public VentanaCrearUsuario(ControladorAdministrador controladorAdministrador, String keyUnlock) {
        initComponents();

        this.controladorAdministrador = controladorAdministrador;
        crearAdministrador();
        cargarCodigo();
        llenarTblAdministradores();

        this.keyUnlock = keyUnlock;

    }

    public void crearAdministrador() {
        try {
            Constructor<Administrador> constructor = Administrador.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            administrador = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarCodigo() {
        txtCodigo.setText(String.valueOf(controladorAdministrador.generarCodigo()));
    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtFormattedCedula.setValue("");
        jDateChooser1.setDate(new Date());
        txtPassword.setText("");
        txtCorreo.setText("");
        cargarCodigo();
        txtFormattedTelefono.setValue("");
        cargarBotones();
        tblUsuarios.clearSelection();
        txtFormattedCedula.setEditable(true);

        llenarTblAdministradores();
    }

    public void cargarBotones() {
        btnCrear.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    public void cargarBotonesCambio() {
        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void llenarTblAdministradores() {
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setRowCount(0);

        for (Administrador admin : (List<Administrador>) controladorAdministrador.getListaGenerica()) {

            if (admin.getEnumTipoAdministrador() != EnumTipoAdministrador.COMPLETO) {
                Object[] row = {admin.getCedula(), admin.getNombre(), admin.getApellido(),
                    admin.getCorreo()};

                modelo.addRow(row);
            }

        }

        tblUsuarios.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtFormattedTelefono = new javax.swing.JFormattedTextField();
        txtFormattedCedula = new javax.swing.JFormattedTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Usuario");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Cédula:");

        jLabel4.setText("Código:");

        jLabel5.setText("Nacimiento:");

        jLabel6.setText("Teléfono:");

        try {
            txtFormattedTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtFormattedCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setText("Correo:");

        jLabel8.setText("Password:");

        btnCrear.setBackground(new java.awt.Color(51, 51, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(txtFormattedTelefono)
                            .addComponent(txtFormattedCedula)
                            .addComponent(txtCodigo)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtPassword)
                            .addComponent(txtCorreo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnCrear)
                        .addGap(34, 34, 34)
                        .addComponent(btnActualizar)
                        .addGap(34, 34, 34)
                        .addComponent(btnEliminar)
                        .addGap(35, 35, 35)
                        .addComponent(btnCancelar)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFormattedCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFormattedTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:

        int codigo = Integer.valueOf(txtCodigo.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = (String) txtFormattedCedula.getValue();
        Calendar fechaNacimiento = jDateChooser1.getCalendar();
        String email = txtCorreo.getText();
        String password = txtPassword.getText();
        String telefono = (String) txtFormattedTelefono.getValue();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || fechaNacimiento == null
                || email.isBlank() || password.isBlank() || telefono.isBlank()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            if (controladorAdministrador.validarEmail(email)) {
                String passwordEncriptado = controladorAdministrador.encriptarPassword(keyUnlock, password);
                administrador.setPassword(passwordEncriptado);

                System.out.println(passwordEncriptado);
                administrador.setCodigo(codigo);
                administrador.setNombre(nombre);
                administrador.setApellido(apellido);
                administrador.setCedula(cedula);
                administrador.setFechaNacimiento(fechaNacimiento);
                administrador.setCorreo(email);

                administrador.setNumeroTelefono(telefono);
                administrador.setEnumTipoAdministrador(EnumTipoAdministrador.SIMPLE);

                if (controladorAdministrador.create(administrador)) {
                    JOptionPane.showMessageDialog(this, "Administrador creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();

                } else {
                    JOptionPane.showMessageDialog(this, "Administrador ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Email invalido", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:

        int fila = tblUsuarios.getSelectedRow();

        String cedula = (String) tblUsuarios.getValueAt(fila, 0);
        administrador.setCedula(cedula);
        administrador = (Administrador) controladorAdministrador.read(administrador);

        String passwordDesencriptado = controladorAdministrador.desencriptarPassword(keyUnlock, administrador.getPassword());

        txtCodigo.setText(String.valueOf(administrador.getCodigo()));
        txtNombre.setText(administrador.getNombre());
        txtApellido.setText(administrador.getApellido());
        txtFormattedCedula.setValue(administrador.getCedula());
        txtFormattedCedula.setEditable(false);
        txtCorreo.setText(administrador.getCorreo());
        txtPassword.setText(passwordDesencriptado);
        txtFormattedTelefono.setValue(administrador.getNumeroTelefono());
        jDateChooser1.setCalendar(administrador.getFechaNacimiento());

        cargarBotonesCambio();

    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.valueOf(txtCodigo.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = (String) txtFormattedCedula.getValue();
        Calendar fechaNacimiento = jDateChooser1.getCalendar();
        String email = txtCorreo.getText();
        String password = txtPassword.getText();
        String telefono = (String) txtFormattedTelefono.getValue();

        if (nombre.isBlank() || apellido.isBlank() || cedula.isBlank() || fechaNacimiento == null
                || email.isBlank() || password.isBlank() || telefono.isBlank()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            String passwordEncriptado = controladorAdministrador.encriptarPassword(keyUnlock, password);
            administrador.setPassword(passwordEncriptado);

            administrador.setCodigo(codigo);
            administrador.setNombre(nombre);
            administrador.setApellido(apellido);
            administrador.setCedula(cedula);
            administrador.setFechaNacimiento(fechaNacimiento);
            administrador.setCorreo(email);

            administrador.setNumeroTelefono(telefono);
            administrador.setEnumTipoAdministrador(EnumTipoAdministrador.SIMPLE);

            if (controladorAdministrador.update(administrador, administrador)) {
                JOptionPane.showMessageDialog(this, "Administrador actualizado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                limpiar();

            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String cedula = (String) txtFormattedCedula.getValue();

        administrador.setCedula(cedula);

        if (controladorAdministrador.delete(administrador)) {
            JOptionPane.showMessageDialog(this, "Administrador eliminado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFormattedCedula;
    private javax.swing.JFormattedTextField txtFormattedTelefono;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}