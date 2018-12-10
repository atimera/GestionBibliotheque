package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.BookRepository;
import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.service.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
