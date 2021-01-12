/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import ups.edu.ec.controlador.ControladorTelefono;
import ups.edu.ec.controlador.ControladorUsuario;

/**
 *
 * @author Adolfo
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private VentanaRegistrarUsuario ventanaRegistrarUsuario;
    private VentanaIniciarSesion ventanaIniciarSesion;
    private VentanaRegistroTelefonos ventanaRegistroTelefonos;
    private VentanaGestionTelefono ventanaGestionTelefono;
    private VentanaGestionUsuario ventanaGestionUsuario;

    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();

        controladorUsuario = new ControladorUsuario();
        controladorTelefono = new ControladorTelefono();

        ventanaGestionTelefono = new VentanaGestionTelefono(controladorUsuario, controladorTelefono);
        ventanaGestionUsuario = new VentanaGestionUsuario(controladorUsuario);
        ventanaRegistrarUsuario = new VentanaRegistrarUsuario(controladorUsuario);
        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, this, 
                ventanaGestionTelefono, ventanaGestionUsuario);
        ventanaRegistroTelefonos = new VentanaRegistroTelefonos(controladorUsuario, controladorTelefono);
        

        desktopPane.add(ventanaRegistrarUsuario);
        desktopPane.add(ventanaIniciarSesion);
        desktopPane.add(ventanaRegistroTelefonos);
        desktopPane.add(ventanaGestionTelefono);
        desktopPane.add(ventanaGestionUsuario);

        this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
    }

    public JMenu getMenuGestion() {
        return menuGestion;
    }

    public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }

    public JMenuItem getMenuItemCrearUsuario() {
        return menuItemCrearUsuario;
    }

    public JMenuItem getMenuItemIniciarSesion() {
        return menuItemIniciarSesion;
    }

    public void cerrarVentanas() {
        ventanaRegistrarUsuario.setVisible(false);
        ventanaIniciarSesion.setVisible(false);
        ventanaRegistroTelefonos.setVisible(false);
        ventanaGestionTelefono.setVisible(false);
        ventanaGestionUsuario.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        menuItemCrearUsuario = new javax.swing.JMenuItem();
        menuItemIniciarSesion = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        menuItemTelefono = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        menuItemGestionUsuario = new javax.swing.JMenuItem();
        menuItemGestionTelefonos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Telefonica");

        menuMenu.setMnemonic('f');
        menuMenu.setText("Menu");

        menuItemCrearUsuario.setMnemonic('o');
        menuItemCrearUsuario.setText("Crear Usuario");
        menuItemCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearUsuarioActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemCrearUsuario);

        menuItemIniciarSesion.setMnemonic('s');
        menuItemIniciarSesion.setText("Iniciar Sesión");
        menuItemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIniciarSesionActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemIniciarSesion);

        menuItemCerrarSesion.setText("Cerrar Sesión");
        menuItemCerrarSesion.setEnabled(false);
        menuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesionActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemCerrarSesion);

        menuItemTelefono.setMnemonic('a');
        menuItemTelefono.setText("Teléfonos");
        menuItemTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTelefonoActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemTelefono);

        menuItemExit.setMnemonic('x');
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuMenu.add(menuItemExit);

        menuBar.add(menuMenu);

        menuGestion.setMnemonic('e');
        menuGestion.setText("Gestión");
        menuGestion.setEnabled(false);

        menuItemGestionUsuario.setMnemonic('t');
        menuItemGestionUsuario.setText("Usuario");
        menuItemGestionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionUsuarioActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemGestionUsuario);

        menuItemGestionTelefonos.setMnemonic('y');
        menuItemGestionTelefonos.setText("Teléfonos");
        menuItemGestionTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionTelefonosActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemGestionTelefonos);

        menuBar.add(menuGestion);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearUsuarioActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaRegistrarUsuario.setVisible(true);
    }//GEN-LAST:event_menuItemCrearUsuarioActionPerformed

    private void menuItemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIniciarSesionActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaIniciarSesion.setVisible(true);
    }//GEN-LAST:event_menuItemIniciarSesionActionPerformed

    private void menuItemTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTelefonoActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaRegistroTelefonos.setVisible(true);
    }//GEN-LAST:event_menuItemTelefonoActionPerformed

    private void menuItemGestionTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionTelefonosActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaGestionTelefono.setVisible(true);
    }//GEN-LAST:event_menuItemGestionTelefonosActionPerformed

    private void menuItemGestionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionUsuarioActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        ventanaGestionUsuario.setVisible(true);
    }//GEN-LAST:event_menuItemGestionUsuarioActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed
        // TODO add your handling code here:
        cerrarVentanas();
        menuGestion.setEnabled(false);
        menuItemCerrarSesion.setEnabled(false);
        menuItemCrearUsuario.setEnabled(true);
        menuItemIniciarSesion.setEnabled(true);

    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemCrearUsuario;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemGestionTelefonos;
    private javax.swing.JMenuItem menuItemGestionUsuario;
    private javax.swing.JMenuItem menuItemIniciarSesion;
    private javax.swing.JMenuItem menuItemTelefono;
    private javax.swing.JMenu menuMenu;
    // End of variables declaration//GEN-END:variables

}