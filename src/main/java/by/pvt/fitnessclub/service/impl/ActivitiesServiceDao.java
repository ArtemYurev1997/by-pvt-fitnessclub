package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.dto.ActivitiesRequest;
import by.pvt.fitnessclub.dto.ActivitiesResponse;
import by.pvt.fitnessclub.dto.ActivitiesUpdateRequest;
import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.mapper.ActivitiesMapper;
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
    private final ActivitiesMapper activitiesMapper;

    @Override
    public Activities save(ActivitiesRequest activitiesRequest) {
        return activitiesRepository.save(activitiesMapper.toEntity(activitiesRequest));
    }

    @Override
    public void delete(Long id) {
        activitiesRepository.deleteById(id);
    }

    @Override
    public ActivitiesResponse findById(Long id) {
        Optional<Activities> activity = Optional.of(activitiesRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return activitiesMapper.toResponse(activity.get());
    }

    @Override
    public List<Activities> getAll() {
        return activitiesRepository.findAll();
    }

    @Override
    public Activities update(ActivitiesUpdateRequest activitiesUpdateRequest) {
        return activitiesRepository.save(activitiesMapper.toEntityUpdate(activitiesUpdateRequest));
    }
}
