package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.AuthorRepositoryCustom;
import com.opc.projet.gestionbiblio.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class AuthorRepositoryCustomImpl implements AuthorRepositoryCustom {

    // for connection to the db
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAuthorBooks(long authorId) {
        TypedQuery<Book> query =
                em.createQuery(
                        "select b from Author a  join a.books b where a.id="+ authorId, Book.class);
        return  query.getResultList();
    }

    @Override
    public Book findAuthorBookById(long authorId, long bookId) {
        TypedQuery<Book> query =
                em.createQuery(
                        "select b from Author a  join a.books b where a.id="+ authorId +" and b.id="+ bookId,
                        Book.class);
        Book theBook = null;
        try {
            theBook = query.getSingleResult();
        }catch (Exception ignored){}

        return  theBook;
    }

    @Transactional
    @Override
    public int deleteBookFromBooks(long authorId, long bookId) {
        Query query = em.createNativeQuery(
                "DELETE FROM author_book ab WHERE ab.author_id=? and ab.book_id=?");

        query.setParameter(1, authorId);
        query.setParameter(2, bookId);

        return query.executeUpdate();
    }
}
