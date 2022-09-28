package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDB;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class JpaEliminar {

    public static void main(String[] args){

        EntityManager em = JpaUtilDB.getEntityManager();

        Scanner s = new Scanner(System.in);
        System.out.println("ingrese el id del cliente: ");
        Long id = s.nextLong();

        try{

            Cliente clienteEliminar = em.find(Cliente.class, id);
            if(clienteEliminar == null){
                System.out.println("objeto cliente nulo");
            }

            em.getTransaction().begin();

            em.remove(clienteEliminar);
            System.out.println("cliente eliminado correctamente");

            em.getTransaction().commit();

        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        }finally {
            em.close();
        }
    }
    }

