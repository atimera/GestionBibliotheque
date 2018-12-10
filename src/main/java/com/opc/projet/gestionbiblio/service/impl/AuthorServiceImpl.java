package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.AuthorRepository;
import com.opc.projet.gestionbiblio.model.Author;
import com.opc.projet.gestionbiblio.service.contract.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }

}
