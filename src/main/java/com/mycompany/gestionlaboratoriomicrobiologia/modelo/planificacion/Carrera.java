/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion;

/**
 *
 * @author DELL
 */
public enum Carrera {
    AMBIENTAL("Ing. Ambiental"),
    TI("Ing. Tecnologías de la Información"),
    TURISMO("Ing. Turismo"),
    ZOOTECNIA("Ing. Zootecnia"),
    AGRONOMIA("Ing. Agronomía");

    private final String nombreCompleto;

    Carrera(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
