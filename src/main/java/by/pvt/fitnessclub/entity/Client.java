package by.pvt.fitnessclub.entity;

import by.pvt.fitnessclub.enums.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Table(schema = "testsch", name ="user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "status = 'PREMIUM'")
public class Client {
    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "telephone_number")
    private String telephone;
    @Column(name = "last_visit")
    private LocalDate lastVisit;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    @Column(name = "amount_spent")
    private Double amountSpent;
    @Embedded
    private Address address;
}
