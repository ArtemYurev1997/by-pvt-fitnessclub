package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.RecordsWithFields;

import java.util.List;

public interface RecordsService {
    RecordsWithFields save(RecordsWithFields recordsWithFields, Long id);

    void delete(Long id);

    RecordsWithFields findById(Long id);

    List<RecordsWithFields> getAll();
}
