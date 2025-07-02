/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionlaboratoriomicrobiologia.modelo.administracion;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Pedido {
    private int id;
    private LocalDate fecha;
    private EstadoPedido estado; // Enum: PENDIENTE, PROCESADO
    // + Relación con materiales
}


