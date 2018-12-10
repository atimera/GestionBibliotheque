package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
public interface LibraryRepository  extends JpaRepository<Library, Long> {

//    // === find all
//    public List<Library> findAll();
//
//    // === find all order by name
//    public List<Library> findAllOrderByName();
//
//    // === find all group by city
//    public List<Library> findAllGoupByCity();
//
//    // === find by id
//    public Library findById(long id);
//
//    // === insert / update
//    public Library save(Library library);
//
//
//    // === delete by id
//    public void deletById(long id);



}
