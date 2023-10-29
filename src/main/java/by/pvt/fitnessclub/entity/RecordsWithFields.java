package by.pvt.fitnessclub.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Table(schema = "testsch", name ="records")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecordsWithFields {
    @Id
    @SequenceGenerator(name = "seq_records", sequenceName = "records_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_records")
    @Column(name = "id")
    private Long id;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office officeId;
    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

}
