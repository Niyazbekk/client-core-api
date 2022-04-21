package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.model.ClientRequest;
import com.example.clientcoreapi.model.ClientResponse;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientID(UUID.randomUUID().toString());
        ClientEntity clientEntity = modelMapper.map(clientRequest,ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {

        return clientRepository.getClienEntityBy().stream()
                .map(client -> modelMapper.map(client,ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientById(String clientID) {
        ClientEntity clientEntity = clientRepository.getClienEntityByClientID(clientID);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClientById(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        ClientEntity dbEntity = clientRepository.getClienEntityByClientID(clientRequest.getClientID());
        clientEntity.setId(dbEntity.getId());

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse deleteClientById(String clientID) {
        return clientRepository.deleteClientEntityByClientID(clientID);
    }
}
