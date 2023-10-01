package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.RecordsWithFields;
import by.pvt.fitnessclub.repository.RecordsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecordsRepositoryHibernate implements RecordsDao {
    private final SessionFactory sessionFactory;

    public RecordsRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    @Override
    public void addRecords(RecordsWithFields recordsWithFields) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(recordsWithFields);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        RecordsWithFields records = session.get(RecordsWithFields.class, id);
        session.getTransaction().begin();
        session.remove(records);
        session.getTransaction().commit();
    }
}
