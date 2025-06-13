package domain.lenka.com.hibernate_jpql_crud_controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UpdateLaptopController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

        Query query = em.createQuery("UPDATE Laptop e SET e.price = e.price + 3000 WHERE e.price = :oldPrice");
        /*

         */
        query.setParameter("oldPrice", 67000);

        em.getTransaction().begin();
        int updated = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        System.out.println("Update rows: " + updated);
    }
}
