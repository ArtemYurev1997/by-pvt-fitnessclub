package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import by.pvt.fitnessclub.repository.OfficeDaoRepository;
import by.pvt.fitnessclub.service.OfficeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceDao implements OfficeService {
    private final OfficeDaoRepository officeDaoRepository;

    public OfficeServiceDao(OfficeDaoRepository officeDaoRepository) {
        this.officeDaoRepository = officeDaoRepository;
    }

    public List<OfficeWithSubselect> getSmallOffices() {
        return officeDaoRepository.getSmallOffices();
    }

    public List<BigDecimal> getSmallOfficesPrices() {
        List<OfficeWithSubselect> offices = getSmallOffices();
        List<BigDecimal> prices = offices.stream().map(office -> office.getPrice()).collect(Collectors.toList());
        return prices;
    }
}
