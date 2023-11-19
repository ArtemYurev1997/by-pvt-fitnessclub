package by.pvt.fitnessclub.controller;

import by.pvt.fitnessclub.dto.ClientRequest;
import by.pvt.fitnessclub.dto.ClientResponse;
import by.pvt.fitnessclub.entity.Client;
import by.pvt.fitnessclub.mapper.ClientMapper;
import by.pvt.fitnessclub.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/getAll")
    public List<ClientResponse> findAll() {
        return clientService.getAllClients();
    }

    @PostMapping("/addClient")
    public ClientResponse add(@RequestBody ClientRequest clientRequest) {
        return clientService.addClient(clientRequest);
    }

    @PostMapping("/updateClient")
    public List<ClientResponse> update(@RequestBody ClientRequest clientRequest) {
        return clientService.update(clientRequest);
    }
}
