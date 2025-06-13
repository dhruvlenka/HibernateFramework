package domain.lenka.com.hibernate_jpql_crud_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DisplayAllLaptopController {
    public static void main(String[] args) {
        //Method Chaining
        EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

        Query query = em.createQuery("from Laptop"); //it will run the query and will access the data from Laptop Entity

        List<Laptop> laptopList = query.getResultList(); //getResultList: it will fetch multiple results

        if(!laptopList.isEmpty()){
            for (Laptop laptop: laptopList){
                System.out.println(laptop);
            }
        }

    }
}
