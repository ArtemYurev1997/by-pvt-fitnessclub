package by.pvt.fitnessclub.entity;


import by.pvt.fitnessclub.enums.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(schema = "testsch", name ="visitor")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "person_visitor_id")
public class Visitor extends Client {
    @Column(name = "first_visit")
    private LocalDate firstVisit;
    @Column(name = "last_visit")
    private LocalDate lastVisit;
    @Column(name = "telephone_number")
    private String telephone;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    @Column(name = "amount_spent")
    private Double amountSpent;
    @OneToMany(mappedBy = "visitor")
    private List<Attendance> attendances;

}
