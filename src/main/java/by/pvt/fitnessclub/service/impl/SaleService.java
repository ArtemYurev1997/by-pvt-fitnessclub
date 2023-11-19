package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Sales;
import by.pvt.fitnessclub.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private SalesRepository salesRepository;

    @Autowired
    public SaleService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public Sales save(Sales sale) {
        Sales sales = salesRepository.save(sale);
        return sales;
    }

    public void delete(Long id) {
        salesRepository.deleteById(id);
    }

    public Sales findById(Long id) {
        Optional<Sales> sales = Optional.of(salesRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return sales.get();
    }

    public List<Sales> getAll() {
        return salesRepository.findAll();
    }
}
