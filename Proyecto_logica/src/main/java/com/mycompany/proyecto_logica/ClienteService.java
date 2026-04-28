package com.mycompany.proyecto_logica;

import java.util.HashMap;

/**
 * Servicio que gestiona el registro y consulta de clientes en memoria.
 */
public class ClienteService {

    private final HashMap<String, Cliente> clientes = new HashMap<>();

    /**
     * Registra un nuevo cliente.
     *
     * @param cliente cliente a registrar
     * @throws IllegalArgumentException si ya existe un cliente con el mismo documento
     */
    public void registrar(Cliente cliente) {
        String doc = cliente.getDocumento_identidad();
        if (clientes.containsKey(doc)) {
            throw new IllegalArgumentException(
                    "El cliente con documento " + doc + " ya existe.");
        }
        clientes.put(doc, cliente);
    }

    /**
     * Busca un cliente por su número de documento.
     *
     * @param documento número de documento
     * @return el {@link Cliente} encontrado, o {@code null} si no existe
     */
    public Cliente buscar(String documento) {
        return clientes.get(documento);
    }

    /**
     * Indica si ya existe un cliente con el documento dado.
     *
     * @param documento número de documento
     * @return {@code true} si existe
     */
    public boolean existe(String documento) {
        return clientes.containsKey(documento);
    }
}
