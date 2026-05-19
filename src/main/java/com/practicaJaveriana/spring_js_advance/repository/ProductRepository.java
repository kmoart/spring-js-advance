package com.practicaJaveriana.spring_js_advance.repository;

import com.practicaJaveriana.spring_js_advance.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
