package by.pvt.fitnessclub.config;

import jakarta.persistence.*;


public class HibernateConfiguration {
    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ClientJpa");
        return entityManagerFactory.createEntityManager();
    }
}
