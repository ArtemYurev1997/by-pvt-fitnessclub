package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;

import java.util.List;

public class AttendanceService {
    private final AttendanceDaoRepository attendanceDaoRepository;

    public AttendanceService(AttendanceDaoRepository attendanceDaoRepository) {
        this.attendanceDaoRepository = attendanceDaoRepository;
    }

    public void addAttendance(Attendance attendance) {
        attendanceDaoRepository.addAttendance(attendance);
    }

    public void delete(Long id) {
        attendanceDaoRepository.delete(id);
    }

    public Attendance findById(Long id) {
        return attendanceDaoRepository.findById(id);
    }

    public List<Attendance> getAllActivities() {
        return attendanceDaoRepository.getAllAttendances();
    }
}
