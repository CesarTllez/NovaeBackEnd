package com.company.novae.controller;

import com.company.novae.dto.ClientDto;
import com.company.novae.entity.Client;
import com.company.novae.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping
    public Set<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Client client) {
        clientService.create(client);
    }

    @PutMapping
    public void update(@RequestBody Client client) {
        clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }

    @GetMapping("/{id}/cards")
    public Client findByIdWithCards(@PathVariable("id") Long id) {
        return clientService.findByIdWithCards(id);
    }

    @PutMapping("/stored-process")
    public void updateClientWithStoredProcess(@RequestBody Client client){
        clientService.updateClientWithStoredProcess(client);
    }
}
