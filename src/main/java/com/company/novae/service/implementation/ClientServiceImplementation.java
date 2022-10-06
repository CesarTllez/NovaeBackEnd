package com.company.novae.service.implementation;

import com.company.novae.entity.Client;
import com.company.novae.exceptions.NotFoundException;
import com.company.novae.repository.IClientRepository;
import com.company.novae.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImplementation implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Set<Client> findAll() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client findById(Long id) {
        if (clientRepository.findById(id).isPresent())
            return clientRepository.findById(id).get();
        throw new NotFoundException();
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    @Override
    public void updateById(Client client) {
        clientRepository.updateById(client.getId(), client.getName(), client.getEmail());
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
