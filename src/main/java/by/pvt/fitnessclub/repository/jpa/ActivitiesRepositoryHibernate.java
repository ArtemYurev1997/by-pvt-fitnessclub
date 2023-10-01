package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.repository.ActivitiesDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<Activities> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Activities> criteriaQuery = criteriaBuilder.createQuery(Activities.class);
        //Root указывает целевой класс, откуда будет делаться выборка (альтернатива jpql: from Employee e)
        Root<Activities> root = criteriaQuery.from(Activities.class);
        //Если склеить всё это получиться: select e from Employee e
        criteriaQuery.select(root);
        List<Activities> activitiesList = entityManager.createQuery(criteriaQuery).getResultList();
        return activitiesList;
    }

    public Double getActivityMinSalary() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
        criteriaQuery.select(criteriaBuilder.min(criteriaQuery.from(Activities.class).get("cost")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }


}
