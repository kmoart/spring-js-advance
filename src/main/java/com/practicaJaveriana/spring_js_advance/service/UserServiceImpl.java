package com.practicaJaveriana.spring_js_advance.service;

import com.practicaJaveriana.spring_js_advance.domain.Client;
import com.practicaJaveriana.spring_js_advance.domain.User;
import com.practicaJaveriana.spring_js_advance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findById(Integer id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        this.userRepository.deleteById(id);
    }
}
