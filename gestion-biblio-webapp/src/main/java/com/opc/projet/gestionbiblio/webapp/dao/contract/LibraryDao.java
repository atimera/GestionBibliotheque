package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Library;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LibraryDao {

    @Transactional
    public void add(Library library);

    @Transactional
    public int getLibrary(Integer libraryId);

    @Transactional
    public List<Library> getLibraries();

}
