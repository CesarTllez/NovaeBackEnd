package com.company.novae.controller;

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
    public Set<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") Long id) {
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
}
