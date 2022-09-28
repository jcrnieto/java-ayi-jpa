package org.curso.ayi.jpa.app;

import jakarta.persistence.EntityManager;
import org.curso.ayi.jpa.app.configuration.JpaUtilDB;
import org.curso.ayi.jpa.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JpaEditar {

    public static void main(String[] args){

        EntityManager em = JpaUtilDB.getEntityManager();

        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("ingrese el id del cliente a modificar"));
            Cliente c = em.find(Cliente.class, id);

            if(c == null) {
                System.out.println("objeto cliente nulo");
            }else{
                String nombre = JOptionPane.showInputDialog("ingrese el nombre");
                String apellido = JOptionPane.showInputDialog("ingrese el apellido");
                String pago = JOptionPane.showInputDialog("ingrese el pago");


                em.getTransaction().begin();

                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setFormaPago(pago);
                c.setFechaCreacion(LocalDate.now());
                System.out.println("id del cliente: " + c.getId());
                em.merge(c);
                System.out.println("cliente actualizado" + c.toString());

                em.getTransaction().commit();

            }


        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.getMessage();
        }finally {
            em.close();
        }
    }
}
