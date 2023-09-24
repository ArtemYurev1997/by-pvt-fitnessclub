package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Activities;

import java.util.List;

public interface ActivitiesDaoRepository {
    void addActivities(Activities activities);

    void delete(Long id);

    Activities findById(Long id);

    List<Activities> getAllActivities();
}
