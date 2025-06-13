package domain.lenka.com.hibernate_jpql_crud_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UpdatingPriceUsingNameController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("UPDATE Laptop l SET l.price = :newPrice WHERE l.name = :laptopName");
        query.setParameter("newPrice", 53990);
        query.setParameter("laptopName", "Asus");

        int rowsUpdated = query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("Rows Updated: " + rowsUpdated);



    }
}
