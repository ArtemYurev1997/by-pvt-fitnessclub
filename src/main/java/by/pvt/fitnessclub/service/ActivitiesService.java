package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.dto.ActivitiesRequest;
import by.pvt.fitnessclub.dto.ActivitiesResponse;
import by.pvt.fitnessclub.dto.ActivitiesUpdateRequest;
import by.pvt.fitnessclub.entity.Activities;

import java.util.List;

public interface ActivitiesService {
    Activities save(ActivitiesRequest activitiesRequest);

    void delete(Long id);

    ActivitiesResponse findById(Long id);

    List<Activities> getAll();

    Activities update(ActivitiesUpdateRequest activitiesUpdateRequest);
}
