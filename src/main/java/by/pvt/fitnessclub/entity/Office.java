package by.pvt.fitnessclub.entity;

import by.pvt.fitnessclub.enums.OfficeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Office(String name, Long inventoryNumber, Integer maxCount, OfficeStatus officeStatus, BigDecimal price) {
        this.name = name;
        this.inventoryNumber = inventoryNumber;
        this.maxCount = maxCount;
        this.officeStatus = officeStatus;
        this.price = price;
    }
}
