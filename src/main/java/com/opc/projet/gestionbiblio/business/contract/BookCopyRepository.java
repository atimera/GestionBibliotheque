package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {


//    // === find all
//    public List<BookCopy> findAll();
//
//    // === find by id
//    public BookCopy findById(long id);
//
//    // === insert / update
//    public BookCopy save(BookCopy copy);
//
//    // === delete by id
//    public void deletById(long id);

}
