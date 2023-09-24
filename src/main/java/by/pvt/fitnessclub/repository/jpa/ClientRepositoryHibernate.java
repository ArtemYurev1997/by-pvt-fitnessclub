package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientRepositoryHibernate implements ClientDaoRepository {
    private final SessionFactory sessionFactory;

    public ClientRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
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
        session.close();
        return clients;
    }
}
