/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.planificacion;

/**
 *
 * @author DELL
 */
public class Laboratorio {

    private String codigo;
    private String nombre;
    private String ubicacion;
    private EstadoLab estado; // Enum:   PENDIENTE,APROBADO,RECHAZADO,CANCELADO

    /*EstadoLab*/
    public String getCodigo() {

        return codigo;

    }

    public Laboratorio(String codigo, String nombre, String ubicacion, EstadoLab estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public EstadoLab getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
