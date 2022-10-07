package com.company.novae.service.implementation;

import com.company.novae.dto.ClientDto;
import com.company.novae.entity.Client;
import com.company.novae.exceptions.NotFoundException;
import com.company.novae.repository.IClientRepository;
import com.company.novae.service.IClientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ClientServiceImplementation implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Set<ClientDto> findAll() {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(
                clientRepository.findAll(),
                new TypeToken<Set<ClientDto>>() {}.getType());
    }

    @Override
    public ClientDto findById(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(clientRepository.findById(id).get(), ClientDto.class);
        }
        throw new NotFoundException("");
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    @Override
    public void update(Client client) {
        if (clientRepository.countById(client.getId()) == 1)
            clientRepository.update(client.getId(), client.getDni(), client.getName(), client.getEmail());
        else throw new NotFoundException("");
    }

    @Override
    public void deleteById(Long id) {
        if (clientRepository.countById(id) == 1) clientRepository.deleteById(id);
        else throw new NotFoundException("");
    }

    @Override
    public Client findByIdWithCards(Long id) {
        if (clientRepository.findById(id).isPresent())
            return clientRepository.findById(id).get();
        else throw new NotFoundException("");
    }

    @Transactional
    @Override
    public void updateClientWithStoredProcess(Client client) {
        clientRepository.updateClientWithStoredProcess(client.getName(), client.getEmail(), client.getDni());
    }
}
