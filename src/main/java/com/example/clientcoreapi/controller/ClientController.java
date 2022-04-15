package com.example.clientcoreapi.controller;


import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    Environment env;


    @GetMapping("/check")
    public String check(){
        return "client-core-api is working at " + env.getProperty("local.server.port") + " port";
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientEntity clientEntity) {
        clientService.createClient(clientEntity);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientEntity> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{clientID}")
    public ClientEntity getClientById(@PathVariable String clientID) {
        return clientService.getClientById(clientID);
    }

    @PutMapping("/{clientID}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientID,
                                                 @Valid @RequestBody ClientEntity clientEntity) {
        clientService.updateClientById(clientID, clientEntity);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{clientID}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientID) {
        clientService.deleteClientById(clientID);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
