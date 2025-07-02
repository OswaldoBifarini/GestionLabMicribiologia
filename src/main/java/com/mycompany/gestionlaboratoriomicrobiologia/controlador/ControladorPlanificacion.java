/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.controlador;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.AgendamientoDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.ConflictoHorarioException;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Agendamiento;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Laboratorio;
import static javax.swing.text.html.HTML.Tag.I;

/**
 *
 * @author DELL
 */
public class ControladorPlanificacion {

    private final AgendamientoDAO agendamientoDAO;

    // Inyección de dependencias por constructor
    public ControladorPlanificacion(AgendamientoDAO agendamientoDAO) {
        this.agendamientoDAO = agendamientoDAO;
    }

    public void crearAgendamiento(Agendamiento agendamiento) throws ConflictoHorarioException {
        if (agendamiento == null) {
            throw new IllegalArgumentException("El agendamiento no puede ser nulo");
        }

        Laboratorio laboratorio = agendamiento.getLaboratorio();
        if (laboratorio == null) {
            throw new IllegalArgumentException("Laboratorio no asignado en el agendamiento");
        }

        if (agendamientoDAO.existeConflictoHorario(
                agendamiento.getFechaUso(),
                agendamiento.getHoraInicio(),
                agendamiento.getHoraFin())) {

            throw new ConflictoHorarioException(
                    "Conflicto de horario para el laboratorio "
                    + agendamiento.getLaboratorio().getCodigo()
                    + " en la fecha " + agendamiento.getFechaUso()
            );
        }
        agendamientoDAO.insertar(agendamiento);
    }

}
