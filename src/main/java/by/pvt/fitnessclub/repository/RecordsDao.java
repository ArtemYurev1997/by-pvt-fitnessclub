package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.RecordsWithFields;

public interface RecordsDao {
    void addRecords(RecordsWithFields recordsWithFields);

    void delete(Long id);
}
