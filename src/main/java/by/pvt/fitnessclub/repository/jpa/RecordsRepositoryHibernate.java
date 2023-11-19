package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.RecordsWithFields;
import by.pvt.fitnessclub.repository.GenericRepository;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordsRepositoryHibernate implements GenericRepository<RecordsWithFields> {
    @Autowired
    private SessionFactory sessionFactory;

    public RecordsRepositoryHibernate() {
//        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }


    public void addRecords(RecordsWithFields recordsWithFields) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(recordsWithFields);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(RecordsWithFields recordsWithFields) {
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

    @Override
    public RecordsWithFields findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.find(RecordsWithFields.class, id);
    }

    @Override
    public List<RecordsWithFields> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select r from RecordsWithFields r", RecordsWithFields.class).getResultList();
    }


}
