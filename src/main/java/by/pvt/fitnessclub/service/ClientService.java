package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;

import java.util.List;

public interface ClientService {
     void addClient(Client client);

     void delete(Long id);

     Client findById(Long id);

     List<Client> getAllClients();

    List<Client> findByName(String name);
}
