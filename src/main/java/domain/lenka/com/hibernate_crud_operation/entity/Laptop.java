package domain.lenka.com.hibernate_crud_operation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Laptop {
    @Id
    private int id;
    private String name;
    private String color;
    private double price;
    private String ram;
    private LocalDate purchaseDate;

}
