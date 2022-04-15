package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public String createClient(ClientEntity clientEntity) {
        clientEntity.setClientID(UUID.randomUUID().toString());
        clientRepository.save(clientEntity);
        return "OK";
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return (List<ClientEntity>) clientRepository.findAll();
    }

    @Override
    public ClientEntity getClientById(String clientID) {
        return clientRepository.getClienEntityByClientID(clientID);
    }

    @Override
    public void updateClientById(String clientID, ClientEntity clientEntity) {
        ClientEntity dbEntity = clientRepository.getClienEntityByClientID(clientID);
        dbEntity.setClientID(clientEntity.getClientID());
        dbEntity.setName(clientEntity.getName());
        dbEntity.setSurname(clientEntity.getSurname());
        dbEntity.setEmail(clientEntity.getEmail());
        dbEntity.setDelivery_option(clientEntity.getDelivery_option());
        dbEntity.setAddress(clientEntity.getAddress());

        clientRepository.save(dbEntity);
    }

    @Override
    public void deleteClientById(String clientID) {
        clientRepository.deleteClientEntityByClientID(clientID);
    }
}
