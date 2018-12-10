package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.BookRepository;
import com.opc.projet.gestionbiblio.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class BookRepositoryImpl {

    // for connection to the db
    @PersistenceContext
    EntityManager em;



}
