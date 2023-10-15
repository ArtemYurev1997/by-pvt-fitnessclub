package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Visitor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VisitorRepositoryHibernate {
    private final SessionFactory sessionFactory;

    public VisitorRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    public Visitor findById(Long id) {
        Session session = sessionFactory.openSession();
        Visitor visitor = session.get(Visitor.class, id);
        return visitor;
    }

    public List<Visitor> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitor> criteriaQuery = criteriaBuilder.createQuery(Visitor.class);
        Root<Visitor> root = criteriaQuery.from(Visitor.class);
        criteriaQuery.select(root);
        List<Visitor> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }


}
