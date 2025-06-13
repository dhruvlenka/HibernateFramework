package domain.lenka.com.hibernate_jpql_crud_controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DeleteLaptopController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE FROM Laptop l WHERE l.name = :laptopName");
        query.setParameter("laptopName", "Asus");

        int deletedRows = query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }
}
