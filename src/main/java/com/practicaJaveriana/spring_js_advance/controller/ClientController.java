package com.practicaJaveriana.spring_js_advance.controller;

import com.practicaJaveriana.spring_js_advance.domain.Client;
import com.practicaJaveriana.spring_js_advance.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll(){
        return ResponseEntity.ok(this.clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(this.clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(
                this.clientService.save(client), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteById(@PathVariable Integer id){
        this.clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
