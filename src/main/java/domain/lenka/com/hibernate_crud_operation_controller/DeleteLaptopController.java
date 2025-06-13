package domain.lenka.com.hibernate_crud_operation_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DeleteLaptopController {
    public static void main(String[] args) {
        //Step 1: Creating EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

        //Step 2: Creating EntityManager
        EntityManager em = emf.createEntityManager();

        //Step 3: Starting Transaction
        em.getTransaction().begin();

        //Step 4: Finding the laptop by ID
        int id = 123456;;;
        Laptop laptop = em.find(Laptop.class, id);

        //Step 5: Removing the laptop if it exists
        if(laptop != null){
            em.remove(laptop);
            System.out.println("Laptop with ID: " + id + " is deleted.");
        } else {
            System.out.println("Laptop not found with ID " + id);
        }

        //Step 6: Commiting the Transaction
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
