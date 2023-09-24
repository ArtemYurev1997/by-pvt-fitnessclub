package by.pvt.fitnessclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(schema = "testsch", name ="activities")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activities {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Double cost;
    @OneToMany(mappedBy = "activities")
    private List<Office> offices;

}
