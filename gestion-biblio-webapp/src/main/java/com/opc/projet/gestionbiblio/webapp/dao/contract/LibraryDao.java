package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Library;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named
public interface LibraryDao {

    @Transactional
    public List<Library> list();

    /**
     * Add a Library to the db
     * @param library the library to add
     */
    @Transactional
    public void add(Library library);

    @Transactional
    public void update(Integer libraryId);


    public Library get(Integer libraryId);




}
