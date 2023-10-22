package by.pvt.fitnessclub.entity;

import lombok.*;
import org.hibernate.annotations.Where;
import jakarta.persistence.*;
import java.util.List;

@Table(schema = "testsch", name ="user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
//@Where(clause = "status = 'PREMIUM'")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "clientId", cascade = CascadeType.REMOVE)
    private List<RecordsWithFields> recordsWithFields;
}
