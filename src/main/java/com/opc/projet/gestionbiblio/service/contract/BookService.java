package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getAll();
    Book getById(long id);
    Book save(Book book);
    void deleteById(long id);

}
