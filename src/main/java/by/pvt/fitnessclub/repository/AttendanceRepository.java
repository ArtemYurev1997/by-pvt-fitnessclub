package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("select count(a) from Attendance a where a.visitor.id=:visitorId")
    Integer countOfAttendanceByVisitor(@Param("visitorId") Long id);
}
