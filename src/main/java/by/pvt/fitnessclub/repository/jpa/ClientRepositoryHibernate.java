package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;
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
public class ClientRepositoryHibernate implements ClientDaoRepository {
    @Autowired
    private  SessionFactory sessionFactory;

    public ClientRepositoryHibernate() {
//        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }


    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.getTransaction().begin();
        session.remove(client);
        session.getTransaction().commit();
    }

    @Override
    public Client findById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("select u from Client u").getResultList();
        return clients;
    }

    public List<Client> findByName(String name) {
        Session session = sessionFactory.openSession();
        List<Client> query = session.createQuery("select c from Client c where c.name=:name").setParameter("name", name).getResultList();
        return query;
    }

    public List<Client> findAll() {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root);
        List<Client> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Client> findAgeByRange(Integer min, Integer max) {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> client = criteriaQuery.from(Client.class);
        criteriaQuery.select(client).where(criteriaBuilder.between(client.get("age"), min, max)).orderBy(criteriaBuilder.asc(client.get("age")));
        List<Client> clientList = entityManager.createQuery(criteriaQuery).getResultList();
        return clientList;
    }




}
