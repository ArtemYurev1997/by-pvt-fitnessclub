package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Office;
import by.pvt.fitnessclub.entity.OfficeWithSubselect;
import by.pvt.fitnessclub.repository.OfficeDaoRepository;
import by.pvt.fitnessclub.repository.OfficeRepository;
import by.pvt.fitnessclub.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeServiceDao implements OfficeService {
//    private final OfficeDaoRepository officeDaoRepository;

    private OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceDao(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office save(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public void delete(Long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public Office findById(Long id) {
        Optional<Office> office = Optional.of(officeRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return office.get();
    }

    @Override
    public List<Office> getAll() {
        return officeRepository.findAll();
    }

    public List<OfficeWithSubselect> getSmallOffices() {
//        return officeDaoRepository.getSmallOffices();
        return null;
    }

    public List<BigDecimal> getSmallOfficesPrices() {
        List<OfficeWithSubselect> offices = getSmallOffices();
        List<BigDecimal> prices = offices.stream().map(office -> office.getPrice()).collect(Collectors.toList());
        return prices;
    }
}
