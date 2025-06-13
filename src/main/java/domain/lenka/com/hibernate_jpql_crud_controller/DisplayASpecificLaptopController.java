package domain.lenka.com.hibernate_jpql_crud_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DisplayASpecificLaptopController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

        Query query = em.createQuery("SELECT a FROM Laptop a WHERE a.price=?1");
        query.setParameter(1, 67000);

        try {
            //fetching a single entity(unique) result
            Laptop laptop = (Laptop) query.getSingleResult();
            System.out.println(laptop);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is no product with this price.");
        }
    }
}
