/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.Controlador;
import ups.edu.ec.controlador.ControladorTelefono;
import ups.edu.ec.controlador.ControladorUsuario;
import ups.edu.ec.modelo.*;

/**
 *
 * @author Adolfo
 */
public class VentanaRegistroTelefonos extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;

    /**
     * Creates new form VentanaRegistroTelefonos
     */
    public VentanaRegistroTelefonos(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        initComponents();
        cbxOpcionBusqueda.setSelectedIndex(0);

        this.controladorUsuario = controladorUsuario;
        this.controladorTelefono = controladorTelefono;

    }

    public void limpiar() {
        cbxOpcionBusqueda.setSelectedIndex(0);
        txtFormattedBusqueda.setValue("");
        txtBusquedaApellido.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");

        DefaultTableModel modeloTabla = (DefaultTableModel) tblTelefonos.getModel();
        modeloTabla.setRowCount(0);
        tblTelefonos.setModel(modeloTabla);

        btnBuscar.setEnabled(false);
        btnListarTodos.setEnabled(true);

    }

    public void limpiarDatos() {
        //txtFormattedBusqueda.setValue("");
        //txtBusquedaApellido.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");

        DefaultTableModel modeloTabla = (DefaultTableModel) tblTelefonos.getModel();
        modeloTabla.setRowCount(0);
        tblTelefonos.setModel(modeloTabla);

        btnBuscar.setEnabled(false);
        btnListarTodos.setEnabled(true);
    }

    public void formatearOpcion() {
        txtFormattedBusqueda.setEditable(true);
        txtFormattedBusqueda.setValue("");
        //txtFormattedBusqueda.setVisible(true);
        txtFormattedBusqueda.setEnabled(true);
        txtFormattedBusqueda.setBackground(Color.white);
        //txtFormattedBusqueda.setColumns(50);
        btnListarTodos.setEnabled(false);
        btnBuscar.setEnabled(true);
        txtBusquedaApellido.setEnabled(false);

    }

    public void llenarTablaTelefonos(List<Telefono> listaTelefonos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTelefonos.getModel();
        modeloTabla.setRowCount(0);

        for (Telefono tele : listaTelefonos) {
            Object[] rowData = {tele.getCodigo(), tele.getNumero(), tele.getTipo(), tele.getOperadora()};
            modeloTabla.addRow(rowData);
        }

        tblTelefonos.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxOpcionBusqueda = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFormattedBusqueda = new javax.swing.JFormattedTextField();
        btnListarTodos = new javax.swing.JButton();
        txtBusquedaApellido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Registros");

        jLabel1.setText("Seleccione el método de busqueda:");

        cbxOpcionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Apellido", "Cédula", "Número de celular", "Número fijo" }));
        cbxOpcionBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionBusquedaActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 51, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtFormattedBusqueda.setEditable(false);
        txtFormattedBusqueda.setEnabled(false);
        txtFormattedBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormattedBusquedaActionPerformed(evt);
            }
        });

        btnListarTodos.setBackground(new java.awt.Color(51, 51, 255));
        btnListarTodos.setText("Listar todos los Teléfonos");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });

        txtBusquedaApellido.setEditable(false);
        txtBusquedaApellido.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(cbxOpcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnListarTodos))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFormattedBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txtBusquedaApellido))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtFormattedBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOpcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar)
                    .addComponent(btnListarTodos))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombre:");

        txtNombre.setEditable(false);

        jLabel3.setText("Apellido:");

        txtApellido.setEditable(false);

        jLabel4.setText("Cédula:");

        txtCedula.setEditable(false);

        jLabel5.setText("Correo:");

        txtCorreo.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(210, 210, 210)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtCedula)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Número", "Tipo", "Operadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblTelefonos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOpcionBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionBusquedaActionPerformed
        // TODO add your handling code here:
        try {
            String item = (String) cbxOpcionBusqueda.getSelectedItem();
            if (item.equals("Apellido")) {
                txtBusquedaApellido.setEnabled(true);
                txtBusquedaApellido.setEditable(true);
                //txtBusquedaApellido.setVisible(true);
                //txtBusquedaApellido.setColumns(50);
                txtFormattedBusqueda.setEnabled(false);
                btnListarTodos.setEnabled(false);
                btnBuscar.setEnabled(true);
                /*txtFormattedBusqueda.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("??????????????????????????")
                        )
                );*/

            } else if (item.equals("Número de celular")) {
                formatearOpcion();
                txtBusquedaApellido.setText("");
                txtFormattedBusqueda.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)0##-###-####")
                        )
                );

            } else if (item.equals("Número fijo")) {
                formatearOpcion();
                txtBusquedaApellido.setText("");
                txtFormattedBusqueda.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)0#-####-###")
                        )
                );

            } else if (item.equals("Cédula")) {
                formatearOpcion();

                txtBusquedaApellido.setText("");
                txtFormattedBusqueda.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("0#########")
                        )
                );
            } else {
                txtBusquedaApellido.setText("");
                txtFormattedBusqueda.setEditable(false);
                txtFormattedBusqueda.setEnabled(false);
                txtBusquedaApellido.setEditable(false);
                txtBusquedaApellido.setEnabled(false);
                txtFormattedBusqueda.setBackground(Color.DARK_GRAY);
                btnBuscar.setEnabled(false);
                btnListarTodos.setEnabled(true);

                txtFormattedBusqueda.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("")
                        )
                );
            }
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número del teléfono erroneo");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cbxOpcionBusquedaActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
        // TODO add your handling code here:
        var listaTelefono = (List<Telefono>) controladorTelefono.findAll();

        if (listaTelefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen teléfonos");
        } else {
            llenarTablaTelefonos(listaTelefono);
        }


    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     *
     * @param evt
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String itemSeleccionado = (String) cbxOpcionBusqueda.getSelectedItem();

        if (itemSeleccionado.equalsIgnoreCase("Apellido")) {
            String busquedaTexto = txtBusquedaApellido.getText();
            System.out.println(busquedaTexto);

            String[] apellidos = busquedaTexto.split(" ");
            String apellidoMayusculas = "";
            for (String apellido : apellidos) {
                apellidoMayusculas += String.valueOf(Character.toUpperCase(apellido.charAt(0)));
                apellidoMayusculas += apellido.substring(1, apellido.length());
                apellidoMayusculas += " ";
            }           
            
            Usuario usuario = new Usuario(apellidoMayusculas.trim());
            usuario = (Usuario) controladorUsuario.read(usuario);
            if (usuario != null) {

                txtNombre.setText(usuario.getNombre());
                txtApellido.setText(usuario.getApellido());
                txtCedula.setText(usuario.getCedula());
                txtCorreo.setText(usuario.getCorreo());

                if (!usuario.getListaTelefonos().isEmpty()) {
                    llenarTablaTelefonos(usuario.getListaTelefonos());
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no contiene teléfonos");
                }
            } else {
                //limpiarDatos();
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            }

        } else if (itemSeleccionado.equalsIgnoreCase("Cédula")) {
            String busquedaTexto = String.valueOf(txtFormattedBusqueda.getValue());
            System.out.println(busquedaTexto);
            Usuario usuario = new Usuario();
            usuario.setCedula(busquedaTexto.trim());
            usuario = (Usuario) controladorUsuario.readCedula(usuario);
            if (usuario != null) {

                txtNombre.setText(usuario.getNombre());
                txtApellido.setText(usuario.getApellido());
                txtCedula.setText(usuario.getCedula());
                txtCorreo.setText(usuario.getCorreo());

                if (!usuario.getListaTelefonos().isEmpty()) {
                    llenarTablaTelefonos(usuario.getListaTelefonos());
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no contiene teléfonos");
                }

            } else {
                //limpiarDatos();
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            }

        } else {
            String busquedaTexto = String.valueOf(txtFormattedBusqueda.getValue());
            System.out.println(busquedaTexto);
            Telefono telefono = new Telefono(busquedaTexto.trim());
            telefono = (Telefono) controladorTelefono.read(telefono);
            if (telefono != null) {
                telefono.toString();

                var usuario = controladorUsuario.readNumero(telefono);
                if (usuario != null) {
                    txtNombre.setText(usuario.getNombre());
                    txtApellido.setText(usuario.getApellido());
                    txtCedula.setText(usuario.getCedula());
                    txtCorreo.setText(usuario.getCorreo());

                    DefaultTableModel modeloTabla = (DefaultTableModel) tblTelefonos.getModel();
                    modeloTabla.setRowCount(0);
                    Object[] rowData = {telefono.getCodigo(), telefono.getNumero(), telefono.getTipo(), telefono.getOperadora()};
                    modeloTabla.addRow(rowData);
                    tblTelefonos.setModel(modeloTabla);

                }
            } else {
                //limpiarDatos();
                JOptionPane.showMessageDialog(this, "Teléfono no encontrado");
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFormattedBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormattedBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormattedBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JComboBox<String> cbxOpcionBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBusquedaApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFormattedBusqueda;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
