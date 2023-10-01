package by.pvt.fitnessclub.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConfiguration {
    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ClientJpa");
        return entityManagerFactory.createEntityManager();
    }
}
