package org.curso.ayi.jpa.app.repositories;

import org.curso.ayi.jpa.app.entity.Cliente;

import java.util.List;

public interface IClienteRepository <T> {
    List<Cliente> Listar();

    Cliente getById(Long id);

    void insertar(Cliente cliente);

    void eliminar(Long id);

    void guardar(Cliente cliente);
}
