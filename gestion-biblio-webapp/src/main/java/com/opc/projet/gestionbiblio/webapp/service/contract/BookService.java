package com.opc.projet.gestionbiblio.webapp.service.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getAll();

    Book get(Integer id);

    void delete(Integer id);

    void save(Book book);

    void update(Book book);



}
