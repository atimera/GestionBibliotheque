package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.BookCopyRepository;
import com.opc.projet.gestionbiblio.model.BookCopy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class BookCopyRepositoryImpl {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

}
