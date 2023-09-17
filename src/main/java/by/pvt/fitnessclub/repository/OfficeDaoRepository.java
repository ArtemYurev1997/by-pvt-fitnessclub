package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Office;
import by.pvt.fitnessclub.entity.OfficeWithSubselect;

import java.math.BigDecimal;
import java.util.List;

public interface OfficeDaoRepository {
    void addOffice(Office office);

    void delete(Long id);

    Office findOfficeById(Long id);

    List<Office> getAllOffices();

    List<OfficeWithSubselect> getSmallOffices();

    Office updateCountOfPeople(Long id, Integer maxCount);

    Office updatePriceForHour(Long id, BigDecimal price);

    BigDecimal priceForOffices(Long id);
}
