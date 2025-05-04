package domain.lenka.com.hibernate_crud_operation_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class InsertLaptopController {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        Laptop laptop = new Laptop();
        laptop.setId(345671);
        laptop.setName("Asus");
        laptop.setColor("Dark Grey");
        laptop.setPrice(53990);
        laptop.setRam("14");
        laptop.setPurchaseDate(LocalDate.parse("2025-04-25"));

        et.begin(); //initiating the transaction
        em.persist(laptop);
        et.commit(); //committing the transaction

    }
}
