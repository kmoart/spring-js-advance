package com.practicaJaveriana.spring_js_advance.service;

import com.practicaJaveriana.spring_js_advance.domain.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> findById(Integer id);

    Iterable<Client> findAll();

    Client save(Client client);

    void deleteById(Integer id);
}
