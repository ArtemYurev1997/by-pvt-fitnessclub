package by.pvt.fitnessclub.mapper;

import by.pvt.fitnessclub.dto.ClientResponse;
import by.pvt.fitnessclub.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientResponse toResponse(Client client);
}
