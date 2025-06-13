package domain.lenka.com.hibernate_unidirectional_mapping.onetoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pan {
    @Id
    private String panNumber;
    private String name;
    private LocalDate dob;
}
