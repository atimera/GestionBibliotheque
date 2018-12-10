package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.AuthorRepository;
import com.opc.projet.gestionbiblio.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class AuthorRepositoryImpl {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

}
