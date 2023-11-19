package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Attendance;

import java.util.List;

public interface AttendanceService {

     Attendance save(Long activityId, Long visitorId);

    void delete(Long id);

    Attendance findById(Long id);

    public List<Attendance> getAll();

    Integer countOfAttendanceByVisitor(Long id);
}
