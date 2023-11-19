package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Attendance;

import java.util.List;

public interface AttendanceDaoRepository {
    void addAttendance(Attendance attendance);

    void delete(Long id);

    Attendance findById(Long id);

    List<Attendance> getAllAttendances();
}
