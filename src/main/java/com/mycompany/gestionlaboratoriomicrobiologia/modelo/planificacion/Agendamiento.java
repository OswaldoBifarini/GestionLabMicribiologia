/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion;

import com.mycompany.gestionlaboratoriomicrobiologia.modelo.persona.Docente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Agendamiento {

    private int id;
    private LocalDate fechaSolicitud;
    private LocalDate fechaUso;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String tema;
    private int nroEstudiantes;
    private EstadoAgendamiento estado;
    private Docente docente;
    private Laboratorio laboratorio;
    private PAO pao;
    private Asignatura asignatura;

    // Constructor
    public Agendamiento(LocalDate fechaUso, LocalTime horaInicio, LocalTime horaFin,
            Docente docente, Laboratorio laboratorio, PAO pao,
            Asignatura asignatura, String tema, int nroEstudiantes) {
        this.fechaSolicitud = LocalDate.now();
        this.fechaUso = fechaUso;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.docente = docente;
        this.laboratorio = laboratorio;
        this.pao = pao;
        this.asignatura = asignatura;
        this.tema = tema;
        this.nroEstudiantes = nroEstudiantes;
        this.estado = EstadoAgendamiento.PENDIENTE;
    }

    // Métodos de validación de horarios
    public boolean esHorarioValido() {
        return validarFechaFutura()
                && validarHorasConsecutivas()
                && validarDuracionMinima();
    }

    private boolean validarFechaFutura() {
        return !fechaUso.isBefore(LocalDate.now());
    }

    private boolean validarHorasConsecutivas() {
        return horaInicio.isBefore(horaFin);
    }

    private boolean validarDuracionMinima() {
        return horaFin.isAfter(horaInicio.plusMinutes(30));
    }

    public boolean tieneConflictoCon(Agendamiento otro) {
        if (!this.fechaUso.equals(otro.fechaUso)) {
            return false;
        }
        if (!this.laboratorio.equals(otro.laboratorio)) {
            return false;
        }

        return (this.horaInicio.isBefore(otro.horaFin)
                && this.horaFin.isAfter(otro.horaInicio));
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public LocalDate getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(LocalDate fechaUso) {
        this.fechaUso = fechaUso;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getNroEstudiantes() {
        return nroEstudiantes;
    }

    public void setNroEstudiantes(int nroEstudiantes) {
        this.nroEstudiantes = nroEstudiantes;
    }

    public EstadoAgendamiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAgendamiento estado) {
        this.estado = estado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public PAO getPao() {
        return pao;
    }

    public void setPao(PAO pao) {
        this.pao = pao;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agendamiento that = (Agendamiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agendamiento{"
                + "fechaUso=" + fechaUso
                + ", horaInicio=" + horaInicio
                + ", horaFin=" + horaFin
                + ", laboratorio=" + laboratorio.getCodigo()
                + ", estado=" + estado
                + '}';
    }
}
