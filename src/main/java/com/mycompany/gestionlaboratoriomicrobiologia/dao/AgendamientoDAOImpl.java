/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;


import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Agendamiento;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */

public class AgendamientoDAOImpl implements AgendamientoDAO {

    private static final String INSERT_SQL = "INSERT INTO agendamientos "
            + "(fecha_solicitud, fecha_uso, hora_inicio, hora_fin, tema, "
            + "nro_estudiantes, estado, docente_id, laboratorio_codigo, pao_id, asignatura_codigo) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String CONFLICT_SQL = "SELECT COUNT(*) FROM agendamientos "
            + "WHERE fecha_uso = ? AND laboratorio_codigo = ? "
            + "AND ((hora_inicio < ? AND hora_fin > ?) "
            + "OR (hora_inicio < ? AND hora_fin > ?))";

    @Override
    public boolean existeConflictoHorario(LocalDate fecha, LocalTime inicio, LocalTime fin) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(CONFLICT_SQL)) {
            
            stmt.setDate(1, Date.valueOf(fecha));
            stmt.setTime(2, Time.valueOf(fin));
            stmt.setTime(3, Time.valueOf(inicio));
            stmt.setTime(4, Time.valueOf(fin));
            stmt.setTime(5, Time.valueOf(inicio));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar conflictos", e);
        }
        return false;
    }

    @Override
    public void guardar(Agendamiento agendamiento) {
        insertar(agendamiento); // Alias para insertar
    }

    @Override
    public void insertar(Agendamiento agendamiento) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setDate(1, Date.valueOf(agendamiento.getFechaSolicitud()));
            stmt.setDate(2, Date.valueOf(agendamiento.getFechaUso()));
            stmt.setTime(3, Time.valueOf(agendamiento.getHoraInicio()));
            stmt.setTime(4, Time.valueOf(agendamiento.getHoraFin()));
            stmt.setString(5, agendamiento.getTema());
            stmt.setInt(6, agendamiento.getNroEstudiantes());
            stmt.setString(7, agendamiento.getEstado().name());
            stmt.setString(8, agendamiento.getDocente().getIdDocente());
            stmt.setString(9, agendamiento.getLaboratorio().getCodigo());
            stmt.setInt(10, agendamiento.getPao().getId());
            stmt.setString(11, agendamiento.getAsignatura().getCodigo());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    agendamiento.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar agendamiento", e);
        }
    }

    // Implementa los demás métodos según necesidad
    @Override
    public List<Agendamiento> obtenerPorFechaYLaboratorio(LocalDate fecha, String codigoLaboratorio) {
        List<Agendamiento> agendamientos = new ArrayList<>();
        // Implementa la consulta SQL
        return agendamientos;
    }

    @Override
    public void actualizar(Agendamiento entidad) {
        // Implementación similar a insertar pero con UPDATE
    }

    @Override
    public void eliminar(int id) {
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM agendamientos WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar agendamiento", e);
        }
    }

    @Override
    public Agendamiento obtenerPorId(int id) {
        // Implementa la consulta SELECT por ID
        return null;
    }

    @Override
    public List<Agendamiento> obtenerTodos() {
        // Implementa la consulta SELECT *
        return new ArrayList<>();
    }
}
