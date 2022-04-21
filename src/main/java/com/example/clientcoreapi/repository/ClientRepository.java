package com.example.clientcoreapi.repository;

import com.example.clientcoreapi.model.ClientResponse;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity,Long> {
    ClientEntity getClienEntityByClientID(String clientID);

    @Transactional
    ClientResponse deleteClientEntityByClientID(String clientID);

    List<ClientEntity> getClienEntityBy();
}
