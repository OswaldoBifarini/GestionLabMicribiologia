/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.dao;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Agendamiento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AgendamientoDAO {
    void guardar(Agendamiento agendamiento);
    List<Agendamiento> obtenerPorFechaYLaboratorio(LocalDate fecha, String codigoLaboratorio);
    boolean existeConflictoHorario(LocalDate fechaUso, LocalTime horaInicio, LocalTime horaFin);
    void insertar(Agendamiento agendamiento);
    void actualizar(Agendamiento agendamiento);
    void eliminar(int id);
    Agendamiento obtenerPorId(int id);
    List<Agendamiento> obtenerTodos();
}