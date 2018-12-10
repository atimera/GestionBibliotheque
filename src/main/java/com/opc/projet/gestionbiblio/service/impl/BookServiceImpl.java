package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.BookRepository;
import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.service.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(long pId) {
        Book vBook = null;
        Optional<Book> optional = repository.findById(pId);

        if(optional.isPresent()){
            vBook = optional.get();
        }
        return vBook;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
