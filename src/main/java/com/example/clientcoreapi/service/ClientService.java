package com.example.clientcoreapi.service;


import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.repository.ClientEntity;

import java.util.List;

public interface ClientService {
    String createClient(ClientEntity clientEntity);

    List<ClientEntity> getAllClients();

    ClientEntity getClientById(String clientID);

    void updateClientById(String clientID , ClientEntity clientEntity);

    void deleteClientById(String clientID);
}
