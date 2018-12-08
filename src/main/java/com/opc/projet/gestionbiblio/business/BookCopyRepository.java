package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.BookCopy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class BookCopyRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<BookCopy> findAll(){

        TypedQuery<BookCopy> namedQuery = em.createNamedQuery("find_all_BookCopies", BookCopy.class);
        return namedQuery.getResultList();
    }

    // === find by id
    public BookCopy findById(long id){
        return em.find(BookCopy.class, id);
    }

    // === insert / update
    public BookCopy save(BookCopy copy){
        if(copy.getId() == null){
            em.persist(copy);
        }else {
            em.merge(copy);
        }
        return copy;
    }

    // === delete by id
    public void deletById(long id){
        BookCopy copy = findById(id);
        em.remove(copy);
    }



}
