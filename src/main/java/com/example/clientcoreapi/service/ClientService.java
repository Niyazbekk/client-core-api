package com.example.clientcoreapi.service;


import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.model.ClientRequest;
import com.example.clientcoreapi.model.ClientResponse;
import com.example.clientcoreapi.repository.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);

    List<ClientResponse> getAllClients();

    ClientResponse getClientById(String clientID);

    ClientResponse updateClientById(ClientRequest clientRequest);

    ClientResponse deleteClientById(String clientID);
}
