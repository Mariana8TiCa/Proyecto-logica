/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_logica;

/**
 *
 * @author Mariana
 */
public class Mesa extends Mueble {
    private String forma_tapa;
    private double dimension_ancho;
    private double dimension_largo;
    private String material_tapa;

    public Mesa(int codigo, String descripcion, String material, double precio, String color, int cantidad_unidades,
            String forma_tapa, double dimension_ancho, double dimension_largo, String material_tapa) {
        super(codigo, descripcion, material, precio, color, cantidad_unidades);
        this.forma_tapa = forma_tapa;
        this.dimension_ancho = dimension_ancho;
        this.dimension_largo = dimension_largo;
        this.material_tapa = material_tapa;
    }

    public Mesa() {
    }

    public String getForma_tapa() {
        return forma_tapa;
    }

    public void setForma_tapa(String forma_tapa) {
        this.forma_tapa = forma_tapa;
    }

    public double getDimension_ancho() {
        return dimension_ancho;
    }

    public void setDimension_ancho(double dimension_ancho) {
        this.dimension_ancho = dimension_ancho;
    }

    public double getDimension_largo() {
        return dimension_largo;
    }

    public void setDimension_largo(double dimension_largo) {
        this.dimension_largo = dimension_largo;
    }

    public String getMaterial_tapa() {
        return material_tapa;
    }

    public void setMaterial_tapa(String material_tapa) {
        this.material_tapa = material_tapa;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Mesa" +
                "Forma de la tapa: " + forma_tapa +
                ". Dimension del acnho de la tapa: " + dimension_ancho +
                ". Dimension del largo de la tapa:" + dimension_largo +
                ". Material de la tapa: " + material_tapa + '}';
    }
}
