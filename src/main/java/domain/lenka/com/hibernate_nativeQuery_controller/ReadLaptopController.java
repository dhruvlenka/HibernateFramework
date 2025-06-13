package domain.lenka.com.hibernate_nativeQuery_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;

public class ReadLaptopController {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM Laptop", Laptop.class);

        List<Laptop> laptops = query.getResultList();
        for(Laptop laptop: laptops){
            System.out.println(laptop);
        }

    }
}
