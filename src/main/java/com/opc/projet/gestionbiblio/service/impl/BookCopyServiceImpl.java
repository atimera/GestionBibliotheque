package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.BookCopyRepository;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.service.contract.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    BookCopyRepository repository;

    @Override
    public List<BookCopy> getAll() {
        return repository.findAll();
    }

    @Override
    public BookCopy getById(long id) {
        return repository.findById(id);
    }

    @Override
    public BookCopy save(BookCopy copy) {
        return repository.save(copy);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
