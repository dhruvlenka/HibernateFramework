package domain.lenka.com.hibernate_crud_operation_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateLaptopController {
    public static void main(String[] args) {
        //Step:1: Creating EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

        //Step:2: Creating EntityManager
        EntityManager em = emf.createEntityManager();

        //Step:3: Starting the Transaction
        em.getTransaction().begin();

        int id = 345671;
        Laptop laptop = em.find(Laptop.class, id);
        laptop.setRam("16GB"); //updating the RAM in the database
        System.out.println("RAM Updated: " + laptop.getRam());

        em.getTransaction().commit(); //commiting the transaction

        em.close(); //closing entity manager
        emf.close(); //closing entity manager factory

    }
}
