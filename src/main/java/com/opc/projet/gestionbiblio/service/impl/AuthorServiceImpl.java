package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.AuthorRepository;
import com.opc.projet.gestionbiblio.model.Author;
import com.opc.projet.gestionbiblio.service.contract.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author getById(long pId) {
        Author vAuthor = null;
        Optional<Author> optional = repository.findById(pId);

        if(optional.isPresent()){
            vAuthor = optional.get();
        }
        return vAuthor;
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
