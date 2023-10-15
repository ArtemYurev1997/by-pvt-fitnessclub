package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;
import by.pvt.fitnessclub.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class ClientServiceDao implements ClientService {

    private final ClientDaoRepository clientDaoRepository;

    public ClientServiceDao(ClientDaoRepository clientDaoRepository) {
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

    public List<Client> findByName(String name) {
        return clientDaoRepository.findByName(name);
    }
}
