package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;

import java.util.List;

public interface AttendanceService {

     void addAttendance(Attendance attendance);


    void delete(Long id);

    Attendance findById(Long id);

    public List<Attendance> getAllActivities();
}
