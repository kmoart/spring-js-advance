package com.practicaJaveriana.spring_js_advance.repository;

import com.practicaJaveriana.spring_js_advance.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
}
