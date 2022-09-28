package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDB;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.xml.stream.events.EntityDeclaration;
import java.util.Scanner;

public class JpaPorId {

    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        Scanner s = new Scanner(System.in);

        System.out.println("ingrese el id");
        Long id = s.nextLong();

        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);



        em.close();

    }
}
