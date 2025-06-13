package domain.lenka.com.hibernate_nativeQuery_controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class InsertLaptopController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNativeQuery("INSERT INTO Laptop(id, color, name, price, purchaseDate, ram) VALUES(?,?,?,?,?,?)");
        query.setParameter(1, "954712");
        query.setParameter(2, "Grey");
        query.setParameter(3, "Asus");
        query.setParameter(4, 30000);
        query.setParameter(5,"2025-03-10");
        query.setParameter(6, "8GB");

        int rows = query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        System.out.println("Rows Inseted: " + rows);
    }
}
