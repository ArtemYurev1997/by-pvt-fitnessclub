package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import java.math.BigDecimal;
import java.util.List;


public interface OfficeService {

     List<OfficeWithSubselect> getSmallOffices();

     List<BigDecimal> getSmallOfficesPrices();

}
