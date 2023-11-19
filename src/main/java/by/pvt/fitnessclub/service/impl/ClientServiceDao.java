package by.pvt.fitnessclub.service.impl;

import by.pvt.fitnessclub.dto.ClientRequest;
import by.pvt.fitnessclub.dto.ClientResponse;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.mapper.ClientMapper;
import by.pvt.fitnessclub.repository.ClientRepository;
import by.pvt.fitnessclub.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceDao implements ClientService, UserDetailsService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;
//    private final ClientDaoRepository clientDaoRepository;

    @Autowired
    public ClientServiceDao(ClientRepository clientRepository, ClientMapper clientMapper, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public ClientResponse addClient(ClientRequest clientRequest) {
        if(clientRequest.getLogin() != null) {
            throw new RuntimeException("Логин занят!");
        }
        Client client = clientMapper.toEntity(clientRequest);
        String password = passwordEncoder.encode(client.getPassword());
        client.setPassword(password);
        clientRepository.save(client);
        return clientMapper.toResponse(client);
    }

    public List<ClientResponse> update(ClientRequest clientRequest) {
        Optional<Client> admin = clientRepository.findById(clientRequest.getId());
        String password = passwordEncoder.encode(clientRequest.getPassword());
        if (admin.isPresent()) {
            admin.get().setPassword(password);
            clientRepository.save(admin.get());
        }
        return getAllClients();
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findById(Long id) {
        Optional<Client> client = Optional.of(clientRepository.findById(id).orElseThrow(() -> new RuntimeException("404")));
        return client.get();
    }

    public List<ClientResponse> getAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toResponse).collect(Collectors.toList());
    }

    public List<Client> findByName(String name) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByLogin(username);
    }
}
