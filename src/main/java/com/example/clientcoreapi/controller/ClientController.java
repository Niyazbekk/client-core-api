package com.example.clientcoreapi.controller;


import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.model.ClientRequest;
import com.example.clientcoreapi.model.ClientResponse;
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
    public ClientResponse createClient(@Valid @RequestBody ClientRequest clientRequest) {

        return clientService.createClient(clientRequest);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{clientID}")
    public ClientResponse getClientById(@PathVariable String clientID) {
        return clientService.getClientById(clientID);
    }

    @PutMapping("/{clientID}")
    public ClientResponse updateClientById(@Valid @RequestBody ClientRequest clientRequest) {
        return clientService.updateClientById(clientRequest);
    }

    @DeleteMapping("/{clientID}")
    public ClientResponse deleteClientById(@PathVariable String clientID) {
        return clientService.deleteClientById(clientID);
    }
}
