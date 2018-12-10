package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface BookRepository extends JpaRepository<Book, Long> {


//    // === find all
//    public List<Book> findAll();
//
//    // === find by id
//    public Book findById(long id);
//
//    // === insert / update
//    public Book save(Book book);
//
//    // === delete by id
//    public void deletById(long id);


}
