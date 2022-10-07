package com.company.novae.service;

import com.company.novae.dto.ClientDto;
import com.company.novae.entity.Client;

public interface IClientService extends ICRUDService<Client, Long, ClientDto> {
    public Client findByIdWithCards(Long id);

    public void updateClientWithStoredProcess(Client client);
}
