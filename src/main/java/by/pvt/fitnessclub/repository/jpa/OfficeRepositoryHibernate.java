package by.pvt.fitnessclub.repository.jpa;

import by.pvt.fitnessclub.config.HibernateJavaConfiguration;
import by.pvt.fitnessclub.entity.Office;
import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import by.pvt.fitnessclub.repository.OfficeDaoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

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
        Query query = session.createQuery("select o from Office o");
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
        Query query = session.createQuery("select os from OfficeWithSubselect os");
        return (List<OfficeWithSubselect>) query.getResultList();
    }
}
