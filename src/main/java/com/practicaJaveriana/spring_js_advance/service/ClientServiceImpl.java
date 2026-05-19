package com.practicaJaveriana.spring_js_advance.service;

import com.practicaJaveriana.spring_js_advance.domain.Client;
import com.practicaJaveriana.spring_js_advance.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return this.clientRepository.findById(id);
    }

    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
