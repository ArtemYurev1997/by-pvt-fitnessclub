package by.pvt.fitnessclub.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(schema = "testsch", name ="attendance")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    @SequenceGenerator(name = "seq_attendance", sequenceName = "attendance_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_attendance")
    @Column(name = "id")
    private Long id;
    @Column(name = "date_of_visit")
    private LocalDate dateOfVisit;
    @Column(name = "amount_spent")
    private BigDecimal amountSpent;
    @Column(name = "activity_id")
    private Long activityId;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;
}
