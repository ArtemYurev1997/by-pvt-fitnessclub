package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Visitor;
import by.pvt.fitnessclub.enums.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    @Modifying
    @Query("update Visitor v set v.status=:status where v.id=:id")
    void update(@Param("status") ClientStatus clientStatus, @Param("id") Long id);

}
