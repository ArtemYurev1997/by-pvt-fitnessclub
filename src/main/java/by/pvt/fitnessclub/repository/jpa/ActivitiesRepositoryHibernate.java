package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.repository.ActivitiesDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ActivitiesRepositoryHibernate implements ActivitiesDaoRepository {
    private final SessionFactory sessionFactory;

    public ActivitiesRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    @Override
    public void addActivities(Activities activities) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(activities);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Activities activities = session.get(Activities.class, id);
        session.getTransaction().begin();
        session.remove(activities);
        session.getTransaction().commit();
    }

    @Override
    public Activities findById(Long id) {
        Session session = sessionFactory.openSession();
        Activities activities = session.find(Activities.class, id);
        return activities;
    }

    @Override
    public List<Activities> getAllActivities() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select a from Activities a");
        return (List<Activities>) query.getResultList();
    }
}
