package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDB;
import org.curso.ayi.jpa.app.entity.Cliente;
import org.curso.ayi.jpa.app.services.IClienteServices;
import org.curso.ayi.jpa.app.services.impl.ClienteServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDB.getEntityManager();

        IClienteServices service = new ClienteServiceImpl(em);


/*        System.out.println("========== insertar nuevo cliente ===========");
        Cliente cliente = new Cliente();
        cliente.setNombre("Luci");
        cliente.setApellido("Mena");
        cliente.setFormaPago("paypal");
        cliente.setFechaCreacion(LocalDate.now());
        service.insert(cliente);
        System.out.println("cliente guardado con exito");
        service.getAll().forEach(System.out::println);
        System.out.println("========== listar ==========");
        List<Cliente> clientes = service.getAll();
        clientes.forEach(System.out::println);*/

/*        System.out.println("========== obtener por id ==========");
        Optional<Cliente> optionalCliente = service.getById(1L);
        optionalCliente.ifPresent(System.out::println);*/

        System.out.println("=========== editar cliente ==========");
        Cliente cliente = new Cliente();
        cliente.setId(6L);
        cliente.setNombre("Martin");
        cliente.setApellido("Guzman");
        cliente.setFormaPago("Efectivo");
        cliente.setFechaCreacion(LocalDate.now());

        service.insert(cliente);


/*        System.out.println("========== eliminar cliente ===========");
        service.eliminar(7L);*/

        /*//*if (optionalCliente.isPresent()) {
            service.eliminar(id);
        }*/

        em.close();



    }
}
