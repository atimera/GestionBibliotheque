package com.opc.projet.gestionbiblio.webapp.service.contract;

import com.opc.projet.gestionbiblio.webapp.entity.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookCopyService {

    List<BookCopy> getAll();

    BookCopy get(Integer id);

    void delete(Integer id);

    void save(BookCopy book);

    void update(BookCopy book);

}
