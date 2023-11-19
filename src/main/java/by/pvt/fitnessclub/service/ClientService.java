package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.dto.ClientRequest;
import by.pvt.fitnessclub.dto.ClientResponse;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;

import java.util.List;

public interface ClientService {
     ClientResponse addClient(ClientRequest clientRequest);

     void delete(Long id);

    List<ClientResponse> update(ClientRequest clientRequest);

     Client findById(Long id);

     List<ClientResponse> getAllClients();

    List<Client> findByName(String name);
}
