/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_logica;

/**
 *
 * @author Mariana
 */
public class Silla extends Mueble{
    private String material_tapizado;
    private String color_tapizado;
    private String densidad_espuma;

    public Silla(String codigo, String descripcion, String material, double precio, String color, int cantidad_unidades, String material_tapizado, String color_tapizado, String densidad_espuma) {
        super(codigo, descripcion, material, precio, color, cantidad_unidades);
        this.material_tapizado = material_tapizado;
        this.color_tapizado = color_tapizado;
        this.densidad_espuma = densidad_espuma;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "Silla: " + 
        "Material del tapizado: " + material_tapizado + 
        ". Color del tapizado: " + color_tapizado + 
        ". Densidad de la espuma: " + densidad_espuma + '}';
    }
}
