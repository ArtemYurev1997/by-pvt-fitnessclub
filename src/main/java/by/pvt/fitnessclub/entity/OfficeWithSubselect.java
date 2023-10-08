package by.pvt.fitnessclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Subselect("select o.id as id, o.name as name, o.inventory_number as inventory, o.price as price from testsch.office o")
@Data
@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
public class OfficeWithSubselect {
    @Id
    private Long id;
    private String name;
    private Long inventory;
    private BigDecimal price;
}
