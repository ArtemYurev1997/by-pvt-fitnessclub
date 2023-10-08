package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Attendance;
import by.pvt.fitnessclub.entity.Visitor;
import by.pvt.fitnessclub.repository.AttendanceDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class AttendanceRepositoryHibernate implements AttendanceDaoRepository {
    private final SessionFactory sessionFactory;
    private final VisitorRepositoryHibernate visitorRepositoryHibernate;

    public AttendanceRepositoryHibernate(VisitorRepositoryHibernate visitorRepositoryHibernate) {
        this.visitorRepositoryHibernate = visitorRepositoryHibernate;
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

    public List<Attendance> findSumByDate(LocalDate start, LocalDate end) {
        Session session = sessionFactory.openSession();
        List<Attendance> attendances = session.createQuery("select sum(a.amountSpent) from Attendance a where a.dateOfVisit>=:start " +
                "and a.dateOfVisit<=:end").setParameter("start", start).setParameter("end", end).getResultList();
        return attendances;
    }

    public Attendance updateVisitorId(Long id, Long visitorId) {
        Session session = sessionFactory.openSession();
        Attendance attendance = session.find(Attendance.class, id);
        Visitor visitor =  visitorRepositoryHibernate.findById(visitorId);
        session.getTransaction().begin();
        attendance.setVisitor(visitor);
        session.update(attendance);
        session.getTransaction().commit();
        return attendance;
    }

    public List<Attendance> findNameAndAgeVisitors(String name, Integer age) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Attendance> criteriaQuery = criteriaBuilder.createQuery(Attendance.class);
        Root<Attendance> attendance = criteriaQuery.from(Attendance.class);
        Join<Attendance, Visitor> visitor = attendance.join("visitor");
        criteriaQuery.select(attendance).where(criteriaBuilder.and(criteriaBuilder.equal(visitor.get("name"), name), criteriaBuilder.equal(visitor.get("age"), age)));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
