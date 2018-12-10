package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.LibraryRepository;
import com.opc.projet.gestionbiblio.model.Library;
import com.opc.projet.gestionbiblio.service.contract.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository repository;

    @Override
    public List<Library> getAll() {
        return repository.findAll();
    }

    @Override
    public Library getById(long pId) {
        Library vLibrary = null;

        Optional<Library> optional = repository.findById(pId);

        if(optional.isPresent()){
            vLibrary = optional.get();
        }

        return vLibrary;
    }

    @Override
    public Library save(Library library) {
        return repository.save(library);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
