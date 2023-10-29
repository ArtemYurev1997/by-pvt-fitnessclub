package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.repository.ActivitiesRepository;
import by.pvt.fitnessclub.service.ActivitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivitiesServiceDao implements ActivitiesService {
    private final ActivitiesRepository activitiesRepository;

    @Override
    public Activities save(Activities activities) {
        return activitiesRepository.save(activities);
    }

    @Override
    public void delete(Long id) {
        activitiesRepository.deleteById(id);
    }

    @Override
    public Activities findById(Long id) {
        Optional<Activities> activity = Optional.of(activitiesRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return activity.get();
    }

    @Override
    public List<Activities> getAll() {
        return activitiesRepository.findAll();
    }
}
