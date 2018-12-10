package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.UserRepository;
import com.opc.projet.gestionbiblio.model.User;
import com.opc.projet.gestionbiblio.model.User;
import com.opc.projet.gestionbiblio.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long pId) {
        User vUser = null;
        Optional<User> optional = repository.findById(pId);

        if(optional.isPresent()){
            vUser = optional.get();
        }
        return vUser;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
