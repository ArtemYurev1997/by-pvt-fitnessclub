package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Activities;

import java.util.List;

public interface ActivitiesService {
    Activities save(Activities activities);

    void delete(Long id);

    Activities findById(Long id);

    List<Activities> getAll();
}
