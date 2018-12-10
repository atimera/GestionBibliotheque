package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.LibraryRepository;
import com.opc.projet.gestionbiblio.model.Library;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
@Repository
public class LibraryRepositoryImpl {

    // for connection to the db
    @PersistenceContext
    EntityManager em;


}
