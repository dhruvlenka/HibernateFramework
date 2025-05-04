package domain.lenka.com.hibernate_crud_operation_controller;

import domain.lenka.com.hibernate_crud_operation.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class ReadLaptopController {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the laptop you want to read: ");
        int id = sc.nextInt();

        Laptop laptop = em.find(Laptop.class, id);
        if(laptop != null){
            System.out.println("Laptop ID: " + laptop.getId());
            System.out.println("Laptop Name: " + laptop.getName());
            System.out.println("Laptop Color: " + laptop.getColor());
            System.out.println("Laptop Price: " + laptop.getPrice());
            System.out.println("Laptop Price: " + laptop.getRam());
            System.out.println("Laptop Purchase Date: " + laptop.getPurchaseDate() + "\n");

        } else {
            System.out.println("Laptop not found with ID " + id);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
