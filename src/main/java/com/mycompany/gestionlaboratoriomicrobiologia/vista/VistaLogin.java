/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.vista;

import com.mycompany.gestionlaboratoriomicrobiologia.controlador.ControladorLogin;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Rol;
import javax.swing.JOptionPane;

public class VistaLogin extends javax.swing.JFrame {

    private ControladorLogin controlador;
    // Variables para los campos de texto
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtContrasena;

    /**
     * Constructor para usar con controlador
     */
    public VistaLogin(ControladorLogin controlador) {
        this.controlador = controlador;
        initComponents();
        // Asigna los campos txtUsuario y txtContrasena a los componentes generados
        txtUsuario = jTextField1;
        txtContrasena = jPasswordField1;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Gestión de Laboratorio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        panelPrincipal.add(lblTitulo, gridBagConstraints);

        jLabelUsuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuario Mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 70, 0, 0);
        panelPrincipal.add(jLabelUsuario, gridBagConstraints);

        jLabelContraseña.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelContraseña.setText(" Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 70, 0, 0);
        panelPrincipal.add(jLabelContraseña, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 226;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 20, 0, 53);
        panelPrincipal.add(jTextField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 226;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 20, 0, 53);
        panelPrincipal.add(jPasswordField1, gridBagConstraints);

        btnLogin.setBackground(new java.awt.Color(70, 130, 180));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 66, 0);
        panelPrincipal.add(btnLogin, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerformed(evt);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String email = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        try {
            Rol rol = controlador.autenticar(email, contrasena);
            abrirVistaSegunRol(rol);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                this,
                "Credenciales inválidas: " + ex.getMessage(),
                "Error de Autenticación",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void abrirVistaSegunRol(Rol rol) {
        switch (rol) {
            case ADMINISTRADOR:
                new VistaAdmin().setVisible(true);
                break;
            case TECNICO:
                new VistaTecnico().setVisible(true);
                break;
            case DOCENTE:
                new VistaDocente().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(
                    this,
                    "Rol no reconocido: " + rol,
                    "Error de Acceso",
                    JOptionPane.ERROR_MESSAGE
                );
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}