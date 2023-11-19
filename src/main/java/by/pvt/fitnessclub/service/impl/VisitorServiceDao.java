package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Visitor;
import by.pvt.fitnessclub.enums.ClientStatus;
import by.pvt.fitnessclub.repository.VisitorRepository;
import by.pvt.fitnessclub.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceDao implements VisitorService {
    private  VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceDao(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor add(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public void delete(Long id) {
        visitorRepository.deleteById(id);
    }

    @Override
    public Visitor findById(Long id) {
        Optional<Visitor> visitor = Optional.of(visitorRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return visitor.get();
    }

    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }

    @Override
    public void update(ClientStatus clientStatus, Long id) {
         visitorRepository.update(clientStatus, id);
    }
}
