package by.pvt.fitnessclub.dto;

import lombok.Data;

@Data
public class ActivitiesUpdateRequest {
    private Long id;
    private String name;
    private Double cost;
}
