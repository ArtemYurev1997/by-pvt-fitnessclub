package by.pvt.fitnessclub.mapper;

import by.pvt.fitnessclub.dto.ActivitiesRequest;
import by.pvt.fitnessclub.dto.ActivitiesResponse;
import by.pvt.fitnessclub.dto.ActivitiesUpdateRequest;
import by.pvt.fitnessclub.entity.Activities;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivitiesMapper {
    ActivitiesResponse toResponse(Activities activities);
    Activities toEntity(ActivitiesRequest activitiesRequest);
    Activities toEntityUpdate(ActivitiesUpdateRequest activitiesUpdateRequest);
}
