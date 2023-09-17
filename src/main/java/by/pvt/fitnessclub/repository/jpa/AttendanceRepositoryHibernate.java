package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AttendanceRepositoryHibernate implements AttendanceDaoRepository {
    private final SessionFactory sessionFactory;

    public AttendanceRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    @Override
    public void addAttendance(Attendance attendance) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(attendance);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Attendance attendance = session.get(Attendance.class, id);
        session.getTransaction().begin();
        session.remove(attendance);
        session.getTransaction().commit();
    }

    @Override
    public Attendance findById(Long id) {
        Session session = sessionFactory.openSession();
        Attendance attendance = session.get(Attendance.class, id);
        return attendance;
    }

    @Override
    public List<Attendance> getAllAttendances() {
        Session session = sessionFactory.openSession();
        List<Attendance> attendances = session.createQuery("select a from Attendance a").getResultList();
        session.close();
        return attendances;
    }
}
