package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {

    List<Library> getAll();
    Library getById(long id);
    Library save(Library library);
    void deleteById(long id);

}
