package com.practicaJaveriana.spring_js_advance.service;

import com.practicaJaveriana.spring_js_advance.domain.Client;
import com.practicaJaveriana.spring_js_advance.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Integer id);

    Iterable<User> findAll();

    User save(User user);

    void deleteById(Integer id);
}
