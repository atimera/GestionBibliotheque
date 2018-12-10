package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class BookRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<Book> findAll(){

        TypedQuery<Book> namedQuery = em.createNamedQuery("find_all_books", Book.class);
        return namedQuery.getResultList();
    }

    // === find by id
    public Book findById(long id){
        return em.find(Book.class, id);
    }

    // === insert / update
    public Book save(Book book){
        if(book.getId() == null){
            em.persist(book);
        }else {
            em.merge(book);
        }
        return book;
    }

    // === delete by id
    public void deletById(long id){
        Book book = findById(id);
        em.remove(book);
    }



}
