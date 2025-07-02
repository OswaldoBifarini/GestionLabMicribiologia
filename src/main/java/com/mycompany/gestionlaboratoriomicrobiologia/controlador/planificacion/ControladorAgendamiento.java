/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.gestionlaboratoriomicrobiologia.controlador.planificacion;

import com.mycompany.gestionlaboratoriomicrobiologia.dao.AgendamientoDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.dao.LaboratorioDAO;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.BusinessException;
import com.mycompany.gestionlaboratoriomicrobiologia.excepciones.ConflictoHorarioException;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Agendamiento;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.EstadoLab;
import com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion.Laboratorio;
import java.util.List;

public class ControladorAgendamiento {

    private final AgendamientoDAO agendamientoDAO;
    private final LaboratorioDAO laboratorioDAO;

    public ControladorAgendamiento(AgendamientoDAO agendamientoDAO, LaboratorioDAO laboratorioDAO) {
        this.agendamientoDAO = agendamientoDAO;
        this.laboratorioDAO = laboratorioDAO;
    }

    public void solicitarAgendamiento(Agendamiento solicitud) 
        throws BusinessException, ConflictoHorarioException {
        
        // Validar objeto de solicitud
        if (solicitud == null) {
            throw new BusinessException("La solicitud de agendamiento no puede ser nula");
        }
        
        // 1. Validación básica de horario
        if (solicitud.getFechaUso() == null || solicitud.getHoraInicio() == null || solicitud.getHoraFin() == null) {
            throw new BusinessException("Fecha u horas no definidas");
        }
        
        if (!solicitud.esHorarioValido()) {
            throw new BusinessException("Horario inválido: Verifique fecha y horas");
        }
        
        // 2. Verificar laboratorio
        if (solicitud.getLaboratorio() == null) {
            throw new BusinessException("Laboratorio no asignado");
        }
        
        Laboratorio lab = laboratorioDAO.obtenerPorCodigo(solicitud.getLaboratorio().getCodigo());
        if (lab == null) {
            throw new BusinessException("Laboratorio no encontrado: " + solicitud.getLaboratorio().getCodigo());
        }
        
        if (lab.getEstado() != EstadoLab.DISPONIBLE) {
            throw new BusinessException("Laboratorio no disponible. Estado: " + lab.getEstado());
        }

        // 3. Verificar conflictos de horario
        List<Agendamiento> existentes = agendamientoDAO.obtenerPorFechaYLaboratorio(
            solicitud.getFechaUso(), 
            lab.getCodigo()  // Usar código del laboratorio recuperado
        );
        
        for (Agendamiento existente : existentes) {
            if (solicitud.tieneConflictoCon(existente)) {
                throw new ConflictoHorarioException(
                    "Conflicto con agendamiento existente: " + 
                    existente.getId() + " (" + 
                    existente.getHoraInicio() + " - " + 
                    existente.getHoraFin() + ")"
                );
            }
        }

        // 4. Persistir en base de datos
        agendamientoDAO.guardar(solicitud);
        
        // 5. Notificación (opcional)
        // ControladorNotificacion.notificarNuevaSolicitud(solicitud);
    }
}