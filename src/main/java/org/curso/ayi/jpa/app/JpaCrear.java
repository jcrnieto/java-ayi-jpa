package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDB;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JpaCrear {
    public static void main(String[] args){

        EntityManager em = JpaUtilDB.getEntityManager();

        try{

            String nombre = JOptionPane.showInputDialog("ingrese el nombre");
            String apellido = JOptionPane.showInputDialog("ingrese el apellido");
            String pago = JOptionPane.showInputDialog("ingrese el pago");


            em.getTransaction().begin();

            Cliente clienteInsertar = new Cliente();
            clienteInsertar.setNombre(nombre);
            clienteInsertar.setApellido(apellido);
            clienteInsertar.setFormaPago(pago);
            clienteInsertar.setFechaCreacion(LocalDate.now());

            em.persist(clienteInsertar);

            System.out.println("cliente guardado satisfactoriamente en base de datos");

            em.getTransaction().commit();

        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        }finally {
            em.close();
        }
    }
}
