package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.*;
import by.pvt.fitnessclub.repository.OfficeDaoRepository;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class OfficeRepositoryHibernate implements OfficeDaoRepository {
    private final SessionFactory sessionFactory;

    public OfficeRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfiguration.getSessionFactory();
    }

    @Override
    public void addOffice(Office office) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    public void addOfficeWithInventoryNumber(Long id, Long inventoryNumber) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.detach(office);
        office.setId(null);
        session.getTransaction().begin();
        office.setInventoryNumber(inventoryNumber);
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        session.getTransaction().begin();
        session.remove(office);
        session.getTransaction().commit();
    }

    @Override
    public Office findOfficeById(Long id) {
        Session session = sessionFactory.openSession();
        Office office = session.find(Office.class, id);
        return office;
    }

    @Override
    public List<Office> getAllOffices() {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select o from Office o");
        return (List<Office>) query.getResultList();
    }

    public Office updateCountOfPeople(Long id, Integer maxCount) {
        Session session = sessionFactory.openSession();
        Office office = session.find(Office.class, id);
        session.getTransaction().begin();
        office.setMaxCount(maxCount);
        session.update(office);
        session.getTransaction().commit();
        return office;
    }

    public Office updatePriceForHour(Long id, BigDecimal price) {
        Session session = sessionFactory.openSession();
        Office office = session.find(Office.class, id);
        session.getTransaction().begin();
        office.setPrice(price);
        session.update(office);
        session.getTransaction().commit();
        return office;
    }

    public BigDecimal priceForOffices(Long id) {
        Session session = sessionFactory.openSession();
        Office office = session.find(Office.class, id);
        BigDecimal price = office.getPrice();
        return price;
    }

    public List<OfficeWithSubselect> getSmallOffices() {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select os from OfficeWithSubselect os");
        return (List<OfficeWithSubselect>) query.getResultList();
    }

    public Integer getAllCountOfPeopleInComplex() {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        criteriaQuery.select(criteriaBuilder.sum(criteriaQuery.from(Office.class).get("maxCount")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<Office> findMaxCountAndPrice(Integer count, BigDecimal price) {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.select(office).where(criteriaBuilder.and(criteriaBuilder.equal(office.get("maxCount"), count), criteriaBuilder.equal(office.get("price"), price)));
        List<Office> offices = entityManager.createQuery(criteriaQuery).getResultList();
        return offices;
    }

    public void getAllOfficesAndAllActivitiesAndOfficeById(Long activityId) {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("select a from Employee a").getResultList();
        List<Activities> activities = session.createQuery("select a from Activities a").getResultList();
        session.close();
        Session session1 = sessionFactory.openSession();
        Activities activity = session1.get(Activities.class, activityId);
        session1.close();

    }


}
