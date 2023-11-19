package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Employee;
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
public class EmployeeRepositoryHibernate {
    @Autowired
    private  SessionFactory sessionFactory;

    public EmployeeRepositoryHibernate() {
//        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    public List<Employee> findByMaxSalary() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("select e from Employee e where e.salary=(select max(e1.salary) from Employee e1)").getResultList();
        return employees;
    }

    public List<Employee> findByMinSalary() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("select e from Employee e where e.salary=(select min(e1.salary) from Employee e1)").getResultList();
        return employees;
    }

    public List<Employee> findAll() {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }


}
