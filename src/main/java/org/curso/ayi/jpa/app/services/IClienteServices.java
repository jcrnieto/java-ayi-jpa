package org.curso.ayi.jpa.app.services;

import org.curso.ayi.jpa.app.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteServices {
    List<Cliente> getAll();

    Optional<Cliente> getById(Long id);

    void aliminar(Long id);

    void insert(Cliente cliente);
}
