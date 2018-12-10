package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.LibraryRepository;
import com.opc.projet.gestionbiblio.model.Library;
import com.opc.projet.gestionbiblio.service.contract.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository repository;

    @Override
    public List<Library> getAll() {
        return repository.findAll();
    }

    @Override
    public Library getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Library save(Library library) {
        return repository.save(library);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
