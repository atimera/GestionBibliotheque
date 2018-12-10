package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.BookCopyRepository;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.service.contract.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    BookCopyRepository repository;

    @Override
    public List<BookCopy> getAll() {
        return repository.findAll();
    }


    @Override
    public BookCopy getById(long pId) {
        BookCopy vCopy = null;
        Optional<BookCopy> optional = repository.findById(pId);

        if(optional.isPresent()){
            vCopy = optional.get();
        }
        return vCopy;
    }


    @Override
    public BookCopy save(BookCopy copy) {
        return repository.save(copy);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
