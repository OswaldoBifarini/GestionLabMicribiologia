/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion;

/**
 *
 * @author DELL
 */
public class PAO {

    private int id;
    private int nroPAO;
    private String paralelo;
    private Carrera carrera; // Relación con carreras

    // + Getters/Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroPAO() {
        return nroPAO;
    }

    public void setNroPAO(int nroPAO) {
        this.nroPAO = nroPAO;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

}
