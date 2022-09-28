package org.curso.ayi.jpa.app.repositories.impl;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.entity.Cliente;
import org.curso.ayi.jpa.app.repositories.IClienteRepository;

import java.util.List;


public class ClienteRepository implements IClienteRepository {

    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Cliente> Listar(){
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }
    @Override
    public Cliente getById(Long id){
        return  em.find(Cliente.class, id);
    }
    @Override
    public void insertar(Cliente cliente){
        if(cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        }else {
            em.persist(cliente);
        }
    }
    @Override
    public void eliminar(Long id){
            Cliente cliente = getById(id);
            em.remove(cliente);
    }

    @Override
    public void guardar(Cliente cliente) {

    }
}
