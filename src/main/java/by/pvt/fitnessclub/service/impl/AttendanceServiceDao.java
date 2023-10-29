package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;
import by.pvt.fitnessclub.repository.AttendanceRepository;
import by.pvt.fitnessclub.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceDao implements AttendanceService {
//    private final AttendanceDaoRepository attendanceDaoRepository;
    private AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceDao(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void delete(Long id) {
        attendanceRepository.deleteById(id);
    }

    public Attendance findById(Long id) {
       Optional<Attendance> attendance = Optional.of(attendanceRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
       return attendance.get();
    }

    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    public Integer countOfAttendanceByVisitor(Long id) {
        return attendanceRepository.countOfAttendanceByVisitor(id);
    }
}
