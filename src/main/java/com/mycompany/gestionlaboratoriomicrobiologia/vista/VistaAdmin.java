package com.mycompany.gestionlaboratoriomicrobiologia.vista;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.AgendamientoDAOImpl;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.ConexionDB;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class VistaAdmin extends javax.swing.JFrame {

    private Connection conexion;
    private AgendamientoDAOImpl controladorAgendamiento;

    public VistaAdmin() {
        try {
            conexion = ConexionDB.conectar();
            controladorAgendamiento = new AgendamientoDAOImpl(conexion);
            initComponents();
            cargarDatosUsuarios();
            cargarDatosLaboratorios();
            configurarEventos();
            configurarComboReportes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + ex.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboReportes = new javax.swing.JComboBox<>();
        btnGenerarReporte = new javax.swing.JButton();
        panelEstadistico = new javax.swing.JPanel();

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

        panelReportes.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Generar Reportes");
        jPanel4.add(jLabel1);

        comboReportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboReportesActionPerformed(evt);
            }
        });
        jPanel4.add(comboReportes);

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        jPanel4.add(btnGenerarReporte);

        panelReportes.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jTabbedPane4.addTab("Reportes del Sistema", panelReportes);

        panelEstadistico.setLayout(new java.awt.BorderLayout());
        jTabbedPane4.addTab("Estadisticas", panelEstadistico);

        jTabbedPane1.addTab("Reportes", jTabbedPane4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboReportesActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        generarReporte();
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void configurarEventos() {
        btnAgregarUsuario.addActionListener(e -> agregarUsuario());
        btnEditarUsuario.addActionListener(e -> editarUsuario());
        btnEliminarUsuario.addActionListener(e -> eliminarUsuario());
        btnAgregarLab.addActionListener(e -> agregarLaboratorio());
        btnEditarLab.addActionListener(e -> editarLaboratorio());
        btnCambiarEstado.addActionListener(e -> cambiarEstadoLaboratorio());
        btnGenerarReporte.addActionListener(e -> generarReporte());
    }

    private void configurarComboReportes() {
        comboReportes.removeAllItems();
        comboReportes.addItem("Seleccione un reporte...");
        comboReportes.addItem("Uso de laboratorios por período");
        comboReportes.addItem("Agendamientos por docente");
        comboReportes.addItem("Materiales próximos a caducar");
        comboReportes.addItem("Incidencias reportadas");
        comboReportes.addItem("Reporte Estadístico");
    }

    private void cargarDatosUsuarios() {
        try {
            String query = "SELECT idusuario, nombre, apellido, tipousuario, email, telefono FROM usuario";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("idusuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("tipousuario"),
                    rs.getString("email"),
                    rs.getString("telefono")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosLaboratorios() {
        try {
            String query = "SELECT idlaboratorio, descripcion as nombre, capacidad FROM laboratorio";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tablaLaboratorios.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("idlaboratorio"),
                    rs.getString("nombre"),
                    "Edificio X",
                    "DISPONIBLE",
                    rs.getInt("capacidad")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar laboratorios: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarUsuario() {
        JDialog dialog = new JDialog(this, "Nuevo Usuario", true);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setSize(400, 300);

        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtTelefono = new JTextField();
        JComboBox<String> comboRol = new javax.swing.JComboBox<>(new String[]{"ADMINISTRADOR", "DOCENTE", "TECNICO"});
        JPasswordField txtPassword = new JPasswordField();

        dialog.add(new JLabel("Nombre:"));
        dialog.add(txtNombre);
        dialog.add(new JLabel("Apellido:"));
        dialog.add(txtApellido);
        dialog.add(new JLabel("Email:"));
        dialog.add(txtEmail);
        dialog.add(new JLabel("Teléfono:"));
        dialog.add(txtTelefono);
        dialog.add(new JLabel("Rol:"));
        dialog.add(comboRol);
        dialog.add(new JLabel("Contraseña:"));
        dialog.add(txtPassword);

        JButton btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()
                    || txtEmail.getText().isEmpty() || txtPassword.getPassword().length == 0) {
                JOptionPane.showMessageDialog(dialog, "Complete todos los campos obligatorios",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String query = "INSERT INTO usuario (nombre, apellido, email, telefono, tipousuario, password) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.setString(1, txtNombre.getText());
                stmt.setString(2, txtApellido.getText());
                stmt.setString(3, txtEmail.getText());
                stmt.setString(4, txtTelefono.getText());
                stmt.setString(5, comboRol.getSelectedItem().toString());
                stmt.setString(6, new String(txtPassword.getPassword()));

                stmt.executeUpdate();
                cargarDatosUsuarios();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(dialog, "Error al guardar usuario: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        dialog.add(new JLabel());
        dialog.add(panelBotones);
        dialog.setVisible(true);
    }

    private void editarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idUsuario = (int) tablaUsuarios.getValueAt(filaSeleccionada, 0);

        JDialog dialog = new JDialog(this, "Editar Usuario", true);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setSize(400, 300);

        JTextField txtNombre = new JTextField(tablaUsuarios.getValueAt(filaSeleccionada, 1).toString());
        JTextField txtApellido = new JTextField(tablaUsuarios.getValueAt(filaSeleccionada, 2).toString());
        JTextField txtEmail = new JTextField(tablaUsuarios.getValueAt(filaSeleccionada, 4).toString());
        JTextField txtTelefono = new JTextField(tablaUsuarios.getValueAt(filaSeleccionada, 5).toString());
        JComboBox<String> comboRol = new javax.swing.JComboBox<>(new String[]{"ADMINISTRADOR", "DOCENTE", "TECNICO"});
        comboRol.setSelectedItem(tablaUsuarios.getValueAt(filaSeleccionada, 3).toString());

        dialog.add(new JLabel("Nombre:"));
        dialog.add(txtNombre);
        dialog.add(new JLabel("Apellido:"));
        dialog.add(txtApellido);
        dialog.add(new JLabel("Email:"));
        dialog.add(txtEmail);
        dialog.add(new JLabel("Teléfono:"));
        dialog.add(txtTelefono);
        dialog.add(new JLabel("Rol:"));
        dialog.add(comboRol);

        JButton btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String query = "UPDATE usuario SET nombre = ?, apellido = ?, email = ?, "
                        + "telefono = ?, tipousuario = ? WHERE idusuario = ?";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.setString(1, txtNombre.getText());
                stmt.setString(2, txtApellido.getText());
                stmt.setString(3, txtEmail.getText());
                stmt.setString(4, txtTelefono.getText());
                stmt.setString(5, comboRol.getSelectedItem().toString());
                stmt.setInt(6, idUsuario);

                stmt.executeUpdate();
                cargarDatosUsuarios();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(dialog, "Error al actualizar usuario: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        dialog.add(new JLabel());
        dialog.add(panelBotones);
        dialog.setVisible(true);
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idUsuario = (int) tablaUsuarios.getValueAt(filaSeleccionada, 0);

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM usuario WHERE idusuario = ?";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.setInt(1, idUsuario);
                stmt.executeUpdate();

                cargarDatosUsuarios();
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar usuario: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarLaboratorio() {
        JDialog dialog = new JDialog(this, "Nuevo Laboratorio", true);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setSize(400, 250);

        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtCapacidad = new JTextField();
        JComboBox<String> comboEstado = new javax.swing.JComboBox<>(new String[]{"DISPONIBLE", "OCUPADO", "MANTENIMIENTO", "INACTIVO"});

        dialog.add(new JLabel("Código:"));
        dialog.add(txtCodigo);
        dialog.add(new JLabel("Nombre:"));
        dialog.add(txtNombre);
        dialog.add(new JLabel("Capacidad:"));
        dialog.add(txtCapacidad);
        dialog.add(new JLabel("Estado:"));
        dialog.add(comboEstado);

        JButton btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCapacidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Complete los campos obligatorios",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String query = "INSERT INTO laboratorio (idlaboratorio, descripcion, capacidad) VALUES (?, ?, ?)";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.setString(1, txtCodigo.getText());
                stmt.setString(2, txtNombre.getText());
                stmt.setInt(3, Integer.parseInt(txtCapacidad.getText()));

                stmt.executeUpdate();
                cargarDatosLaboratorios();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Laboratorio registrado exitosamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(dialog, "Error al guardar laboratorio: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "La capacidad debe ser un número válido",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        dialog.add(new JLabel());
        dialog.add(panelBotones);
        dialog.setVisible(true);
    }

    private void editarLaboratorio() {
        int filaSeleccionada = tablaLaboratorios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un laboratorio para editar",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String codigoLab = tablaLaboratorios.getValueAt(filaSeleccionada, 0).toString();

        JDialog dialog = new JDialog(this, "Editar Laboratorio", true);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));
        dialog.setSize(400, 250);

        JTextField txtCodigo = new JTextField(tablaLaboratorios.getValueAt(filaSeleccionada, 0).toString());
        txtCodigo.setEditable(false);
        JTextField txtNombre = new JTextField(tablaLaboratorios.getValueAt(filaSeleccionada, 1).toString());
        JTextField txtCapacidad = new JTextField(tablaLaboratorios.getValueAt(filaSeleccionada, 4).toString());
        JComboBox<String> comboEstado = new javax.swing.JComboBox<>(new String[]{"DISPONIBLE", "OCUPADO", "MANTENIMIENTO", "INACTIVO"});
        comboEstado.setSelectedItem(tablaLaboratorios.getValueAt(filaSeleccionada, 3).toString());

        dialog.add(new JLabel("Código:"));
        dialog.add(txtCodigo);
        dialog.add(new JLabel("Nombre:"));
        dialog.add(txtNombre);
        dialog.add(new JLabel("Capacidad:"));
        dialog.add(txtCapacidad);
        dialog.add(new JLabel("Estado:"));
        dialog.add(comboEstado);

        JButton btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String query = "UPDATE laboratorio SET descripcion = ?, capacidad = ? WHERE idlaboratorio = ?";
                PreparedStatement stmt = conexion.prepareStatement(query);
                stmt.setString(1, txtNombre.getText());
                stmt.setInt(2, Integer.parseInt(txtCapacidad.getText()));
                stmt.setString(3, codigoLab);

                stmt.executeUpdate();
                cargarDatosLaboratorios();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Laboratorio actualizado exitosamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(dialog, "Error al actualizar laboratorio: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "La capacidad debe ser un número válido",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);

        dialog.add(new JLabel());
        dialog.add(panelBotones);
        dialog.setVisible(true);
    }

    private void cambiarEstadoLaboratorio() {
        int filaSeleccionada = tablaLaboratorios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un laboratorio",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] opciones = {"DISPONIBLE", "OCUPADO", "MANTENIMIENTO", "INACTIVO"};
        String nuevoEstado = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el nuevo estado:",
                "Cambiar Estado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (nuevoEstado != null) {
            tablaLaboratorios.setValueAt(nuevoEstado, filaSeleccionada, 3);
            JOptionPane.showMessageDialog(this, "Estado actualizado exitosamente");
        }
    }

    private void generarReporte() {
        int tipoReporte = comboReportes.getSelectedIndex();
        if (tipoReporte == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de reporte",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "";
            String titulo = "";

            switch (tipoReporte) {
                case 1:
                    query = "SELECT * FROM vistareporteuso";
                    titulo = "Uso de laboratorios";
                    break;
                case 2:
                    query = "SELECT d.nombre, COUNT(a.idagendamiento) as reservas "
                            + "FROM agendamiento a JOIN docente d ON a.iddocente = d.idusuario "
                            + "GROUP BY d.nombre";
                    titulo = "Agendamientos por docente";
                    break;
                case 3:
                    query = "SELECT * FROM material WHERE fecha_caducidad BETWEEN CURRENT_DATE AND (CURRENT_DATE + INTERVAL '30 days')";
                    titulo = "Materiales próximos a caducar";
                    break;
                case 4:
                    query = "SELECT * FROM logagendamiento WHERE accion LIKE '%INCIDENCIA%'";
                    titulo = "Incidencias reportadas";
                    break;
                case 5:
                    cargarGraficoEstadistico();
                    return;
            }

            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            JTable tablaReporte = new javax.swing.JTable(buildTableModel(rs));
            JDialog reporteDialog = new JDialog(this, "Reporte: " + titulo, true);
            reporteDialog.add(new JScrollPane(tablaReporte));
            reporteDialog.setSize(600, 400);
            reporteDialog.setLocationRelativeTo(this);
            reporteDialog.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al generar reporte: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    private void cargarGraficoEstadistico() {
        try {
            List<AgendamientoDAOImpl.Estadistica> datos = controladorAgendamiento.obtenerEstadisticasDetalladas();
            
            // Verificar si hay datos
            if (datos == null || datos.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "No hay datos disponibles para generar el gráfico estadístico",
                    "Información", 
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM");
            
            for (AgendamientoDAOImpl.Estadistica e : datos) {
                String serie = e.getAsignatura() + " - " + e.getPractica();
                String fechaLabel = e.getFecha().format(fmt);
                dataset.addValue(e.getTotal(), serie, fechaLabel);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                "Uso de Laboratorios",
                "Fecha",
                "Cantidad de Agendamientos",
                dataset
            );

            CategoryPlot plot = chart.getCategoryPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            // Rotar etiquetas para mejor visualización
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
            domainAxis.setLowerMargin(0.02);
            domainAxis.setUpperMargin(0.02);

            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setItemMargin(0.1);  // Espacio entre barras

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(750, 550));
            
            // Limpiar el panel y agregar el nuevo gráfico
            panelEstadistico.removeAll();
            panelEstadistico.setLayout(new BorderLayout());
            panelEstadistico.add(chartPanel, BorderLayout.CENTER);
            
            panelEstadistico.revalidate();
            panelEstadistico.repaint();
            
            // Cambiar a la pestaña de estadísticas
            jTabbedPane4.setSelectedComponent(panelEstadistico);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Error al generar estadísticas: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLab;
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnEditarLab;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JComboBox<String> comboReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel panelEstadistico;
    private javax.swing.JPanel panelLaboratorios;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JTable tablaLaboratorios;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
