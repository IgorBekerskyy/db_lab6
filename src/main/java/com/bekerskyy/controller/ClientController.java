package com.bekerskyy.controller;
import com.bekerskyy.domain.Client;
import com.bekerskyy.dto.ClientDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Client")
@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClientDto>> getAll() {
        List<Client> clients = clientService.getAll();
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = new ClientDto(
                    client.getId(),
                    client.getSurname(),
                    client.getName(),
                    client.getBirthday(),
                    client.getGender(),
                    client.getAdresse(),
                    client.getNative_language(),
                    client.getZip_code(),
                    client.getPhone(),
                    client.getEmail(),
                    client.getBonus_account_id()
            );
            clientDtos.add(clientDto);
        }
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Integer id) {
        Client client = clientService.getById(id);
        if (client != null) {
            ClientDto clientDto = new ClientDto(
                    client.getId(),
                    client.getSurname(),
                    client.getName(),
                    client.getBirthday(),
                    client.getGender(),
                    client.getAdresse(),
                    client.getNative_language(),
                    client.getZip_code(),
                    client.getPhone(),
                    client.getEmail(),
                    client.getBonus_account_id()
            );
            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Client newClient) {
        clientService.create(newClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientDto> update(@PathVariable Integer id,
                                              @RequestBody Client client) {
        Client client1 = clientService.getById(id);
        if (client1 != null) {
            clientService.update(id, client);
            ClientDto clientDto = new ClientDto(
                    client.getId(),
                    client.getSurname(),
                    client.getName(),
                    client.getBirthday(),
                    client.getGender(),
                    client.getAdresse(),
                    client.getNative_language(),
                    client.getZip_code(),
                    client.getPhone(),
                    client.getEmail(),
                    client.getBonus_account_id()
            );
            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (clientService.getById(id) != null) {
            clientService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
