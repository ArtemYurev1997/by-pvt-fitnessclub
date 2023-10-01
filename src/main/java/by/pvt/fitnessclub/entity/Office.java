package by.pvt.fitnessclub.entity;

import by.pvt.fitnessclub.enums.OfficeStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(schema = "testsch", name ="office")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "inventory_number", nullable = false)
    private Long inventoryNumber;
    @Column(name = "max_count_of_people")
    private Integer maxCount;
    @Column(name = "office_status")
    @Enumerated(EnumType.STRING)
    private OfficeStatus officeStatus;
    @Column(name = "price")
    private BigDecimal price;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "activities_id")
    private Activities activities;
    @OneToMany(mappedBy = "officeId")
    private List<RecordsWithFields> recordsWithFields;

    public Office(String name, Long inventoryNumber, Integer maxCount, OfficeStatus officeStatus, BigDecimal price) {
        this.name = name;
        this.inventoryNumber = inventoryNumber;
        this.maxCount = maxCount;
        this.officeStatus = officeStatus;
        this.price = price;
    }
}
