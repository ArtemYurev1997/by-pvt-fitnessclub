package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Visitor;
import by.pvt.fitnessclub.enums.ClientStatus;

import java.util.List;

public interface VisitorService {
    Visitor add(Visitor visitor);

    void delete(Long id);

    Visitor findById(Long id);

    List<Visitor> getAll();

    void update(ClientStatus clientStatus, Long id);
}
