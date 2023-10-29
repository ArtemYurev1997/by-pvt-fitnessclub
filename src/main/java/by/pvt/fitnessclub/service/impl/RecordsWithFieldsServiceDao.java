package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.RecordsWithFields;
import by.pvt.fitnessclub.entity.Visitor;
import by.pvt.fitnessclub.enums.ClientStatus;
import by.pvt.fitnessclub.repository.RecordsDao;
import by.pvt.fitnessclub.service.AttendanceService;
import by.pvt.fitnessclub.service.RecordsService;
import by.pvt.fitnessclub.service.VisitorService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecordsWithFieldsServiceDao implements RecordsService {

    private RecordsDao recordsDao;
    private AttendanceService attendanceService;
    private VisitorService visitorService;
    private SessionFactory sessionFactory;

    @Autowired
    public RecordsWithFieldsServiceDao(RecordsDao recordsDao, AttendanceService attendanceService, VisitorService visitorService, SessionFactory sessionFactory) {
        this.recordsDao = recordsDao;
        this.attendanceService = attendanceService;
        this.visitorService = visitorService;
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public RecordsWithFields save(RecordsWithFields recordsWithFields, Long id) {
        if(attendanceService.countOfAttendanceByVisitor(id) > 1) {
            Visitor visitor = visitorService.findById(id);
            visitor.setStatus(ClientStatus.PREMIUM);
            visitorService.add(visitor);
            return recordsDao.save(recordsWithFields);
        }
        else {
            throw new RuntimeException("Ошибка транзакции!");
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        recordsDao.deleteById(id);
    }

    @Override
    public RecordsWithFields findById(Long id) {
        Optional<RecordsWithFields> record = Optional.of(recordsDao.findById(id).orElseThrow(() -> new RuntimeException("Error!")));
        return record.get();
    }

    @Override
    public List<RecordsWithFields> getAll() {
        return recordsDao.findAll();
    }
}