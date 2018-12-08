package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class AuthorRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<Author> findAll(){
        return em.createQuery("select au from Author au", Author.class).getResultList();
    }

    // === find by id
    public Author findById(long id){
        return em.find(Author.class, id);
    }

    // === insert / update
    public Author save(Author author){
        if(author.getId() == null){
            em.persist(author);
        }else {
            em.merge(author);
        }
        return author;
    }

    // === delete by id
    public void deletById(long id){
        Author author = findById(id);
        if(author != null)
            em.remove(author);
    }



}
