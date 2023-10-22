package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.RecordsWithFields;
import by.pvt.fitnessclub.repository.GenericRepository;

public class RecordsWithFieldsServiceDao {
    private final GenericRepository<RecordsWithFields> recordsDao;

    public RecordsWithFieldsServiceDao(GenericRepository<RecordsWithFields> recordsDao) {
        this.recordsDao = recordsDao;
    }

    public void add(RecordsWithFields recordsWithFields) {
        recordsDao.add(recordsWithFields);
    }
}