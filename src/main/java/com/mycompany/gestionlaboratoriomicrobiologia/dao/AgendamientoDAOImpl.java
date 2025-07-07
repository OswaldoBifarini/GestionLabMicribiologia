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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AgendamientoDAOImpl implements AgendamientoDAO {

    private final Connection conexion;

    public AgendamientoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    public static class Estadistica {

        private LocalDate fecha;
        private String asignatura;
        private String practica;
        private int total;

        public Estadistica(LocalDate fecha, String asignatura, String practica, int total) {
            this.fecha = fecha;
            this.asignatura = asignatura;
            this.practica = practica;
            this.total = total;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public String getAsignatura() {
            return asignatura;
        }

        public String getPractica() {
            return practica;
        }

        public int getTotal() {
            return total;
        }
    }

    /* public List<Estadistica> obtenerEstadisticasDetalladas() throws SQLException {
        String sql = "SELECT ag.fecha AS fecha, "
                   + "a.nombre AS asignatura, "
                   + "p.descripcion AS practica, "  // Columna alternativa común
                   + "COUNT(*) AS total "
                   + "FROM agendamiento ag "
                   + "JOIN practica p ON ag.idpractica = p.idpractica "
                   + "JOIN clase c ON p.idclase = c.idclase "
                   + "JOIN asignatura a ON c.idasignatura = a.idasignatura "
                   + "GROUP BY ag.fecha, a.nombre, p.descripcion "  // Actualizado
                   + "ORDER BY ag.fecha, a.nombre, p.descripcion";  // Actualizado

        try (PreparedStatement st = conexion.prepareStatement(sql); 
             ResultSet rs = st.executeQuery()) {
            
            List<Estadistica> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new Estadistica(
                    rs.getDate("fecha").toLocalDate(),
                    rs.getString("asignatura"),
                    rs.getString("practica"),
                    rs.getInt("total")
                ));
            }
            return lista;
        }
    }*/
    
    /////////nueva implementacion de con correccion de columnas
    public List<Estadistica> obtenerEstadisticasDetalladas() throws SQLException {
        String sql = "SELECT ag.fecha AS fecha, "
                + "COALESCE(a.nombre, 'SIN ASIGNATURA') AS asignatura, "
                + "COALESCE(p.tema, 'SIN PRACTICA') AS practica, " // Cambiado a p.tema
                + "COUNT(*) AS total "
                + "FROM agendamiento ag "
                + "LEFT JOIN practica p ON ag.idpractica = p.idpractica " // LEFT JOIN
                + "LEFT JOIN clase c ON p.idclase = c.idclase "
                + "LEFT JOIN asignatura a ON c.idasignatura = a.idasignatura "
                + "GROUP BY ag.fecha, COALESCE(a.nombre, 'SIN ASIGNATURA'), COALESCE(p.tema, 'SIN PRACTICA')"
                + "ORDER BY ag.fecha, COALESCE(a.nombre, 'SIN ASIGNATURA'), COALESCE(p.tema, 'SIN PRACTICA')";

        try (PreparedStatement st = conexion.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            List<Estadistica> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new Estadistica(
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("asignatura"),
                        rs.getString("practica"),
                        rs.getInt("total")
                ));
            }
            return lista;
        }
    }
    public Map<LocalDate, Integer> obtenerDatosPoblacionales() throws SQLException {
    String sql = "SELECT fecha_uso, COUNT(*) as conteo FROM agendamiento GROUP BY fecha_uso ORDER BY fecha_uso";
    Map<LocalDate, Integer> datos = new LinkedHashMap<>();
    
    try (PreparedStatement st = conexion.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {
        while (rs.next()) {
            datos.put(
                rs.getDate("fecha_uso").toLocalDate(),
                rs.getInt("conteo")
            );
        }
    }
    return datos;
}

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
        try (PreparedStatement stmt = this.conexion.prepareStatement(CONFLICT_SQL)) {
            stmt.setDate(1, Date.valueOf(fecha));
            stmt.setTime(2, Time.valueOf(fin));
            stmt.setTime(3, Time.valueOf(inicio));
            stmt.setTime(4, Time.valueOf(fin));
            stmt.setTime(5, Time.valueOf(inicio));

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar conflictos", e);
        }
    }

    @Override
    public void guardar(Agendamiento agendamiento) {
        insertar(agendamiento);
    }

    @Override
    public void insertar(Agendamiento agendamiento) {
        try (PreparedStatement stmt = this.conexion.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
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

    @Override
    public Map<String, Integer> conteoAgendamientosPorCurso() throws SQLException {
        String sql = "SELECT a.nombre AS curso, COUNT(*) AS total "
                + "FROM agendamiento ag "
                + "JOIN practica p ON ag.idpractica = p.idpractica "
                + "JOIN clase c ON p.idclase = c.idclase "
                + "JOIN asignatura a ON c.idasignatura = a.idasignatura "
                + "GROUP BY a.nombre";

        try (PreparedStatement st = conexion.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            Map<String, Integer> mapa = new LinkedHashMap<>();
            while (rs.next()) {
                mapa.put(rs.getString("curso"), rs.getInt("total"));
            }
            return mapa;
        }
    }

    @Override
    public List<Agendamiento> obtenerPorFechaYLaboratorio(LocalDate fecha, String codigoLaboratorio) {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Agendamiento entidad) {
        //  pendiente de implementar
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM agendamientos WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar agendamiento", e);
        }
    }

    @Override
    public Agendamiento obtenerPorId(int id) {
        return null;
    }

    @Override
    public List<Agendamiento> obtenerTodos() {
        return new ArrayList<>();
    }
}
