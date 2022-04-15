package com.example.clientcoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface ClientRepository extends CrudRepository<ClientEntity,Long> {
    ClientEntity getClienEntityByClientID(String clientID);

    @Transactional
    void deleteClientEntityByClientID(String clientID);
}
