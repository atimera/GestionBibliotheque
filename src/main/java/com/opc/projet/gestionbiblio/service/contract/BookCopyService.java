package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookCopyService {

    List<BookCopy> getAll();
    BookCopy getById(long id);
    BookCopy save(BookCopy copy);
    void deleteById(long id);

}
