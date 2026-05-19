package com.practicaJaveriana.spring_js_advance.repository;

import com.practicaJaveriana.spring_js_advance.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> {
}
