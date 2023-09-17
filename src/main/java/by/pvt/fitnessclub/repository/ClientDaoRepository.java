package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Client;

import java.util.List;

public interface ClientDaoRepository {
    void addClient(Client client);

    void delete(Long id);

    Client findById(Long id);

    List<Client> getAllClients();
}
