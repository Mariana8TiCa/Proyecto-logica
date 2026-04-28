package com.mycompany.proyecto_logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Valida los datos de entrada para el registro de un cliente.
 */
public class ClienteValidator {

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Valida los campos del formulario de registro.
     *
     * @param documento  número de documento (no vacío)
     * @param nombre     nombre completo (no vacío)
     * @param fechaTexto fecha en formato DD/MM/AAAA (día/mes/año de 4 dígitos,
     *                   p. ej. 15/03/1990)
     * @throws IllegalArgumentException si algún campo es inválido; el mensaje
     *                                  explica cuál es el error.
     */
    public static void validar(String documento, String nombre, String fechaTexto) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de documento es obligatorio.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo es obligatorio.");
        }
        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria.");
        }
        try {
            LocalDate.parse(fechaTexto.trim(), FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "La fecha debe tener el formato DD/MM/AAAA (día/mes/año, ej. 15/03/1990).");
        }
    }

    /** Convierte un texto con formato DD/MM/AAAA a {@link LocalDate}. */
    public static LocalDate parsearFecha(String fechaTexto) {
        return LocalDate.parse(fechaTexto.trim(), FORMATO_FECHA);
    }
}
