package by.pvt.fitnessclub.entity;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(schema = "testsch", name ="employee")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "person_employee_id")
public class Employee extends Client {
    @Column(name = "date_enter")
    private LocalDate dateEnter;
    @Column(name = "date_exit")
    private LocalDate dateExit;
    @Column(name = "post")
    private String post;
    @Column(name = "amount_spent")
    private BigDecimal salary;

}
