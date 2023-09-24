package by.pvt.fitnessclub.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Table(schema = "testsch", name ="user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
