package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface AuthorRepository extends JpaRepository<Author, Long> {

//    // === find all
//    public List<Author> findAll();
//
//    // === find by id
//    public Author findById(long id);
//
//    // === insert / update
//    public Author save(Author author);
//
//    // === delete by id
//    public void deletById(long id);


}
