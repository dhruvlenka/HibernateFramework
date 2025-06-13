package domain.lenka.com.hibernate_unidirectional_mapping.onetoone.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class Person {
    @Id
    private int id;
    private String name;
    private String email;
    private int mobileNumber;

    @OneToOne
    private Pan pan;
}
