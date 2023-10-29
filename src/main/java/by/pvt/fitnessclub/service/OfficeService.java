package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Office;
import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import java.math.BigDecimal;
import java.util.List;


public interface OfficeService {
     Office save(Office office);

     void delete(Long id);

     Office findById(Long id);

     List<Office> getAll();

     List<OfficeWithSubselect> getSmallOffices();

     List<BigDecimal> getSmallOfficesPrices();
}
