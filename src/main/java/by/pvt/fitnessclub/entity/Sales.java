package by.pvt.fitnessclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(schema = "testsch", name ="sales")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
        @Id
        @GeneratedValue
        @Column(name = "id")
        private Long id;
        @Column(name = "value")
        private BigDecimal value;
        @Column(name = "start")
        private LocalDate start;
        @Column(name = "end")
        private LocalDate end;
        @Column(name = "status")
        private String status;
}
