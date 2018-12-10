package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> getAll();
    Author getById(long id);
    Author save(Author author);
    void deleteById(long id);

}
