package org.curso.ayi.jpa.app.services.impl;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.entity.Cliente;
import org.curso.ayi.jpa.app.repositories.IClienteRepository;
import org.curso.ayi.jpa.app.repositories.impl.ClienteRepository;
import org.curso.ayi.jpa.app.services.IClienteServices;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl  implements IClienteServices {

    private EntityManager em;
    private IClienteRepository<Cliente> iClienteRepository;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.iClienteRepository = new ClienteRepository(em);
    }
    @Override
    public List<Cliente> getAll(){
        return  iClienteRepository.Listar();
    }


    @Override
    public Optional<Cliente> getById(Long id){
        Optional<Cliente> clienteById;

        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if(clienteById.isPresent()){
            return Optional.of(clienteById.get());
        }else{
            return null;
        }
    }

    @Override
    public void aliminar(Long id){

        Optional<Cliente> clienteById;
        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

         if(clienteById.isPresent()){

             try{
                 em.getTransaction().begin();
                 iClienteRepository.eliminar(id);
                 em.getTransaction().commit();
             }catch(Exception e){
                 em.getTransaction().rollback();
                 e.printStackTrace();
             }finally {
                 em.close();
             }


         } else{
             System.out.println("no se puede borrar");
         }
    }

    @Override
    public void insert(Cliente cliente){

        try {
            em.getTransaction().begin();
            iClienteRepository.guardar(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    public void update(Cliente cliente) {

        if (cliente.getId() > 0 ) {
            Optional<Cliente> clienteById;
            clienteById = Optional.ofNullable(iClienteRepository.getById(cliente.getId()));

            if (clienteById.isPresent()) {
                try {
                    em.getTransaction().begin();
                    iClienteRepository.insertar(cliente);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("El ID no existe");
        }

    }
}
