package by.pvt.fitnessclub.service;

import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;

import java.util.List;

public class ClientService {
    private final ClientDaoRepository clientDaoRepository;

    public ClientService(ClientDaoRepository clientDaoRepository) {
        this.clientDaoRepository = clientDaoRepository;
    }

    public void addClient(Client client) {
        clientDaoRepository.addClient(client);
    }

    public void delete(Long id) {
        clientDaoRepository.delete(id);
    }

    public Client findById(Long id) {
        return clientDaoRepository.findById(id);
    }

    public List<Client> getAllClients() {
        return clientDaoRepository.getAllClients();
    }
}
