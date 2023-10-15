package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;
import by.pvt.fitnessclub.service.AttendanceService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceServiceDao implements AttendanceService {
    private final AttendanceDaoRepository attendanceDaoRepository;

    public AttendanceServiceDao(AttendanceDaoRepository attendanceDaoRepository) {
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
