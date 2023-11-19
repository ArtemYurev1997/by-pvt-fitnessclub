package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.RecordsWithFields;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsDao extends JpaRepository<RecordsWithFields, Long> {

}
