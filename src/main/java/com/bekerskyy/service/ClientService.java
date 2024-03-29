package com.bekerskyy.service;

import com.bekerskyy.domain.Client;
import com.bekerskyy.repository.ClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements AbstractService<Client, Integer> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Integer id, Client client) {
        if (clientRepository.findById(id).isPresent()) {
            return clientRepository.save(client);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
        }
    }
}
