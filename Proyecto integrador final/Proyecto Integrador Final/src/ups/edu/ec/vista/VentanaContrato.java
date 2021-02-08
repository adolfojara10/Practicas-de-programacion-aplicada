/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorCliente;
import ups.edu.ec.controlador.ControladorContrato;
import ups.edu.ec.controlador.ControladorSitio;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.Contrato;
import ups.edu.ec.modelo.EnumClienteContrato;
import ups.edu.ec.modelo.EnumTipoPrecioContrato;
import ups.edu.ec.modelo.Sitio;

/**
 *
 * @author User
 */
public class VentanaContrato extends javax.swing.JInternalFrame {

    private ControladorContrato controladorContrato;
    private ControladorSitio controladorSitio;
    private ControladorCliente controladorCliente;

    private Sitio sitio;
    private Contrato contrato;
    private Cliente cliente;

    private static DecimalFormat decimalFormat;

    /**
     * Creates new form VentanaContrato
     */
    public VentanaContrato(ControladorContrato controladorContrato, ControladorSitio controladorSitio,
            ControladorCliente controladorCliente) {
        initComponents();

        this.controladorContrato = controladorContrato;
        this.controladorSitio = controladorSitio;
        this.controladorCliente = controladorCliente;

        contrato = new Contrato();
        cliente = new Cliente();

        //decimalFormat = new DecimalFormat("^(\\d)+(\\.)((\\d){0,2})$");
        limpiar();
    }

    public void cargarCodigo() {

        txtCodigo.setText(String.valueOf(controladorContrato.getLongitud() + 1));
    }

    public void cargarSitio() {
        sitio = controladorSitio.encontrarSitioDesocupado();
        txtNumeroSitio.setText(String.valueOf(sitio.getCodigo()));
    }

    public void limpiar() {
        contrato = new Contrato();
        cliente = new Cliente();
        cargarCodigo();
        jDateChooserInicio.cleanup();
        jDateChooserFin.cleanup();
        btnGroupPrecio.clearSelection();
        cargarSitio();
        txtFormattedCedula.setValue("");
        txtFormattedCedula.setEditable(true);
        txtSubtotal.setText("");
        buttonGroupDescuento.clearSelection();
        txtTotal.setText("");
        buttonGroupPagado.clearSelection();
        Date date = java.util.Calendar.getInstance().getTime();
        jDateChooserInicio.setDate(date);
        jDateChooserFin.setDate(date);
        llenarTblContratos();
        tblContratos.clearSelection();

        btnCrear.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    public void llenarTblContratos() {
        var contratos = (List<Contrato>) controladorContrato.findAll();

        DefaultTableModel modelo = (DefaultTableModel) tblContratos.getModel();
        modelo.setRowCount(0);

        contratos.stream().map(con -> {
            if (con.getFechaFin().before(new Date())) {
                controladorSitio.cambiarAEstadoDesocupado(con.getNumeroSitioFk());
                if (con.getPagado().equalsIgnoreCase("NO")) {
                    con.setTotal(BigDecimal.valueOf(con.getTotal().doubleValue() + (con.getTotal().doubleValue() * 0.10)));
                    controladorContrato.update(con);
                }

            }
            return con;
        }).map(con -> {
            String pagado = "NO";
            if (con.getPagado().equalsIgnoreCase("SI")) {
                pagado = "SI";
            }
            Object[] row = {con.getCodigo(), con.getFechaInicio().toString(), con.getFechaFin().toString(),
                con.getTotal(), pagado, con.getNumeroSitioFk().getCodigo(), con.getCedulaClienteFk().getCedula()};
            return row;
        }).forEachOrdered(row -> {
            modelo.addRow(row);
        });

        tblContratos.setModel(modelo);
        /*
        for (Contrato con : contratos) {
            if (con.getFechaFin().before(new Date())) {
                controladorSitio.cambiarAEstadoDesocupado(con.getNumeroSitioFk());
                if (con.getPagado().equalsIgnoreCase("NO")) {
                    con.setTotal(BigDecimal.valueOf(con.getTotal().doubleValue() + (con.getTotal().doubleValue() * 0.10)));
                    controladorContrato.update(con);
                }

            }
            String pagado = "NO";
            if (con.getPagado().equalsIgnoreCase("SI")) {
                pagado = "SI";
            }
            Object[] row = {con.getCodigo(), con.getFechaInicio().toString(), con.getFechaFin().toString(),
                con.getTotal(), pagado, con.getNumeroSitioFk().getCodigo(), con.getCedulaClienteFk().getCedula()};

            modelo.addRow(row);
        }

        tblContratos.setModel(modelo);*/
    }

    public void calcularSubtotal() {
        BigDecimal subtotal = controladorContrato.obtenerSubtotal(sitio, jDateChooserInicio.getDate(),
                jDateChooserFin.getDate(), contrato.getPrecio());

        //String formateado = String.format("%.2f", subtotal);
        //subtotal = decimalFormat.format(subtotal);
        txtSubtotal.setText(subtotal.toString());
    }

    public double casteoString(String numero) {

        numero = numero.replace(",", ".");

        return Double.valueOf(numero);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrecio = new javax.swing.ButtonGroup();
        buttonGroupDescuento = new javax.swing.ButtonGroup();
        buttonGroupPagado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioBtnDia = new javax.swing.JRadioButton();
        radioBtnSemana = new javax.swing.JRadioButton();
        radioBtnMes = new javax.swing.JRadioButton();
        txtSubtotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFormattedCedula = new javax.swing.JFormattedTextField();
        txtCodigo = new javax.swing.JTextField();
        jDateChooserFin = new com.toedter.calendar.JDateChooser();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        txtNumeroSitio = new javax.swing.JTextField();
        radioBtnSi = new javax.swing.JRadioButton();
        radioBtnNo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        radioBtnPagadoSi = new javax.swing.JRadioButton();
        radioBtnPagadoNo = new javax.swing.JRadioButton();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContratos = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Contrato");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setText("Código:");

        jLabel2.setText("Fecha Inicio:");

        jLabel3.setText("Fecha Fin:");

        jLabel4.setText("Precio:");

        btnGroupPrecio.add(radioBtnDia);
        radioBtnDia.setText("Día");
        radioBtnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDiaActionPerformed(evt);
            }
        });

        btnGroupPrecio.add(radioBtnSemana);
        radioBtnSemana.setText("Semana");
        radioBtnSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnSemanaActionPerformed(evt);
            }
        });

        btnGroupPrecio.add(radioBtnMes);
        radioBtnMes.setText("Mes");
        radioBtnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnMesActionPerformed(evt);
            }
        });

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setText("Subtotal:");

        jLabel5.setText("$");

        jLabel7.setText("Descuento:");

        jLabel8.setText("Número Sitio:");

        jLabel9.setText("Cliente:");

        try {
            txtFormattedCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));

        txtNumeroSitio.setEditable(false);
        txtNumeroSitio.setBackground(new java.awt.Color(102, 102, 102));

        buttonGroupDescuento.add(radioBtnSi);
        radioBtnSi.setText("SI");
        radioBtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnSiActionPerformed(evt);
            }
        });

        buttonGroupDescuento.add(radioBtnNo);
        radioBtnNo.setText("NO");
        radioBtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnNoActionPerformed(evt);
            }
        });

        jLabel10.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(102, 102, 102));

        jLabel11.setText("$");

        jLabel12.setText("Pagado:");

        buttonGroupPagado.add(radioBtnPagadoSi);
        radioBtnPagadoSi.setText("SI");
        radioBtnPagadoSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPagadoSiActionPerformed(evt);
            }
        });

        buttonGroupPagado.add(radioBtnPagadoNo);
        radioBtnPagadoNo.setText("NO");
        radioBtnPagadoNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPagadoNoActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(0, 0, 255));
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
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFormattedCedula)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnSi)
                                .addGap(18, 18, 18)
                                .addComponent(radioBtnNo)
                                .addGap(33, 33, 33))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserFin, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jDateChooserInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioBtnSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioBtnMes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtNumeroSitio))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(154, 154, 154)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtSubtotal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrear)
                                .addGap(37, 37, 37)
                                .addComponent(btnActualizar)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnPagadoSi)
                                .addGap(18, 18, 18)
                                .addComponent(radioBtnPagadoNo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(36, 36, 36)
                                .addComponent(btnCancelar)))
                        .addGap(22, 22, 22)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioBtnDia)
                    .addComponent(radioBtnSemana)
                    .addComponent(radioBtnMes))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumeroSitio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFormattedCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioBtnSi)
                    .addComponent(radioBtnNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioBtnPagadoSi)
                        .addComponent(radioBtnPagadoNo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        tblContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha inicio", "Fecha fin", "Total", "Pagado", "Sitio", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContratos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.valueOf(txtCodigo.getText());
        Date fechaInicio = jDateChooserInicio.getDate();
        Date fechaFin = jDateChooserFin.getDate();
        String cedula = (String) txtFormattedCedula.getValue();
        String subtotal = txtSubtotal.getText();
        String total = txtTotal.getText();

        if (cedula.isBlank()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            cliente.setCedula(cedula);

            cliente = (Cliente) controladorCliente.findByCedula(cedula);

            if (cliente != null) {
                contrato.setCodigo(codigo);
                contrato.setFechaInicio(fechaInicio);
                contrato.setFechaFin(fechaFin);
                contrato.setCedulaClienteFk(cliente);
                contrato.setNumeroSitioFk(sitio);

                contrato.setSubtotal(BigDecimal.valueOf(casteoString(subtotal)));
                contrato.setTotal(BigDecimal.valueOf(casteoString(total)));

                if (controladorContrato.create(contrato)) {
                    JOptionPane.showMessageDialog(this, "Contrato creado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    controladorSitio.cambiarAEstadoContratado(sitio);
                    cliente.setContrato(EnumClienteContrato.SI.toString());
                    controladorCliente.update(cliente);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Contrato ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnCrearActionPerformed

    private void radioBtnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDiaActionPerformed
        // TODO add your handling code here:

        contrato.setPrecio(EnumTipoPrecioContrato.DIA.toString());
        sitio.setPrecio(BigDecimal.valueOf(0.0023));
        controladorSitio.update(sitio);

        calcularSubtotal();


    }//GEN-LAST:event_radioBtnDiaActionPerformed

    private void radioBtnSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnSemanaActionPerformed
        // TODO add your handling code here:
        contrato.setPrecio(EnumTipoPrecioContrato.SEMANA.toString());
        sitio.setPrecio(BigDecimal.valueOf(0.002));
        controladorSitio.update(sitio);

        calcularSubtotal();

    }//GEN-LAST:event_radioBtnSemanaActionPerformed

    private void radioBtnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnMesActionPerformed
        // TODO add your handling code here:
        contrato.setPrecio(EnumTipoPrecioContrato.MES.toString());
        sitio.setPrecio(BigDecimal.valueOf(0.0017));
        controladorSitio.update(sitio);

        calcularSubtotal();

    }//GEN-LAST:event_radioBtnMesActionPerformed

    private void radioBtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnSiActionPerformed
        // TODO add your handling code here:

        contrato.setDescuento("SI");
        calcularSubtotal();

        BigDecimal totalNumero = controladorContrato.obtenerTotal(casteoString(txtSubtotal.getText()));
        String formateado = String.format("%.2f", totalNumero);

        //subtotal = decimalFormat.format(subtotal);
        txtTotal.setText(formateado);

    }//GEN-LAST:event_radioBtnSiActionPerformed

    private void radioBtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnNoActionPerformed
        // TODO add your handling code here:
        contrato.setDescuento("NO");

        calcularSubtotal();
        txtTotal.setText(txtSubtotal.getText());
    }//GEN-LAST:event_radioBtnNoActionPerformed

    private void radioBtnPagadoSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPagadoSiActionPerformed
        // TODO add your handling code here:
        calcularSubtotal();
        contrato.setPagado("SI");

    }//GEN-LAST:event_radioBtnPagadoSiActionPerformed

    private void radioBtnPagadoNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPagadoNoActionPerformed
        // TODO add your handling code here:
        calcularSubtotal();
        contrato.setPagado("NO");

    }//GEN-LAST:event_radioBtnPagadoNoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContratosMouseClicked
        // TODO add your handling code here:

        int fila = tblContratos.getSelectedRow();

        contrato = new Contrato();

        contrato.setCodigo((int) (tblContratos.getValueAt(fila, 0)));

        contrato = (Contrato) controladorContrato.read(contrato.getCodigo());

        txtCodigo.setText(String.valueOf(contrato.getCodigo()));
        jDateChooserInicio.setDate(contrato.getFechaInicio());
        jDateChooserFin.setDate(contrato.getFechaFin());

        switch (contrato.getPrecio()) {
            case "DIA" -> {
                btnGroupPrecio.setSelected((ButtonModel) radioBtnDia.getModel(), true);
                break;
            }
            case "MES" -> {
                btnGroupPrecio.setSelected((ButtonModel) radioBtnMes.getModel(), true);
                break;
            }

            default -> {
                btnGroupPrecio.setSelected((ButtonModel) radioBtnSemana.getModel(), true);
                break;
            }

        }

        sitio = contrato.getNumeroSitioFk();
        txtNumeroSitio.setText(String.valueOf(sitio.getCodigo()));
        cliente = contrato.getCedulaClienteFk();
        txtFormattedCedula.setValue(cliente.getCedula());
        txtFormattedCedula.setEditable(false);
        txtSubtotal.setText(String.valueOf(contrato.getSubtotal()));

        if (contrato.getDescuento().equalsIgnoreCase("SI")) {
            buttonGroupDescuento.setSelected(radioBtnSi.getModel(), true);
        } else {
            buttonGroupDescuento.setSelected(radioBtnNo.getModel(), true);
        }

        txtTotal.setText(String.valueOf(contrato.getTotal()));

        if (contrato.getPagado().equalsIgnoreCase("SI")) {
            buttonGroupPagado.setSelected(radioBtnPagadoSi.getModel(), true);
        } else {
            buttonGroupPagado.setSelected(radioBtnPagadoNo.getModel(), true);
        }

        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);

    }//GEN-LAST:event_tblContratosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        contrato.setSubtotal(BigDecimal.valueOf(casteoString(txtSubtotal.getText())));
        contrato.setTotal(BigDecimal.valueOf(casteoString(txtTotal.getText())));

        if (controladorContrato.update(contrato)) {
            JOptionPane.showMessageDialog(this, "Contrato actualizado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            controladorSitio.cambiarAEstadoContratado(contrato.getNumeroSitioFk());
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        cliente = contrato.getCedulaClienteFk();

        if (controladorContrato.delete(contrato)) {
            JOptionPane.showMessageDialog(this, "Contrato eliminado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            controladorSitio.cambiarAEstadoDesocupado(contrato.getNumeroSitioFk());
            cliente.setContrato(EnumClienteContrato.NO.toString());
            controladorCliente.update(cliente);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.ButtonGroup btnGroupPrecio;
    private javax.swing.ButtonGroup buttonGroupDescuento;
    private javax.swing.ButtonGroup buttonGroupPagado;
    private com.toedter.calendar.JDateChooser jDateChooserFin;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioBtnDia;
    private javax.swing.JRadioButton radioBtnMes;
    private javax.swing.JRadioButton radioBtnNo;
    private javax.swing.JRadioButton radioBtnPagadoNo;
    private javax.swing.JRadioButton radioBtnPagadoSi;
    private javax.swing.JRadioButton radioBtnSemana;
    private javax.swing.JRadioButton radioBtnSi;
    private javax.swing.JTable tblContratos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtFormattedCedula;
    private javax.swing.JTextField txtNumeroSitio;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
