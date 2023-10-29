package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.repository.ClientDaoRepository;
import by.pvt.fitnessclub.repository.ClientRepository;
import by.pvt.fitnessclub.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ClientServiceDao implements ClientService {
    private ClientRepository clientRepository;
//    private final ClientDaoRepository clientDaoRepository;

    @Autowired
    public ClientServiceDao(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findById(Long id) {
        Optional<Client> client = Optional.of(clientRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return client.get();
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> findByName(String name) {
        return null;
    }
}
