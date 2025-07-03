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
        tabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Panel de Administración");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Crear pestañas
        JPanel panelUsuarios = new javax.swing.JPanel();
        panelUsuarios.add(new JLabel("Gestión de Usuarios"));
        tabbedPane.addTab("Usuarios", panelUsuarios);

        JPanel panelLaboratorios = new javax.swing.JPanel();
        panelLaboratorios.add(new JLabel("Gestión de Laboratorios"));
        tabbedPane.addTab("Laboratorios", panelLaboratorios);

        JPanel panelReportes = new javax.swing.JPanel();
        panelReportes.add(new JLabel("Reportes del Sistema"));
        tabbedPane.addTab("Reportes", panelReportes);

        getContentPane().add(tabbedPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}