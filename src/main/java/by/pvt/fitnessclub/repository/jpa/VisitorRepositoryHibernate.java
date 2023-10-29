package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Visitor;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VisitorRepositoryHibernate {
    @Autowired
    private SessionFactory sessionFactory;

    public VisitorRepositoryHibernate() {
//        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    public Visitor findById(Long id) {
        Session session = sessionFactory.openSession();
        Visitor visitor = session.get(Visitor.class, id);
        return visitor;
    }

    public List<Visitor> findAll() {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visitor> criteriaQuery = criteriaBuilder.createQuery(Visitor.class);
        Root<Visitor> root = criteriaQuery.from(Visitor.class);
        criteriaQuery.select(root);
        List<Visitor> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }


}
