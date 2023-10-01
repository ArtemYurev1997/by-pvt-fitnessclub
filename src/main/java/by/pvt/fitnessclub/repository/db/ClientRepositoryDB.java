package by.pvt.fitnessclub.repository.db;

import by.pvt.fitnessclub.config.HibernateConfiguration;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientRepositoryDB implements ClientDaoRepository {
    public void addClient(Client client) {
        EntityManager entityManager = HibernateConfiguration.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = HibernateConfiguration.getEntityManager();
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Client findById(Long id) {
        EntityManager entityManager = HibernateConfiguration.getEntityManager();
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        EntityManager entityManager = HibernateConfiguration.getEntityManager();
        List<Client> clients = entityManager.createQuery("select c from Client c").getResultList();
        entityManager.close();
        return clients;
    }

    @Override
    public List<Client> findByName(String name) {
        return null;
    }

}
