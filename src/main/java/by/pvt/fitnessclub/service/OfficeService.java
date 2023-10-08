package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import by.pvt.fitnessclub.repository.OfficeDaoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OfficeService {
    private final OfficeDaoRepository officeDaoRepository;

    public OfficeService(OfficeDaoRepository officeDaoRepository) {
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
