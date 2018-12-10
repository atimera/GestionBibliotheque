package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.UserRepository;
import com.opc.projet.gestionbiblio.model.User;
import com.opc.projet.gestionbiblio.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
