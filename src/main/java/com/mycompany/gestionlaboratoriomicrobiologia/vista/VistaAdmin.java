/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author DELL
 */
public class VistaAdmin extends javax.swing.JFrame {


    /**
     * Creates new form VistaAdmin
     */
    public VistaAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelUsuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        panelLaboratorios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLaboratorios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarLab = new javax.swing.JButton();
        btnEditarLab = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        panelReportes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panel de Administración");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Rol", "Email", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        btnAgregarUsuario.setText("Agregar Usuario");
        jPanel1.add(btnAgregarUsuario);

        btnEditarUsuario.setText("Editar");
        jPanel1.add(btnEditarUsuario);

        btnEliminarUsuario.setText("Eliminar");
        jPanel1.add(btnEliminarUsuario);

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jTabbedPane2.addTab("Gestión de Usuarios", panelUsuarios);

        jTabbedPane1.addTab("Usuarios", jTabbedPane2);

        panelLaboratorios.setLayout(new java.awt.BorderLayout());

        tablaLaboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Ubicación", "Estado", "Capacidad"
            }
        ));
        tablaLaboratorios.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaLaboratorios);
        tablaLaboratorios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelLaboratorios.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnAgregarLab.setText("Agregar Lab");
        jPanel2.add(btnAgregarLab);

        btnEditarLab.setText("Editar Lab");
        jPanel2.add(btnEditarLab);

        btnCambiarEstado.setText("Cambiar Estado");
        jPanel2.add(btnCambiarEstado);

        panelLaboratorios.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jTabbedPane3.addTab("Gestión de Laboratorios", panelLaboratorios);

        jTabbedPane1.addTab("Laboratorios", jTabbedPane3);

        javax.swing.GroupLayout panelReportesLayout = new javax.swing.GroupLayout(panelReportes);
        panelReportes.setLayout(panelReportesLayout);
        panelReportesLayout.setHorizontalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        panelReportesLayout.setVerticalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Reportes del Sistema", panelReportes);

        jTabbedPane1.addTab("Reportes", jTabbedPane4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLab;
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnEditarLab;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel panelLaboratorios;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JTable tablaLaboratorios;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}